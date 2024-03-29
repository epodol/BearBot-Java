package dev.erictech.bearbot.commands.fun.pictures;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CatCommand implements CommandExecutor {

    @Command(aliases = {"!cat", "!cpic", "!catpic", "!catpicture", "!catto", "!meow"}, description = "Finds a random cat picture", usage = "!cat")
    public String onCommand(DiscordApi api, Message message, TextChannel channel, Server server, String[] args) {
        try {
            String inline = "";
            URL apiurl = new URL("https://dog.ceo/api/breeds/image/random");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) apiurl.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if (responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            else {
                //Scanner functionality will read the JSON data from the stream
                Scanner sc = new Scanner(apiurl.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                //Close the stream when reading the data has been finished
                sc.close();
            }
            JSONParser parse = new JSONParser();
            JSONObject jobj = (JSONObject) parse.parse(inline);
            String url = (String) jobj.get("message");
            new MessageBuilder().setEmbed(new EmbedBuilder()
                    .setTitle("Dog Picture!")
                    .setFooter("Requested by: " + message.getAuthor().getDisplayName(), message.getAuthor().getAvatar())
                    .setImage(url)
                    .setTimestampToNow()
                    .setColor(Color.decode("#FF4500")))
                    .send(channel);
            conn.disconnect();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return null;

//        ComingSoonError.comingSoon(channel);
//        return null;
    }

}