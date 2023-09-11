package ml.zvicraft.dev.mcreported.GUI;


import ml.zvicraft.dev.mcreported.PlayerAPI.ChatBoolen;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


import java.util.ArrayList;
import java.util.List;

import static ml.zvicraft.dev.mcreported.MCreported.plugin;
import static ml.zvicraft.dev.mcreported.utils.Utils.chat;
import static ml.zvicraft.dev.mcreported.utils.Utils.material;


public class Default {

    public static Inventory inv;
    public static String inventory_name,reportTypeIN, reportTypeINV, itemName;
    public static int inv_rows = 6 * 9;

    public static void initialise() {
        inventory_name = chat("");
        reportTypeIN = chat(plugin.getConfig().getString("ReportType"));
        reportTypeINV = chat(plugin.getConfig().getString("Online-Players-Menu"));
        inv = Bukkit.createInventory(null, inv_rows);
    }

    public static Inventory Gui(Player player) {
        Inventory toReturn2 = Bukkit.createInventory(null, inv_rows, inventory_name);
        toReturn2 = ReportType();
        toReturn2.setContents(inv.getContents());
        return toReturn2;
    }

    public static void clicked(Player player, int slot, ItemStack clicked, Inventory inv) {

    }


    public static Inventory ReportType(){
        Inventory toReturn = Bukkit.createInventory(null,5*9,reportTypeIN);
        for (int i = 0; i <= 9; i++) {
            material(Material.RED_STAINED_GLASS_PANE,toReturn,1,i,chat("&e"));
        }
        material(Material.RED_STAINED_GLASS_PANE,toReturn,1,17,chat("&e"));
        material(Material.RED_STAINED_GLASS_PANE,toReturn,1,18,chat("&e"));
        material(Material.RED_STAINED_GLASS_PANE,toReturn,1,26,chat("&e"));
        material(Material.RED_STAINED_GLASS_PANE,toReturn,1,27,chat("&e"));
        for (int i = 35; i <= 44; i++) {
            material(Material.RED_STAINED_GLASS_PANE,toReturn,1,i,chat("&e"));
        }
        material(Material.PLAYER_HEAD, toReturn, 1,20, reportTypeINV);
        material(Material.BARRIER, toReturn, 1,40,Utils.chat(plugin.getConfig().getString("Report-Close")));
        material(Material.RED_SHULKER_BOX, toReturn, 1,24,Utils.chat(plugin.getConfig().getString("Report-Bugs")));




        return toReturn;
    }

    public static Inventory ReportTypeInv(){
        Inventory inv = Bukkit.createInventory(null, 54, Utils.chat(plugin.getConfig().getString("Online-Players-Menu")));
        int t = 0;
        for (Player plr : Bukkit.getServer().getOnlinePlayers()) {
            ItemStack i = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
            SkullMeta im = (SkullMeta) i.getItemMeta();

            List<String> il = new ArrayList<String>();
            il.add(Utils.chat(plugin.getConfig().getString("Status-Online-Menu")));
            im.setOwner(plr.getName());
            im.setLore(il);
            im.setDisplayName(Utils.chat("&7" + plr.getName()));
            i.setItemMeta(im);
            inv.setItem(t,i);
            itemName = im.getDisplayName();


        }
        return inv;
    }
    //PDC - PersistentDataContainer
    public static String playerNamePDC = "player_name_pdc";

    //PDC - PersistentDataContainer
    public static String reasonPDC = "reason_pdc";

        public static void rtClicked(Player player, int slot, ItemStack clicked, Inventory inv) {
        if(clicked!=null) {
            if (clicked.getItemMeta() != null) {
                if(clicked.getItemMeta().getDisplayName()!=null){
                    if(slot == 40){
                        player.closeInventory();
                    }
                    if (slot == 20){
                        player.openInventory(ReportTypeInv());
                    }
                    if (slot == 24){
                        player.closeInventory();
                        player.sendMessage(chat("&eReason: "));
                        ChatBoolen.setPlayerAbility(player,reasonPDC,true);
                    }
                    if(clicked.getItemMeta().getDisplayName().equals(chat("&cReport Bug"))){}

                    }

            }
        }
    }

}
