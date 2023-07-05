package org.xukz.compare.annotation;

import org.xukz.compare.function.CompareFunction;

import java.lang.annotation.*;

/**
 * @author xukz
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface CompareField {
    String name();

    Class<? extends CompareFunction> compare();

    String suffix() default "";

    int order() default 1;
}
