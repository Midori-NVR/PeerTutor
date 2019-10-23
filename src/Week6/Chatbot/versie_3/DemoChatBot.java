package Week6.Chatbot.versie_3;

import java.util.Scanner;

public class DemoChatBot {
    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot("Veronica");
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.println(chatBot);
        System.out.println("Tik \"stop\" om te eindigen");
        while (!input.equalsIgnoreCase("stop")){
            input = sc.nextLine();
            System.out.println(chatBot.antwoordOpVraag(input));
        }
    }
}
