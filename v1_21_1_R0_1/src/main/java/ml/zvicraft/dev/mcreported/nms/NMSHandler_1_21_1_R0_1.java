package ml.zvicraft.dev.mcreported.nms;


import ml.zvicraft.dev.mcreported.api.NMS;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_20_R1.util.CraftChatMessage;
import org.bukkit.entity.Player;

public class NMSHandler_1_21_1_R0_1 implements NMS {

    @Override
    public void sendMessage(Player player, String message) {
        for (IChatBaseComponent component : CraftChatMessage.fromString(message)) {
            ((CraftPlayer) player).getHandle().sendChatMessage(null, true, null);
        }
    }

    @Override
    public void breakBlock(Player player, Location loc) {
        player.breakBlock((org.bukkit.block.Block) Block.byItem(Item.BY_BLOCK.get(Material.ACACIA_BOAT)));
    }

}