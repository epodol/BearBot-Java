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

public class VersionCommand implements CommandExecutor {

    @Command(aliases = {"!version"}, description = "Returns the current version that the bot is using", usage = "!version")
    public void onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle("Current Bear Bot Version")
                .addField("Current Version:", "`v0.1.3-alpha`")
                .setColor(Color.cyan)
                .setFooter("Requested by: " + message.getAuthor().getDisplayName(), message.getAuthor().getAvatar()))
                .send(channel);
    }
}
