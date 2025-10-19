package questions.lvti;

import java.util.function.Consumer;

class Q2_3064 {
    public static void main(String[] args) {
        for(var x: System.getProperties().entrySet()) {
            var m = x.getKey();
        }

        for(var x: System.getProperties().keySet()) {
            var m = x;
        }

        var obj = (String) null;

        var k = (Consumer<String>) System.out::println;;
    }
}
