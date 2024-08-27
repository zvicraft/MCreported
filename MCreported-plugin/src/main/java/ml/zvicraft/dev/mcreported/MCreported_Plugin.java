package ml.zvicraft.dev.mcreported;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import ml.zvicraft.dev.mcreported.FileManager.FileManager;
import ml.zvicraft.dev.mcreported.GUI.ChatEvent;
import ml.zvicraft.dev.mcreported.GUI.Default;
import ml.zvicraft.dev.mcreported.GUI.JoinAndLeaveEvent;
import ml.zvicraft.dev.mcreported.api.NMS;
import ml.zvicraft.dev.mcreported.commands.*;
import ml.zvicraft.dev.mcreported.events.LisenersMenu;
import ml.zvicraft.dev.mcreported.utils.BungeeMessageListener;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class MCreported_Plugin extends JavaPlugin {
    public static MCreported_Plugin plugin;

    public static List<ReportP> reports = new ArrayList<>();
    private NMS nmsHandler;

    public MCreported_Plugin(NMS nmsHandler) {
    }
//    public static HashMap<Player,Integer> amount ;


    public void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public void onEnable() {
        try {
            //Set your nms field
            NMS nms = (NMS) Class.forName("ml.zvicraft.dev.mcreported.nms.NMSHandler_" + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3].substring(1)).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }




        String packageName = this.getServer().getClass().getPackage().getName();
        // Get full package string of CraftServer.
        // org.bukkit.craftbukkit.version
        String version = packageName.substring(packageName.lastIndexOf('.') + 1);
        // Get the last element of the package

        try {
            final Class<?> clazz = Class.forName("ml.zvicraft.dev.mcrepored.nms." + version + ".NMSHandler_1_18_R0");
            // Check if we have a NMSHandler_1_18_wR0 class at that location.
            if (NMS.class.isAssignableFrom(clazz)) { // Make sure it actually implements NMS
                this.nmsHandler = (NMS) clazz.getConstructor().newInstance(); // Set our handler
            }
        } catch (final Exception e) {
            e.printStackTrace();
            this.getLogger().severe("Could not find support for this CraftBukkit version.");
            this.getLogger().info("Check for updates at URL HERE");
            this.setEnabled(false);
            return;
        }
        this.getLogger().info("Loading support for " + version);




        SpigotUpdater updater = new SpigotUpdater(this, 111004);

        try {
            if (updater.checkForUpdates())
                getLogger().info("An update was found! New version: " + updater.getLatestVersion() + " download: " + updater.getResourceURL());
        } catch (Exception e) {
            getLogger().warning("Could not check for updates! Stacktrace:");
            e.printStackTrace();
        }
        plugin = this;
        if (!plugin.getConfig().getBoolean("Bungee")) {

            try {
            new Mcdiscord();
        } catch (LoginException e) {
            System.out.println(getConfig().getString("TOKEN-INVADE"));
//            throw new RuntimeException(e);
        }}else{
            getLogger().info("BungeeCord detected, disabling discord support");
            return;
        }
        loadConfig();
        loadData();

        Default.initialise();
        getLogger().info("MCREPORTED | The plugin is enabled");
        getServer().getConsoleSender().sendMessage(Utils.chat(getConfig().getString("prefix") + "&athe plugin is enabled"));
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
        getCommand("report").setExecutor((CommandExecutor)new ReportCommand());
        getCommand("reloadrmc").setExecutor((CommandExecutor)new CommadsConfig());
        getCommand("reports").setExecutor((CommandExecutor)new reportshow());
        getCommand("reportscancel").setExecutor((CommandExecutor)new reportcencelcommand());
        getCommand("reportscancelall").setExecutor((CommandExecutor)new reportcommandcancelall());
        getServer().getPluginManager().registerEvents((Listener)new LisenersMenu(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new ChatEvent(), (Plugin)this);
        getServer().getPluginManager().registerEvents((Listener)new JoinAndLeaveEvent(), (Plugin)this);


        if( getDataFolder().mkdir() ){

            getDataFolder().mkdirs();


        }



         ReportP.getAmount().restore();
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "Mcreported:channel");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "Mcreported:channel", new BungeeMessageListener(this));
        // Register the incoming channel, from Bungee
    }

    public void onDisable() {
        ReportP.getAmount().save();
        for (ReportP report : reports) {
            FileManager.ymlData.set("reports." + report.getId() + ".msg", report.getMsg());
            FileManager.ymlData.set("reports." + report.getId() + ".client", report.getClient());
            FileManager.ymlData.set("reports." + report.getId() + ".reported", report.getReported());
            FileManager.ymlData.set("reports." + report.getId() + ".time", report.getTime());
            FileManager.ymlData.set("reports." + report.getId() + ".amount", ReportP.getAmount());

        }
        FileManager.saveFiles();
    }


    public static void loadData() {
        try {
            FileManager.ymlData.getConfigurationSection("reports").getKeys(false).forEach(key -> {
                List<String> msg = FileManager.ymlData.getStringList("reports." + key + ".msg");
                String client = FileManager.ymlData.getString("reports." + key + ".client");
                String reported = FileManager.ymlData.getString("reports." + key + ".reported");
                Date time = (Date)FileManager.ymlData.getObject("reports." + key + ".time", Date.class);
                String msgL = "";
                for (String e : msg)
                    msgL = msgL + e;
                ReportP data = new ReportP(Integer.parseInt(key), client, reported, time, new String[] { msgL });
                reports.add(data);
            });
            FileManager.ymlData.set("reports", null);
            FileManager.saveFiles();
            FileManager.reloadFiles();
            ReportP.getAmount().save();
            ReportP.getAmount().restore();
        } catch (Exception exception) {}
    }

    int t = 0;

    boolean have = false;

    public int getlastId() {
        while (true) {
            reports.stream().forEach(key -> {
                if (key.getId() == this.t)
                    this.have = true;
            });
            if (!this.have) {
                int k = this.t;
                this.t = 0;
                return k;
            }
            this.have = false;
            this.t++;
        }
    }

    private String combineSplit(String[] split) {
        if (split.length == 0) {
            return "";
        } else if (split.length == 1) {
            return split[0];
        }
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            builder.append(s).append(' ');
        }
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }
    public static void forwardData(Player player, String message, boolean something) {

        try {

            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF(message);
            out.writeBoolean(something);

            player.sendPluginMessage(plugin, "channel", out.toByteArray());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void doSomethingWithTheData(String message, boolean something) {
    }
}
