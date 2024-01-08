package ml.zvicraft.dev.mcreported.GUI;

import ml.zvicraft.dev.mcreported.Mcdiscord;
import ml.zvicraft.dev.mcreported.PlayerAPI.ChatBoolen;
import ml.zvicraft.dev.mcreported.ReportP;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;
import java.util.Date;

import static ml.zvicraft.dev.mcreported.GUI.Default.itemName;
import static ml.zvicraft.dev.mcreported.GUI.Default.reasonPDC;
import static ml.zvicraft.dev.mcreported.MCreported_Plugin.plugin;
import static ml.zvicraft.dev.mcreported.MCreported_Plugin.reports;
import static ml.zvicraft.dev.mcreported.utils.Utils.chat;



public class ChatEvent extends ListenerAdapter implements Listener {

    public static String name=itemName;


    @EventHandler
    public static void chatting(AsyncPlayerChatEvent e){

        Player player = e.getPlayer();
        if(ChatBoolen.getPlayerAbility(player,name)){
            String PlayerName = e.getMessage();
            e.setCancelled(true);
            ChatBoolen.setPlayerAbility(player,name,false);
            ChatBoolen.setPlayerAbility(player,reasonPDC,true);
            ChatBoolen.setString(player,name,PlayerName);
            player.sendMessage(chat("&eReason: "));
        }
        else if(ChatBoolen.getPlayerAbility(player,reasonPDC)){
            String reason = e.getMessage();
            if(ChatBoolen.getString(player,name)!="") {
                ReportP s = new ReportP(plugin.getlastId() , player.getName(),name, new Date(), reason);
                reports.add(s);
                player.sendMessage(chat("&a" + name + " reported by you!"));
                Mcdiscord.jda.getTextChannelById(plugin.getConfig().getLong("PLAYER-CHANNEL"));
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setColor(Color.red);
                embedBuilder.setTitle("Report Systems");
                embedBuilder.addField("Report To:", s.getReported(), false);
                embedBuilder.addField("Type report", "Report Player", true);
                embedBuilder.addField("Reason:", reason, false);
                embedBuilder.setFooter("Reported by: " + player.getName(), null);
                Mcdiscord.jda.getTextChannelById(plugin.getConfig().getLong("PLAYER-CHANNEL")).sendTyping().queue();
                Mcdiscord.jda.getTextChannelById(plugin.getConfig().getLong("PLAYER-CHANNEL")).sendMessageEmbeds(embedBuilder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();
                embedBuilder.clear();

                ChatBoolen.setString(player, name, "");
                ChatBoolen.setPlayerAbility(player, reasonPDC, false);
                e.setCancelled(true);
            }else{
                ReportP s = new ReportP(plugin.getlastId(), player.getName(), "bug", new Date(), reason);
                reports.add(s);
                Mcdiscord.jda.getTextChannelById(plugin.getConfig().getLong("BUGS-CHANNEL"));
                EmbedBuilder embedBuilder = new EmbedBuilder();
                embedBuilder.setColor(Color.orange);
                embedBuilder.setTitle("Report Systems");
                embedBuilder.addField("Type report", "Report Bug", true);
                embedBuilder.addField("Bug:", reason, false);
                embedBuilder.setFooter("Reported by: " + player.getName(), null);
                Mcdiscord.jda.getTextChannelById(plugin.getConfig().getLong("BUGS-CHANNEL")).sendTyping().queue();
                Mcdiscord.jda.getTextChannelById(plugin.getConfig().getLong("BUGS-CHANNEL")).sendMessageEmbeds(embedBuilder.build(), new net.dv8tion.jda.api.entities.MessageEmbed[0]).queue();
                embedBuilder.clear();
                player.sendMessage(chat("&aBug reported by you!"));
                ChatBoolen.setPlayerAbility(player, reasonPDC, false);
                e.setCancelled(true);
            }
        }
    }



}