package ml.zvicraft.dev.mcreported.GUI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ml.zvicraft.dev.mcreported.PlayerAPI.ChatBoolen;

import static ml.zvicraft.dev.mcreported.GUI.Default.playerNamePDC;
import static ml.zvicraft.dev.mcreported.GUI.Default.reasonPDC;

public class JoinAndLeaveEvent implements Listener {

    @EventHandler
    public static void joinEvent(PlayerJoinEvent e){
        Player p= e.getPlayer();
        ChatBoolen.setPlayerAbility(p,playerNamePDC,false);
        ChatBoolen.setPlayerAbility(p,reasonPDC,false);
        ChatBoolen.setString(p,ChatEvent.name,"");
    }

    @EventHandler
    public static void leaveEvent(PlayerQuitEvent e){
        Player p= e.getPlayer();
        ChatBoolen.setPlayerAbility(p,playerNamePDC,false);
        ChatBoolen.setPlayerAbility(p,reasonPDC,false);
        ChatBoolen.setString(p,ChatEvent.name,"");
    }



}
