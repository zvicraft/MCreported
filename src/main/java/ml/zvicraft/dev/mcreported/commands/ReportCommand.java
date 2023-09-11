package ml.zvicraft.dev.mcreported.commands;

import ml.zvicraft.dev.mcreported.GUI.Default;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static ml.zvicraft.dev.mcreported.MCreported.plugin;


public class ReportCommand implements CommandExecutor {

//    String WEBHOOK_URL = plugin.getConfig().getString("WEBHOOK_URL_C");
//    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK_URL);
//    String playerName = "JohnDoe"; // replace with the actual player's name
//    String problemType = "System Report"; // replace with the type of report
//    String problemDescription = "System report submitted by " + playerName; // replace with the report description


    private final Map<UUID, UUID> reportedPlayers = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(plugin.getConfig().getString("MUST-BE-PLAYER-ERROR")));
            return true;
        }

        Player p = (Player) sender;
//        Inventory inv1 = Bukkit.createInventory(null, 45, Utils.chat("&a&lReport Menu!"));
        p.openInventory(Default.ReportType());
//        material(Material.PLAYER_HEAD, inv1, 1,20,Utils.chat("&bReported Player..."));
//        material(Material.BARRIER, inv1, 1,40,Utils.chat("&cClose!"));
//        material(Material.RED_SHULKER_BOX, inv1, 1,24,Utils.chat("&bReported Bugs..."));
//
//
//
//        for (int i : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 37, 38, 39, 41, 42, 43, 43, 44}) {
//            material(Material.RED_STAINED_GLASS_PANE, inv1,1, i," ");
//        }


//        p.openInventory(inv1);
//

        return true;
    }
}
