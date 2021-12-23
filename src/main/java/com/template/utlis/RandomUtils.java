package com.template.utlis;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.template.props.Credentials.creds;
import static com.template.utlis.ObjectUtils.getRandomValue;
import static com.template.utlis.StaticOptions.answers;
import static com.template.utlis.StaticOptions.characteristicsTags;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class RandomUtils {


    public static String getRandomSite() {
        return "https://" + randomAlphabetic(10) + ".com";
    }

    public static String getRandomInstagram() {
        return "https://www.instagram.com/" + randomAlphabetic(10);
    }

    public static String getRandomGmail() {
        return creds.email().replaceAll("@", randomAlphabetic(8) + "@");
    }

    public static List<String> getRandomCharacteristicsTags(int count) {
        List<String> available = new ArrayList<>(characteristicsTags);
        List<String> values = new ArrayList<>();
        int index;
        for (int i = 0; i < count; i++) {
            index = new Random().nextInt(available.size() - 1) + 1;
            values.add(available.get(index));
            available.remove(index);
        }
        return values;
    }

    public static String getRandomAnswer() {
        return getRandomValue(answers);
    }
}
