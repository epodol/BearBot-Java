package dev.erictech.bearbot.commands.fun.pictures;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MemeCommand implements MessageCreateListener {
    static final Logger logger = LogManager.getLogger(MemeCommand.class.getName());

    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!meme")) {
            logger.info(event.getMessage() + " in " + event.getServer() + " " + event.getChannel() + " by user " + event.getMessageAuthor());
            try {
                String inline = "";
                URL apiurl = new URL("https://meme-api.herokuapp.com/gimme");
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
                String url = (String) jobj.get("url");
                String title = (String) jobj.get("title");
                String post = (String) jobj.get("postLink");
                String author = (String) jobj.get("author");
                long votes = (long) jobj.get("ups");
                boolean nsfw = (boolean) jobj.get("nsfw");
                boolean spoiler = (boolean) jobj.get("spoiler");
                new MessageBuilder().setEmbed(new EmbedBuilder()
                        .setTitle(title)
                        .setAuthor(author, post, "https://www.redditinc.com/assets/images/site/reddit-logo.png")
                        .setFooter("" + votes, "https://i.imgur.com/nFn8U6a.png")
                        .setImage(url)
                        .setColor(Color.decode("#FF4500")))
                        .send(event.getChannel());
                conn.disconnect();
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}