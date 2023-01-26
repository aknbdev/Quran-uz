package io.quran.app.utils;
import lombok.experimental.UtilityClass;
import java.util.HashMap;

@UtilityClass
public class Converter {
    private static final HashMap<Character, String> krillToLatinMap = new HashMap<>();
    private static final HashMap<Character, String> latinToKrillMap = new HashMap<>();

    static {
        krillToLatinMap.put('а', "a");
        krillToLatinMap.put('б', "b");
        krillToLatinMap.put('в', "v");
        krillToLatinMap.put('г', "g");
        krillToLatinMap.put('д', "d");
        krillToLatinMap.put('е', "e");
        krillToLatinMap.put('ё', "yo");
        krillToLatinMap.put('ж', "j");
        krillToLatinMap.put('з', "z");
        krillToLatinMap.put('и', "i");
        krillToLatinMap.put('й', "y");
        krillToLatinMap.put('к', "k");
        krillToLatinMap.put('л', "l");
        krillToLatinMap.put('м', "m");
        krillToLatinMap.put('н', "n");
        krillToLatinMap.put('о', "o");
        krillToLatinMap.put('п', "p");
        krillToLatinMap.put('р', "r");
        krillToLatinMap.put('с', "s");
        krillToLatinMap.put('т', "t");
        krillToLatinMap.put('у', "u");
        krillToLatinMap.put('ф', "f");
        krillToLatinMap.put('х', "x");
        krillToLatinMap.put('ц', "s");
        krillToLatinMap.put('ч', "ch");
        krillToLatinMap.put('ш', "sh");
        krillToLatinMap.put('щ', "sh");
        krillToLatinMap.put('ъ', "'");
        krillToLatinMap.put('ь', "");
        krillToLatinMap.put('ы', "i");
        krillToLatinMap.put('э', "e");
        krillToLatinMap.put('ю', "yu");
        krillToLatinMap.put('я', "ya");
        krillToLatinMap.put('қ', "q");
        krillToLatinMap.put('ў', "o'");
        krillToLatinMap.put('ғ', "g'");
        krillToLatinMap.put('ҳ', "h");
    }

    static {
        System.out.println("Run Latin to Uzbek block");
        krillToLatinMap.put('А', "A");
        krillToLatinMap.put('Б', "B");
        krillToLatinMap.put('В', "V");
        krillToLatinMap.put('Г', "G");
        krillToLatinMap.put('Д', "D");
        krillToLatinMap.put('Е', "E");
        krillToLatinMap.put('Ё', "Yo");
        krillToLatinMap.put('Ж', "J");
        krillToLatinMap.put('З', "Z");
        krillToLatinMap.put('И', "I");
        krillToLatinMap.put('Й', "Y");
        krillToLatinMap.put('К', "K");
        krillToLatinMap.put('Л', "L");
        krillToLatinMap.put('М', "M");
        krillToLatinMap.put('Н', "N");
        krillToLatinMap.put('О', "O");
        krillToLatinMap.put('П', "P");
        krillToLatinMap.put('Р', "R");
        krillToLatinMap.put('С', "S");
        krillToLatinMap.put('Т', "T");
        krillToLatinMap.put('У', "U");
        krillToLatinMap.put('Ф', "F");
        krillToLatinMap.put('Х', "X");
        krillToLatinMap.put('Ц', "S");
        krillToLatinMap.put('Ч', "Ch");
        krillToLatinMap.put('Ш', "Sh");
        krillToLatinMap.put('Щ', "Sh");
        krillToLatinMap.put('Ъ', "'");
        krillToLatinMap.put('Ь', "");
        krillToLatinMap.put('Ы', "I");
        krillToLatinMap.put('Э', "E");
        krillToLatinMap.put('Ю', "Yu");
        krillToLatinMap.put('Я', "Ya");
        krillToLatinMap.put('Қ', "Q");
        krillToLatinMap.put('Ў', "O'");
        krillToLatinMap.put('Ғ', "G'");
        krillToLatinMap.put('Ҳ', "H");
    }

    public static String convertKrillToLatin(String text) {
        return convert(text, krillToLatinMap);
    }
    public static String convertLatinToKrill(String text) {
        return convert(text, latinToKrillMap);
    }

    private static String convert(String givenText, HashMap<Character, String> mappingChars) {
        StringBuilder expectedText = new StringBuilder();
        for (int i = 0; i < givenText.length(); i++) {
            char givenChar = givenText.charAt(i);
            String expectedChar = mappingChars.get(givenChar);
            if (expectedChar != null) {
                expectedText.append(expectedChar);
            } else {
                expectedText.append(givenChar);
            }
        }
        return expectedText.toString();
    }
}