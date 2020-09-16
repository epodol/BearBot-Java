

/**
 * The BearBot program is a Java Discord Bot using
 * Gradle and JavaCord that preforms most common
 * bot commands.
 *
 * @author @epodol
 * @version 0.1.4-alpha
 * @since 2020-09-12
 */

package dev.erictech.bearbot;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import dev.erictech.bearbot.commands.HelpCommand;
import dev.erictech.bearbot.commands.PingCommand;
import dev.erictech.bearbot.commands.VersionCommand;
import dev.erictech.bearbot.commands.fun.games.CoinCommand;
import dev.erictech.bearbot.commands.fun.games.DiceCommand;
import dev.erictech.bearbot.commands.fun.games.RPSCommand;
import dev.erictech.bearbot.commands.fun.pictures.CatCommand;
import dev.erictech.bearbot.commands.fun.pictures.DogCommand;
import dev.erictech.bearbot.commands.fun.pictures.MemeCommand;
import dev.erictech.bearbot.commands.moderation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

import java.util.Scanner;

public class Main {

    protected static ActivityType activityType = ActivityType.LISTENING;

    protected static String activityName = "@Bear help";

    private static Logger logger = LogManager.getLogger(Main.class);

    /**
     * This is the main method which simply displays "Hello World" to the standard output.
     *
     * @param args Bot Token
     */

    public static void main(String[] args) {

//        BearBotProperties properties = new BearBotProperties();
//        properties.getPropValues();

        startCommands(args.length);
        DiscordApi api = startBot(args[0]);


//        logger.info("You can invite me by using the following url: " + api.createBotInvite());

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
        handler.registerCommand(new CatCommand());


        //Ping Sock
        api.addMessageCreateListener(event -> {
            if (event.getMessage().getMentionedUsers().contains(api.getYourself())) {
                event.getMessage().addReaction(":PingSock:741719911679918182");
            }
        });

        api.addServerJoinListener(event -> logger.info("Joined server " + event.getServer().getName()));
        api.addServerLeaveListener(event -> logger.info("Left server " + event.getServer().getName()));
    }

    public static void startCommands(int argsLength) {

        Scanner scn = new Scanner(System.in);

        System.out.println("\n\n" +
                "  ____                  ____        _   \n" +
                " |  _ \\                |  _ \\      | |  \n" +
                " | |_) | ___  __ _ _ __| |_) | ___ | |_ \n" +
                " |  _ < / _ \\/ _` | '__|  _ < / _ \\| __|\n" +
                " | |_) |  __/ (_| | |  | |_) | (_) | |_ \n" +
                " |____/ \\___|\\__,_|_|  |____/ \\___/ \\__|\n" +
                "                                        \n" +
                "                                        \n");

        System.out.println("Now Starting:");
        if (argsLength != 1) {
            System.err.println("Please provide a token as the first argument!");
            return;
        }
        System.out.print("Enter \"0\" to use quickstart, otherwise enter \"1\":\t");
        if (scn.nextByte() == 1) {
            manualStart();
        } else {
            System.out.println("Quick Start!");
        }
    }

    public static void manualStart() {

        System.out.println("Manual Start!");

        Scanner scn = new Scanner(System.in);

        System.out.println("\nChoose one to change or enter \"0\" to exit Manual Start.");
        System.out.println("\n#\tType\t\t\tCurrent Value");
        System.out.println("\n1\tActivity Type\t" + activityType + "\n2\tActivity Name\t" + activityName + "\n2\tUpdate Activity");

        switch (scn.nextByte()) {
            case 0:
                return;
            case 1:
                changeActivityTypeConsole();
                break;
            case 2:
                System.out.println("Manual Start!");
                changeActivityNameConsole();
                break;
            default:
                System.out.println("Option Unknown!");
                manualStart();
                break;
        }


    }

    public static void changeActivityTypeConsole() {

        System.out.println("Change Activity Type");

        Scanner scn = new Scanner(System.in);

        System.out.println("\nChoose one to change or enter \"0\" to go back.");
        System.out.println("\n#\tValue");
        System.out.println("\n1\tPLAYING\n2\tSTREAMING\n3\tLISTENING\n4\tWATCHING");
        int activity = scn.nextInt();
        if (activity == 1 || activity == 2 || activity == 3 || activity == 4) {
            activityType = ActivityType.getActivityTypeById(activity - 1);
            System.out.println("\nSet the Activity Type to " + activityType + "\n");
        } else {
            System.out.println("Going Back");
        }
        manualStart();
    }

    public static void changeActivityNameConsole() {

    }


    public static DiscordApi startBot(String token) {
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
        api.updateActivity(activityType, activityName);
        return api;
    }

}
