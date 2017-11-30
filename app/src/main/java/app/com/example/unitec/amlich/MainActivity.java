package app.com.example.unitec.amlich;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static app.com.example.unitec.amlich.GridCellAdapter.getIdMonthAsString;

public class MainActivity extends AppCompatActivity implements getPositionCurrent {
    private static final String tag = "MyCalendarActivity";
    private TextView currentMonth;
    private TextView txtMonth;

    private TextView nextMonth;
    private GridView calendarView;
    private GridCellAdapter adapter;
    private Calendar _calendar;
    private TextView displayInforDate,inforHourCanchi;
    private boolean checkChoose = false;
    private  String curentDateString;
    private String[] CurrentTime;
    private int[] CurrentDateInt;
    private int positionView;
    private int positionViewCurrent;
    @SuppressLint("NewApi")
    private int month, year;
    @SuppressWarnings("unused")
    @SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
    private final DateFormat dateFormatter = new DateFormat();
    private static final String dateTemplate = "M"; /** Called when the activity is first created. */
    private static final String yearTempalte = "yyyy"; /** Called when the activity is first created. */
    private static final String dayofWeek = "EEE";

    private GestureDetector gestureDetector;
    private int SWIPE_THRESHOLD = 100;
    private int SWIPE_VELOCITY_THRESHOLD = 100;
    private LinearLayout geniruteLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMonth = (TextView)findViewById(R.id.selectedDayMonthYear);
        _calendar = Calendar.getInstance(Locale.getDefault());
        month = _calendar.get(Calendar.MONTH)+1;
        year = _calendar.get(Calendar.YEAR);

        inforHourCanchi = (TextView)findViewById(R.id.inforHourCanchi);
        displayInforDate = (TextView)findViewById(R.id.display_luna_date);
        currentMonth =(TextView) this.findViewById(R.id.currentMonth);

        nextMonth = (TextView) this.findViewById(R.id.nextMonth);
        nextMonth.setTextColor(Color.GRAY);


        calendarView = (GridView) this.findViewById(R.id.calendar);

        geniruteLayout = (LinearLayout)findViewById(R.id.geniruteLayout);
        adapter = new GridCellAdapter(getApplicationContext(), month, year,this);
        adapter.notifyDataSetChanged();
        calendarView.setAdapter(adapter);
        initFirstDisplay();

        calendarView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((GridCellAdapter) parent.getAdapter()).setSelected(view,position);
                checkChoose = true;
                positionView = position;
                String[] selectedGridDate = GridCellAdapter.list
                        .get(position).split("-");
                String theday = selectedGridDate[0];
                String themonth = selectedGridDate[2];
                String theyear = selectedGridDate[3];

                int MonthToCovert = getIdMonthAsString(themonth);
                int DayToCovert =   Integer.parseInt(theday);
                int YearToCovert =  Integer.parseInt(theyear);


                //covert to luna date
                printDateLuna(DayToCovert,MonthToCovert,YearToCovert);

                if ((DayToCovert > 8)&& (position < 8)){
                    nextMonthView();
                }else if (( DayToCovert < 7 )&& ( position > 28 )){
                    prevMonthView();
                }
            }
        });




        ImageButton cal_Amlich = (ImageButton)findViewById(R.id.btnViewAmLich);
        cal_Amlich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VietCaledar viewChoice = new VietCaledar();
                Intent intent = new Intent(MainActivity.this,DetailCaledar.class);

                //startActivity(intent);
                if (checkChoose ==true){
                    viewChoice = chooseDate(positionView);
                }else {
                    viewChoice=chooseDate(positionViewCurrent);

                }
                intent.putExtra(Intent.EXTRA_TEXT, viewChoice);
                startActivity(intent);
            }
        });



        gestureDetector = new GestureDetector(this,new MyGesture());
        geniruteLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    private void setGridCellAdapterToDate(int month, int year) {
        adapter = new GridCellAdapter(getApplicationContext(), month, year,this);
        _calendar.set(year, month - 1, _calendar.get(Calendar.DAY_OF_MONTH));
        currentMonth.setText("Tháng " +DateFormat.format(dateTemplate,
                _calendar.getTime()));


        adapter.notifyDataSetChanged();
        calendarView.setAdapter(adapter);

    }
    public void nextMonthView(){
        if (month <= 1) {
            month = 12;
            year--;
            txtMonth.setText(""+year);
        } else {
            month--;
        }
        setGridCellAdapterToDate(month, year);
    }
    public void prevMonthView(){
        if (month > 11) {
            month = 1;
            year++;
            txtMonth.setText(""+year);
        } else {
            month++;
        }
        setGridCellAdapterToDate(month, year);
    }



    @Override public void onDestroy() {
        super.onDestroy();
    }



    public void printDateLuna(int day,int month,int year){
        ChinaCalendar lunaDate = new ChinaCalendar(day,month,year);
        String[] nameLuna = lunaDate.getNameLuna();
        VietCaledar v = new VietCaledar();
        v.setCanChiHour(nameLuna[0]);
        displayInforDate.setText("Ngày "+nameLuna[0]+" tháng "+nameLuna[1]+" năm "+nameLuna[2]);
        inforHourCanchi.setText(v.getCanChiHour());
        Log.d("hoa",v.getCanChiHour()+"");
    }

    public void initFirstDisplay(){
        currentMonth.setText("Tháng "+DateFormat.format(dateTemplate, _calendar.getTime()));


        txtMonth.setText(DateFormat.format(yearTempalte, _calendar.getTime()));
        java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        curentDateString = df.format(_calendar.getTime());
        CurrentTime = curentDateString.split("-");
        CurrentDateInt = new int[]{
                Integer.parseInt(CurrentTime[2]),
                Integer.parseInt(CurrentTime[1]),
                Integer.parseInt(CurrentTime[0])
        };

        printDateLuna(CurrentDateInt[0],CurrentDateInt[1],CurrentDateInt[2]);
    }

    public VietCaledar chooseDate(int vitri){
        String[] selectedGridDate = GridCellAdapter.list
                .get(vitri).split("-");
        String theday = selectedGridDate[0];
        String themonth = selectedGridDate[2];
        String theyear = selectedGridDate[3];
        int MonthToCovert = getIdMonthAsString(themonth);
        int DayToCovert =   Integer.parseInt(theday);
        int YearToCovert =  Integer.parseInt(theyear);

        ChinaCalendar lunaDate = new ChinaCalendar(DayToCovert,MonthToCovert,YearToCovert);
        int[] date = lunaDate.ConVertToLunar();
        String[] nameDay = lunaDate.getNameLuna();
        VietCaledar viewDateLuna = new VietCaledar();

        viewDateLuna.setDaySolar(DayToCovert);
        viewDateLuna.setMonthSolar(MonthToCovert);
        viewDateLuna.setYearSolar(YearToCovert);

        viewDateLuna.setDayLuna(date[0]);
        viewDateLuna.setMonnthLuna(date[1]);
        viewDateLuna.setYearLuna(date[2]);

        viewDateLuna.setCanChiHour(nameDay[0]);
        viewDateLuna.setPosition(vitri);

        return viewDateLuna;

    }

    @Override
    public void onReturn(int position) {
        positionViewCurrent = position;
    }

    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (e2.getX()-e1.getX()>SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD){
                nextMonthView();

            }
            if (e1.getX()-e2.getX()>SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD){
                prevMonthView();
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
