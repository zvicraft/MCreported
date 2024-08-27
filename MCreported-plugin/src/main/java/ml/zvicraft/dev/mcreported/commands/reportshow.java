package ml.zvicraft.dev.mcreported.commands;

import ml.zvicraft.dev.mcreported.ReportP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static ml.zvicraft.dev.mcreported.MCreported_Plugin.reports;

public class reportshow implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender,  Command command,  String s,  String[] strings) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            p.sendMessage(reports+"");
            for (ReportP report : reports) {
                p.sendMessage(report + "");
                report.getAmount().restore();
                p.sendMessage("\n------------------------------------------\n");
            }
        }
        return true;
    }
}
