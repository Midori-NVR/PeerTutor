package Week3.BloedGeven;

import java.util.Scanner;

public class BloedGevenEnquete {
    public static void main(String[] args) {
        final double MIN_DONATIE = 0.45;
        char gender = 'O';
        Scanner sc = new Scanner(System.in);
        System.out.print("Heb je de laatste 4 maanden een tatoeage laten zetten? (J/N): ");
        char antwoord = sc.nextLine().charAt(0);
        if (antwoord == 'J' || antwoord == 'j') {
            System.out.println("Jammer, je komt niet in aanmerking om bloed te geven.");
            return;
        } else if (antwoord == 'N' || antwoord == 'n') {
            while (true) {
                System.out.print("Ben je een man of vrouw (M/V): ");
                String tmp = sc.nextLine();
                if (!tmp.isEmpty()) gender = tmp.charAt(0);
                else gender = ' ';
                if (gender == 'M' || gender == 'm') {
                    System.out.print("Heb je seksuele betrekkingen gehad met een andere man? (J/N): ");
                    antwoord = sc.nextLine().charAt(0);
                    break;
                } else if (gender == 'V' || gender == 'v') {
                    System.out.print("Ben je zwanger? (J/N): ");
                    antwoord = sc.nextLine().charAt(0);
                    break;
                } else {
                    System.out.println("Dit is niet in de keuzes.");
                }
            }
            if (!(antwoord == 'N' || antwoord == 'n')) {
                System.out.println("Jammer, je komt niet in aanmerking om bloed te geven.");
                return;
            }
        }
        System.out.print("Wat is je leeftijd? ");
        int age = sc.nextInt();
        sc.nextLine();
        if (age < 18) {
            System.out.println("Je moet minstens 18 jaar zijn.");
            return;
        }
        if (age > 71) {
            System.out.println("Je mag maximum tot 71 jaar bloedgeven.");
            return;
        }
        if (age > 66) {
            System.out.print("Heb je al bloed gegeven? ");
            antwoord = sc.nextLine().charAt(0);
            if (!(antwoord == 'J' || antwoord == 'j')) {
                System.out.println("Je kan maar tot maximum 66 jaar starten met bloedgeven.");
                return;
            } else {
                System.out.print("Hoeveel jaar geleden heb je het laatst bloedgegeven?");
                int yearPast = sc.nextInt();
                sc.nextLine();
                if (yearPast > 3) {
                    System.out.println("na 66 mag je maximum 3 jaar tussen donaties hebben.");
                    return;
                }
            }
        }
        System.out.print("Wat is je lengte (in m): ");
        double length = sc.nextDouble();
        sc.nextLine();
        System.out.print("Wat is je gewicht (in kg): ");
        double weight = sc.nextDouble();
        sc.nextLine();
        boolean allowed = false;
        double volume = 0;
        if (gender == 'M' || gender == 'm') volume = (0.3669 * Math.pow(length, 3)) + (0.03219 * weight + 0.6041);
        else if (gender == 'V' || gender == 'v') volume = (0.3561 * Math.pow(length, 3)) + (0.03308 * weight + 0.1833);
        else {
            System.out.println("Something went wrong.");
        }
        System.out.println("Bloedvolume: " + volume);
        double maxDonatie = volume * 0.13;
        System.out.println("Max donatie: " + maxDonatie);
        System.out.println("Min donatie: " + MIN_DONATIE);
        allowed = maxDonatie >= MIN_DONATIE;
        System.out.println("Je mag " + (allowed ? "WEL" : "NIET") + " bloed geven");

        System.out.printf("Bloedvolume: %.2f ", volume);

        volume = Math.round(volume*10);
        for (int i = 0; i < volume; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.printf("Max donatie: %.2f ", maxDonatie);
        maxDonatie = Math.round(maxDonatie*10);
        for (int i = 0; i < maxDonatie; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.printf("Min donatie: %.2f ", MIN_DONATIE);
        double minDonatie = Math.round(MIN_DONATIE*10);
        for (int i = 0; i < minDonatie; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
