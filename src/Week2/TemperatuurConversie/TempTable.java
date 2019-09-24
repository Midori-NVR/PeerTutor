package Week2.TemperatuurConversie;

import java.util.Scanner;

/**
 * @author Niels Van Reeth
 * @version 1.0 24/09/2019.
 */
public class TempTable {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        int start;
        int end;
        int step;
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Conversietabel °C naar °F\n" +
                        "========================="
        );
        System.out.print("Geef de begintemperatuur in °C:");
        start = scanner.nextInt();
        System.out.print("Geef de eindtemperatuur in °C:");
        end = scanner.nextInt();
        if (start >= end){
            System.out.println("De begintemperatuur moet kleiner zijn dan de eindtemperatuur!");
            return;
        }
        System.out.print("Geef de stapwaarde:");
        step = scanner.nextInt();
        while (start <= end){
            System.out.printf("%d°C = %.1f°F\n", start, start*9./5 +32);
            start += step;
        }
    }
}
