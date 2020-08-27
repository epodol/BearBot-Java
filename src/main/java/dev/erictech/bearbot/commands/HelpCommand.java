package dev.erictech.bearbot.commands;

import dev.erictech.bearbot.ComingSoonError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;

public class HelpCommand implements MessageCreateListener {
    static final Logger logger = LogManager.getLogger(HelpCommand.class.getName());

    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!help")) {
            logger.info(event.getMessage() + " in " + event.getServer() + " " + event.getChannel() + " by user " + event.getMessageAuthor());
            new MessageBuilder().setEmbed(new EmbedBuilder()
                    .setTitle("Bear Bot Commands!")
                    .setDescription("Bear Bot is still a work in progress! Most of these commands may not work as intended!")
                    .addInlineField("General", "!help, !ping, @bear")
                    .addInlineField("Games", "!coin, !dice, !rps")
                    .addInlineField("Pictures", "!meme, !dog")
                    .addInlineField("Moderation", "!ban, !unban, !mute, !unmute, !kick")
                    .setColor(Color.cyan))
                    .send(event.getChannel());
        }
    }
}
