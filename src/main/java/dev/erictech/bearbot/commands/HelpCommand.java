package dev.erictech.bearbot.commands;

import dev.erictech.bearbot.ComingSoonError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class HelpCommand implements MessageCreateListener {
    static final Logger logger = LogManager.getLogger(HelpCommand.class.getName());

    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!help")) {
            logger.info(event.getMessage() + " in " + event.getServer() + " " + event.getChannel() + " by user " + event.getMessageAuthor());
            ComingSoonError.commingSoon(event.getChannel());
        }
    }
}
