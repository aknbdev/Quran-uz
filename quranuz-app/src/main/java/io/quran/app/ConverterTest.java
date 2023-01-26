package io.quran.app;
import java.util.Scanner;
import static io.quran.app.utils.Converter.convertKrillToLatin;
import static io.quran.app.utils.Converter.convertLatinToKrill;

public class ConverterTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean breaker = false;
        while (!breaker) {
            System.out.println("""
                    Send me wanted converter number!
                    1) Latin -> Uzbek
                    2) Uzbek -> Latin
                    3) Stop""");
            int converterNumber = in.nextInt();
            in.nextLine();
            if (converterNumber == 1) {
                System.out.print("Latin -> Uzbek\nEnter text: ");
                String text = in.nextLine();
                String convertedText = convertKrillToLatin(text);
                System.out.println(convertedText);
            } else if (converterNumber == 2) {
                System.out.print("Uzbek -> Latin\nEnter text: ");
                String text = in.nextLine();
                String convertedText = convertLatinToKrill(text);
                System.out.println(convertedText);
            } else if (converterNumber == 3) {
                breaker = true;
            } else {
                System.out.println("Unexpected command!!!");
            }
            System.out.println("\n\n\n");
        }
        in.close();
    }
}
