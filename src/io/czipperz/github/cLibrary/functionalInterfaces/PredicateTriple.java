package io.czipperz.github.cLibrary.functionalInterfaces;

import java.awt.*;
import java.util.Objects;

/**
 * Created by czipperz on 4/23/15.
 */
@FunctionalInterface
public interface PredicateTriple<A, B, C> {
    boolean test(A a, B b, C c);

    default PredicateTriple<A, B, C> and(PredicateTriple<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other);
        return (A a, B b, C c) -> test(a, b, c) && other.test(a, b, c);
    }

    default PredicateTriple<A, B, C> negate() {
        return (A a, B b, C c) -> !test(a, b, c);
    }

    default PredicateTriple<A, B, C> or(PredicateTriple<? super A, ? super B, ? super C> other) {
        Objects.requireNonNull(other);
        return (A a, B b, C c) -> test(a, b, c) || other.test(a, b, c);
    }

    default FunctionTriple<A, B, C, Boolean> toFunction() {
        return this::test;
    }
}
