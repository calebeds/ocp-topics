package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target({ElementType.FIELD, ElementType.PARAMETER})
//@Target({ElementType.TYPE, ElementType.FIELD})
@Target(ElementType.TYPE_USE)
@interface DataItem {}

@DataItem class X{}
@DataItem interface Y{}

class Z {
    @DataItem int a;
    @DataItem static int b;

    @DataItem
    Z() {}

    void m1(@DataItem int a) {}
}
class TargetExample {
}
