package dev.erictech.bearbot;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;

public class ComingSoonError {
    public static void comingSoon(TextChannel channel){
        new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle("Feature Coming Soon!")
                .setDescription("This Feature is currently in development. Stay tuned for more information!")
                .setColor(Color.red)
                .setTimestampToNow()
                .setThumbnail("https://www.a-dato.com/wp-content/uploads/2018/11/Coming-soon.png"))
                .send(channel);
    }
}
