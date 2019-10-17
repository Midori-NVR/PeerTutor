package Week5.Golven;

/**
 * @author Niels Van Reeth
 * @version 1.0 17/10/2019.
 */
public class GolfTest {
    public static void main(String[] args) {
        Golf golf = new Golf();
        golf.setFrequentie(2);
        for (double i = 1; i <= 5; i+=.5) {
            golf.setAmplitude(i);
            System.out.println(golf);
        }
        GolvenGrafiek golvenGrafiek = new GolvenGrafiek(10);
        golvenGrafiek.tekenGolven();
    }
}
