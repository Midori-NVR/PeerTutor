package Week5.Golven;

import java.awt.*;
import java.util.Random;

/**
 * @author Niels Van Reeth
 * @version 1.0 17/10/2019.
 */
public class GolvenGrafiek {
    private int aantal;
    private Random rand;

    public GolvenGrafiek(int aantal) {
        this.rand = new Random();
        this.aantal = aantal;
    }

    public void tekenGolven() {
        GrafiekWindow grafiekWindow = new GrafiekWindow(10, 6);
        Golf golf = new Golf();
        Color color;
        for (int i = 0; i < aantal; i++) {
            golf.setFrequentie(rand.nextDouble() * 4);
            golf.setAmplitude(rand.nextDouble() * 4);
            color = Color.getHSBColor(rand.nextFloat() * 360, rand.nextFloat() * 100, rand.nextFloat() * 100);
            for (double j = -5; j <= 5; j += 0.0001) {
                grafiekWindow.tekenPunt(j, golf.getYwaarde(j), color);
            }
        }
        grafiekWindow.toon();
    }
}
