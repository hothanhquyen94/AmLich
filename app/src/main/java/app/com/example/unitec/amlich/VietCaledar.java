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
    String canChiday;
    String canChiHour;



    public String getCanChiday() {
        return canChiday;
    }

    public void setCanChiday(String can) {
        canChiday = can;
    }

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


    public String getCanChiHour() {
        return canChiHour;
    }

    public void setCanChiHour(String strings) {
        if(strings.equals( "Giáp Tý")  || strings.equals( "Giáp Ngọ" ))
            this.canChiHour = ( "Giáp Tý(23-1), Ất Sửu(1-3), Đinh Mão(5-7), Canh Ngọ(11-13), Nhâm Thân(15-17), Quý Dậu(17-19)");

        if(strings.equals( "Ất Sửu")  || strings.equals( "Ất Mùi" ))
            this.canChiHour = ( "Mậu Dần(3-5), Kỷ Mão(5-7), Tân Tị(9-11), Giáp Thân(15-17), Bính Tuất(19-21), Đinh Hợi(21-23)");

        if(strings.equals( "Bính Dần")  || strings.equals( "Bính Thân" ))
            this.canChiHour = ( "Mậu Tý(23-1), Kỷ Sửu(1-3), Nhâm Thìn(7-9), Quý Tị(9-11), Ất Mùi(13-15), Mậu Tuất(19-21)");

        if(strings.equals( "Đinh Mão")  || strings.equals( "Đinh Dậu" ))
            this.canChiHour = ( " Canh Tý(23-1), Nhâm Dần(3-5), Quý Mão(5-7), Bính Ngọ(11-13), Đinh Mùi(13-15), Kỷ Dậu(17-19)");

        if(strings.equals( "Mậu Thìn")  || strings.equals( "Mậu Tuất" ))
            this.canChiHour = ( " Giáp Dần(3-5), Bính Thìn(7-9), Đinh Tị(9-11), Canh Thân(15-17), Tân Dậu(17-19), Quý Hợi(21-23)");

        if(strings.equals( "Kỷ Tị")  || strings.equals( "Kỷ Hợi" ))
            this.canChiHour = ( " Ất Sửu(1-3), Mậu Thìn(7-9), Canh Ngọ(11-13), Tân Mùi(13-15), Giáp Tuất(19-21), Ất Hợi(21-23)");

        if(strings.equals( "Canh Ngọ")  || strings.equals( "Canh Tý" ))
            this.canChiHour = ( " Bính Tý(23-1), Đinh Sửu(1-3), Kỷ Mão(5-7), Nhâm Ngọ(11-13), Giáp Thân(15-17), Ất Dậu(17-19)");

        if(strings.equals( "Tân Mùi")  || strings.equals( "Tân Sửu" ))
            this.canChiHour = ( " Canh Dần(3-5), Tân Mão(5-7), Quý Tị(9-11), Bính Thân(15-17), Mậu Tuất(19-21), Kỷ Hợi(21-23)");

        if(strings.equals( "Nhâm Thân")  || strings.equals( "Nhâm Dần" ))
            this.canChiHour = ( " Canh Tý(23-1), Tân Sửu(1-3), Giáp Thìn(7-9), Ất Tị(9-11), Đinh Mùi(13-15), Canh Tuất(19-21)");

        if(strings.equals( "Quý Dậu")  || strings.equals( "Quý Mão" ))
            this.canChiHour = ( "Nhâm Tý(23-1), Giáp Dần(3-5), Ất Mão(5-7), Mậu Ngọ(11-13), Kỷ Mùi(13-15), Tân Dậu(17-19)");

        if(strings.equals( "Giáp Tuất")  || strings.equals( "Giáp Thìn" ))
            this.canChiHour = ( "Bính Dần(3-5), Mậu Thìn(7-9), Kỷ Tị(9-11), Nhâm Thân(15-17), Quý Dậu(17-19), Ất Hợi(21-23)");

        if(strings.equals( "Ất Hợi")  || strings.equals( "Ất Tị" ))
            this.canChiHour = ( "Đinh Sửu(1-3), Canh Thìn(7-9), Nhâm Ngọ(11-13), Quý Mùi(13-15), Bính Tuất(19-21), Đinh Hợi(21-23)");

        if(strings.equals( "Bính Tý")  || strings.equals( "Bính Ngọ" ))
            this.canChiHour = ( "Mậu Tý(23-1), Kỷ Sửu(1-3), Tân Mão(5-7), Giáp Ngọ(11-13), Bính Thân(15-17), Đinh Dậu(17-19)");

        if(strings.equals( "Đinh Sửu")  || strings.equals( "Đinh Mùi" ))
            this.canChiHour  = ( "Nhâm Dần(3-5), Quý Mão(5-7), Ất Tị(9-11), Mậu Thân(15-17), Canh Tuất(19-21), Tân Hợi(21-23)");

        if(strings.equals( "Mậu Dần")  || strings.equals( "Mậu Thân" ))
            this.canChiHour = ( "Nhâm Tý(23-1), Quý Sửu(1-3), Bính Thìn(7-9), Đinh Tị(9-11), Kỷ Mùi(13-15), Nhâm Tuất(19-21)");

        if(strings.equals( "Kỷ Mão")  || strings.equals( "Kỷ Dậu" ))
            this.canChiHour = ( "Giáp Tý(23-1), Bính Dần(3-5), Đinh Mão(5-7), Canh Ngọ(11-13), Tân Mùi(13-15), Quý Dậu(17-19)");

        if(strings.equals( "Canh Thìn")  || strings.equals( "Canh Tuất" ))
            this.canChiHour = ( " Mậu Dần(3-5), Canh Thìn(7-9), Tân Tị(9-11), Giáp Thân(15-17), Ất Dậu(17-19), Đinh Hợi(21-23)");

        if(strings.equals( "Tân Tị")  || strings.equals( "Tân Hợi" ))
            this.canChiHour = ( "Kỷ Sửu(1-3), Nhâm Thìn(7-9), Giáp Ngọ(11-13), Ất Mùi(13-15), Mậu Tuất(19-21), Kỷ Hợi(21-23)");

        if(strings.equals( "Nhâm Ngọ")  || strings.equals( "Nhâm Tý" ))
            this.canChiHour = ( "Canh Tý(23-1), Tân Sửu(1-3), Quý Mão(5-7), Bính Ngọ(11-13), Mậu Thân(15-17), Kỷ Dậu(17-19)");

        if(strings.equals( "Quý Mùi")  || strings.equals( "Quý Sửu" ))
            this.canChiHour = ( "Giáp Dần(3-5), Ất Mão(5-7), Đinh Tị(9-11), Canh Thân(15-17), Nhâm Tuất(19-21), Quý Hợi(21-23)");

        if(strings.equals( "Giáp Thân")  || strings.equals( "Giáp Dần" ))
            this.canChiHour = ( "Giáp Tý(23-1), Ất Sửu(1-3), Mậu Thìn(7-9), Kỷ Tị(9-11), Tân Mùi(13-15), Giáp Tuất(19-21)");

        if(strings.equals( "Ất Dậu")  || strings.equals( "Ất Mão" ))
            this.canChiHour = ( "Bính Tý(23-1), Mậu Dần(3-5), Kỷ Mão(5-7), Nhâm Ngọ(11-13), Quý Mùi(13-15), Ất Dậu(17-19)");

        if(strings.equals( "Bính Tuất")  || strings.equals( "Bính Thìn" ))
            this.canChiHour = ( " Canh Dần(3-5), Nhâm Thìn(7-9), Quý Tị(9-11), Bính Thân(15-17), Đinh Dậu(17-19), Kỷ Hợi(21-23)");

        if(strings.equals( "Đinh Hợi")  || strings.equals( "Đinh Tị" ))
            this.canChiHour = ( "Tân Sửu(1-3), GiápThìn(7-9), Bính Ngọ(11-13), Đinh Mùi(13-15), Canh Tuất(19-21), Tân Hợi(21-23)");

        if(strings.equals( "Mậu Ngọ")  || strings.equals( "Mậu Tý" ))
            this.canChiHour = ( " Nhâm Tý(23-1), Quý Sửu(1-3), Ất Mão(5-7), Mậu Ngọ(11-13), Canh Thân(15-17), Tân Dậu(17-19)");

        if(strings.equals( "Kỷ Mùi")  || strings.equals( "Kỷ Sửu" ))
            this.canChiHour = ( "Bính Dần(3-5), Đinh Mão(5-7), Kỷ Tị(9-11), Nhâm Thân(15-17), Giáp Tuất(19-21), Ất Hợi(21-23)");

        if(strings.equals("Canh Thân")  || strings.equals("Canh Dần"))
            this.canChiHour = ( "Bính Tý(23-1), Đinh Sửu(1-3), Canh Thìn(7-9), Tân Tị(9-11), Quý Mùi(13-15), Bính Tuất(19-21)");

        if(strings.equals( "Tân Dậu")  || strings.equals( "Tân Mão" ))
            this.canChiHour = ( "Mậu Tý(23-1), Canh Dần(3-5), Tân Mão(5-7), Giáp Ngọ(11-13), Ất Mùi(13-15), Đinh Dậu(17-19)");

        if(strings.equals( "Nhâm Tuất") ||  strings.equals( "Nhâm Thìn" ))
            this.canChiHour = ( "Nhâm Dần(3-5), Giáp Thìn(7-9), Ất Tị(9-11), Mậu Thân(15-17), Kỷ Dậu(17-19), Tân Hợi(21-23)");

        if(strings.equals( "Quý Hợi")  || strings.equals( "Quý Tị" ))
            this.canChiHour = ( "Quý Sửu(1-3), Bính Thìn(7-9), Mậu Ngọ(11-13), Kỷ Mùi(13-15), Nhâm Tuất(19-21), Quý Hợi(21-23)");

    }
}
