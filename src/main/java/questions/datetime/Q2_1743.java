package questions.datetime;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

class Q2_1743 {
    public static void main(String[] args) {
        Duration duration = Duration.ofDays(2);
        System.out.println(duration);
        duration = Duration.ofDays(0);
        System.out.println(duration);
        duration = Duration.ofHours(0);
        System.out.println(duration);
        duration = Duration.ofMinutes(0);
        System.out.println(duration);
        duration = Duration.ofSeconds(0);
        System.out.println(duration);
        duration = Duration.ofMillis(0);
        System.out.println(duration);
        duration = Duration.ofNanos(0);
        System.out.println(duration);
        duration = Duration.of(5, ChronoUnit.MINUTES);
        System.out.println(duration);


        Period period = Period.ofYears(0);
        System.out.println(period);
        period = Period.ofMonths(0);
        System.out.println(period);
        period = Period.ofDays(0);
        System.out.println(period);
        period = Period.of(1, 2, 3);
        System.out.println(period);
        period = Period.ofWeeks(3);
        System.out.println(period);
    }
}
