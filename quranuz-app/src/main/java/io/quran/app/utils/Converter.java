package io.quran.app.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Converter {
    public static String convertKrillToLatin(String text) {
        StringBuilder latinText = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            switch (text.charAt(i)) {
                case 'а' -> latinText.append("a");
                case 'б' -> latinText.append("b");
                case 'в' -> latinText.append("v");
                case 'г' -> latinText.append("g");
                case 'д' -> latinText.append("d");
                case 'э' -> latinText.append("e");
                case 'ё' -> latinText.append("yo");
                case 'ж' -> latinText.append("j");
                case 'з' -> latinText.append("z");
                case 'и' -> latinText.append("i");
                case 'й' -> latinText.append("y");
                case 'к' -> latinText.append("k");
                case 'л' -> latinText.append("l");
                case 'м' -> latinText.append("m");
                case 'н' -> latinText.append("n");
                case 'о' -> latinText.append("o");
                case 'п' -> latinText.append("p");
                case 'р' -> latinText.append("r");
                case 'с' -> latinText.append("s");
                case 'т' -> latinText.append("t");
                case 'у' -> latinText.append("u");
                case 'ф' -> latinText.append("f");
                case 'х' -> latinText.append("x");
                case 'ц' -> latinText.append("s");
                case 'ч' -> latinText.append("ch");
                case 'ш' -> latinText.append("sh");
                case 'щ' -> latinText.append("sh");
                case 'ъ' -> latinText.append("'");
                case 'ы' -> latinText.append("i");
                case 'ю' -> latinText.append("yu");
                case 'я' -> latinText.append("ya");
                case 'қ' -> latinText.append("q");
                case 'ў' -> latinText.append("o'");
                case 'ғ' -> latinText.append("g'");
                case 'ҳ' -> latinText.append("h");

                /* -> UPPERCASE <- */
                case 'А' -> latinText.append("A");
                case 'Б' -> latinText.append("B");
                case 'В' -> latinText.append("V");
                case 'Г' -> latinText.append("G");
                case 'Д' -> latinText.append("D");
                case 'Э' -> latinText.append("E");
                case 'Ё' -> latinText.append("Yo");
                case 'Ж' -> latinText.append("J");
                case 'З' -> latinText.append("Z");
                case 'И' -> latinText.append("I");
                case 'Й' -> latinText.append("Y");
                case 'К' -> latinText.append("K");
                case 'Л' -> latinText.append("L");
                case 'М' -> latinText.append("M");
                case 'Н' -> latinText.append("N");
                case 'О' -> latinText.append("O");
                case 'П' -> latinText.append("P");
                case 'Р' -> latinText.append("R");
                case 'С' -> latinText.append("S");
                case 'Т' -> latinText.append("T");
                case 'У' -> latinText.append("U");
                case 'Ф' -> latinText.append("F");
                case 'Х' -> latinText.append("X");
                case 'Ц' -> latinText.append("S");
                case 'Ч' -> latinText.append("Ch");
                case 'Ш' -> latinText.append("Sh");
                case 'Щ' -> latinText.append("Sh");
                case 'Ъ' -> latinText.append("'");
                case 'Ы' -> latinText.append("I");
                case 'Ю' -> latinText.append("Yu");
                case 'Я' -> latinText.append("Ya");
                case 'Қ' -> latinText.append("Q");
                case 'Ў' -> latinText.append("O'");
                case 'Ғ' -> latinText.append("G'");
                case 'Ҳ' -> latinText.append("H");
                default -> {
                    if ((i == 0 && text.charAt(i) == 'Е') ||
                        (i > 0 && text.charAt(i) == 'Е' && text.charAt(i - 1) == ' ')) {
                        latinText.append("Ye");
                    } else if ((i == 0 && text.charAt(i) == 'е') ||
                               (i > 0 && text.charAt(i) == 'е' && text.charAt(i - 1) == ' ')) {
                        latinText.append("ye");
                    } else {
                        latinText.append(text.charAt(i));
                    }
                }
            }
            i++;
        }
        return latinText.toString();
    }

    public static String convertLatinToKrill(String text) {
        StringBuilder krillText = new StringBuilder();
        String twoWord;
        int i = 0;
        while (i < text.length()) {
            twoWord = (i < text.length() - 1) ? text.charAt(i) + "" + text.charAt(i + 1) : "";
            switch (twoWord) {
                case "ya" -> { krillText.append("я"); i += 2; }
                case "Ya" -> { krillText.append("Я"); i += 2; }
                case "yu" -> { krillText.append("ю"); i += 2; }
                case "Yu" -> { krillText.append("Ю"); i += 2; }
                case "yo" -> { krillText.append("ё"); i += 2; }
                case "Yo" -> { krillText.append("Ё"); i += 2; }
                case "ch" -> { krillText.append("ч"); i += 2; }
                case "Ch" -> { krillText.append("Ч"); i += 2; }
                case "sh" -> { krillText.append("ш"); i += 2; }
                case "Sh" -> { krillText.append("Ш"); i += 2; }
                case "o'" -> { krillText.append("ў"); i += 2; }
                case "O'" -> { krillText.append("Ў"); i += 2; }
                case "g'" -> { krillText.append("ғ"); i += 2; }
                case "G'" -> { krillText.append("Ғ"); i += 2; }
                case "ye" -> { krillText.append("е"); i += 2; }
                case "Ye" -> { krillText.append("Е"); i += 2; }
                default -> {
                    switch (text.charAt(i)) {
                        case 'a' -> krillText.append("а");
                        case 'b' -> krillText.append("б");
                        case 'v' -> krillText.append("в");
                        case 'g' -> krillText.append("г");
                        case 'd' -> krillText.append("д");
                        case 'j' -> krillText.append("ж");
                        case 'z' -> krillText.append("з");
                        case 'i' -> krillText.append("и");
                        case 'y' -> krillText.append("й");
                        case 'k' -> krillText.append("к");
                        case 'l' -> krillText.append("л");
                        case 'm' -> krillText.append("м");
                        case 'n' -> krillText.append("н");
                        case 'o' -> krillText.append("о");
                        case 'p' -> krillText.append("п");
                        case 'r' -> krillText.append("р");
                        case 's' -> krillText.append("с");
                        case 't' -> krillText.append("т");
                        case 'u' -> krillText.append("у");
                        case 'f' -> krillText.append("ф");
                        case 'x' -> krillText.append("х");
                        case '\'' -> krillText.append("ъ");
                        case 'q' -> krillText.append("қ");
                        case 'h' -> krillText.append("ҳ");

                        /* -> UPPERCASE <- */
                        case 'A' -> krillText.append("А");
                        case 'B' -> krillText.append("Б");
                        case 'V' -> krillText.append("В");
                        case 'G' -> krillText.append("Г");
                        case 'D' -> krillText.append("Д");
                        case 'J' -> krillText.append("Ж");
                        case 'Z' -> krillText.append("З");
                        case 'I' -> krillText.append("И");
                        case 'Y' -> krillText.append("Й");
                        case 'K' -> krillText.append("К");
                        case 'L' -> krillText.append("Л");
                        case 'M' -> krillText.append("М");
                        case 'N' -> krillText.append("Н");
                        case 'O' -> krillText.append("О");
                        case 'P' -> krillText.append("П");
                        case 'R' -> krillText.append("Р");
                        case 'S' -> krillText.append("С");
                        case 'T' -> krillText.append("Т");
                        case 'U' -> krillText.append("У");
                        case 'F' -> krillText.append("Ф");
                        case 'X' -> krillText.append("Х");
                        case 'Q' -> krillText.append("Қ");
                        case 'H' -> krillText.append("Ҳ");
                        default -> {
                            if ((i == 0 && text.charAt(i) == 'e') || (i > 0 && text.charAt(i - 1) == ' ' && text.charAt(i) == 'e')) {
                                krillText.append("э");
                            } else if ((i == 0 && text.charAt(i) == 'E') || (i > 0 && text.charAt(i - 1) == ' ' && text.charAt(i) == 'E')) {
                                krillText.append("Э");
                            } else {
                                krillText.append(text.charAt(i));
                            }
                        }
                    }
                    i++;
                }
            }
        }
        return krillText.toString();
    }
}
/*
    private static String convert(String givenText, HashMap<Character, String> mappingChars) {
        StringBuilder expectedText = new StringBuilder();
        for (int i = 0; i < givenText.length(); i++) {
            String givenChar = givenText.charAt(i) + "";
            String givenTwoChar = givenText.charAt(i) +""+ givenText.charAt(i);
            String expectedChar = mappingChars.get(givenChar);
            if (expectedChar != null) {
                expectedText.append(expectedChar);
            } else {
                expectedText.append(givenChar);
            }
        }
        return expectedText.toString();
    }
 */