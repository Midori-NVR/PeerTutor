package Week9.Rekenmachine.rekenen;

import Week9.Rekenmachine.rekenen.plugins.Plugin;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

/**
 * PEER TUTORING
 * P2W3
 */
public class Rekenmachine {
    private final int MAX_AANTAL_PLUGINS = 10;
    private Plugin[] ingeladenPlugins;
    private int aantalPlugins;
    private StringBuilder log;

    public Rekenmachine() {
        log = new StringBuilder();
        this.ingeladenPlugins = new Plugin[MAX_AANTAL_PLUGINS];
        aantalPlugins = 0;
    }

    public void installeer(Plugin teInstallerenPlugin) {
        //Opgave 2.1.a
        if(aantalPlugins >= MAX_AANTAL_PLUGINS) {
            System.out.println("array is vol");
            return;
        }
        for (Plugin plugin :ingeladenPlugins) {
            if(plugin != null && plugin.getCommand().equals(teInstallerenPlugin.getCommand())){
                System.out.println("plugin '"+teInstallerenPlugin.getCommand()+"' is al ingeladen");
                return;
            }
        }
        ingeladenPlugins[aantalPlugins] = teInstallerenPlugin;
        aantalPlugins++;
    }

    public double bereken(String command, double x, double y) {
        //Opgave 2.1.b
        for (Plugin plugin :ingeladenPlugins) {
            if (plugin != null && plugin.getCommand().equals(command)) {
                double result = plugin.bereken(x,y);
                log.append(String.format("[%s] %.5f %s %.5f = %.5f\n", new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss").format(new Date()), x,command,y,result));
                return result;
            }
        }
        System.out.println("onbekend commando '" + command + "'");
        return 0;
    }

    public String getLog(){
        return "==== LOG ====\n" + log.toString();
    }

    @Override
    public String toString() {
        //Opgave 2.1c
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Geïnstalleerde Plugins:");
        for (Plugin pl :ingeladenPlugins) {
            if (pl == null) continue;
            stringBuilder.append(" ").append(pl.getCommand());
        }
        return stringBuilder.toString();
    }
}
