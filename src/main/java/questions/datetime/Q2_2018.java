package questions.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

class Q2_2018 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2021, 2, 26, 17, 0, 0);
        System.out.println(localDateTime);
        ZonedDateTime nyZonedDateTime = localDateTime.atZone(ZoneId.of("America/New_York"));
        System.out.println(nyZonedDateTime);
        ZonedDateTime laZonedDateTime = localDateTime.atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println(laZonedDateTime);

        Duration duration = Duration.between(nyZonedDateTime, laZonedDateTime);
        System.out.println(duration);

        duration = Duration.between(laZonedDateTime, nyZonedDateTime);
        System.out.println(duration);
    }
}
