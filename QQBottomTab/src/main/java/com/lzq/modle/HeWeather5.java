package com.lzq.modle;

/**
 * Created by Administrator on 2017/9/22.
 */

public class HeWeather5<T> {


    /**
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","prov":"北京","update":{"loc":"2016-08-3111: 52","utc":"2016-08-3103: 52"}}
     * now : {"cond":{"code":"104","txt":"阴"},"fl":"11","hum":"31","pcpn":"0","pres":"1025","tmp":"13","vis":"10","wind":{"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}}
     * status : ok
     */

    private BasicBean basic;
    private NowBean now;
    private String status;

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

    @Override
    public String toString() {
        return "HeWeather5{" +
                "basic=" + basic +
                ", now=" + now +
                ", status='" + status + '\'' +
                '}';
    }

    public boolean isReturnStatus() {
        return isReturnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        isReturnStatus = returnStatus;
    }

    public boolean isReturnStatus;

    public static class BasicBean {
        /**
         * city : 北京
         * cnty : 中国
         * id : CN101010100
         * lat : 39.904000
         * lon : 116.391000
         * prov : 北京
         * update : {"loc":"2016-08-3111: 52","utc":"2016-08-3103: 52"}
         */

        private String city;
        private String cnty;
        private String id;
        private String lat;
        private String lon;
        private String prov;
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

        public String getProv() {
            return prov;
        }

        public void setProv(String prov) {
            this.prov = prov;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public static class UpdateBean {
            @Override
            public String toString() {
                return "UpdateBean{" +
                        "loc='" + loc + '\'' +
                        ", utc='" + utc + '\'' +
                        '}';
            }

            /**
             * loc : 2016-08-3111: 52
             * utc : 2016-08-3103: 52
             */

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
        @Override
        public String toString() {
            return "NowBean{" +
                    "cond=" + cond +
                    ", fl='" + fl + '\'' +
                    ", hum='" + hum + '\'' +
                    ", pcpn='" + pcpn + '\'' +
                    ", pres='" + pres + '\'' +
                    ", tmp='" + tmp + '\'' +
                    ", vis='" + vis + '\'' +
                    ", wind=" + wind +
                    '}';
        }

        /**
         * cond : {"code":"104","txt":"阴"}
         * fl : 11
         * hum : 31
         * pcpn : 0
         * pres : 1025
         * tmp : 13
         * vis : 10
         * wind : {"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}
         */

        private CondBean cond;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
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
            /**
             * code : 104
             * txt : 阴
             */

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

            @Override
            public String toString() {
                return "CondBean{" +
                        "code='" + code + '\'' +
                        ", txt='" + txt + '\'' +
                        '}';
            }
        }

        public static class WindBean {
            @Override
            public String toString() {
                return "WindBean{" +
                        "deg='" + deg + '\'' +
                        ", dir='" + dir + '\'' +
                        ", sc='" + sc + '\'' +
                        ", spd='" + spd + '\'' +
                        '}';
            }

            /**
             * deg : 40
             * dir : 东北风
             * sc : 4-5
             * spd : 24
             */

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
