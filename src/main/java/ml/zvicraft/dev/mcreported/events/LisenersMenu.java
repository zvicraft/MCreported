package ml.zvicraft.dev.mcreported.events;

import ml.zvicraft.dev.mcreported.GUI.Default;
import ml.zvicraft.dev.mcreported.PlayerAPI.ChatBoolen;
import ml.zvicraft.dev.mcreported.completion.DiscordWebhook;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static ml.zvicraft.dev.mcreported.GUI.Default.reasonPDC;
import static ml.zvicraft.dev.mcreported.MCreported.plugin;
import static ml.zvicraft.dev.mcreported.utils.Utils.chat;


public class LisenersMenu implements Listener {

    Map<Player, String> lastMessages = new HashMap<>();


    String WEBHOOK_URL = plugin.getConfig().getString("WEBHOOK_URL_C");
    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK_URL);
    String playerName = "zvicraft"; // replace with the actual player's name
    String problemType = "System Report"; // replace with the type of report
    String problemDescription = "System report submitted by " + playerName;
    private final Map<UUID, UUID> reportedPlayers = new HashMap<>();

    @EventHandler
    public void onClick(InventoryClickEvent e) {


//        Inventory inv = Bukkit.createInventory(null, 54, Utils.chat("&0Online Players"));
//
//        for (Player plr : Bukkit.getServer().getOnlinePlayers()) {
//            ItemStack i = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
//            SkullMeta im = (SkullMeta) i.getItemMeta();
//
//            List<String> il = new ArrayList<String>();
//            il.add(Utils.chat("&7Status: &aOnline"));
//            im.setOwner(plr.getName());
//            im.setLore(il);
//            im.setDisplayName(Utils.chat("&7" + plr.getName()));
//            i.setItemMeta(im);
//
//            inv.addItem(i);
//        }
//if (Utils.chat(e.getView().getTitle()).equals(Utils.chat("&a&lReport Menu!"))
//                && e.getCurrentItem() != null) {



            String title = e.getView().getTitle();

            Player player = (Player) e.getWhoClicked();

            if (title.equals(Default.reportTypeIN)) {
                e.setCancelled(true);
                if (e.getCurrentItem() == null) {
                    return;
                }
                Default.rtClicked(player, e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        if (title.equals(Default.reportTypeINV)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }

//            Default.rtClicked(player, e.getSlot(), e.getCurrentItem(), e.getInventory());
//            player.closeInventory();
            player.closeInventory();
            player.sendMessage(chat("&eReason: "));
            ChatBoolen.setPlayerAbility(player,reasonPDC,true);
        }
    }

    public void getNameInput(Player p) {
        ConversationFactory cf = new ConversationFactory(plugin);
        Conversation conv = cf.withFirstPrompt(new ConvName()).withLocalEcho(false).buildConversation(p);
        conv.begin();
        return;
    }


    
}
