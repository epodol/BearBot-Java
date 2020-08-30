package dev.erictech.bearbot.commands.fun.games;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import dev.erictech.bearbot.ComingSoonError;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.server.Server;

public class DiceCommand implements CommandExecutor {

    @Command(aliases = {"!dice", "!d", "!roll"}, description = "Rolls a pair of dice", usage = "!dice")
    public String onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        ComingSoonError.comingSoon(channel);
        return null;
    }

}