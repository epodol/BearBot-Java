package dev.erictech.bearbot.commands.moderation;

import dev.erictech.bearbot.ComingSoonError;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class UnBanCommand implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!unban")) {
            ComingSoonError.commingSoon(event.getChannel());
        }
    }
}
