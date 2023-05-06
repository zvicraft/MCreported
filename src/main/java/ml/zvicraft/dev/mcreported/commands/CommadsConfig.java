package ml.zvicraft.dev.mcreported.commands;

import ml.zvicraft.dev.mcreported.MCreported;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class CommadsConfig implements CommandExecutor {
    private MCreported plugin = MCreported.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) sender;

        if (player.hasPermission("MCreport.reload")) {
            plugin.reloadConfig();
            player.sendMessage(Utils.chat(plugin.getConfig().getString("reload")));
        } else {
            player.sendMessage(Utils.chat(plugin.getConfig().getString("none-permission")));
        }
        return false;
    }
}
