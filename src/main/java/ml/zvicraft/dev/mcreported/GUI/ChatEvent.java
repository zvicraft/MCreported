package ml.zvicraft.dev.mcreported.GUI;

import ml.zvicraft.dev.mcreported.PlayerAPI.ChatBoolen;
import ml.zvicraft.dev.mcreported.ReportP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;



import java.util.Date;

import static ml.zvicraft.dev.mcreported.GUI.Default.*;
import static ml.zvicraft.dev.mcreported.MCreported.plugin;
import static ml.zvicraft.dev.mcreported.MCreported.reports;
import static ml.zvicraft.dev.mcreported.utils.Utils.chat;



public class ChatEvent implements Listener {

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
                ReportP s = new ReportP(plugin.getlastId(), player.getName(),name, new Date(), reason);
                reports.add(s);

                player.sendMessage(chat("&a" + name + " reported by you!"));


                ChatBoolen.setString(player, name, "");
                ChatBoolen.setPlayerAbility(player, reasonPDC, false);
                e.setCancelled(true);
            }else{
                ReportP s = new ReportP(plugin.getlastId(), player.getName(), "bug", new Date(), reason);
                reports.add(s);
                player.sendMessage(chat("&aBug reported by you!"));
                ChatBoolen.setPlayerAbility(player, reasonPDC, false);
                e.setCancelled(true);
            }
        }
    }



}