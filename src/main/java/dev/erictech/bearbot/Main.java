package dev.erictech.bearbot;

import dev.erictech.bearbot.commands.HelpCommand;
import dev.erictech.bearbot.commands.PingCommand;
import dev.erictech.bearbot.commands.PingSock;
import dev.erictech.bearbot.commands.fun.games.CoinCommand;
import dev.erictech.bearbot.commands.fun.games.DiceCommand;
import dev.erictech.bearbot.commands.fun.games.RPSCommand;
import dev.erictech.bearbot.commands.fun.pictures.DogPictureCommand;
import dev.erictech.bearbot.commands.moderation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide a valid token as the first argument!");
            return;
        }

        String token = args[0];

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        api.updateActivity(ActivityType.LISTENING, " !help");

        logger.info("You can invite me by using the following url: " + api.createBotInvite());

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

        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }
}
