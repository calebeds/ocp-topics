package localization;

import java.util.Locale;
import java.util.ResourceBundle;

class BundleSearching {
    public static void main(String[] args) {
        showDefaultLocaleIrrelevant();
        showIgnoreAmericanBundle();
        showUsingDefaultLocale();
    }


    private static void showDefaultLocaleIrrelevant() {
        Locale.setDefault(new Locale("en", "IE"));
        Locale canadaLocale = new Locale("en", "CA");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Mill", canadaLocale);

        System.out.println(resourceBundle.getString("name"));
        System.out.println("----------------");
    }

    private static void showIgnoreAmericanBundle() {
        Locale.setDefault(new Locale("en", "IE"));
        Locale usLocale = new Locale("en", "US");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Mill", usLocale);
        System.out.println(resourceBundle.getString("open"));
        System.out.println(resourceBundle.getString("name"));
        System.out.println("----------------");

    }

    private static void showUsingDefaultLocale() {
        Locale.setDefault(new Locale("en", "IE"));
        Locale frenchLocale = new Locale("fr", "FR");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Mill", frenchLocale);
        System.out.println(resourceBundle.getString("open"));
        System.out.println(resourceBundle.getString("name"));
        System.out.println("----------------");
    }
}
