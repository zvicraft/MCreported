package com.zvicraft.dev.mcreportedbungeee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;

public class MCreportedBungeee extends Plugin implements Listener {
    public static MCreportedBungeee plugin;
    public static Configuration config;

    @Override
    public void onEnable() {
        plugin = this;

        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }

        // Load the configuration
        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            new Mcdiscord();
        } catch (LoginException e) {
            System.out.println(config.getString("TOKEN-INVADE"));
            throw new RuntimeException(e);
        }


        ProxyServer.getInstance().registerChannel("Mcreported:channel");

        // Register your event listener
        getProxy().getPluginManager().registerListener(this, this);


        getLogger().info("Running on BungeeCord.");

    }


    @Override
    public void onDisable() {

        getProxy().unregisterChannel("Mcreported:channel");
    }

    @EventHandler
    public void onReceive(PluginMessageEvent e) {

        if (!e.getTag().equals("Mcreported:channel")) {
            return;
        }

        InetSocketAddress senderServer = e.getSender().getAddress();

        for (ServerInfo server : getProxy().getServers().values()) {

            if (!server.getAddress().equals(senderServer) && server.getPlayers().size() > 0) {

                server.sendData("Mcreported:channel", e.getData());
            }
        }
    }
    // Execute BungeeCord-specific code
}

