package io.czipperz.github.cLibrary.functionalInterfaces;

import java.util.Objects;

/**
 * Represents a function that accepts one argument and produces a result.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object, Object, Object)}.
 *
 * @param <A> the type of the first input to the function
 * @param <B> the type of the second input to the function
 * @param <C> the type of the third input to the function
 * @param <R> the type of the result of the function
 *
 * Created by czipperz on 4/23/15.
 */
@FunctionalInterface
public interface FunctionTriple<A, B, C, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param a the first function argument
     * @param b the second function argument
     * @return the function result
     */
    R apply(A a, B b, C c);

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
     * @see #andThenFirst(FunctionTriple)
     */
    default <V> FunctionTriple<V, B, C, R> composeFirst(FunctionTriple<? super V, ? super B, ? super C, ? extends A> before) {
        Objects.requireNonNull(before);
        return (V v, B b, C c) -> apply(before.apply(v, b, c), b, c);
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
     * @see #composeFirst(FunctionTriple)
     */
    default <V> FunctionTriple<A, B, C, V> andThenFirst(FunctionTriple<? super R, ? super B, ? super C, ? extends V> after) {
        Objects.requireNonNull(after);
        return (A a, B b, C c) -> after.apply(apply(a, b, c), b, c);
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
     * @see #andThenFirst(FunctionTriple)
     */
    default <V> FunctionTriple<A, V, C, R> composeSecond(FunctionTriple<? super A, ? super V, ? super C, ? extends B> before) {
        Objects.requireNonNull(before);
        return (A a, V v, C c) -> apply(a, before.apply(a, v, c), c);
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
     * @see #composeFirst(FunctionTriple)
     */
    default <V> FunctionTriple<A, B, C, V> andThenSecond(FunctionTriple<? super A, ? super R, ? super C, ? extends V> after) {
        Objects.requireNonNull(after);
        return (A a, B b, C c) -> after.apply(a, apply(a, b, c), c);
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
     * @see #andThenFirst(FunctionTriple)
     */
    default <V> FunctionTriple<A, B, V, R> composeThird(FunctionTriple<? super A, ? super B, ? super V, ? extends C> before) {
        Objects.requireNonNull(before);
        return (A a, B b, V v) -> apply(a, b, before.apply(a, b, v));
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
     * @see #composeFirst(FunctionTriple)
     */
    default <V> FunctionTriple<A, B, C, V> andThenThird(FunctionTriple<? super A, ? super B, ? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (A a, B b, C c) -> after.apply(a, b, apply(a, b, c));
    }
}
