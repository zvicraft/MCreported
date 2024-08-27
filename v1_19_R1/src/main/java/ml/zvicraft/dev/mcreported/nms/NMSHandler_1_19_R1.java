package ml.zvicraft.dev.mcreported.nms;

import ml.zvicraft.dev.mcreported.api.NMS;
import net.minecraft.network.chat.Component;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_19_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_19_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import java.util.UUID;


public class NMSHandler_1_19_R1 implements NMS {

    private static final UUID UUID = null;

    @Override
    public void sendMessage(Player player, String message) {
        for(Component component : CraftChatMessage.fromString(message)) {
            ((CraftPlayer)player).getHandle().sendChatMessage(null, true,null);
        }
    }

    @Override
    public void breakBlock(Player player, Location loc) {

    }
}

