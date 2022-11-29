import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/*
 * Simple Discord Bot example using JDA 5.0.0
 */
public class SimpleBot {
    private static Logger log = LoggerFactory.getLogger(SimpleBot.class);
    private static final String SECRET_PROP_FILE = "secret";
    private JDA jda;

    public SimpleBot() {
        String token = ResourceBundle.getBundle(SECRET_PROP_FILE).getString("TOKEN");
        jda = JDABuilder.createDefault(token)
                // enables explicit access to message.getContentDisplay()
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.addEventListener(new MyMessageListener());
        String mes = "SimpleBot ready to answer...";
        //System.out.println(mes);
        log.info(mes);
    }

    public JDA getJda() {
        return jda;
    }

    public boolean isConnected() {
        return (jda.getStatus() == JDA.Status.CONNECTED);
    }

    public boolean shutdown() {
        jda.shutdown();
        String mes = "Shutdown SimpleBot...";
        //System.out.println(mes);
        log.info(mes);
        return (jda.getStatus() == JDA.Status.SHUTDOWN);
    }

    public static void main(String[] args) {
        new SimpleBot();
    }
}
