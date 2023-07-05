package org.xukz.test.function;

import org.xukz.compare.function.CompareFunction;

import java.math.BigDecimal;

public class SubtractFunction implements CompareFunction<BigDecimal, BigDecimal> {

    @Override
    public BigDecimal compare(BigDecimal o1, BigDecimal o2) {
        if (o1 == null || o2 == null) return BigDecimal.ZERO;
        return o1.subtract(o2);
    }
}
