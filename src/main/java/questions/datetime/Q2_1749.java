package questions.datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

class Q2_1749 {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
        System.out.println(localDateTime1);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime1, ZoneId.of("US/Eastern"));
        System.out.println(zonedDateTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
        System.out.println(localDateTime2);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTime2, ZoneId.of("US/Eastern"));
        System.out.println(zonedDateTime2);

        long x = ChronoUnit.HOURS.between(zonedDateTime1, zonedDateTime2);
        System.out.println(x);
        x = ChronoUnit.HOURS.between(zonedDateTime2, zonedDateTime1);
        System.out.println(x );
    }
}
