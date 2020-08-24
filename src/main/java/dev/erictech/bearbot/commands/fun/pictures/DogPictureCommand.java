package dev.erictech.bearbot.commands.fun.pictures;

import dev.erictech.bearbot.ComingSoonError;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class DogPictureCommand implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!dog")) {
            ComingSoonError.commingSoon(event.getChannel());
        }
    }
}
