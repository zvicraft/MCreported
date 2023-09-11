package ml.zvicraft.dev.mcreported.commands;

import ml.zvicraft.dev.mcreported.MCreported;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class reportcommandcancelall implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat(MCreported.plugin.getConfig().getString("MUST-BE-PLAYER-ERROR")));
            return true;
        }
        Player player = (Player)sender;
        if (player.hasPermission("MCreport.staff"))
            MCreported.reports.clear();
        return true;
    }
}
