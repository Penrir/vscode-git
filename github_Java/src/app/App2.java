package app;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Random;

public class App2 {
    public static void main(String[] args) throws Exception {
    	
    	Date a = new Date();
       System.out.println(a);
       System.out.println(a.getDate());
       System.out.println(a.getDay());
       System.out.println(a.getTimezoneOffset());
       System.out.println(a.toGMTString());
       System.out.println(a.toLocaleString());
       
       System.out.println(LocalDate.of(2020, 4, 18).plusDays(-2));
       System.out.println(Period.ofDays(2));
       System.out.println(LocalDate.of(2020, 4, 18).minusDays(2));
    }
}