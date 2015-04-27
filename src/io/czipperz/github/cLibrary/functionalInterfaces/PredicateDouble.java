package io.czipperz.github.cLibrary.functionalInterfaces;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by czipperz on 4/23/15.
 */
@FunctionalInterface
public interface PredicateDouble<A, B> {
    boolean test(A a, B b);

    default PredicateDouble<A, B> and(PredicateDouble<? super A, ? super B> other) {
        Objects.requireNonNull(other);
        return (A a, B b) -> test(a, b) && other.test(a, b);
    }

    default PredicateDouble<A, B> negate() {
        return (A a, B b) -> !test(a, b);
    }

    default PredicateDouble<A, B> or(PredicateDouble<? super A, ? super B> other) {
        Objects.requireNonNull(other);
        return (A a, B b) -> test(a, b) || other.test(a, b);
    }

    default FunctionDouble<A, B, Boolean> toFunction() {
        return this::test;
    }
}
