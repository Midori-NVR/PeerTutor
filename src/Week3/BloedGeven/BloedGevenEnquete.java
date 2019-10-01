package Week3.BloedGeven;

import java.util.Scanner;

public class BloedGevenEnquete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Heb je de laatste 4 maanden een tatoeage laten zetten? (J/N): ");
        char antwoord = sc.nextLine().charAt(0);
        if(antwoord == 'J'){
            System.out.println("Jammer, je komt niet in aanmerking om bloed te geven.");
        }else if(antwoord == 'N'){
            while (antwoord != 'M' && antwoord != 'V') {
                System.out.println("Ben je een man of vrouw (M/V): ");
                antwoord = sc.nextLine().charAt(0);
                if (antwoord == 'M') {
                    System.out.println("Heb je seksuele betrekkingen gehad met een andere man? (J/N): ");
                    antwoord = sc.nextLine().charAt(0);
                    return;
                } else if (antwoord == 'V') {
                    System.out.println("Ben je zwanger? (J/N): ");
                    antwoord = sc.nextLine().charAt(0);
                    return;
                }else{
                    System.out.println("Dit is niet in de keuzes.");
                }
            }
        }
    }
}
