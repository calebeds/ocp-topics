package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE) // not in .class file
@interface Mouse {}

@Retention(RetentionPolicy.CLASS) // in .class file
@interface Cat {}

@Retention(RetentionPolicy.RUNTIME) // stored in .class file and available at runbime
@interface Keyboard {}

class RetentionExample {
}
