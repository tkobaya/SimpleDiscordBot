/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleBotTest {

    private static SimpleBot bot;

    @BeforeClass public static void init() {
        bot = new SimpleBot();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test public void testBotConnection() {
        assertTrue(bot.isConnected());
    }

    @Test public void testShutdown() {
        assertTrue(bot.shutdown());
    }

}
