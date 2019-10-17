package Week5.Golven;

/**
 * @author Niels Van Reeth
 * @version 1.0 17/10/2019.
 */
public class Golf {
    private double amplitude;
    private double frequentie;

    public Golf() {
        this.amplitude = 1.0;
        this.frequentie = 1.0;
    }

    public double getYwaarde(double x){
        return amplitude * Math.sin(frequentie * x);
    }

    @Override
    public String toString() {
        StringBuilder formule = new StringBuilder();
        formule.append("y = ");
        if (amplitude != 1) formule.append(String.format("%.1f ",amplitude));
        formule.append("sin (");
        if (frequentie != 1) formule.append(String.format("%.1f ",frequentie));
        formule.append("x)");
        return formule.toString();
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        if (amplitude == 0) return;
        this.amplitude = amplitude;
    }

    public double getFrequentie() {
        return frequentie;
    }

    public void setFrequentie(double frequentie) {
        if (frequentie == 0) return;
        this.frequentie = frequentie;
    }
}
