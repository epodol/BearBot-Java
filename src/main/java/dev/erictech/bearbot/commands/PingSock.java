package dev.erictech.bearbot.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingSock implements MessageCreateListener {
    static final Logger logger = LogManager.getLogger(PingSock.class.getName());

    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().contains("<@!746461027914481815>")) {
            logger.info(event.getMessage() + " in " + event.getServer() + " " + event.getChannel() + " by user " + event.getMessageAuthor());
            event.getMessage().addReaction(":PingSock:741719911679918182");
        }
    }
}
