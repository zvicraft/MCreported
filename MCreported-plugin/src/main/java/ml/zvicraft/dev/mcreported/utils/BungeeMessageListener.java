package ml.zvicraft.dev.mcreported.utils;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import ml.zvicraft.dev.mcreported.MCreported_Plugin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeMessageListener implements PluginMessageListener {

    MCreported_Plugin plugin;

    public BungeeMessageListener(MCreported_Plugin instance) {
        plugin = instance;
    }


    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {

        if (!channel.equals("channel")) {
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(bytes);

        String message = in.readUTF();

        boolean something = in.readBoolean();

        plugin.doSomethingWithTheData(message, something);
    }
}