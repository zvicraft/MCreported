package ml.zvicraft.dev.mcreported;

import javax.security.auth.login.LoginException;
import ml.zvicraft.dev.mcreported.GUI.ChatEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Mcdiscord {
    public static JDA jda = null;

    public Mcdiscord() throws LoginException {
        String token = MCreported.plugin.getConfig().getString("TOKEN");
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching(MCreported.plugin.getConfig().getString("WSH")));
        builder.addEventListeners(new Object[] { new ChatEvent() });
        jda = builder.build();
    }
}
