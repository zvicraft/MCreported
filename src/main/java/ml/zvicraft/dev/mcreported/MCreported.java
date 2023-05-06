package ml.zvicraft.dev.mcreported;

import ml.zvicraft.dev.mcreported.commands.ReportCommand;
import ml.zvicraft.dev.mcreported.commands.CommadsConfig;
import ml.zvicraft.dev.mcreported.events.LisenersMenu;
import ml.zvicraft.dev.mcreported.utils.Utils;
import org.bukkit.Color;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public final class MCreported extends JavaPlugin {
    public static MCreported instance;
    public static MCreported getInstance() {
        return instance;
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveConfig();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        getLogger().info( "MCREPORTED | The plugin is enabled");
        getServer().getConsoleSender().sendMessage(Utils.chat(this.getConfig().getString("prefix") + "&athe plugin is enabled"));
        this.getConfig().options().copyDefaults(false);
        this.saveDefaultConfig();
        getCommand("report").setExecutor(new ReportCommand());
        getCommand("reloadrmc").setExecutor(new CommadsConfig());

        getServer().getPluginManager().registerEvents(new LisenersMenu(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
