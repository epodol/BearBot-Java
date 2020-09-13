package dev.erictech.bearbot.commands.fun.games;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;

import java.util.Random;

public class CoinCommand implements CommandExecutor {
    @Command(aliases = {"!coin", "!flip", "!flipacoin", "!coinflip"}, description = "Flips a coin", usage = "!coin")
    public void onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        Random rand = new Random();
        String result;
        boolean coin = rand.nextBoolean();
        if (coin) result = "Heads";
        else result = "Tails";
        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle("Flip a coin!")
                .addField("Result: ", "It was **" + result + "**!")
                .setTimestampToNow()
                .setFooter("Requested by: " + message.getAuthor().getDisplayName(), message.getAuthor().getAvatar()))
                .send(channel);
    }
}
