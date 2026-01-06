package test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class DateTime {

    public static void main(String [] args){
        LocalDateTime localDate = LocalDateTime.now();
        LocalDateTime localDate2 = LocalDateTime.now().plus(3, TimeUnit.HOURS.toChronoUnit());
//        Period p = Period.between(localDate, localDate2);
        Duration duration = Duration.between(localDate, localDate2);
        System.out.println("the difference "+duration.toHours());
//        System.out.println("the difference "+ChronoUnit.HOURS.between(localDate, localDate2));
    }
}
