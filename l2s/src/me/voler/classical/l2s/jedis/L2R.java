package me.voler.classical.l2s.jedis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class L2R {
    // 由32位（16进制）字符串得到4个5位（62进制）字符串
    public static String[] plantString(String luri) {
        String md5 = MD5Util(luri);
        char[] digits = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};
        String[] parts = new String[4];
        int[][] randoms = new int[4][5];

        for (int i = 0; i < parts.length; i++) {
            // 将32位字符串分为4段
            parts[i] = md5.substring(i * 8, (i + 1) * 8 - 1);

            int section = Integer.valueOf(parts[i], 16);
            parts[i] = "";
            // 从每段低位开始，每6位（bit）得到一个字符（62进制）
            for (int j = 0; j < randoms[i].length; j++) {
                randoms[i][j] = section & 0x3f;
                parts[i] += digits[randoms[i][j] % 62];
                section >>= 6;
            }

        }

        return parts;
    }

    // 由长链接得到32位（16进制）字符串
    public static String MD5Util(String luri) {
        byte[] bs = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(luri.getBytes());
            bs = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        char[] temp = new char[2];

        String s = "";
        for (int i = 0; i < bs.length; i++) {
            temp[0] = digits[(bs[i] >>> 4) & 0X0F];
            temp[1] = digits[bs[i] & 0X0F];

            s += new String(temp);
        }

        return s;
    }
}
