package cn.domon.tinyweather.Data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Domon on 16-5-10.
 */
public class WeatherInfoData {

    @SerializedName("HeWeather data service 3.0")
    private WeatherData weatherData;

    public class WeatherData {

        private Aqi aqi;
        private Basic basic;
        private Daily daily;
        private Hourly hourly;
        private Now now;
        private SuggestionData suggestionData;
        private String status;

        public Aqi getAqi() {
            return aqi;
        }

        public void setAqi(Aqi aqi) {
            this.aqi = aqi;
        }

        public Basic getBasic() {
            return basic;
        }

        public void setBasic(Basic basic) {
            this.basic = basic;
        }

        public Daily getDaily() {
            return daily;
        }

        public void setDaily(Daily daily) {
            this.daily = daily;
        }

        public Hourly getHourly() {
            return hourly;
        }

        public void setHourly(Hourly hourly) {
            this.hourly = hourly;
        }

        public Now getNow() {
            return now;
        }

        public void setNow(Now now) {
            this.now = now;
        }

        public SuggestionData getSuggestionData() {
            return suggestionData;
        }

        public void setSuggestionData(SuggestionData suggestionData) {
            this.suggestionData = suggestionData;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "WeatherInfoData{" +
                    "aqi=" + aqi +
                    ", basic=" + basic +
                    ", daily=" + daily +
                    ", hourly=" + hourly +
                    ", now=" + now +
                    ", suggestionData=" + suggestionData +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
