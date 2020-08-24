package dev.erictech.bearbot.commands.moderation;

import dev.erictech.bearbot.ComingSoonError;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class KickCommand implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!kick")) {
            ComingSoonError.commingSoon(event.getChannel());
        }
    }
}
