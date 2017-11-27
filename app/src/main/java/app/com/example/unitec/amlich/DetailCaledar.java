package app.com.example.unitec.amlich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailCaledar extends AppCompatActivity {
    private TextView currentDayOfWeek;
    private TextView txtMonthAndYear;
    private TextView txtDay,txtTucNgu,txtInforDateLuna,txtDayLuna,txtMonthLuna,txtYearLuna,txtNameDay,txtNameMonth,txtNameYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_caledar);
        inits();

    }

    public void inits(){
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
        VietCaledar viewDate = (VietCaledar)intent.getSerializableExtra(Intent.EXTRA_TEXT);

        currentDayOfWeek.setText(new String(getWeekDayAsString(viewDate.getPosition())));
        String valueday = String.valueOf(viewDate.getDaySolar());
        txtDay.setText(valueday);
        String valuemonth = String.valueOf(viewDate.getMonthSolar());
        String valueyear = String.valueOf(viewDate.getYearSolar());

        txtMonthAndYear.setText("Tháng "+valuemonth+" năm "+valueyear);
        Log.d("aaa",viewDate.getMonthSolar()+"  "+viewDate.getYearSolar());

        txtDayLuna.setText(""+viewDate.getDayLuna());
        txtMonthLuna.setText(""+viewDate.getMonnthLuna());
        txtYearLuna.setText(""+viewDate.getYearLuna());
    }

    private String getWeekDayAsString(int i) {
        int j = (i%7);
        return Util.weekdays[j];
    }
}
