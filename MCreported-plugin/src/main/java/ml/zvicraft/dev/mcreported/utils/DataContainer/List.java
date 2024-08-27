package ml.zvicraft.dev.mcreported.utils.DataContainer;


import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class List<T> extends ArrayList {


    /**
     * to save the data you need to do in your
     * Enable void: yourObject.restore();
     * Disable void: yourObject.save();
     * <p>
     * Set in Java is an interface declared in java. util package.
     * It extends the collection interface that allows creating an unordered collection or list,
     * where duplicate values are not allowed. As the name implies,
     * a set in Java is used to create a mathematical set.
     **/

    private FileManager file;
    private Plugin plugin;


    public List(Plugin plugin, String url) {
        file = new FileManager(plugin, "sets", url + "-set.yml");
        this.plugin = plugin;
    }

    public void save() {
        int i = 0;
        for (Object map : this) {
            file.getYml().set("set." + i, map);
            i += 1;
        }
        file.save();
    }

    public void restore() {
        int i = 0;
        while (file.getYml().get("set." + i) != null) {
            Object value = file.getYml().get("set." + i);
            this.add(value);
            i += 1;
        }

        file.getYml().set("set", null);
        file.save();

    }

}
