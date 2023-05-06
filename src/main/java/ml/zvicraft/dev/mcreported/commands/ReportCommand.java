package ml.zvicraft.dev.mcreported.commands;

import ml.zvicraft.dev.mcreported.completion.DiscordWebhook;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        Inventory inv1 = Bukkit.createInventory(null, 45, Utils.chat("&a&lReport Menu!"));
        Inventory inv = Bukkit.createInventory(null, 54, Utils.chat("&0Online Players"));
        for (Player plr : Bukkit.getServer().getOnlinePlayers()) {
            ItemStack i = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
            SkullMeta im = (SkullMeta) i.getItemMeta();

            List<String> il = new ArrayList<String>();
            il.add(Utils.chat("&7Status: &aOnline"));
            im.setOwner(plr.getName());
            im.setLore(il);
            im.setDisplayName(Utils.chat("&7" + plr.getName()));
            i.setItemMeta(im);

            inv.addItem(i);
        }
        ItemStack reportP = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta reportPMeta = reportP.getItemMeta();
        reportPMeta.setDisplayName(Utils.chat("&bReported Player..."));
        inv1.setItem(20, reportP);
        ItemStack reportBug = new ItemStack(Material.RED_SHULKER_BOX);
        ItemMeta reportBugMata = reportBug.getItemMeta();
        reportBugMata.setDisplayName(Utils.chat("&bReported Bugs..."));
        inv1.setItem(24, reportBug);
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMata = close.getItemMeta();
        closeMata.setDisplayName(Utils.chat("&aClose!"));
        inv1.setItem(40, close);
        ItemStack frame = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        for (int i : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 17, 18, 26, 27, 35, 36, 37, 38, 39, 41, 42, 43, 43, 44}) {
            inv1.setItem(i, frame);
        }
        p.openInventory(inv1);
//        if (args.length < 2) {
//            if (args.length < 2) {
//                sender.sendMessage(ChatColor.RED + "Used: /report");
//                return true;
//            }
//            Player reportedPlayer = Bukkit.getPlayer(args[0]);
//            if (reportedPlayer == null) {
//                sender.sendMessage(ChatColor.RED + "Player not found");
//                return true;
//            }
//
//            UUID reporterUUID = ((Player) sender).getUniqueId();
//            UUID reportedUUID = reportedPlayer.getUniqueId();
//
//            if (reportedUUID.equals(reporterUUID)) {
//                sender.sendMessage(ChatColor.RED + "You cannot report yourself.");
//                return true;
//            }
//
//            if (reportedPlayers.containsKey(reporterUUID) && reportedPlayers.get(reporterUUID).equals(reportedUUID)) {
//                sender.sendMessage(ChatColor.RED + "You have already reported this player.");
//                return true;
//            }
//
//            String reportReason = String.join(" ", args).substring(args[0].length() + 1);
//            String reportMessage = String.format("%s Reported by %s for: %s", sender.getName(),
//                    reportedPlayer.getName()
//                    , reportReason);
//
//            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[REPORTS] " + reportMessage);
//            Bukkit.getServer().getOnlinePlayers().stream()
//                    .filter(player -> player.hasPermission("report.receive"))
//                    .forEach(player -> player.sendMessage(ChatColor.RED + "[REPORTS] " + reportMessage));
//
//            reportedPlayers.put(reporterUUID, reportedUUID);
//
//            sender.sendMessage(ChatColor.GREEN + "Player successfully reported");
//

//            webhook.addEmbed(new DiscordWebhook.EmbedObject()
//                    .setTitle("Report system")
//                    .setColor(Color.RED)
//                    .addField("Report on: ", reportedPlayer.getName(), true)
//                    .addField("problem type: ", reportReason, true)
//                    .setDescription(reportMessage)
//                    .setFooter("Reported by: " + sender.getName(), null));
//            try {
//                webhook.execute();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            return false;


        return false;
    }
}
