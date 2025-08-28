package annotations;

import java.lang.annotation.Inherited;

@Inherited @interface BreathInWater {}

@BreathInWater class Fish {

}

class Trout extends Fish {}

class InheritedExample {
}
