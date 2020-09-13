package dev.erictech.bearbot.commands.moderation;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.awt.*;

public class BanCommand implements CommandExecutor {
    @Command(aliases = {"!ban"}, description = "Bans a user", usage = "!ban <@user>")
    public String onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        if (args.length != 1 || message.getMentionedUsers().size() != 1) {
            return "The first argument must be a user!";
        }
        User bannedUser = message.getMentionedUsers().get(0);
        if (message.getAuthor().canBanUserFromServer(bannedUser)) {
            server.banUser(bannedUser);
            new MessageBuilder().setEmbed(new EmbedBuilder()
                    .setTitle("User Banned")
                    .setDescription("Successfully banned " + bannedUser.getDiscriminatedName())
                    .setColor(Color.red)
                    .setTimestampToNow()
                    .setFooter("Banned by: " + message.getAuthor().getDisplayName(), message.getAuthor().getAvatar()))
                    .send(channel);
            return null;
        } else return "You can not ban this user from this server!";
    }
}
