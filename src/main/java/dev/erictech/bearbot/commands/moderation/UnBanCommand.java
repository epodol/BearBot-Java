package dev.erictech.bearbot.commands.moderation;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Ban;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

import java.awt.*;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class UnBanCommand implements CommandExecutor {
    @Command(aliases = {"!unban", "!welcomeback"}, description = "Unbans a user by User ID", usage = "!unban <user>]")
    public String onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) throws ExecutionException, InterruptedException {
        if (args.length != 1) {
            return "The first argument must be a user ID!";
        }
        String unbannedUserID = args[0];

        CompletableFuture cf = api.getUserById(unbannedUserID);
        User user = (User) cf.get();

        Object bans = server.getBans().thenApply(x -> x.toArray());
        System.out.println(bans);

//        CompletableFuture x = server.getBans().thenApply(bans -> bans.stream()
//                .filter(ban -> ban.getUser().equals(user))
//                .findAny());



        boolean command = false;

        if (message.getAuthor().canBanUserFromServer(user)) {
            if (command){
                server.unbanUser(unbannedUserID);

                new MessageBuilder().setEmbed(new EmbedBuilder()
                        .setTitle("User Unbanned")
                        .setDescription("Successfully unbanned " + user.getDiscriminatedName())
                        .setColor(Color.red)
                        .setTimestampToNow()
                        .setFooter("Unbanned by: " + message.getAuthor().getDisplayName(), message.getAuthor().getAvatar()))
                        .send(channel);
                return null;
            } else return "This user is not banned from this server!";
        } else return "You can not unban this user from this server!";
    }
}
