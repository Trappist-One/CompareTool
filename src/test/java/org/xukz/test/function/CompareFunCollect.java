package org.xukz.test.function;

import org.xukz.compare.function.CompareFunction;

public class CompareFunCollect {

    public static class StringLength implements CompareFunction<String, Integer> {

        @Override
        public Integer compare(String o1, String o2) {
            int length1 = 0;
            int length2 = 0;
            if (o1 != null) {
                length1 = o1.length();
            }

            if (o2 != null) {
                length2 = o2.length();
            }

            return length1 - length2;
        }
    }
}
