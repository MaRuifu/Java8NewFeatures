package com.test5Date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestDate {


    /**
     * Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。
     *
     * 在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：
     *
     * 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
     *
     * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
     *
     * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
     *
     * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
     *
     * Local(本地) − 简化了日期时间的处理，没有时区的问题。
     *
     * Zoned(时区) − 通过制定的时区处理日期时间。
     *
     * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作
     */




    //1.LocalDate    LocalTime   LocalDateTime  用法一样,用于让人读的时间日期
    @Test
    public void test1(){
        LocalDateTime ldt=LocalDateTime.now();//获取当前日期时间
        System.out.println(ldt);

        LocalDateTime ldt2=LocalDateTime.of(2020,10,19,13,22,33);//指定一个日期时间
        System.out.println(ldt2);

        LocalDateTime ldt3=ldt.plusYears(2);//加2年
        System.out.println(ldt3);

        LocalDateTime ldt4=ldt.minusMonths(2);//减2个月
        System.out.println(ldt4);

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());
    }

    //2.Instant:时间戳（以Unix元年： 1970年1月1日00:00:00到某个时间之间的毫秒值）
    @Test
    public void test2(){
        Instant ins1=Instant.now();//默认获取UTC时区的时间
        System.out.println(ins1);

        OffsetDateTime odt=ins1.atOffset(ZoneOffset.ofHours(8));//获取偏移日期时间，加8小时偏移
        System.out.println(odt);

        System.out.println(ins1.toEpochMilli());//获取与Unix元年间隔毫秒数

        Instant ins2=Instant.ofEpochSecond(60);//较Unix元年加60秒
        System.out.println(ins2);//1970-01-01T00:01:00Z
    }

    //3.Duration:计算两个时间之间的间隔，Period：计算两个日期之间的间隔
    @Test
    public void test3(){
        Instant ins1=Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Instant ins2=Instant.now();
        Duration duration=Duration.between(ins1, ins2);
        System.out.println(duration.toMillis());//1000

        System.out.println("------------------------------");

        LocalTime lt1=LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        LocalTime lt2=LocalTime.now();
        System.out.println(Duration.between(lt1, lt2).toMillis());//1001

        System.out.println("------------------------------");

        LocalDate ld1=LocalDate.of(2015, 1, 1);
        LocalDate ld2=LocalDate.now();
        Period period=Period.between(ld1, ld2);
        System.out.println(period.getYears());//2
        System.out.println(period.getMonths());//6
        System.out.println(period.getDays());//19
    }

    //TemporalAdjuster:时间校验器
    @Test
    public void test5(){
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);//2017-07-20T19:28:57.822

        LocalDateTime ldt2=ldt.withDayOfMonth(10);
        System.out.println(ldt2);//2017-07-10T19:28:57.822

        LocalDateTime ldt3=ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));//调整为下个周日
        System.out.println(ldt3);//2017-07-23T19:31:39.479

        //自定义：下一个工作日
        LocalDateTime ldt5=ldt.with((l)->{
            LocalDateTime ldt4=(LocalDateTime)l;
            DayOfWeek dow=ldt4.getDayOfWeek();//获取当前星期
            if(dow.equals(DayOfWeek.FRIDAY)){//如果是周5，下个工作日即加3天
                return ldt4.plusDays(3);
            }else if(dow.equals(DayOfWeek.SATURDAY)){//如果是周6，下个工作日即加2天
                return ldt4.plusDays(2);
            }else{
                return ldt4.plusDays(1);//其他，下个工作日即为明天
            }
        });
        System.out.println(ldt5);//2017-07-21T19:37:05.533
    }

    //DateTimeFormatter:格式化时间/日期
    @Test
    public void test6(){
        DateTimeFormatter dtf=DateTimeFormatter.ISO_DATE;
        DateTimeFormatter dtf1=DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt=LocalDateTime.now();

        String strDate=ldt.format(dtf);
        System.out.println(strDate);

        System.out.println("------------------------");

        DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");//自定义格式化格式
        String strDate2=dtf2.format(ldt);
        System.out.println(strDate2);//2017年07月20日 19:49:53

        LocalDateTime newDate=ldt.parse(strDate2,dtf2);//以指定格式解析字符串，重新获得LocalDateTime类型
        System.out.println(newDate);//2017-07-20T19:49:53
    }
 @Test
    public void test61(){

        String strDate=LocalDateTime.ofInstant(Instant.ofEpochMilli(8000), ZoneId.of("UCT")).format(DateTimeFormatter.ISO_TIME);
        System.out.println(strDate);
        System.out.println(ZoneId.systemDefault());

    }



    @Test
    public void test62(){
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

        String  staTime = "13:00";
        String  endTime = "13:01";

        LocalDateTime staLocalDateTime=LocalDateTime.of(0,0,0,String.join(staTime,":").,22,0);//指定一个日期时间
        LocalDateTime endLocalDateTime=LocalDateTime.of(0,0,0,13,22,0);//指定一个日期时间
//
//        LocalDateTime staLocalDateTime = LocalDateTime.parse("13:00", dtf);
//        LocalDateTime endLocalDateTime = LocalDateTime.parse("13:01", dtf);
        System.out.println(Math.abs(ChronoUnit.SECONDS.between(staLocalDateTime, endLocalDateTime)));

    }




    //ZonedDate、ZonedTime、ZonedDateTime
    @Test
    public void test7(){
        Set<String> set=ZoneId.getAvailableZoneIds();//获取支持的所有时区
        set.forEach(System.out::println);

        LocalDateTime ldt=LocalDateTime.now(ZoneId.of("Europe/Monaco"));//获取指定时区的日期时间类型
        System.out.println(ldt);//2017-07-20T14:01:23.417

        LocalDateTime ldt2=LocalDateTime.now(ZoneId.of("Europe/Monaco"));
        ZonedDateTime zdt=ldt2.atZone(ZoneId.of("Europe/Monaco"));//获取带时区的时间类型
        System.out.println(zdt);//2017-07-20T14:01:23.420+02:00[Europe/Monaco]//与UTC时间有2个小时的时差
    }
}
