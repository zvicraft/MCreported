package com.zvicraft.dev.mcreportedbungeee;

import net.dv8tion.jda.api.EmbedBuilder;
import net.md_5.bungee.api.plugin.Listener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.zvicraft.dev.mcreportedbungeee.MCreportedBungeee.config;

public class MessageListener implements PluginMessageListener, Listener {
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (channel.equals("Mcreported:channel")) {
            String reported = new String(message);
            String reasonPDC = new String(message);
            String senderName = new String(message);
            String serverName = new String(message);
            Mcdiscord.jda.getTextChannelById(config.getLong("PLAYER-CHANNEL"));
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setColor(Color.red);
            embedBuilder.setTitle("Report Systems");
            embedBuilder.addField("Report To:",reported, false);
            embedBuilder.addField("Type report", "Report Player", true);
            embedBuilder.addField("Reason:",reasonPDC, false);
            embedBuilder.setFooter("Reported by: " + senderName + "Server:" + serverName , null);
            Mcdiscord.jda.getTextChannelById(config.getLong("PLAYER-CHANNEL")).sendTyping().queue();
            Mcdiscord.jda.getTextChannelById(config.getLong("PLAYER-CHANNEL")).sendMessageEmbeds(embedBuilder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();
            embedBuilder.clear();
                // Use the value as needed
            }
        }
    }

