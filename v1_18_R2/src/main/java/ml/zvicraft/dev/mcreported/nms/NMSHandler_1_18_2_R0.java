package ml.zvicraft.dev.mcreported.nms;

import ml.zvicraft.dev.mcreported.api.NMS;
import net.minecraft.network.chat.Component;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_18_R2.util.CraftChatMessage;
import org.bukkit.entity.Player;


public class NMSHandler_1_18_2_R0 implements NMS {

    @Override
    public void sendMessage(Player player, String message) {
        for(Component component : CraftChatMessage.fromString(message)) {
            ((CraftPlayer)player).getHandle().sendMessage(null ,null, null);
        }
    }

    @Override
    public void breakBlock(Player player, Location loc) {

    }
}

