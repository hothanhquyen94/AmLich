package app.com.example.unitec.amlich;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
import java.util.ArrayList;
import java.util.Calendar;
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
    private int positionCurrent;
    private GridCellAdapter adapter;
    private int month,day, year;
    private int size;
    private InputStream inputStream ;
    private String[] dulieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_caledar);
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
        positionCurrent = viewDate.getPosition();
        month = viewDate.getMonthSolar();
        year = viewDate.getYearSolar();
        day = viewDate.getDaySolar();
        adapter = new GridCellAdapter(getApplicationContext(), month, year,this);
        adapter.notifyDataSetChanged();
        size = GridCellAdapter.list.size();

        //readData();
        String ten = (getApplication().getResources().getString(R.string.data));
        dulieu = ten.split("-");
        Log.d("qưert",dulieu[1]+"");

        inits(positionCurrent);
        imgNextDay.setOnClickListener(this);
        imgPreDay.setOnClickListener(this);
        adapter = new GridCellAdapter(getApplicationContext(), month, year,this);
        adapter.notifyDataSetChanged();

    }

    private void setGridCellAdapterToDate(int month, int year) {
        adapter = new GridCellAdapter(getApplicationContext(), month, year,this);
        adapter.notifyDataSetChanged();

    }

    public void preDay(){
        if (positionCurrent == 0){

            if(day==1){
                if (month <= 1 ){
                    month = 12;
                    year--;

                }else {
                    month--;
                }
            }
            positionCurrent = size-1;
            setGridCellAdapterToDate(month,year);

        }else {
            positionCurrent--;
        }
        inits(positionCurrent);
    }

    public void nextDay(){
        if (positionCurrent == (size-1) ){
            if (day == 29 || day == 30 || day == 31){
                if (month > 11) {
                    month = 1;
                    year++;

                }else {
                    month++;
                }
            }
            positionCurrent = 0;
            setGridCellAdapterToDate(month,year);

        } else {
            positionCurrent++;
        }
        inits(positionCurrent);
    }




    public void inits(int position){
        String[] selectedGridDate = GridCellAdapter.list
                .get(position).split("-");
        String theday = selectedGridDate[0];
        String themonth = selectedGridDate[2];
        String theyear = selectedGridDate[3];
        int MonthToCovert = getIdMonthAsString(themonth);
        int DayToCovert =   Integer.parseInt(theday);
        int YearToCovert =  Integer.parseInt(theyear);

        ChinaCalendar lunaDate = new ChinaCalendar(DayToCovert,MonthToCovert,YearToCovert);
        int[] date = lunaDate.ConVertToLunar();
        VietCaledar v = new VietCaledar();

        txtDay.setText(theday);
        txtMonthAndYear.setText("Tháng "+MonthToCovert+" năm "+theyear);
        String[] nameLuna = lunaDate.getNameLuna();
        v.setCanChiHour(nameLuna[0]);
        currentDayOfWeek.setText(getWeekDayAsString(position));
        txtDayLuna.setText(""+date[0]);
        txtMonthLuna.setText(""+date[1]);
        txtYearLuna.setText(""+date[2]);
        txtNameDay.setText(nameLuna[0]);
        txtNameMonth.setText(nameLuna[1]);
        txtNameYear.setText(nameLuna[2]);
        txtInforDateLuna.setText(v.getCanChiHour().toString());

         Random n = new Random();
         int i = n.nextInt(dulieu.length)-1;
         txtTucNgu.setText(dulieu[i]);
    }

    private String getWeekDayAsString(int i) {
        int j = (i%7);
        return Util.weekdays[j];
    }

    @Override
    public void onClick(View v) {
        if (v == imgNextDay) {
            nextDay();
        }
        if (v == imgPreDay) {
            preDay();
        }
    }

    @Override
    public void onReturn(int position) {
    }


}
