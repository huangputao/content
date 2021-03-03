package com.example.content.util.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
    public static final String goWeekURL = "http://api.goseek.cn/Tools/holiday?date=";//从公认网站上获取 节假日信息

    //String转时间
    public static Date parseDate(String dateValue) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter.parse(dateValue);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurrentDateTime(String format) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(format);
        String time = dateFormat.format(date);
        return time;
    }

    //获取当前时间
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * @param year    年份
     * @param pattern 返回值的格式 yyyy-MM-dd
     * @return String
     * @throws ParseException
     * @Title: getFirstDayOfYear
     * @Description: 获取某年的第一天
     * @date createTime：2018年3月26日上午11:24:54
     */
    public static String getFirstDayOfYear2(String year, String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        Date currYearFirst = calendar.getTime();
        return df.format(currYearFirst);
    }

    /**
     * @return boolean
     * @Title: compareDate
     * @Description: 比较两个时间字符串大小
     * @date 2017年8月18日下午4:26:40
     */
    public static boolean compareDate(String date, String date1, String pattern) {
        boolean flag = true;
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            Date dt = df.parse(date);
            Date dt1 = df.parse(date1);
            if (dt.getTime() > dt1.getTime()) {
                return flag = false;
            } else if (dt.getTime() < dt1.getTime()) {
                return flag = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return flag;
    }

    /**
     * @return String
     * @Title: timestampToString
     * @Description: Timestamp转String
     * @date 2017年8月31日下午2:12:27
     */
    public static String timestampToString(Timestamp timestamp, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(timestamp);
    }

    /**
     * @return Timestamp
     * @Title: stringToTimestamp
     * @Description: String转Timestamp
     * @date 2017年8月31日下午2:21:24
     */
    public static Timestamp stringToTimestamp(String time) {
        return Timestamp.valueOf(time);
    }

    /**
     * @param year    年份
     * @param pattern 返回值的格式 yyyy-MM-dd
     * @return String
     * @throws ParseException
     * @Title: getFirstDayOfYear
     * @Description: 获取某年的第一天
     * @date createTime：2018年3月26日上午11:24:54
     */
    public static String getFirstDayOfYear(String year, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        Date currYearFirst = calendar.getTime();
        return df.format(currYearFirst);
    }


    /**
     * @param year    年份
     * @param pattern 返回值的格式 yyyy-MM-dd
     * @return String
     * @throws ParseException
     * @Title: getLastDayOfYear
     * @Description: 获取某年的最后一天
     * @date createTime：2018年3月26日上午11:26:05
     */
    public static String getLastDayOfYear(String year, String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, Integer.valueOf(year));
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return df.format(currYearLast);
    }


    /**
     * @param date
     * @param pattern
     * @return String
     * @throws ParseException
     * @Title: getFirstDayOfMonth
     * @Description: 获取某月的第一天
     * @date createTime：2018年3月17日上午11:35:09
     */
    public static String getFirstDayOfMonth(String date, String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDayOfMonth = calendar.getTime();
        return df.format(firstDayOfMonth);
    }


    /**
     * @param date
     * @param pattern
     * @return String
     * @throws ParseException
     * @Title: getlastDayOfMonth
     * @Description: 获取某月的最后一天
     * @date createTime：2018年3月17日上午11:36:51
     */
    public static String getLastDayOfMonth(String date, String pattern) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        Date lastDayOfMonth = calendar.getTime();
        return df.format(lastDayOfMonth);
    }


    /**
     * @param date yyyy-MM-dd
     * @return int
     * @Title: getWeek
     * @Description: 判断日期是本年份的第几周
     * @date createTime：2018年3月26日下午2:04:01
     */
    public static int getWeek(String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal.get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * @param date
     * @return int
     * @Title: getQuarter
     * @Description: 获取日期所在的季度
     * @date createTime：2018年3月26日下午2:27:27
     */
    public static int getQuarter(String date) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(format.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int month = cal.get(Calendar.MONTH) + 1;
        int Quarter = 0;
        if (month >= 1 && month <= 3) {
            Quarter = 1;
        } else if (month >= 4 && month <= 6) {
            Quarter = 2;
        } else if (month >= 7 && month <= 9) {
            Quarter = 3;
        } else if (month >= 10 && month <= 12) {
            Quarter = 4;
        }
        return Quarter;
    }


    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return List<Date>
     * @throws Exception
     * @Title: dateSplit
     * @Description: 获取两个日期范围内的所有日期
     * @date createTime：2018年3月23日下午4:40:37
     */
    public static List<String> dateSplit(String startDate, String endDate, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse(sdf.format(sdf1.parse(startDate)));
        Date end = sdf.parse(sdf.format(sdf1.parse(endDate)));
        if (!start.before(end)) {
            throw new Exception("开始时间应该在结束时间之后");
        }
        Long spi = end.getTime() - start.getTime();
        Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数
        List<Date> dateList = new ArrayList<Date>();
        dateList.add(end);
        for (int i = 1; i <= step; i++) {
            dateList.add(new Date(dateList.get(i - 1).getTime()
                    - (24 * 60 * 60 * 1000)));// 比上一天减一
        }
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> list = new ArrayList<>();
        dateList.stream().forEach(date -> {
            list.add(sdf2.format(date));
        });
        return list;
    }


    /**
     * @param date
     * @return int 0~6 对应 周日-周六
     * @Title: getDayOfWeek
     * @Description: 获取当前日期是周几
     * @date createTime：2018年3月23日下午4:59:40
     */
    public static int getDayOfWeek(String date) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(date);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0) {
            w = 0;
        }
        return w;
    }

    public static String getDayOfWeekString(String date) {
        int num = getDayOfWeek(date);
        String times = "";
        switch (num) {
            case 1:
                times = "星期一";
                break;
            case 2:
                times = "星期二";
                break;
            case 3:
                times = "星期三";
                break;
            case 4:
                times = "星期四";
                break;
            case 5:
                times = "星期五";
                break;
            case 6:
                times = "星期六";
                break;
            case 0:
                times = "星期天";
                break;
        }
        return times;
    }

    /**
     * @param @param  start
     * @param @param  end
     * @param @throws ParseException
     * @return double
     * @Title: conpareYear
     * @Description: 获取两个时间相差多少年
     * @date createTime：2018年4月4日上午11:54:06
     */
    public static int compareYear(String start, String end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar from = Calendar.getInstance();
        from.setTime(sdf.parse(start));
        Calendar to = Calendar.getInstance();
        to.setTime(sdf.parse(end));
        int fromYear = from.get(Calendar.YEAR);
        int toYear = to.get(Calendar.YEAR);
        int d_value = toYear - fromYear;
        return d_value;
    }


    /**
     * @param date
     * @return int
     * @Title: getYearOfDate
     * @Description: 获取日期的年份
     * @date createTime：2018年3月26日下午4:24:52
     */
    public static int getYearOfDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        cal.clear();
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal.get(Calendar.YEAR);
    }


    /**
     * @param date yyyy-MM-dd
     * @return int
     * @Title: getMonthOfDate
     * @Description: 获取日期的月份
     * @date createTime：2018年3月26日下午4:03:53
     */
    public static int getMonthOfDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        cal.clear();
        try {
            cal.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal.get(Calendar.MONTH) + 1;
    }


    /**
     * @param date
     * @return int
     * @Title: getDayOfDate
     * @Description: 获取日期的天数
     * @date createTime：2018年3月26日下午4:29:00
     */
    public static int getDayOfDate(String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.clear();
        try {
            cal.setTime(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cal.get(Calendar.DATE);
    }


    /**
     * @param date 类型yyyy-MM-dd （将自动转为yyyyMMdd 否则会返回数据错误）
     * @return String 工作日对应结果为 0, 休息日对应结果为 1, 节假日对应的结果为 2, 网站失效-1, 数据格式改变-2
     * @throws ParseException
     * @Title: getHoliday
     * @Description: 获取工作日、节假日、休息日
     * @date createTime：2018年3月23日下午4:10:13
     */
    public static String getHoliday(String date) throws ParseException {
        System.out.println(date);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String param = df.format(df1.parse(date));
        StringBuffer resultBuffer = null;
        BufferedReader br = null;
        URL url;
        try {
            url = new URL(goWeekURL + param);
            URLConnection con;
            try {
                //connection = (HttpURLConnection) urlTime.openConnection();//打开连接
                con = url.openConnection();
                // 设置请求属性
                con.setRequestProperty("accept", "*/*");
                con.setRequestProperty("connection", "Keep-Alive");
                con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                // 建立连接
                con.connect();
                resultBuffer = new StringBuffer();
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String temp;
                while ((temp = br.readLine()) != null) {
                    resultBuffer.append(temp);
                }
                if (resultBuffer.indexOf("data") != -1) {
                    return resultBuffer.substring(resultBuffer.length() - 2, resultBuffer.length() - 1);
                } else {
                    return "-2";
                }
            } catch (IOException e) {
                return "-1";
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            return "-1";
        }
        return null;
    }

    /**
     * @param o(对象),type(时间类型:year,month...),format(时间格式:yyyy-MM-...),num(运算天数1,-1),resul_type(返回类型(java.util.Date)全类名)
     * @return Object
     * @Title: TimeOperation
     * @Description: 时间+-运算
     * @date 2018年5月5日
     */
    public static Object TimeOperation(Object o, String type, String format, int num, String result_type) {
        String[] oname = o.getClass().getName().split("\\.");
        SimpleDateFormat df = new SimpleDateFormat(format);
        Calendar calendar = new GregorianCalendar();
        if (oname[oname.length - 1].equalsIgnoreCase("String")) {
            String time = o.toString();
            Date date = null;
            try {
                date = df.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(date);
            return OperationResult(df, calendar, type, format, num, result_type);
        } else if (oname[oname.length - 1].equalsIgnoreCase("Date")) {
            if (oname[oname.length - 2].equalsIgnoreCase("util")) {
                calendar.setTime((Date) o);
            } else {
                calendar.setTime(new Date(((java.sql.Date) o).getTime()));
            }
            return OperationResult(df, calendar, type, format, num, result_type);
        } else if (oname[oname.length - 1].equalsIgnoreCase("TimeStamp")) {
            calendar.setTime((Timestamp) o);
            return OperationResult(df, calendar, type, format, num, result_type);
        }
        return null;
    }


    /**
     * @return Object
     * @Title: OperationResult
     * @Description:返回时间+-运算结果
     * @date 2018年5月5日
     */
    public static Object OperationResult(SimpleDateFormat df, Calendar calendar, String type, String format,
                                         int num, String result_type) {
        // 判断运算时间类型 年月日
        if (type.equalsIgnoreCase("Year")) {
            calendar.add(Calendar.YEAR, num);
        } else if (type.equalsIgnoreCase("Month")) {
            calendar.add(Calendar.MONDAY, num);
        } else if (type.equalsIgnoreCase("Day")) {
            calendar.add(Calendar.DATE, num);
        } else if (type.equalsIgnoreCase("Hour")) {
            calendar.add(Calendar.HOUR, num);
        } else if (type.equalsIgnoreCase("Minute")) {
            calendar.add(Calendar.MINUTE, num);
        } else if (type.equalsIgnoreCase("Second")) {
            calendar.add(Calendar.SECOND, num);
        }
        // 输出结果
        String rt[] = result_type.split("\\.");
        if (rt[2].equalsIgnoreCase("String")) {
            return df.format(calendar.getTime());
        } else if (rt[2].equalsIgnoreCase("Date")) {
            if (rt[1].equalsIgnoreCase("util")) {
                return calendar.getTime();
            } else {
                return new java.sql.Date(calendar.getTime().getTime());
            }
        } else if (rt[2].equalsIgnoreCase("TimeStamp")) {
            return new Timestamp(calendar.getTimeInMillis());
        }
        return null;
    }

    /**
     * 组装时间
     * @param date
     * @param time
     * @return
     */
    public static String assemblyTime(String date,String time){
    	return date+" "+time+":00";
	}

    /**
     *
     * @param dataSource 数据源,传入时间
     * @param howManyHours  比传入时间大几小时,或者小几小时   传入-1为小一小时
     * @return
     * @throws ParseException
     */
    public static String getHourTime(String dataSource,String howManyHours) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        sf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        Date date = sf.parse(dataSource);

        sf.setTimeZone(TimeZone.getTimeZone("GMT"+howManyHours));
        String time2 = sf.format(date);

        return time2;
    }
}

