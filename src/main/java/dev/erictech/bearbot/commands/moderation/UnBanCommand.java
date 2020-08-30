package dev.erictech.bearbot.commands.moderation;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import dev.erictech.bearbot.ComingSoonError;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.server.Server;

public class UnBanCommand implements CommandExecutor {
    @Command(aliases = {"!unban", "!welcomeback"}, description = "Unbans a user", usage = "!unban")
    public void onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        ComingSoonError.comingSoon(channel);
    }
}
