// import this to use @Documented
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Doc {
    String doc();
}