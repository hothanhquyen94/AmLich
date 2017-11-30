package app.com.example.unitec.amlich;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import static app.com.example.unitec.amlich.GridCellAdapter.getIdMonthAsString;

public class DetailCaledar extends AppCompatActivity implements View.OnClickListener,getPositionCurrent{
    private TextView currentDayOfWeek;
    private TextView txtMonthAndYear;
    private TextView txtDay,txtTucNgu,txtInforDateLuna,
            txtDayLuna,txtMonthLuna,txtYearLuna,
            txtNameDay,txtNameMonth,txtNameYear;
    private VietCaledar viewDate;
    private ImageView imgNextDay,imgPreDay;
    private int mMonth,mDay, mYear;
    private String[] dulieu;
    private GestureDetector gestureDetector;
    private int SWIPE_THRESHOLD = 100;
    private int SWIPE_VELOCITY_THRESHOLD = 100;
    private LinearLayout geniruteLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_caledar);
        geniruteLayout = (LinearLayout)findViewById(R.id.genirute);
        imgNextDay = (ImageView)findViewById(R.id.nextDay);
        imgPreDay = (ImageView)findViewById(R.id.prevDay);
        currentDayOfWeek = (TextView)findViewById(R.id.currentDayOfWeek);
        txtMonthAndYear = (TextView)findViewById(R.id.txtMonthAndYear);
        txtDay = (TextView)findViewById(R.id.txtDay);
        txtTucNgu = (TextView)findViewById(R.id.txtTucNgu);
        txtInforDateLuna = (TextView)findViewById(R.id.txtInforDateLuna);
        txtDayLuna = (TextView)findViewById(R.id.txtDayLuna);
        txtMonthLuna = (TextView)findViewById(R.id.txtMonthLuna);
        txtYearLuna = (TextView)findViewById(R.id.txtYearLuna);
        txtNameDay = (TextView)findViewById(R.id.txtNameDay);
        txtNameYear = (TextView)findViewById(R.id.txtNameYear);
        txtNameMonth = (TextView)findViewById(R.id.txtNameMonth);

        Intent intent = getIntent();
        viewDate = (VietCaledar)intent.getSerializableExtra(Intent.EXTRA_TEXT);
        mMonth = viewDate.getMonthSolar();
        mYear = viewDate.getYearSolar();
        mDay = viewDate.getDaySolar();



        //readData();
        String ten = (getApplication().getResources().getString(R.string.data));
        dulieu = ten.split("-");

        imgNextDay.setOnClickListener(this);
        imgPreDay.setOnClickListener(this);

        Calendar c = Calendar.getInstance();
        getCalendar(c);

        gestureDetector = new GestureDetector(this,new MyGesture());
        geniruteLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });

    }
    public void getCalendar(Calendar c){
        c.set(Calendar.YEAR,mYear);
        c.set(Calendar.MONTH,mMonth-1);
        c.set(Calendar.DAY_OF_MONTH,mDay);
        java.text.DateFormat df = new SimpleDateFormat("EEEE-yyyy-MM-dd", Locale.getDefault());
        String curentDateString = df.format(c.getTime());

        String[] arrayDateString = curentDateString.split("-");
        int day = Integer.parseInt(arrayDateString[3]);
        int month = Integer.parseInt(arrayDateString[2]);
        int year = Integer.parseInt(arrayDateString[1]);

         ChinaCalendar lunaDate = new ChinaCalendar(day,month,year);
         int[] date = lunaDate.ConVertToLunar();
         VietCaledar v = new VietCaledar();
         txtDay.setText(day+"");
         txtMonthAndYear.setText("Tháng "+month+" năm "+year);
         String[] nameLuna = lunaDate.getNameLuna();
         v.setCanChiHour(nameLuna[0]);
         currentDayOfWeek.setText(arrayDateString[0]);
         txtDayLuna.setText(""+date[0]);
         txtMonthLuna.setText(""+date[1]);
         txtYearLuna.setText(""+date[2]);
         txtNameDay.setText(nameLuna[0]);
         txtNameMonth.setText(nameLuna[1]);
         txtNameYear.setText(nameLuna[2]);
         txtInforDateLuna.setText(v.getCanChiHour().toString());

         Random n = new Random();
         int i = n.nextInt(dulieu.length-1)+1;
         txtTucNgu.setText(dulieu[i]);
    }


    @Override
    public void onClick(View v) {
        if (v == imgNextDay) {
            mDay++;
            Calendar c = Calendar.getInstance();
            getCalendar(c);
        }
        if (v == imgPreDay) {
           mDay--;
            Calendar c = Calendar.getInstance();
            getCalendar(c);

        }
    }

    @Override
    public void onReturn(int position) {
    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e2.getX()-e1.getX()>SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD){
                mDay--;
                Calendar c = Calendar.getInstance();
                getCalendar(c);
                Log.d("-----","vuot");
            }
            if (e1.getX()-e2.getX()>SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD){
                mDay++;
                Calendar c = Calendar.getInstance();
                getCalendar(c);
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

}
