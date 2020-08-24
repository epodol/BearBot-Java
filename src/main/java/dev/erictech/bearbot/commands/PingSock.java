package dev.erictech.bearbot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PingSock implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("<@!746461027914481815>")) {
            event.getMessage().addReaction(":PingSock:741719911679918182");
        }
    }
}
