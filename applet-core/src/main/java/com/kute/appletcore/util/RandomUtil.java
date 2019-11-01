package com.kute.appletcore.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class RandomUtil {

    /**
     * 生成随机码
     *
     * @param type   随机码类型[字母:letter;数字:number;字母数字组合:letter_number]
     * @param length 随机码长度
     */
    public static String generateRandomCode(String type, int length) {
        String[] beforeShuffle = null;
        if ("letter".equals(type)) {
            beforeShuffle = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                    "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        } else if ("number".equals(type)) {
            beforeShuffle = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        } else if ("letter_number".equals(type)) {
            beforeShuffle = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
                    "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        }

        List list = Arrays.asList(beforeShuffle);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(0, length);
        return result;
    }

//	public static void main(String[] args) {
//		System.out.println(generateRandomCode("letter_number", 6));
//	}

}
