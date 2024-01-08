package ml.zvicraft.dev.mcreported.events;

import org.bukkit.ChatColor;
import org.bukkit.conversations.ConversationContext;
import org.bukkit.conversations.Prompt;
import org.bukkit.conversations.StringPrompt;

public class ConvName extends StringPrompt {

    @Override
    public Prompt acceptInput(ConversationContext con, String answer) {
        con.getForWhom().sendRawMessage("§6Your new Item will called " + ChatColor.translateAlternateColorCodes('&', answer));
        return null;
    }

    @Override
    public String getPromptText(ConversationContext arg0) {
        return " §6Please enter the Name for your new item!";
    }

}