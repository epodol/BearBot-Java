package dev.erictech.bearbot.commands;

import dev.erictech.bearbot.ComingSoonError;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class HelpCommand implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!help")) {
            ComingSoonError.commingSoon(event.getChannel());
        }
    }
}
