package com.example.administrator.myapplication.bean;

/**
 * Created by Administrator on 2017/6/6.
 */

public class WeaterBean {

    /**
     * resultcode : 200
     * reason : successed!
     * result : {"sk":{"temp":"23","wind_direction":"西风","wind_strength":"5级","humidity":"80%","time":"15:04"},"today":{"temperature":"19℃~25℃","weather":"阵雨转多云","weather_id":{"fa":"03","fb":"01"},"wind":"东南风3-4 级","week":"星期二","city":"无锡","date_y":"2017年06月06日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""},"future":{"day_20170606":{"temperature":"19℃~25℃","weather":"阵雨转多云","weather_id":{"fa":"03","fb":"01"},"wind":"东南风3-4 级","week":"星期二","date":"20170606"},"day_20170607":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风3-4 级","week":"星期三","date":"20170607"},"day_20170608":{"temperature":"24℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4 级","week":"星期四","date":"20170608"},"day_20170609":{"temperature":"25℃~33℃","weather":"雷阵雨转小雨","weather_id":{"fa":"04","fb":"07"},"wind":"南风微风","week":"星期五","date":"20170609"},"day_20170610":{"temperature":"25℃~30℃","weather":"小雨转阵雨","weather_id":{"fa":"07","fb":"03"},"wind":"西南风4-5 级","week":"星期六","date":"20170610"},"day_20170611":{"temperature":"24℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4 级","week":"星期日","date":"20170611"},"day_20170612":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风3-4 级","week":"星期一","date":"20170612"}}}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * sk : {"temp":"23","wind_direction":"西风","wind_strength":"5级","humidity":"80%","time":"15:04"}
         * today : {"temperature":"19℃~25℃","weather":"阵雨转多云","weather_id":{"fa":"03","fb":"01"},"wind":"东南风3-4 级","week":"星期二","city":"无锡","date_y":"2017年06月06日","dressing_index":"舒适","dressing_advice":"建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。","uv_index":"弱","comfort_index":"","wash_index":"不宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
         * future : {"day_20170606":{"temperature":"19℃~25℃","weather":"阵雨转多云","weather_id":{"fa":"03","fb":"01"},"wind":"东南风3-4 级","week":"星期二","date":"20170606"},"day_20170607":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风3-4 级","week":"星期三","date":"20170607"},"day_20170608":{"temperature":"24℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4 级","week":"星期四","date":"20170608"},"day_20170609":{"temperature":"25℃~33℃","weather":"雷阵雨转小雨","weather_id":{"fa":"04","fb":"07"},"wind":"南风微风","week":"星期五","date":"20170609"},"day_20170610":{"temperature":"25℃~30℃","weather":"小雨转阵雨","weather_id":{"fa":"07","fb":"03"},"wind":"西南风4-5 级","week":"星期六","date":"20170610"},"day_20170611":{"temperature":"24℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4 级","week":"星期日","date":"20170611"},"day_20170612":{"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风3-4 级","week":"星期一","date":"20170612"}}
         */

        private SkBean sk;
        private TodayBean today;
        private FutureBean future;

        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public FutureBean getFuture() {
            return future;
        }

        public void setFuture(FutureBean future) {
            this.future = future;
        }

        public static class SkBean {
            /**
             * temp : 23
             * wind_direction : 西风
             * wind_strength : 5级
             * humidity : 80%
             * time : 15:04
             */

            private String temp;
            private String wind_direction;
            private String wind_strength;
            private String humidity;
            private String time;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TodayBean {
            /**
             * temperature : 19℃~25℃
             * weather : 阵雨转多云
             * weather_id : {"fa":"03","fb":"01"}
             * wind : 东南风3-4 级
             * week : 星期二
             * city : 无锡
             * date_y : 2017年06月06日
             * dressing_index : 舒适
             * dressing_advice : 建议着长袖T恤、衬衫加单裤等服装。年老体弱者宜着针织长袖衬衫、马甲和长裤。
             * uv_index : 弱
             * comfort_index :
             * wash_index : 不宜
             * travel_index : 较不宜
             * exercise_index : 较不宜
             * drying_index :
             */

            private String temperature;
            private String weather;
            private WeatherIdBean weather_id;
            private String wind;
            private String week;
            private String city;
            private String date_y;
            private String dressing_index;
            private String dressing_advice;
            private String uv_index;
            private String comfort_index;
            private String wash_index;
            private String travel_index;
            private String exercise_index;
            private String drying_index;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 03
                 * fb : 01
                 */

                private String fa;
                private String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }

        public static class FutureBean {
            /**
             * day_20170606 : {"temperature":"19℃~25℃","weather":"阵雨转多云","weather_id":{"fa":"03","fb":"01"},"wind":"东南风3-4 级","week":"星期二","date":"20170606"}
             * day_20170607 : {"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风3-4 级","week":"星期三","date":"20170607"}
             * day_20170608 : {"temperature":"24℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4 级","week":"星期四","date":"20170608"}
             * day_20170609 : {"temperature":"25℃~33℃","weather":"雷阵雨转小雨","weather_id":{"fa":"04","fb":"07"},"wind":"南风微风","week":"星期五","date":"20170609"}
             * day_20170610 : {"temperature":"25℃~30℃","weather":"小雨转阵雨","weather_id":{"fa":"07","fb":"03"},"wind":"西南风4-5 级","week":"星期六","date":"20170610"}
             * day_20170611 : {"temperature":"24℃~33℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"东南风3-4 级","week":"星期日","date":"20170611"}
             * day_20170612 : {"temperature":"20℃~30℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西风3-4 级","week":"星期一","date":"20170612"}
             */

            private Day20170606Bean day_20170606;
            private Day20170607Bean day_20170607;
            private Day20170608Bean day_20170608;
            private Day20170609Bean day_20170609;
            private Day20170610Bean day_20170610;
            private Day20170611Bean day_20170611;
            private Day20170612Bean day_20170612;

            public Day20170606Bean getDay_20170606() {
                return day_20170606;
            }

            public void setDay_20170606(Day20170606Bean day_20170606) {
                this.day_20170606 = day_20170606;
            }

            public Day20170607Bean getDay_20170607() {
                return day_20170607;
            }

            public void setDay_20170607(Day20170607Bean day_20170607) {
                this.day_20170607 = day_20170607;
            }

            public Day20170608Bean getDay_20170608() {
                return day_20170608;
            }

            public void setDay_20170608(Day20170608Bean day_20170608) {
                this.day_20170608 = day_20170608;
            }

            public Day20170609Bean getDay_20170609() {
                return day_20170609;
            }

            public void setDay_20170609(Day20170609Bean day_20170609) {
                this.day_20170609 = day_20170609;
            }

            public Day20170610Bean getDay_20170610() {
                return day_20170610;
            }

            public void setDay_20170610(Day20170610Bean day_20170610) {
                this.day_20170610 = day_20170610;
            }

            public Day20170611Bean getDay_20170611() {
                return day_20170611;
            }

            public void setDay_20170611(Day20170611Bean day_20170611) {
                this.day_20170611 = day_20170611;
            }

            public Day20170612Bean getDay_20170612() {
                return day_20170612;
            }

            public void setDay_20170612(Day20170612Bean day_20170612) {
                this.day_20170612 = day_20170612;
            }

            public static class Day20170606Bean {
                /**
                 * temperature : 19℃~25℃
                 * weather : 阵雨转多云
                 * weather_id : {"fa":"03","fb":"01"}
                 * wind : 东南风3-4 级
                 * week : 星期二
                 * date : 20170606
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanX {
                    /**
                     * fa : 03
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170607Bean {
                /**
                 * temperature : 20℃~30℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 西风3-4 级
                 * week : 星期三
                 * date : 20170607
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170608Bean {
                /**
                 * temperature : 24℃~33℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 东南风3-4 级
                 * week : 星期四
                 * date : 20170608
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170609Bean {
                /**
                 * temperature : 25℃~33℃
                 * weather : 雷阵雨转小雨
                 * weather_id : {"fa":"04","fb":"07"}
                 * wind : 南风微风
                 * week : 星期五
                 * date : 20170609
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXX {
                    /**
                     * fa : 04
                     * fb : 07
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170610Bean {
                /**
                 * temperature : 25℃~30℃
                 * weather : 小雨转阵雨
                 * weather_id : {"fa":"07","fb":"03"}
                 * wind : 西南风4-5 级
                 * week : 星期六
                 * date : 20170610
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXX {
                    /**
                     * fa : 07
                     * fb : 03
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170611Bean {
                /**
                 * temperature : 24℃~33℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 东南风3-4 级
                 * week : 星期日
                 * date : 20170611
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }

            public static class Day20170612Bean {
                /**
                 * temperature : 20℃~30℃
                 * weather : 多云
                 * weather_id : {"fa":"01","fb":"01"}
                 * wind : 西风3-4 级
                 * week : 星期一
                 * date : 20170612
                 */

                private String temperature;
                private String weather;
                private WeatherIdBeanXXXXXXX weather_id;
                private String wind;
                private String week;
                private String date;

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public WeatherIdBeanXXXXXXX getWeather_id() {
                    return weather_id;
                }

                public void setWeather_id(WeatherIdBeanXXXXXXX weather_id) {
                    this.weather_id = weather_id;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getWeek() {
                    return week;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public static class WeatherIdBeanXXXXXXX {
                    /**
                     * fa : 01
                     * fb : 01
                     */

                    private String fa;
                    private String fb;

                    public String getFa() {
                        return fa;
                    }

                    public void setFa(String fa) {
                        this.fa = fa;
                    }

                    public String getFb() {
                        return fb;
                    }

                    public void setFb(String fb) {
                        this.fb = fb;
                    }
                }
            }
        }
    }
}
