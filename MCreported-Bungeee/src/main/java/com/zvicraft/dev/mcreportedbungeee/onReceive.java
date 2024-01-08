package com.zvicraft.dev.mcreportedbungeee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.net.InetSocketAddress;

import static com.zvicraft.dev.mcreportedbungeee.MCreportedBungeee.config;

public class onReceive implements Listener {
    @EventHandler
    public void onReceive(PluginMessageEvent e) {

        if (!e.getTag().equals(config.getString("Channel-server"))) {
            return;
        }

        InetSocketAddress senderServer = e.getSender().getAddress();

        for (ServerInfo server : getProxy().getServers().values()) {

            if (!server.getAddress().equals(senderServer) && server.getPlayers().size() > 0) {

                server.sendData(config.getString("Channel-server"), e.getData());
            }
        }
    }

    private ProxyServer getProxy() {
        return null;
    }
}
