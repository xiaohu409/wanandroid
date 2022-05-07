package com.github.xiaohu409.wanandroid.mvc.model.weatherbean;

import java.util.List;

public class RealWeatherBean {


    /**
     * status : ok
     * api_version : v2.5
     * api_status : active
     * lang : zh_CN
     * unit : metric
     * tzshift : 28800
     * timezone : Asia/Shanghai
     * server_time : 1640745758
     * location : [39.2072,101.6656]
     * result : {"realtime":{"status":"ok","temperature":-7,"humidity":0.58,"cloudrate":0,"skycon":"CLEAR_DAY","visibility":7.8,"dswrf":47.7,"wind":{"speed":1.8,"direction":22},"pressure":85583.47,"apparent_temperature":-9.9,"precipitation":{"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":10000,"intensity":0}},"air_quality":{"pm25":45,"pm10":49,"o3":6,"so2":8,"no2":42,"co":1.1,"aqi":{"chn":63,"usa":124},"description":{"chn":"良","usa":"轻度污染"}},"life_index":{"ultraviolet":{"index":3,"desc":"弱"},"comfort":{"index":12,"desc":"湿冷"}}},"primary":0}
     */

    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private int tzshift;
    private String timezone;
    private int server_time;
    /**
     * realtime : {"status":"ok","temperature":-7,"humidity":0.58,"cloudrate":0,"skycon":"CLEAR_DAY","visibility":7.8,"dswrf":47.7,"wind":{"speed":1.8,"direction":22},"pressure":85583.47,"apparent_temperature":-9.9,"precipitation":{"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":10000,"intensity":0}},"air_quality":{"pm25":45,"pm10":49,"o3":6,"so2":8,"no2":42,"co":1.1,"aqi":{"chn":63,"usa":124},"description":{"chn":"良","usa":"轻度污染"}},"life_index":{"ultraviolet":{"index":3,"desc":"弱"},"comfort":{"index":12,"desc":"湿冷"}}}
     * primary : 0
     */

    private ResultBean result;
    private List<Double> location;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApi_status() {
        return api_status;
    }

    public void setApi_status(String api_status) {
        this.api_status = api_status;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTzshift() {
        return tzshift;
    }

    public void setTzshift(int tzshift) {
        this.tzshift = tzshift;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public List<Double> getLocation() {
        return location;
    }

    public void setLocation(List<Double> location) {
        this.location = location;
    }

    public static class ResultBean {
        /**
         * status : ok
         * temperature : -7
         * humidity : 0.58
         * cloudrate : 0
         * skycon : CLEAR_DAY
         * visibility : 7.8
         * dswrf : 47.7
         * wind : {"speed":1.8,"direction":22}
         * pressure : 85583.47
         * apparent_temperature : -9.9
         * precipitation : {"local":{"status":"ok","datasource":"radar","intensity":0},"nearest":{"status":"ok","distance":10000,"intensity":0}}
         * air_quality : {"pm25":45,"pm10":49,"o3":6,"so2":8,"no2":42,"co":1.1,"aqi":{"chn":63,"usa":124},"description":{"chn":"良","usa":"轻度污染"}}
         * life_index : {"ultraviolet":{"index":3,"desc":"弱"},"comfort":{"index":12,"desc":"湿冷"}}
         */

        private RealtimeBean realtime;
        private int primary;

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public int getPrimary() {
            return primary;
        }

        public void setPrimary(int primary) {
            this.primary = primary;
        }

        public static class RealtimeBean {
            private String status;
            private int temperature;
            private double humidity;
            private int cloudrate;
            private String skycon;
            private double visibility;
            private double dswrf;
            /**
             * speed : 1.8
             * direction : 22
             */

            private WindBean wind;
            private double pressure;
            private double apparent_temperature;
            /**
             * local : {"status":"ok","datasource":"radar","intensity":0}
             * nearest : {"status":"ok","distance":10000,"intensity":0}
             */

            private PrecipitationBean precipitation;
            /**
             * pm25 : 45
             * pm10 : 49
             * o3 : 6
             * so2 : 8
             * no2 : 42
             * co : 1.1
             * aqi : {"chn":63,"usa":124}
             * description : {"chn":"良","usa":"轻度污染"}
             */

            private AirQualityBean air_quality;
            /**
             * ultraviolet : {"index":3,"desc":"弱"}
             * comfort : {"index":12,"desc":"湿冷"}
             */

            private LifeIndexBean life_index;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getTemperature() {
                return temperature;
            }

            public void setTemperature(int temperature) {
                this.temperature = temperature;
            }

            public double getHumidity() {
                return humidity;
            }

            public void setHumidity(double humidity) {
                this.humidity = humidity;
            }

            public int getCloudrate() {
                return cloudrate;
            }

            public void setCloudrate(int cloudrate) {
                this.cloudrate = cloudrate;
            }

            public String getSkycon() {
                return skycon;
            }

            public void setSkycon(String skycon) {
                this.skycon = skycon;
            }

            public double getVisibility() {
                return visibility;
            }

            public void setVisibility(double visibility) {
                this.visibility = visibility;
            }

            public double getDswrf() {
                return dswrf;
            }

            public void setDswrf(double dswrf) {
                this.dswrf = dswrf;
            }

            public WindBean getWind() {
                return wind;
            }

            public void setWind(WindBean wind) {
                this.wind = wind;
            }

            public double getPressure() {
                return pressure;
            }

            public void setPressure(double pressure) {
                this.pressure = pressure;
            }

            public double getApparent_temperature() {
                return apparent_temperature;
            }

            public void setApparent_temperature(double apparent_temperature) {
                this.apparent_temperature = apparent_temperature;
            }

            public PrecipitationBean getPrecipitation() {
                return precipitation;
            }

            public void setPrecipitation(PrecipitationBean precipitation) {
                this.precipitation = precipitation;
            }

            public AirQualityBean getAir_quality() {
                return air_quality;
            }

            public void setAir_quality(AirQualityBean air_quality) {
                this.air_quality = air_quality;
            }

            public LifeIndexBean getLife_index() {
                return life_index;
            }

            public void setLife_index(LifeIndexBean life_index) {
                this.life_index = life_index;
            }

            public static class WindBean {
                private double speed;
                private int direction;

                public double getSpeed() {
                    return speed;
                }

                public void setSpeed(double speed) {
                    this.speed = speed;
                }

                public int getDirection() {
                    return direction;
                }

                public void setDirection(int direction) {
                    this.direction = direction;
                }
            }

            public static class PrecipitationBean {
                /**
                 * status : ok
                 * datasource : radar
                 * intensity : 0
                 */

                private LocalBean local;
                /**
                 * status : ok
                 * distance : 10000
                 * intensity : 0
                 */

                private NearestBean nearest;

                public LocalBean getLocal() {
                    return local;
                }

                public void setLocal(LocalBean local) {
                    this.local = local;
                }

                public NearestBean getNearest() {
                    return nearest;
                }

                public void setNearest(NearestBean nearest) {
                    this.nearest = nearest;
                }

                public static class LocalBean {
                    private String status;
                    private String datasource;
                    private int intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getDatasource() {
                        return datasource;
                    }

                    public void setDatasource(String datasource) {
                        this.datasource = datasource;
                    }

                    public int getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(int intensity) {
                        this.intensity = intensity;
                    }
                }

                public static class NearestBean {
                    private String status;
                    private int distance;
                    private int intensity;

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public int getDistance() {
                        return distance;
                    }

                    public void setDistance(int distance) {
                        this.distance = distance;
                    }

                    public int getIntensity() {
                        return intensity;
                    }

                    public void setIntensity(int intensity) {
                        this.intensity = intensity;
                    }
                }
            }

            public static class AirQualityBean {
                private int pm25;
                private int pm10;
                private int o3;
                private int so2;
                private int no2;
                private double co;
                /**
                 * chn : 63
                 * usa : 124
                 */

                private AqiBean aqi;
                /**
                 * chn : 良
                 * usa : 轻度污染
                 */

                private DescriptionBean description;

                public int getPm25() {
                    return pm25;
                }

                public void setPm25(int pm25) {
                    this.pm25 = pm25;
                }

                public int getPm10() {
                    return pm10;
                }

                public void setPm10(int pm10) {
                    this.pm10 = pm10;
                }

                public int getO3() {
                    return o3;
                }

                public void setO3(int o3) {
                    this.o3 = o3;
                }

                public int getSo2() {
                    return so2;
                }

                public void setSo2(int so2) {
                    this.so2 = so2;
                }

                public int getNo2() {
                    return no2;
                }

                public void setNo2(int no2) {
                    this.no2 = no2;
                }

                public double getCo() {
                    return co;
                }

                public void setCo(double co) {
                    this.co = co;
                }

                public AqiBean getAqi() {
                    return aqi;
                }

                public void setAqi(AqiBean aqi) {
                    this.aqi = aqi;
                }

                public DescriptionBean getDescription() {
                    return description;
                }

                public void setDescription(DescriptionBean description) {
                    this.description = description;
                }

                public static class AqiBean {
                    private int chn;
                    private int usa;

                    public int getChn() {
                        return chn;
                    }

                    public void setChn(int chn) {
                        this.chn = chn;
                    }

                    public int getUsa() {
                        return usa;
                    }

                    public void setUsa(int usa) {
                        this.usa = usa;
                    }
                }

                public static class DescriptionBean {
                    private String chn;
                    private String usa;

                    public String getChn() {
                        return chn;
                    }

                    public void setChn(String chn) {
                        this.chn = chn;
                    }

                    public String getUsa() {
                        return usa;
                    }

                    public void setUsa(String usa) {
                        this.usa = usa;
                    }
                }
            }

            public static class LifeIndexBean {
                /**
                 * index : 3
                 * desc : 弱
                 */

                private UltravioletBean ultraviolet;
                /**
                 * index : 12
                 * desc : 湿冷
                 */

                private ComfortBean comfort;

                public UltravioletBean getUltraviolet() {
                    return ultraviolet;
                }

                public void setUltraviolet(UltravioletBean ultraviolet) {
                    this.ultraviolet = ultraviolet;
                }

                public ComfortBean getComfort() {
                    return comfort;
                }

                public void setComfort(ComfortBean comfort) {
                    this.comfort = comfort;
                }

                public static class UltravioletBean {
                    private int index;
                    private String desc;

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }

                public static class ComfortBean {
                    private int index;
                    private String desc;

                    public int getIndex() {
                        return index;
                    }

                    public void setIndex(int index) {
                        this.index = index;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }
                }
            }
        }
    }
}
