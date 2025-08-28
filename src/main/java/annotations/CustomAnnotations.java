package annotations;

enum Device {LAPTOP, PHONE};

@interface Human{}

@interface OnWeb{
    int startTime() default 9;
    int hoursPerDay();

    int PEAK_TIME_START = 19;
    public static final int PEAK_TIME_END = 22;

    String name() default "calebe";
    Device consumer() default Device.LAPTOP;
    Class humanOrBot() default Human.class;
    Human extraInfo() default @Human;
    String[] sites() default {"C", "O"};
}

@OnWeb(hoursPerDay = 6) @Human class Student {}

@OnWeb(hoursPerDay = 3)
@Human
class Worker {}

class CustomAnnotations {

}
