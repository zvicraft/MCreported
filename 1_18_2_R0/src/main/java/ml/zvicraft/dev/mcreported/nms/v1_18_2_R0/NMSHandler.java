package ml.zvicraft.dev.mcreported.nms.v1_18_2_R0;

import ml.zvicraft.dev.mcreported.api.NMS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class NMSHandler implements NMS {

    @Override
    public void sendMessage(Player player, String message) {
        Bukkit.getLogger().info("");
    }
}

