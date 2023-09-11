package ml.zvicraft.dev.mcreported.FileManager;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static ml.zvicraft.dev.mcreported.MCreported.plugin;

public class FileManager {

    public static File data = new File(plugin.getDataFolder()+"/data.yml");
    public static YamlConfiguration ymlData = YamlConfiguration.loadConfiguration(data);



    public static void fileCreation(){
        try {
            if (!data.exists()) {
                data.createNewFile();
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public static void saveFiles(){
        try{
            ymlData.save(data);
        }catch (Exception e){e.printStackTrace();}
    }

    public static void reloadFiles(){
        try{
            ymlData.load(data);
        }catch (Exception e){e.printStackTrace();}

    }


}
