package org.minions.devfund.angela.katas;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class MorseCodeDecoder {
    final static private Map<String, String> MorseCode = new HashMap<>();
    static {
        MorseCode.put(".-", "A");
        MorseCode.put("-...", "B");
        MorseCode.put("-.-.", "C");
        MorseCode.put("-..", "D");
        MorseCode.put(".", "E");
        MorseCode.put("..-.", "F");
        MorseCode.put("--.", "G");
        MorseCode.put("....", "H");
        MorseCode.put("..", "I");
        MorseCode.put(".---", "J");
        MorseCode.put("-.-", "K");
        MorseCode.put(".-..", "L");
        MorseCode.put("--", "M");
        MorseCode.put("-.", "N");
        MorseCode.put("---", "O");
        MorseCode.put(".--.", "P");
        MorseCode.put("--.-", "Q");
        MorseCode.put(".-.", "R");
        MorseCode.put("...", "S");
        MorseCode.put("-", "T");
        MorseCode.put("..-", "U");
        MorseCode.put("...-", "V");
        MorseCode.put(".--", "W");
        MorseCode.put("-..-", "X");
        MorseCode.put("-.--", "Y");
        MorseCode.put("--..", "Z");
        //-----------------------
        MorseCode.put(".----", "1");
        MorseCode.put("..---", "2");
        MorseCode.put("...--", "3");
        MorseCode.put("....-", "4");
        MorseCode.put(".....", "5");
        MorseCode.put("-....", "6");
        MorseCode.put("--...", "7");
        MorseCode.put("---..", "8");
        MorseCode.put("----.", "9");
        MorseCode.put("-----", "0");
        //-----------------------
        MorseCode.put(".-.-.-", ".");
        MorseCode.put("--..--", ",");
    }

    static String decodeBits(String bits) {
        String trimmedBits = bits.replaceAll("^0+|0+$", "");
        int rate = getRate(trimmedBits);

        StringBuilder morseCode = new StringBuilder();
        for (String word : trimmedBits.split("0{" + (7 * rate) + "}")) {
            for (String letter : word.split("0{" + (3 * rate) + "}")) {
                for (String dot : letter.split("0{" + rate + "}")) {
                    morseCode.append(dot.length() > rate ? '-' : '.');
                }
                morseCode.append(' ');
            }
            morseCode.append("  ");
        }
        return morseCode.toString();
    }

    private static int getRate(String bits) {
        int rate = Integer.MAX_VALUE;
        Matcher matcher = Pattern.compile("1+|0+").matcher(bits);
        while (matcher.find()) {
            rate = Math.min(rate, matcher.group().length());
        }
        return rate;
    }

    static String decodeMorse(String morseCode) {
        StringBuilder decoded = new StringBuilder();
        for (String word : morseCode.trim().split(" {3}")) {
            for (String letter : word.split(" ")) {
                decoded.append(MorseCode.get(letter));
            }
            decoded.append(' ');
        }
        return decoded.toString().trim();
    }
}
