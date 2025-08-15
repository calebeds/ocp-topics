package localization;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

class LocalizeDates {
    public static void main(String[] args) {
        Locale localeUs = Locale.US;
        Locale localeFrench = new Locale("fr", "FR");
        Locale localeGerman = Locale.GERMANY;

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

        System.out.println("Format Style Medium");
        System.out.println("US: " + dateMediumStyle.withLocale(localeUs).format(localDateTime));
        System.out.println("French " + dateMediumStyle.withLocale(localeFrench).format(localDateTime));

        System.out.println("Format Style SHORT");
        DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);

        System.out.println("US: " + timeShortStyle.withLocale(localeUs).format(localDateTime));

        System.out.println("German: " + timeShortStyle.withLocale(localeGerman).format(localDateTime));

        DateTimeFormatter dateTimeShortStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        System.out.println("Default: " + dateTimeShortStyle.format(localDateTime));

        System.out.println("French: " + dateTimeShortStyle.withLocale(localeFrench).format(localDateTime));
    }
}
