package Week9.Rekenmachine.rekenen.plugins;

/**
 * @author Niels Van Reeth
 * @version 1.0 25/11/2019.
 */
public class Wortel implements Plugin {
    @Override
    public String getCommand() {
        return "V";
    }

    @Override
    public double bereken(double x, double y) {
        return Math.pow(x,1./y);
    }
}
