package ml.zvicraft.dev.mcreported.PlayerAPI;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static ml.zvicraft.dev.mcreported.MCreported_Plugin.plugin;

public class ChatBoolen {


    public static boolean getPlayerAbility(Player player, String boolAnvil){
        boolean r = false;
        try{
            PersistentDataContainer data = player.getPersistentDataContainer();
            if(data.get(new NamespacedKey(plugin,boolAnvil), PersistentDataType.INTEGER) == 1){r = true;}
        }catch (Exception e){
            PersistentDataContainer data = player.getPersistentDataContainer();
            data.set(new NamespacedKey(plugin,boolAnvil),PersistentDataType.INTEGER,0);
        }
        return r;
    }

    //0 - false; 1 - true
    public static void setPlayerAbility(Player player ,String boolAnvil,boolean booleanAbility){
        PersistentDataContainer data = player.getPersistentDataContainer();
        int i =0;
        if(booleanAbility){i=1;}
        data.set(new NamespacedKey(plugin,boolAnvil), PersistentDataType.INTEGER,i);
    }

    public static void setString(Player p, String set, String msg){
        PersistentDataContainer data = p.getPersistentDataContainer();
        data.set(new NamespacedKey(plugin,set),PersistentDataType.STRING,msg);
    }

    public static String getString(Player p,String set){
        try{
            PersistentDataContainer data = p.getPersistentDataContainer();
            return data.get(new NamespacedKey(plugin,set),PersistentDataType.STRING);
        }catch (Exception e){
            PersistentDataContainer data = p.getPersistentDataContainer();
            data.set(new NamespacedKey(plugin,set),PersistentDataType.STRING,"");
            return getString(p,set);
        }
    }
}
