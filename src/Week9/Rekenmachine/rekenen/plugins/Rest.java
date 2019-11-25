package Week9.Rekenmachine.rekenen.plugins;

/**
 * @author Niels Van Reeth
 * @version 1.0 25/11/2019.
 */
public class Rest implements Plugin {
    @Override
    public String getCommand() {
        return "%";
    }

    @Override
    public double bereken(double x, double y) {
        return x % y;
    }
}
