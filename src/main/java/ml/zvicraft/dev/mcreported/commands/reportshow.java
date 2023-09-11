package ml.zvicraft.dev.mcreported.commands;

import ml.zvicraft.dev.mcreported.ReportP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static ml.zvicraft.dev.mcreported.MCreported.reports;

public class reportshow implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            p.sendMessage(reports+"");
            for (ReportP report : reports) {

                p.sendMessage(report + "");
                p.sendMessage("\n------------------------------------------\n");
            }
        }
        return true;
    }
}
