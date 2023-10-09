package ml.zvicraft.dev.mcreported.nms.v1_19_4_R0;

import ml.zvicraft.dev.mcreported.api.NMS;
import net.minecraft.network.chat.Component;
import org.bukkit.craftbukkit.v1_19_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R1.util.CraftChatMessage;
import org.bukkit.entity.Player;

import java.util.UUID;


public class NMSHandler implements NMS {

    private static final UUID UUID = null;

    @Override
    public void sendMessage(Player player, String message) {
        for(Component component : CraftChatMessage.fromString(message)) {
            ((CraftPlayer)player).getHandle().sendChatMessage(null, true,null);
        }
    }
}

