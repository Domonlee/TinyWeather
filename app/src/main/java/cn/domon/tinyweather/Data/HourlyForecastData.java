package cn.domon.tinyweather.Data;

/**
 * Created by Domon on 16-5-5.
 */
public class HourlyForecastData {

    /**
     * date : 2016-05-05 22:00
     * hum : 21
     * pop : 0
     * pres : 1009
     * tmp : 23
     * wind : {"deg":"329","dir":"西北风","sc":"3-4","spd":"22"}
     */

    private String date;
    private String hum;
    private String pop;
    private String pres;
    private String tmp;
    /**
     * deg : 329
     * dir : 西北风
     * sc : 3-4
     * spd : 22
     */

    private WindBean wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public WindBean getWind() {
        return wind;
    }

    public void setWind(WindBean wind) {
        this.wind = wind;
    }

    public static class WindBean {
        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg() {
            return deg;
        }

        public void setDeg(String deg) {
            this.deg = deg;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        public String getSc() {
            return sc;
        }

        public void setSc(String sc) {
            this.sc = sc;
        }

        public String getSpd() {
            return spd;
        }

        public void setSpd(String spd) {
            this.spd = spd;
        }
    }
}
