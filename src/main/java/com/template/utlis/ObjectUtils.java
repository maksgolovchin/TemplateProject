package com.template.utlis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectUtils {

    public static String getRandomValue(List<String> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    public List<String> getFewValues(ArrayList<String> values) {
        List<String> newValues = new ArrayList<>();
        ArrayList<String> availableValues = new ArrayList<>(values);
        for (int i = 1; i <= new Random().nextInt(values.size()) + 1; i++) {
            String value = getRandomValue(availableValues);
            newValues.add(value);
            availableValues.remove(value);
        }
        return newValues;
    }
}
