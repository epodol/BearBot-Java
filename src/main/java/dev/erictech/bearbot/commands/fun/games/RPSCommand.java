package dev.erictech.bearbot.commands.fun.games;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.awt.*;
import java.util.Random;

public class RPSCommand implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        int cc;
        // 0 - Win
        // 1 - Tie
        // 2 - Lose

        if (event.getMessageContent().equalsIgnoreCase("!rps")) {
            event.getChannel().sendMessage("Choose Rock, Paper, or Scissors");
        } else if (event.getMessageContent().equalsIgnoreCase("!rps rock")) {
            TextChannel c = event.getChannel();
            cc = randomRPS();
            if (cc == 0) {
                resultRPS("Rock", "Rock", 1, c);
            } else if (cc == 1) {
                resultRPS("Rock", "Paper", 2, c);
            } else if (cc == 2) {
                resultRPS("Rock", "Scissors", 0, c);
            }
        } else if (event.getMessageContent().equalsIgnoreCase("!rps paper")) {
            TextChannel c = event.getChannel();
            cc = randomRPS();
            if (cc == 0) {
                resultRPS("Paper", "Rock", 0, c);
            } else if (cc == 1) {
                resultRPS("Paper", "Paper", 1, c);
            } else if (cc == 2) {
                resultRPS("Paper", "Scissors", 2, c);
            }
        } else if (event.getMessageContent().equalsIgnoreCase("!rps scissors")) {
            TextChannel c = event.getChannel();
            cc = randomRPS();
            if (cc == 0) {
                resultRPS("Scissors", "Rock", 2, c);
            } else if (cc == 1) {
                resultRPS("Scissors", "Paper", 0, c);
            } else if (cc == 2) {
                resultRPS("Scissors", "Scissors", 1, c);
            }
        }
    }

    public int randomRPS() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

    public void resultRPS(String uc, String cc, int r, TextChannel channel) {
        Color color = Color.gray;
        String result = "Error";
        if (r == 0) {
            color = Color.green;
            result = "You Won!";
        } else if (r == 1) {
            color = Color.orange;
            result = "It's a tie!";
        } else if (r == 2) {
            color = Color.red;
            result = "You Lose!";
        }
        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle("Rock Paper Scissors!")
                .setDescription(result)
                .addInlineField("You Chose:", uc)
                .addInlineField("I Chose:", cc)
                .setColor(color))
                .send(channel);
    }
}
