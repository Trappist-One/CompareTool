package org.xukz.compare.function;

/**
 *
 * @author xukz
 * @since 1.0
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface CompareFunction<T, R> {
    R compare(T o1, T o2);
}
