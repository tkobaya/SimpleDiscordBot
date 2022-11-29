import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class MyMessageListener extends ListenerAdapter {
    private static Logger log = LoggerFactory.getLogger(MyMessageListener.class);

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        if (event.isFromType(ChannelType.PRIVATE))  {
            // Case for Direct Message
            // Just print it out to STDOUT
            String mes = String.format("[DM] @%s: %s",
                    event.getAuthor().getName(),
                    event.getMessage().getContentDisplay());
            log.info(mes);
            // Make a response as Embed Message
            try {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.WHITE);
                eb.setTitle("Response from SimpleBot");
                eb.setDescription(String.format("Hi %s, %s too",
                        event.getAuthor().getName(),
                        event.getMessage().getContentDisplay()));
                eb.setThumbnail("https://avatars.githubusercontent.com/u/8818866?v=4");
                eb.addField("Name1", "Desc1", false);
                eb.setFooter("");
                eb.setAuthor("SimpleBot", "https://github.com/tkobaya/SimpleBot");
                // send the response
                event.getChannel().sendMessageEmbeds(eb.build()).queue();
            } catch (IllegalArgumentException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
        else {
            // Case for public channel
            // Just print it out to STDOUT
            String mes = String.format("[%s] #%s @%s: %s",
                    event.getGuild().getName(),
                    event.getChannel().asTextChannel().getName(),
                    event.getMember().getEffectiveName(),
                    event.getMessage().getContentDisplay());
            log.info(mes);
        }
    }
}
