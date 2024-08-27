package ml.zvicraft.dev.mcreported.api;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface NMS {
    void sendMessage(Player player, String message);

    void breakBlock(Player player, Location loc);

}