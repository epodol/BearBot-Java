package dev.erictech.bearbot.commands.fun.games;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class RPSCommand implements MessageCreateListener {
    private int wincounter = 0;
    public void onMessageCreate(MessageCreateEvent event) {

        if (event.getMessageContent().equalsIgnoreCase("!rps rock")) {
            event.getChannel().sendMessage("Paper - You **lose**!");
            wincounter++;
            event.getChannel().sendMessage("I have won **" + wincounter + "/" + wincounter + "** games!");
        } else if (event.getMessageContent().equalsIgnoreCase("!rps paper")) {
            event.getChannel().sendMessage("Scissors - You **lose**!");
            wincounter++;
            event.getChannel().sendMessage("I have won **" + wincounter + "/" + wincounter + "** games!");
        } else if (event.getMessageContent().equalsIgnoreCase("!rps scissors")) {
            event.getChannel().sendMessage("Rock - You **lose**!");
            wincounter++;
            event.getChannel().sendMessage("I have won **" + wincounter + "/" + wincounter + "** games!");
        } else if (event.getMessageContent().equalsIgnoreCase("!rps")) {
            event.getChannel().sendMessage("Choose rock paper scissors");
        }
    }
}
