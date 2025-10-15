package questions.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

class Q2_1768 {
    public static void main(String[] args) {
        Locale myLocale = new Locale.Builder().setLanguage("en").setRegion("UK").build();
        ResourceBundle msgs = ResourceBundle.getBundle("mymsgs", myLocale);
        Set<String> keys = msgs.keySet();
        System.out.println(keys);

        keys.forEach(key -> System.out.println(key + " -> " + msgs.getString(key)));

        Enumeration<String> en = msgs.getKeys();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            String val = msgs.getString(key);
            System.out.println(key + " --> " + val);
        }
    }
}
