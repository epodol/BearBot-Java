package dev.erictech.bearbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;

import java.awt.*;

public class HelpCommand implements CommandExecutor {

    @Command(aliases = {"!help"}, description = "Returns a random meme from reddit", usage = "!help")
    public void onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
            new MessageBuilder().setEmbed(new EmbedBuilder()
                    .setTitle("Bear Bot Commands!")
                    .setDescription("Bear Bot is still a work in progress! Most of these commands may not work as intended!")
                    .addInlineField("General", "`!help`, `!ping`, `!version`")
                    .addInlineField("Games", "`!coin`, `!dice`, `!rps`")
                    .addInlineField("Pictures", "`!meme`, `!dog`")
                    .addInlineField("Moderation", "`!ban`, `!unban`, `!mute`, `!unmute`, `!kick`, `!warn`")
                    .setColor(Color.cyan)
                    .setTimestampToNow()
                    .setFooter("Requested by: " + message.getAuthor().getDisplayName(), message.getAuthor().getAvatar()))
                    .send(channel);
    }
}
