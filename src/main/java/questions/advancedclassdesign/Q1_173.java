package questions.advancedclassdesign;

abstract class Switch {
    protected abstract void switchON();
    protected abstract void switchOFF();
}

class SimpleSwitch extends Switch {

    @Override
    public void switchON() {
        System.out.println("Switched ON!");
    }

    @Override
    public void switchOFF() {
        System.out.println("Switched OFF!");
    }
}

class Fan {
    Switch aSwitch = new SimpleSwitch();
    public void test() {
        aSwitch.switchON();
        aSwitch.switchOFF();
    }
}

class Q1_173 {
    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.test();
    }
}
