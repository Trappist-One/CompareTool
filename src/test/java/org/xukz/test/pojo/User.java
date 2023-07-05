package org.xukz.test.pojo;

import lombok.Data;
import org.xukz.compare.annotation.CompareField;
import org.xukz.compare.annotation.Identity;
import org.xukz.test.function.CompareFunCollect;
import org.xukz.test.function.SubtractFunction;

@Data
public class User {
    @Identity
    private Long Id;

    @CompareField(name = "name", compare = CompareFunCollect.StringLength.class)
    private String name;

    @CompareField(name = "age", compare = SubtractFunction.class)
    private int age;

//    @CompareField(name = "name", compare = SubtractFunction.class)
    private String address;
}
