package com.zvicraft.dev.mcreportedbungeee.utils.DataContainer;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class FileManager {


    private static File file;

    private static YamlConfiguration yml;

    public FileManager(Plugin plugin,String URL){
        this.file = new File(plugin.getDataFolder()+"/"+URL);
        this.yml = YamlConfiguration.loadConfiguration(file);
        try{
            plugin.getDataFolder().mkdir();
            if(!file.exists()){file.createNewFile();}}catch (Exception e){e.printStackTrace();}
    }

    public FileManager(Plugin plugin,String folder,String URL){
        this.file = new File(plugin.getDataFolder()+"/"+folder+"/"+URL);
        this.yml = YamlConfiguration.loadConfiguration(file);
        File folderF = new File(plugin.getDataFolder()+"/"+folder);

        try{
            plugin.getDataFolder().mkdir();
            folderF.mkdir();
            if(!file.exists()){file.createNewFile();}}catch (Exception e){e.printStackTrace();}
    }



    public void save(){try{this.yml.save(this.file);}catch (Exception e){e.printStackTrace();}}
    public void load(){try{this.yml.load(this.file);}catch (Exception e){e.printStackTrace();}}

    public static YamlConfiguration getYml() {
        return yml;
    }
}
