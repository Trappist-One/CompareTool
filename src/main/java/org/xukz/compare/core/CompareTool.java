package org.xukz.compare.core;

import com.sun.tools.javac.util.Assert;
import org.xukz.compare.annotation.CompareBody;
import org.xukz.compare.annotation.CompareField;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xukz
 * @since 1.0
 */
public class CompareTool<T> {
    private Class<T> clazz;

    private Map<String, CompareField> fieldMap = new HashMap<>();

    private CompareBody compareBody;

    public CompareTool(Class<T> clazz) {
        Assert.checkNonNull(clazz, "Input parameter class is empty!");
        this.clazz = clazz;
        parseMetadata();
    }

    private void parseMetadata() {
        compareBody = this.clazz.getAnnotation(CompareBody.class);
        Field[] fields = clazz.getDeclaredFields();
        Arrays.asList(fields).forEach(field -> {
            CompareField fieldAnno = field.getAnnotation(CompareField.class);
            if (fieldAnno != null) {
                fieldMap.put(fieldAnno.name(), fieldAnno);
            }
        });
    }

    public Map<String, Object> compare(T source, T target) {

    }

    public List<Map<String, Object>> compare(List<T> source, List<T> target) {

    }


}
