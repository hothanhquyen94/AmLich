package app.com.example.unitec.amlich;

import java.io.Serializable;

/**
 * Created by Unitec on 27/11/2017.
 */

public class VietCaledar implements Serializable {
    int daySolar;
    int monthSolar;
    int yearSolar;
    int dayLuna;
    int monnthLuna;
    int yearLuna;
    int position;
    String dayOFWeek;


    public String getDayOFWeek() {
        return dayOFWeek;
    }

    public void setDayOFWeek(String dayOFWeek) {
        this.dayOFWeek = dayOFWeek;
    }

    public int getDaySolar() {
        return daySolar;
    }

    public void setDaySolar(int daySolar) {
        this.daySolar = daySolar;
    }

    public int getMonthSolar() {
        return monthSolar;
    }

    public void setMonthSolar(int monthSolar) {
        this.monthSolar = monthSolar;
    }

    public int getYearSolar() {
        return yearSolar;
    }

    public void setYearSolar(int yearSolar) {
        this.yearSolar = yearSolar;
    }

    public int getDayLuna() {
        return dayLuna;
    }

    public void setDayLuna(int dayLuna) {
        this.dayLuna = dayLuna;
    }

    public int getMonnthLuna() {
        return monnthLuna;
    }

    public void setMonnthLuna(int monnthLuna) {
        this.monnthLuna = monnthLuna;
    }

    public int getYearLuna() {
        return yearLuna;
    }

    public void setYearLuna(int yearLuna) {
        this.yearLuna = yearLuna;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
