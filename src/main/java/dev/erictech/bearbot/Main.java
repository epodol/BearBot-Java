package dev.erictech.bearbot;

import dev.erictech.bearbot.commands.HelpCommand;
import dev.erictech.bearbot.commands.PingCommand;
import dev.erictech.bearbot.commands.PingSock;
import dev.erictech.bearbot.commands.fun.games.CoinCommand;
import dev.erictech.bearbot.commands.fun.games.DiceCommand;
import dev.erictech.bearbot.commands.fun.games.RPSCommand;
import dev.erictech.bearbot.commands.fun.pictures.DogPictureCommand;
import dev.erictech.bearbot.commands.moderation.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

public class Main {
    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder().setToken().login().join();
        System.out.println("Logged in!");

        api.updateActivity(ActivityType.LISTENING , " !help");

        api.addMessageCreateListener(new BanCommand());
        api.addMessageCreateListener(new KickCommand());
        api.addMessageCreateListener(new MuteCommand());
        api.addMessageCreateListener(new UnMuteCommand());
        api.addMessageCreateListener(new UnBanCommand());

        api.addMessageCreateListener(new PingSock());

        api.addMessageCreateListener(new PingCommand());
        api.addMessageCreateListener(new HelpCommand());

        api.addMessageCreateListener(new CoinCommand());
        api.addMessageCreateListener(new DiceCommand());
        api.addMessageCreateListener(new RPSCommand());

        api.addMessageCreateListener(new DogPictureCommand());

    }


}
