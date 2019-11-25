package Week9.Rekenmachine;

import Week9.Rekenmachine.rekenen.Rekenmachine;
import Week9.Rekenmachine.rekenen.plugins.*;

import java.util.Scanner;

/**
 * PEER TUTORING
 * P2W3
 */
public class TestRekenmachine {
    private static Rekenmachine mijnCalc = new Rekenmachine();

    public static void main(String[] args) {
        //Opgave 3.1
        mijnCalc.installeer(new Optelling());
        mijnCalc.installeer(new Aftrekking());
        mijnCalc.installeer(new Vermenigvuldiging());
        mijnCalc.installeer(new Deling());
        mijnCalc.installeer(new Macht());

        //Opgave 3.3
        mijnCalc.installeer(new Plugin() {
            @Override
            public String getCommand() {
                return "MIN";
            }

            @Override
            public double bereken(double x, double y) {
                return Math.min(x,y);
            }
        });
        mijnCalc.installeer(new Plugin() {
            @Override
            public String getCommand() {
                return "MAX";
            }

            @Override
            public double bereken(double x, double y) {
                return Math.max(x,y);
            }
        });

        doeBerekeningEnDrukAf("+", 5, 2);
        doeBerekeningEnDrukAf("-", 5, 2);
        doeBerekeningEnDrukAf("*", 5, 2);
        doeBerekeningEnDrukAf("/", 5, 2);
        doeBerekeningEnDrukAf("^", 5, 2);
        doeBerekeningEnDrukAf("?", 5, 2);
        System.out.println(mijnCalc.toString());

        //Opgave 3.2
        Scanner sc = new Scanner(System.in);
        String commando;
        double x,y;
        System.out.println("Welkom bij de dynamische rekenmachine!");
        System.out.println(mijnCalc);
        while (true){
            System.out.println();
            System.out.print("Welke berekening wenst U uit te voeren (<ENTER> om te stoppen)?");
            commando = sc.nextLine();
            if(commando.equals("kale")) break;
            System.out.print("Geef twee getallen in (gescheiden door een spatie):");
            x = sc.nextDouble();
            y = sc.nextDouble();
            sc.nextLine();
            System.out.printf("%.2f %s %.2f = %.2f\n",x,commando,y,mijnCalc.bereken(commando,x,y));
        }

        System.out.println(mijnCalc.getLog());
    }

    //Opgave 3.1
    private static void doeBerekeningEnDrukAf(String commando, double getal1, double getal2){
        System.out.printf("%f %s %f = %f\n"
                , getal1, commando, getal2
                , mijnCalc.bereken(commando, getal1, getal2));
    }


}
