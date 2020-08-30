package dev.erictech.bearbot;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import dev.erictech.bearbot.commands.HelpCommand;
import dev.erictech.bearbot.commands.PingCommand;
import dev.erictech.bearbot.commands.VersionCommand;
import dev.erictech.bearbot.commands.fun.games.CoinCommand;
import dev.erictech.bearbot.commands.fun.games.DiceCommand;
import dev.erictech.bearbot.commands.fun.games.RPSCommand;
import dev.erictech.bearbot.commands.fun.pictures.DogCommand;
import dev.erictech.bearbot.commands.fun.pictures.MemeCommand;
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

        CommandHandler handler = new JavacordHandler(api);

        handler.registerCommand(new HelpCommand());
        handler.registerCommand(new VersionCommand());
        handler.registerCommand(new PingCommand());
        handler.registerCommand(new BanCommand());
        handler.registerCommand(new KickCommand());
        handler.registerCommand(new MuteCommand());
        handler.registerCommand(new UnBanCommand());
        handler.registerCommand(new UnMuteCommand());
        handler.registerCommand(new WarnCommand());
        handler.registerCommand(new CoinCommand());
        handler.registerCommand(new DiceCommand());
        handler.registerCommand(new RPSCommand());
        handler.registerCommand(new MemeCommand());
        handler.registerCommand(new DogCommand());



        //Ping Sock
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().contains("<@!" + api.getClientId() + ">")) {
                event.getMessage().addReaction(":PingSock:741719911679918182");
            }
        });

        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }
}
