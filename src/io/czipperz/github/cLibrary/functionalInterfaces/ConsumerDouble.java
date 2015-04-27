package io.czipperz.github.cLibrary.functionalInterfaces;

import java.util.Objects;

/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@code ConsumerTriple} is expected
 * to operate via side-effects.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object, Object)}.
 *
 * Created by czipperz on 4/23/15.
 */
public interface ConsumerDouble<A, B> {
    /**
     * Performs this operation on the given argument.
     *
     * @param a the first input argument
     * @param b the second input argument
     */
    void accept(A a, B b);

    /**
     * Returns a composed {@code ConsumerTriple} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code ConsumerTriple} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default ConsumerDouble<A, B> andThen(ConsumerDouble<? super A, ? super B> after) {
        Objects.requireNonNull(after);
        return (A a, B b) -> { accept(a, b); after.accept(a, b); };
    }
}
