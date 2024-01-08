package com.zvicraft.dev.mcreportedbungeee;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

import static com.zvicraft.dev.mcreportedbungeee.MCreportedBungeee.config;

public class Mcdiscord {
    public static JDA jda = null;

    public Mcdiscord() throws LoginException {
        String token = config.getString("TOKEN");
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching(config.getString("WSH")));
        builder.addEventListeners(new MessageListener());
        jda = builder.build();

    }
}
