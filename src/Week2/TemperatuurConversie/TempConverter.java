package Week2.TemperatuurConversie;

import java.util.Scanner;

/**
 * @author Niels Van Reeth
 * @version 1.0 24/09/2019.
 */
public class TempConverter {
    public static void main(String[] args) {
        int choice;
        int value;
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Conversie graden Celsius - Fahrenheit\n" +
                "====================================="
        );

        while (true) {
            System.out.println(
                    "Welke conversie wens je te doen?\n" +
                    "     1) °C naar °F\n" +
                    "     2) °F naar °C");
            System.out.print("Uw keuze?");
            choice = scanner.nextInt();
            if(choice == 0) return;
            if(choice == 1){
                System.out.print("Geef de waarde in °C:");
                value = scanner.nextInt();
                System.out.printf("%d°C = %.2f°F\n",value, value * 9./5 + 32);
            }else if(choice == 2){
                System.out.print("Geef de waarde in °F:");
                value = scanner.nextInt();
                System.out.printf("%d°F = %.2f°C\n",value,(value - 32.) * 5/9);
            }
            System.out.println("Tot ziens!");
        }
    }
}
