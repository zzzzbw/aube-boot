package com.github.zzzzbw.aube.common.util;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Sql语句过滤工具类
 * <p>
 * 用于过滤sql注入的字符
 * <p>
 * http://antisqlfilter.sourceforge.net/
 *
 * @author by zzzzbw
 * @since 2020/08/27 17:37
 */
@UtilityClass
public class SqlFilterUtils {

    private final String[] KEY_WORDS = {";", "\"", "\'", "/*", "*/", "--", "exec",
            "select", "update", "delete", "insert",
            "alter", "drop", "create", "shutdown"};

    public boolean isUnsafe(Map<String, String[]> parameterMap) {
        for (String key : parameterMap.keySet()) {
            String[] param = parameterMap.get(key);
            for (String s : param) {
                if (isUnsafe(s)) return true;
            }
        }
        return false;
    }

    public boolean isUnsafe(String value) {
        String lowerCase = value.toLowerCase();
        for (String keyWord : KEY_WORDS) {
            if (lowerCase.contains(keyWord)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, String[]> getSafeParameterMap(Map<String, String[]> parameterMap) {
        Map<String, String[]> newMap = new HashMap<>();
        for (String key : parameterMap.keySet()) {
            String[] oldValues = parameterMap.get(key);
            String[] newValues = new String[oldValues.length];
            for (int i = 0; i < oldValues.length; i++) {
                newValues[i] = getSafeValue(oldValues[i]);
            }
            newMap.put(key, newValues);
        }
        return Collections.unmodifiableMap(newMap);
    }

    public String getSafeValue(String oldValue) {
        StringBuilder sb = new StringBuilder(oldValue);
        String lowerCase = oldValue.toLowerCase();
        for (String keyWord : KEY_WORDS) {
            int x;
            while ((x = lowerCase.indexOf(keyWord)) >= 0) {
                if (keyWord.length() == 1) {
                    sb.replace(x, x + 1, " ");
                    lowerCase = sb.toString().toLowerCase();
                    continue;
                }
                sb.deleteCharAt(x + 1);
                lowerCase = sb.toString().toLowerCase();
            }
        }
        return sb.toString();
    }
}
