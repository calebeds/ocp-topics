package textblocks;

class TextBlockTest {
    public static void main(String[] args) {
//        showTextBlocks();
        showJsonTraditionalStyle();
        showJsonTextBlock();
    }

    private static void showTextBlocks() {
        String sName = "Calebe";
        String tbName = """
                Calebe""";
        System.out.println(sName.equals(tbName));
        System.out.println(sName == tbName);

        System.out.println(tbName.substring(4));

        String sQuote = "Hamlet: \"There is nothing either good or bad, but thinking make it so\"";
        System.out.println(sQuote);
        String tbQuote = """
                Hamlet: "There is nothing either good or bad, but thinking make it so"
                """;
        System.out.println(tbQuote);
    }


    private static void showJsonTraditionalStyle() {
        String text = "{" +
                "\"name\": \"Jane Doe\"," +
                "\"age\": 23," +
                "\"address\": \"Main Street, Dublin\"" +
                "}";
        System.out.println(text);
    }

    private static void showJsonTextBlock() {
        String text = """
                {
                  "name": Jane Doe",
                  "age": 23",
                  "address": "Main Street, Dublin"
                }
             """;// to remove incidental spaces, put delimiter in its own line
        System.out.println(text);
    }
}
