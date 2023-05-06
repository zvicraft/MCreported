package ml.zvicraft.dev.mcreported.events;

import ml.zvicraft.dev.mcreported.MCreported;
import ml.zvicraft.dev.mcreported.completion.DiscordWebhook;
import ml.zvicraft.dev.mcreported.utils.Utils;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class LisenersMenu implements Listener {

    Map<Player, String> lastMessages = new HashMap<>();

    private MCreported plugin = MCreported.getInstance();

    String WEBHOOK_URL = plugin.getConfig().getString("WEBHOOK_URL_C");
    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK_URL);
    String playerName = "JohnDoe"; // replace with the actual player's name
    String problemType = "System Report"; // replace with the type of report
    String problemDescription = "System report submitted by " + playerName;
    private final Map<UUID, UUID> reportedPlayers = new HashMap<>();

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();


        if (Utils.chat(e.getView().getTitle()).equals(Utils.chat("&a&lReport Menu!"))
                && e.getCurrentItem() != null) {

            switch (e.getRawSlot()) {
                case 20:
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
                    p.openInventory(inv);
                    break;
                case 24:
                    e.setCancelled(true);

//                    getNameInput(p);
                    new AnvilGUI.Builder()
                            .onClose(player -> {                                               //called when the inventory is closing
                                player.sendMessage("Thanks You");
                            })
                            .onComplete((completion) -> {                                    //called when the inventory output slot is clicked
                                String teximut = completion.getText();
                                completion.getPlayer().sendMessage("You have magical powers!");
                                return Arrays.asList(AnvilGUI.ResponseAction.replaceInputText("Try again"));

                            })

                            .preventClose()                                                    //prevents the inventory from being closed
                            .interactableSlots(AnvilGUI.Slot.INPUT_RIGHT)                               //allow player to take out and replace the right input item
                            .text("What player name?")                              //sets the text the GUI should start with
                            .itemLeft(new ItemStack(Material.PAPER))                      //use a custom item for the first slot
                            .onLeftInputClick(player -> player.sendMessage("Don't click me"))     //called when the left input slot is clicked
                            .title("Enter your answer.")                                       //set the title of the GUI (only works in 1.14+)
                            .plugin(plugin);

//                    Player reportedPlayer = Bukkit.getPlayer(p);
                    //called when the inventory output slot is clicked
                    webhook.addEmbed(new DiscordWebhook.EmbedObject()
                            .setTitle("Report system")
                            .setColor(Color.RED)
                            .addField("Report on: ", "test", true)
                            .addField("Problem type: ", "Bugs..", true)
                            .setFooter("Reported by: " + p.getName(), null));
                    e.getWhoClicked().closeInventory();
                    try {
                        webhook.execute();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    p.closeInventory();
                    break;
                case 40:
                    p.closeInventory();
                    break;
                default:
                    e.setCancelled(true);
                    return;
            }
            p.closeInventory();
        }
    }

    public void getNameInput(Player p) {
        ConversationFactory cf = new ConversationFactory(plugin);
        Conversation conv = cf.withFirstPrompt(new ConvName()).withLocalEcho(false).buildConversation(p);
        conv.begin();
        return;
    }


    public String onMessageReceived(AsyncPlayerChatEvent e) {
        final String message = e.getMessage();
        // do some smart compare
        return message;
    }
}
