package dev.erictech.bearbot.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingCommand implements MessageCreateListener {
    static final Logger logger = LogManager.getLogger(PingCommand.class.getName());

    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!ping")) {
            logger.info(event.getMessage() + " in " + event.getServer() + " " + event.getChannel() + " by user " + event.getMessageAuthor());
            event.getChannel().sendMessage("Pong!");
        }
    }
}
