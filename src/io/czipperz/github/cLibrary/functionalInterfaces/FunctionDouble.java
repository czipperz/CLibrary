package io.czipperz.github.cLibrary.functionalInterfaces;

import java.util.Objects;

/**
 * Represents a function that accepts one argument and produces a result.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object, Object)}.
 *
 * @param <A> the type of the first input to the function
 * @param <B> the type of the second input to the function
 * @param <R> the type of the result of the function
 *
 * Created by czipperz on 4/23/15.
 */
@FunctionalInterface
public interface FunctionDouble<A, B, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param a the first function argument
     * @param b the second function argument
     * @return the function result
     */
    R apply(A a, B b);

    /**
     * Returns a composed function that first applies the {@code before}
     * function to its input, and then applies this function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the first type of input to the {@code before} function, and to the
     *           composed function
     * @param before the function to apply before this function is applied
     * @return a composed function that first applies the {@code before}
     * function and then applies this function
     * @throws NullPointerException if before is null
     *
     * @see #andThenFirst(FunctionDouble)
     */
    default <V> FunctionDouble<V, B, R> composeFirst(FunctionDouble<? super V, ? super B, ? extends A> before) {
        Objects.requireNonNull(before);
        return (V v, B b) -> apply(before.apply(v, b), b);
    }

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     *
     * @see #composeFirst(FunctionDouble)
     */
    default <V> FunctionDouble<A, B, V> andThenFirst(FunctionDouble<? super R, ? super B, ? extends V> after) {
        Objects.requireNonNull(after);
        return (A a, B b) -> after.apply(apply(a, b), b);
    }

    /**
     * Returns a composed function that first applies the {@code before}
     * function to its input, and then applies this function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the first type of input to the {@code before} function, and to the
     *           composed function
     * @param before the function to apply before this function is applied
     * @return a composed function that first applies the {@code before}
     * function and then applies this function
     * @throws NullPointerException if before is null
     *
     * @see #andThenFirst(FunctionDouble)
     */
    default <V> FunctionDouble<A, V, R> composeSecond(FunctionDouble<? super A, ? super V, ? extends B> before) {
        Objects.requireNonNull(before);
        return (A a, V v) -> apply(a, before.apply(a, v));
    }

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     *
     * @see #composeFirst(FunctionDouble)
     */
    default <V> FunctionDouble<A, B, V> andThenSecond(FunctionDouble<? super A, ? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (A a, B b) -> after.apply(a, apply(a, b));
    }
}
