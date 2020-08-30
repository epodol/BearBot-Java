package dev.erictech.bearbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;

import java.awt.*;

public class HelpCommand implements CommandExecutor {

    @Command(aliases = {"!help"}, description = "Returns a random meme from reddit", usage = "!help")
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!help")) {
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
