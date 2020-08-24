package dev.erictech.bearbot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingCommand implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("Pong!");
        }
    }
}
