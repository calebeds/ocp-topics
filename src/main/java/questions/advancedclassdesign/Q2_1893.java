package questions.advancedclassdesign;

class BookStore {
    private static final int taxId = 300_000;
    private String name;

    public String searchBook(final String criteria) {
        int count = 0;
        int sum = 0;
        sum++;
        class Enumerator {
            String iterate(int k) {
                System.out.println(taxId);

                System.out.println(name);
                name += "sk";

                System.out.println(criteria);

                System.out.println(count);

                return "";
            }
        }

        Enumerator enumerator = new Enumerator();

//        count++;

        enumerator.iterate(5);

        return "";
    }
}

class Q2_1893 {

}
