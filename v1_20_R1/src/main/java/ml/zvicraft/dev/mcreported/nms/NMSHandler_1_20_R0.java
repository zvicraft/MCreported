package ml.zvicraft.dev.mcreported.nms;


import ml.zvicraft.dev.mcreported.api.NMS;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class NMSHandler_1_20_R0 implements NMS {

    @Override
    public void breakBlock(Player player, Location loc) {
        player.breakBlock((org.bukkit.block.Block) Block.byItem(Item.BY_BLOCK.get(Material.ACACIA_BOAT)));
    }

}