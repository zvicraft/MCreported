package ml.zvicraft.dev.mcreported.commands;

import ml.zvicraft.dev.mcreported.MCreported_Plugin;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reportcommandcancelall implements CommandExecutor {
    public boolean onCommand( CommandSender sender,  Command command,  String s,  String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(MCreported_Plugin.plugin.getConfig().getString("MUST-BE-PLAYER-ERROR")));
            return true;
        }
        Player player = (Player)sender;
        if (player.hasPermission("MCreport.staff"))
            MCreported_Plugin.reports.clear();
        return true;
    }
}
