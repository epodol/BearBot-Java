package dev.erictech.bearbot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.server.Server;


public class PingCommand implements CommandExecutor {

    @Command(aliases = {"!ping", "!p", "!pong"}, description = "Pings the bot", usage = "!ping")
    public String onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        return "Pong!";
    }

}