package org.xukz.compare.annotation;

import org.xukz.compare.function.CompareFunction;

import java.lang.annotation.*;

/**
 * @author xukz
 * @since 1.0
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CompareBody {

    Class<? extends CompareFunction> compare();

    String suffix() default "";
}
