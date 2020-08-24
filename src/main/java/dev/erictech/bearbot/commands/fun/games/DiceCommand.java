package dev.erictech.bearbot.commands.fun.games;

import dev.erictech.bearbot.ComingSoonError;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class DiceCommand implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!dice")) {
            ComingSoonError.commingSoon(event.getChannel());
        }
    }
}
