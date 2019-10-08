package Week4.Galgje;

import java.util.Scanner;

public class Galgje1 {
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
        System.out.print("Het te zoeken woord: ");
        for (int i = 0; i < woord.length(); i++) {
            System.out.print(".");
        }
        System.out.println();
        String guess = "";
        for (int i = 0; i < 5; i++) {
            System.out.print("Doe een gok: ");
            guess = sc.nextLine();
            if (guess.toLowerCase().equals(woord.toLowerCase())){
                System.out.println("\nProficiat, je hebt het woord geraden in " + (i+1) + " beurt" + (i > 0 ? "en" : ""));
                break;
            }else{
                System.out.print("Fout! ");
            }
        }
    }
}
