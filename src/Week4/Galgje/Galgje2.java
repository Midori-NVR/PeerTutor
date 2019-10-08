package Week4.Galgje;

import java.util.Scanner;

public class Galgje2 {
    public static void main(String[] args) {
        String woord = "";
        Scanner sc = new Scanner(System.in);
        while (woord.length() < 5 || woord.length() > 10) {
            System.out.print("Geef een woord (5 t.e.m. 10 letters): ");
            woord = sc.nextLine();
        }
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
        StringBuilder woordDots = new StringBuilder(woord.length());
        for (int i = 0; i < woord.length(); i++) {
            woordDots.append(".");
        }

        char letter;
        for (int i = 0; i < 8; i++) {
            System.out.println("Het te zoeken woord: " + woordDots);
            System.out.print("Raad een letter: ");
            letter = sc.nextLine().charAt(0);
            for (int j = 0; j < woord.length(); j++) {
                if(woord.toLowerCase().charAt(j) == letter || woord.toUpperCase().charAt(j) == letter){
                    woordDots.setCharAt(j, letter);
                }
            }
            if (woordDots.toString().toLowerCase().equals(woord.toLowerCase())) {
                System.out.println("\nProficiat, je hebt het woord geraden in " + (i + 1) + " beurt" + (i > 0 ? "en" : ""));
                break;
            } else if (i >= 7) {
                System.out.println("U beurten zijn over!");
            }
        }
    }
}
