package questions.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

class Q2_1760 {
    public static void main(String[] args) {
        Instant start = Instant.parse("2015-06-25T16:13:30.00z");
        Instant newStart = start.plus(10, ChronoUnit.HOURS);
        System.out.println("Unchanged: " + start);
        System.out.println("Changed: " + newStart);

        Duration timeToCook = Duration.ofHours(1);
        Instant readyTime = start.plus(timeToCook);
        System.out.println(readyTime);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(readyTime, ZoneId.of("GMT+2"));
        System.out.println(localDateTime);

        localDateTime = LocalDateTime.ofInstant(readyTime, ZoneId.of("GMT+12"));
        System.out.println(localDateTime);

        localDateTime = LocalDateTime.ofInstant(readyTime, ZoneId.of("US/Eastern"));
        System.out.println(localDateTime);
    }
}
