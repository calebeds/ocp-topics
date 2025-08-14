package localization;

import java.util.Locale;

class CreatingLocales {
    public static void main(String[] args) {
        // 1. Constructors
        System.out.println("En locale: " + new Locale("en"));
        Locale localeEnglishGreatBritain = new Locale("en", "GB");
        System.out.printf("Display language of %s: %s %n", localeEnglishGreatBritain, localeEnglishGreatBritain.getDisplayLanguage());
        System.out.printf("Display country of %s: %s %n", localeEnglishGreatBritain, localeEnglishGreatBritain.getDisplayCountry());

        // 2. Built-in constants
        System.out.println("French locale: " + Locale.FRENCH);
        Locale localeFrenchFrance = Locale.FRANCE;
        System.out.printf("Display Language of %s: %s%n", localeFrenchFrance, localeFrenchFrance.getDisplayLanguage());
        System.out.printf("Display Country of %s: %s%n", localeFrenchFrance, localeFrenchFrance.getDisplayCountry());

        // 3. Local Builder
        Locale localeArabicEgypt = new Locale.Builder()
                .setLanguage("ar")
                .setRegion("EG")
                .build();
        System.out.println("Locale arabic egypt: " + localeArabicEgypt);

        Locale localeArabicKuwait = new Locale.Builder()
                .setRegion("KW")
                .setLanguage("ar")
                .build();
        System.out.println("Locale arabic Kuwait: " + localeArabicEgypt);

    }
}
