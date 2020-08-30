package dev.erictech.bearbot.commands.fun.games;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;

import java.awt.*;
import java.util.Random;

public class RPSCommand implements CommandExecutor {
    Random rand = new Random();

    @Command(aliases = {"!rps", "!rpsgame", "!rockpaperscissors"}, description = "Plays rock paper scissors!", usage = "!rps [rock|paper|scissors]")
    public String onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        // 0 - Win
        // 1 - Tie
        // 2 - Lose
        if (args.length > 1) {
            return "Too many arguments!";
        }
        if (args.length == 0) {
            return "Choose Rock, Paper, or Scissors";
        }
        if (args[0].equalsIgnoreCase("rock")) {
            switch (rand.nextInt(3)) {
                case 0:
                    resultRPS("Rock", "Rock", 1, channel, message);
                    break;
                case 1:
                    resultRPS("Rock", "Paper", 2, channel, message);
                    break;
                case 2:
                    resultRPS("Rock", "Scissors", 0, channel, message);
                    break;
            }
            return null;
        }
        if (args[0].equalsIgnoreCase("paper")) {
            switch (rand.nextInt(3)) {
                case 0:
                    resultRPS("Paper", "Rock", 0, channel, message);
                    break;
                case 1:
                    resultRPS("Paper", "Paper", 1, channel, message);
                    break;
                case 2:
                    resultRPS("Paper", "Scissors", 2, channel, message);
                    break;
            }
            return null;
        }
        if (args[0].equalsIgnoreCase("scissors")) {
            switch (rand.nextInt(3)) {
                case 0:
                    resultRPS("Scissors", "Rock", 2, channel, message);
                    break;
                case 1:
                    resultRPS("Scissors", "Paper", 0, channel, message);
                    break;
                case 2:
                    resultRPS("Scissors", "Scissors", 1, channel, message);
                    break;
            }
            return null;
        }
        return "Unknown argument!";
    }

    public void resultRPS(String uc, String cc, int r, TextChannel channel, Message message) {
        Color color;
        String result;
        switch (r) {
            case 0:
                color = Color.green;
                result = "You **Won**!";
                break;
            case 1:
                color = Color.orange;
                result = "It's a **tie**!";
                break;
            case 2:
                color = Color.red;
                result = "You **Lose**!";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + r);
        }
        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle("Rock Paper Scissors!")
                .setDescription(result)
                .addInlineField("You Chose:", uc)
                .addInlineField("I Chose:", cc)
                .setColor(color)
                .setFooter("Requested by: " + message.getAuthor().getDisplayName(), message.getAuthor().getAvatar()))
                .send(channel);
    }
}
