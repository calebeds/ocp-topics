package localization;

import java.text.NumberFormat;
import java.util.Locale;

class SetLocaleCategories {
    public static void main(String[] args) {
        double number = 77_000.11;
        Locale frenchLocale = new Locale("fr", "FR");

//        Locale.setDefault(frenchLocale);

        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getDisplayName());
        System.out.println(defaultLocale.getDisplayLanguage());
        System.out.println(defaultLocale.getDisplayCountry());
        System.out.println(NumberFormat.getInstance().format(number));

        Locale.setDefault(Locale.Category.DISPLAY, frenchLocale);
        System.out.println("\nDisplay changed: " + defaultLocale.getDisplayName());
        System.out.println("Display changed: " +defaultLocale.getDisplayLanguage());
        System.out.println("Display changed: " +defaultLocale.getDisplayCountry());
        System.out.println(NumberFormat.getInstance().format(number));

    }
}
