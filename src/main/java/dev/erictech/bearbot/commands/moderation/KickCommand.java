package dev.erictech.bearbot.commands.moderation;

import dev.erictech.bearbot.ComingSoonError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class KickCommand implements MessageCreateListener {
    static final Logger logger = LogManager.getLogger(KickCommand.class.getName());

    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!dice")) {
            logger.info(event.getMessage() + " in " + event.getServer() + " " + event.getChannel() + " by user " + event.getMessageAuthor());
            ComingSoonError.commingSoon(event.getChannel());
        }
    }
}
