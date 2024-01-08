package com.zvicraft.dev.mcreportedbungeee.utils.DataContainer;

import com.zvicraft.dev.mcreportedbungeee.MCreportedBungeee;
import org.bukkit.plugin.Plugin;


public class HashMap<A,B> extends java.util.HashMap {



    /**
     to save the data you need to do in your
     Enable void: yourObject.restore();
     Disable void: yourObject.save();
      https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/
      **/


    private FileManager file;
    private Plugin plugin;

    public HashMap(MCreportedBungeee plugin, String url){

        file = new FileManager((Plugin) plugin,"hashmaps",url+"-hashmap.yml");
        this.plugin = (Plugin) plugin;
    }
    public void save(){
        int i = 0;
        for (Object map: this.keySet()){
            A key = (A) map;
            B value = (B) this.get(map);
            file.getYml().set("key."+i,key);
            file.getYml().set("value."+i,value);
            i+=1;
        }
        file.save();
    }
    public void restore(){
        int i = 0;
        while (file.getYml().get("key."+i)!=null && file.getYml().get("value."+i) !=null){
            A key = (A) file.getYml().get("key."+i);
            B value = (B) file.getYml().get("value."+i);
            this.put(key,value);
            i+=1;
        }

        file.getYml().set("key",null);
        file.getYml().set("value",null);
        file.save();

    }


}
