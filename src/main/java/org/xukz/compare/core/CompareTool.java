package org.xukz.compare.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.javac.util.Assert;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.xukz.compare.annotation.CompareBody;
import org.xukz.compare.annotation.CompareField;
import org.xukz.compare.annotation.Identity;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author xukz
 * @since 1.0
 */
public class CompareTool<T> {
    private Class<T> clazz;

    private Map<String, CompareField> fieldMap = new HashMap<>();

    private CompareBody compareBody;

    private String identity;

    private Field identityField;

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

            Identity identityAnno = field.getAnnotation(Identity.class);
            if (identityAnno != null) {
                if (StringUtils.isNotBlank(identity)) {
                    throw new RuntimeException("Multiple Identity annotations present");
                }
                identity = field.getName();
                identityField = field;
            }
        });
    }

    public Map<String, Object> compare(T source, T target) {
        Map<String, T> sourceMap = JSONObject.parseObject(JSON.toJSONString(source), Map.class);
        Map<String, T> targetMap = JSONObject.parseObject(JSON.toJSONString(target), Map.class);


    }

    public List<Map<String, T>> compare(List<T> sourceList, List<T> targetList) {
        Map<Object, T> sourceListMap = parseIdentity(sourceList);
        Map<Object, T> targetListMap = parseIdentity(targetList);

        Set<Object> exsitIdentitys = new HashSet<>();
        sourceListMap.forEach((identity, sourceObj) -> {
            T targetObj = targetListMap.get(identity);
            if (targetObj == null) {

            } else {
                compare(sourceObj, targetObj);
                exsitIdentitys.add(identity);
            }
        });
    }

    @SneakyThrows
    private Map<Object, T> parseIdentity(List<T> list) {
        if (list == null) return new HashMap<>();
        LinkedHashMap<Object, T> map = new LinkedHashMap<>();
        for (T t : list) {
            Object key = identityField.get(t);
            if (key != null) {
                map.put(key, t);
            }
        }
        return map;
    }


}
