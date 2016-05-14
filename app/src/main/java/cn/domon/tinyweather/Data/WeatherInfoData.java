package cn.domon.tinyweather.Data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Domon on 16-5-10.
 */
public class WeatherInfoData {

    /**
     * aqi : {"city":{"aqi":"46","co":"0","no2":"28","o3":"73","pm10":"46","pm25":"41","qlty":"优","so2":"2"}}
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-05-10 11:50","utc":"2016-05-10 03:50"}}
     * daily_forecast : [{"astro":{"sr":"05:03","ss":"19:17"},"cond":{"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"},"date":"2016-05-10","hum":"23","pcpn":"0.0","pop":"0","pres":"1008","tmp":{"max":"28","min":"17"},"vis":"10","wind":{"deg":"192","dir":"无持续风向","sc":"微风","spd":"2"}},{"astro":{"sr":"05:02","ss":"19:18"},"cond":{"code_d":"101","code_n":"302","txt_d":"多云","txt_n":"雷阵雨"},"date":"2016-05-11","hum":"28","pcpn":"0.1","pop":"15","pres":"997","tmp":{"max":"30","min":"18"},"vis":"10","wind":{"deg":"195","dir":"南风","sc":"3-4","spd":"13"}},{"astro":{"sr":"05:01","ss":"19:19"},"cond":{"code_d":"104","code_n":"100","txt_d":"阴","txt_n":"晴"},"date":"2016-05-12","hum":"16","pcpn":"2.0","pop":"80","pres":"1010","tmp":{"max":"24","min":"10"},"vis":"10","wind":{"deg":"333","dir":"北风","sc":"4-5","spd":"18"}},{"astro":{"sr":"05:00","ss":"19:20"},"cond":{"code_d":"100","code_n":"300","txt_d":"晴","txt_n":"阵雨"},"date":"2016-05-13","hum":"9","pcpn":"0.0","pop":"0","pres":"1017","tmp":{"max":"26","min":"14"},"vis":"10","wind":{"deg":"206","dir":"无持续风向","sc":"微风","spd":"9"}},{"astro":{"sr":"04:59","ss":"19:21"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2016-05-14","hum":"9","pcpn":"0.0","pop":"46","pres":"1015","tmp":{"max":"22","min":"13"},"vis":"10","wind":{"deg":"327","dir":"无持续风向","sc":"微风","spd":"5"}},{"astro":{"sr":"04:58","ss":"19:22"},"cond":{"code_d":"101","code_n":"100","txt_d":"多云","txt_n":"晴"},"date":"2016-05-15","hum":"7","pcpn":"0.0","pop":"1","pres":"1012","tmp":{"max":"28","min":"14"},"vis":"10","wind":{"deg":"275","dir":"北风","sc":"3-4","spd":"16"}},{"astro":{"sr":"04:58","ss":"19:23"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-05-16","hum":"10","pcpn":"0.0","pop":"0","pres":"1011","tmp":{"max":"29","min":"16"},"vis":"10","wind":{"deg":"123","dir":"无持续风向","sc":"微风","spd":"0"}}]
     * hourly_forecast : [{"date":"2016-05-10 13:00","hum":"26","pop":"0","pres":"1009","tmp":"30","wind":{"deg":"192","dir":"西南风","sc":"微风","spd":"9"}},{"date":"2016-05-10 16:00","hum":"23","pop":"0","pres":"1006","tmp":"30","wind":{"deg":"189","dir":"南风","sc":"微风","spd":"14"}},{"date":"2016-05-10 19:00","hum":"28","pop":"0","pres":"1006","tmp":"29","wind":{"deg":"185","dir":"南风","sc":"微风","spd":"13"}},{"date":"2016-05-10 22:00","hum":"34","pop":"0","pres":"1007","tmp":"25","wind":{"deg":"184","dir":"南风","sc":"微风","spd":"13"}}]
     * now : {"cond":{"code":"100","txt":"晴"},"fl":"25","hum":"28","pcpn":"0","pres":"1010","tmp":"24","vis":"10","wind":{"deg":"350","dir":"北风","sc":"微风","spd":"10"}}
     * status : ok
     * suggestion : {"comf":{"brf":"较舒适","txt":"白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"sport":{"brf":"较适宜","txt":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"},"trav":{"brf":"适宜","txt":"天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。"},"uv":{"brf":"强","txt":"紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。"}}
     */

    @SerializedName("HeWeather data service 3.0")
    private List<HeBean> He;

    public List<HeBean> getHe() {
        return He;
    }

    public void setHe(List<HeBean> He) {
        this.He = He;
    }

    public static class HeBean {
        /**
         * city : {"aqi":"46","co":"0","no2":"28","o3":"73","pm10":"46","pm25":"41","qlty":"优","so2":"2"}
         */

        private AqiBean aqi;
        /**
         * city : 北京
         * cnty : 中国
         * id : CN101010100
         * lat : 39.904000
         * lon : 116.391000
         * update : {"loc":"2016-05-10 11:50","utc":"2016-05-10 03:50"}
         */

        private BasicBean basic;
        /**
         * cond : {"code":"100","txt":"晴"}
         * fl : 25
         * hum : 28
         * pcpn : 0
         * pres : 1010
         * tmp : 24
         * vis : 10
         * wind : {"deg":"350","dir":"北风","sc":"微风","spd":"10"}
         */

        private NowBean now;
        private String status;
        /**
         * comf : {"brf":"较舒适","txt":"白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。"}
         * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
         * drsg : {"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"}
         * flu : {"brf":"少发","txt":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"}
         * sport : {"brf":"较适宜","txt":"天气较好，户外运动请注意防晒。推荐您进行室内运动。"}
         * trav : {"brf":"适宜","txt":"天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。"}
         * uv : {"brf":"强","txt":"紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。"}
         */

        private SuggestionBean suggestion;
        /**
         * astro : {"sr":"05:03","ss":"19:17"}
         * cond : {"code_d":"100","code_n":"101","txt_d":"晴","txt_n":"多云"}
         * date : 2016-05-10
         * hum : 23
         * pcpn : 0.0
         * pop : 0
         * pres : 1008
         * tmp : {"max":"28","min":"17"}
         * vis : 10
         * wind : {"deg":"192","dir":"无持续风向","sc":"微风","spd":"2"}
         */

        private List<DailyForecastBean> daily_forecast;
        /**
         * date : 2016-05-10 13:00
         * hum : 26
         * pop : 0
         * pres : 1009
         * tmp : 30
         * wind : {"deg":"192","dir":"西南风","sc":"微风","spd":"9"}
         */

        private List<HourlyForecastBean> hourly_forecast;

        public AqiBean getAqi() {
            return aqi;
        }

        public void setAqi(AqiBean aqi) {
            this.aqi = aqi;
        }

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionBean getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionBean suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastBean> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public static class AqiBean {
            /**
             * aqi : 46
             * co : 0
             * no2 : 28
             * o3 : 73
             * pm10 : 46
             * pm25 : 41
             * qlty : 优
             * so2 : 2
             */

            private CityBean city;

            public CityBean getCity() {
                return city;
            }

            public void setCity(CityBean city) {
                this.city = city;
            }

            public static class CityBean {
                private String aqi;
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
                private String qlty;
                private String so2;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicBean {
            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            /**
             * loc : 2016-05-10 11:50
             * utc : 2016-05-10 03:50
             */

            private UpdateBean update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateBean getUpdate() {
                return update;
            }

            public void setUpdate(UpdateBean update) {
                this.update = update;
            }

            public static class UpdateBean {
                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowBean {
            /**
             * code : 100
             * txt : 晴
             */

            private CondBean cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            /**
             * deg : 350
             * dir : 北风
             * sc : 微风
             * spd : 10
             */

            private WindBean wind;

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
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

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class CondBean {
                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
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

        public static class SuggestionBean {
            /**
             * brf : 较舒适
             * txt : 白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。
             */

            private ComfBean comf;
            /**
             * brf : 较适宜
             * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
             */

            private CwBean cw;
            /**
             * brf : 热
             * txt : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
             */

            private DrsgBean drsg;
            /**
             * brf : 少发
             * txt : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
             */

            private FluBean flu;
            /**
             * brf : 较适宜
             * txt : 天气较好，户外运动请注意防晒。推荐您进行室内运动。
             */

            private SportBean sport;
            /**
             * brf : 适宜
             * txt : 天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。
             */

            private TravBean trav;
            /**
             * brf : 强
             * txt : 紫外线辐射强，建议涂擦SPF20左右、PA++的防晒护肤品。避免在10点至14点暴露于日光下。
             */

            private UvBean uv;

            public ComfBean getComf() {
                return comf;
            }

            public void setComf(ComfBean comf) {
                this.comf = comf;
            }

            public CwBean getCw() {
                return cw;
            }

            public void setCw(CwBean cw) {
                this.cw = cw;
            }

            public DrsgBean getDrsg() {
                return drsg;
            }

            public void setDrsg(DrsgBean drsg) {
                this.drsg = drsg;
            }

            public FluBean getFlu() {
                return flu;
            }

            public void setFlu(FluBean flu) {
                this.flu = flu;
            }

            public SportBean getSport() {
                return sport;
            }

            public void setSport(SportBean sport) {
                this.sport = sport;
            }

            public TravBean getTrav() {
                return trav;
            }

            public void setTrav(TravBean trav) {
                this.trav = trav;
            }

            public UvBean getUv() {
                return uv;
            }

            public void setUv(UvBean uv) {
                this.uv = uv;
            }

            public static class ComfBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class DrsgBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class FluBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class TravBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class UvBean {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastBean {
            /**
             * sr : 05:03
             * ss : 19:17
             */

            private AstroBean astro;
            /**
             * code_d : 100
             * code_n : 101
             * txt_d : 晴
             * txt_n : 多云
             */

            private CondBean cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            /**
             * max : 28
             * min : 17
             */

            private TmpBean tmp;
            private String vis;
            /**
             * deg : 192
             * dir : 无持续风向
             * sc : 微风
             * spd : 2
             */

            private WindBean wind;

            public AstroBean getAstro() {
                return astro;
            }

            public void setAstro(AstroBean astro) {
                this.astro = astro;
            }

            public CondBean getCond() {
                return cond;
            }

            public void setCond(CondBean cond) {
                this.cond = cond;
            }

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

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
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

            public TmpBean getTmp() {
                return tmp;
            }

            public void setTmp(TmpBean tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public static class AstroBean {
                private String sr;
                private String ss;

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondBean {
                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpBean {
                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
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

        public static class HourlyForecastBean {
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            /**
             * deg : 192
             * dir : 西南风
             * sc : 微风
             * spd : 9
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
    }

    @Override
    public String toString() {
        return "WeatherInfoData{" +
                "He=" + He +
                '}';
    }
}
