package Week6.Chatbot.versie_4;

import java.util.Random;

public class ChatBot {
    private String naam;
    private Random random;
    private String[] antwoorden;
    private String[] zoekWoorden;
    private String[] nonsensAntwoorden;
    private String[] scheldWoorden;
    private long time;
    private int count = 0;
    private int scheldCount = 0;

    public ChatBot(String naam) {
        this.naam = naam;
        this.random = new Random();
        antwoorden = new String[]{"Ok, probeer eerst al eens te herstarten", "Kan je het probleem eens herformuleren?", "En is dat al lang zo?",
                "Waarom heb je ons niet eerder gecontacteerd?", "Ik denk dat je dat zelf wel kan oplossen, niet?", "Die vraag heb ik nog niet vaak gehad!",
                "Sorry, ik was even bezig, kan je de vraag eens herhalen?", "Aha, gekend probleem, ik zoek het op en laat je iets weten.", "Sorry, daar heb ik niet direct een antwoord op. Wat nu?", "En dan?",
                "Dat zal wel, maar er zijn ergere dingen he.", "Hmm, die moet ik opzoeken. En wanneer deed dat zich juist voor?"};
        zoekWoorden = new String[]{"aanloggen", "traag", "scherm", "hangt", "kleuren", "trager", "geluid", "vooruit", "niet", "gisteren", "weekend", "geen idee", "oplossing", "geen", "zeker"};
        nonsensAntwoorden = new String[]{"Probeer opnieuw aan te loggen, lost dat je probleem op?", "Herstarten van het systeem kan vele snelheidsproblemen oplossen. Heb je dat al geprobeerd?",
                "Misschien is er iets mis met de video adapter?",
                "Je kan best nog even wachten, mogelijk lost het probleem zichzelf op.", "Heb je onlangs nieuwe videosoftware geïnstalleerd?", "Is er nog voldoende ruimte vrij op het toestel?", "Het volume staat toch juist he?",
                "Mogelijk een probleem met één van de systeemdrivers.", "Pas op, soms wel hoor.", "En eergisteren?",
                "In de week werken die dingen meestal vlotter...", "Niet wanhopen, we vinden samen wel een oplossing.", "Ik zal het wel oplossen, geef jij mij gewoon wat meer info.", "Echt geen?",
                "Ik ken dat 'zeker', uiteindelijk blijkt het toch niet!"};
        scheldWoorden = new String[]{"fuck", "shit", "idiot", "idioot", "stom"};
        time = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Hallo, ik ben chatbot " + naam + ", stel me een vraag en ik geef je een oplossing!";
    }

    public String antwoordOpVraag(String vraag) {
        if (vraag.length() < 4) {
            return "";
        } else if (vraag.equalsIgnoreCase("stop")) {
            time = System.currentTimeMillis() - time;
            return "Je hebt blijkbaar geen vragen meer. Ok, dan ben ik weg. De groeten van " + naam;
        } else {
            vraag = vraag.toLowerCase();
            for (String scheldwoord : scheldWoorden) {
                if (vraag.contains(scheldwoord.toLowerCase())) {
                    scheldCount++;
                    return "Gelieve beleefd te blijven!";
                }
            }
            if (++count > 5) System.out.print("Zucht, typisch. ");
            for (int i = 0; i < zoekWoorden.length; i++) {
                if (vraag.contains(zoekWoorden[i].toLowerCase())) {
                    return nonsensAntwoorden[i];
                }
            }
            return antwoorden[random.nextInt(antwoorden.length)];
        }
    }

    public String printFactuur() {
        StringBuilder factuur = new StringBuilder();
        int price = 0;
        factuur.append("Factuur:\n");
        factuur.append("Item              Prijs\n");
        factuur.append("=======================\n");
        price +=10;
        time-= 60000;
        factuur.append(String.format("Opstart            € %2d\n",price));
        if (time > 0) {
            factuur.append("Extra time:\n");
            int quarters = (int) Math.ceil(time / 15000.);
            price += quarters;
            factuur.append(String.format("%dx15seconden       € %2d\n", quarters, quarters));
        }
        if(scheldCount > 0) {
            price+= scheldCount*5;
            factuur.append(String.format("Scheldboete        € %2d\n",scheldCount*5));
        }
        factuur.append(String.format("TOTAAL             € %2d\n",price));
        factuur.append("\nGelieve binnen de 2 werkdagen te betalen.");
        return factuur.toString();
    }
}
