package com.rfjava;// import this to use @Documented
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Keyword {
    String name();
}