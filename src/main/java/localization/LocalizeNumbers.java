package localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

class LocalizeNumbers {
    public static void main(String[] args) {
//        formatNumbers();
//        formatCurrencies();
//        parseNumbers();
//        parseCurrencies();
        showCustomerFormats();
    }

    private static void formatNumbers() {
        final double number = 77_000.11;
        System.out.println("Number format with default: " + NumberFormat.getInstance().format(number));
        System.out.println("Number format US: " + NumberFormat.getNumberInstance(Locale.US).format(number));
        System.out.println("Number format Germany: " +NumberFormat.getNumberInstance(Locale.GERMANY).format(number));
        System.out.println("Number format France: " + NumberFormat.getNumberInstance(Locale.FRANCE).format(number));
    }

    private static void formatCurrencies() {
        final double number = 23.22;
        System.out.println("Currency default: " + NumberFormat.getCurrencyInstance().format(number));
        System.out.println("Currency US: " + NumberFormat.getCurrencyInstance(Locale.US).format(number));
        System.out.println("Currency ITALY: " + NumberFormat.getCurrencyInstance(Locale.ITALY).format(number));
        System.out.println("Currency UK: " + NumberFormat.getCurrencyInstance(Locale.UK).format(number));
    }

    private static void parseNumbers() {
        final String unitedStatesNumber = "77,000.11", italianNumber = "77.000,11", frenchNumber = "77 000,11";
        try {
            System.out.printf("Parse %s: %s%n", unitedStatesNumber, NumberFormat.getNumberInstance(Locale.US).parse(unitedStatesNumber));
            System.out.printf("Parse %s: %s%n", italianNumber, NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber));
            System.out.printf("Parse %s: %s%n", frenchNumber, NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void parseCurrencies() {
        final String irishCurrency = "€23.22", unitedStatesCurrency = "$23.22",
                italianCurrency = "23,22 €", unitedKingdomCurrency = "£23.22";

        try {
            System.out.printf("Parse %s: %s%n", irishCurrency, NumberFormat.getCurrencyInstance(new Locale("en", "IE")).parse(irishCurrency));
            System.out.printf("Parse %s: %s%n", unitedStatesCurrency, NumberFormat.getCurrencyInstance(Locale.US).parse(unitedStatesCurrency));
            System.out.printf("Parse %s: %s%n", italianCurrency, NumberFormat.getCurrencyInstance(Locale.ITALY).parse(italianCurrency));
            System.out.printf("Parse %s: %s%n", unitedKingdomCurrency, NumberFormat.getCurrencyInstance(Locale.UK).parse(unitedKingdomCurrency));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showCustomerFormats() {
        final double number = 77_000.17;

        System.out.println(new DecimalFormat("€#,###,###.#").format(number));
        System.out.println(new DecimalFormat("€0,000,000.0").format(number));
    }
}
