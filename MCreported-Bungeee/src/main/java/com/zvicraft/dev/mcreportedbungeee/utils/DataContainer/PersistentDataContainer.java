package com.zvicraft.dev.mcreportedbungeee.utils.DataContainer;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.io.*;

public class PersistentDataContainer {


    /**
     every object (like String Int Byte...) key equals to "plugin.object.key"
     except Object (setObject and getObject).
     Object (setObject and getObject) key equals to "plugin.byteArray.object.key"
    **/



    public static void removeString(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"string."+key));
    }

    public static void setString(Plugin plugin, Player player,String key,String value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"string."+key), PersistentDataType.STRING,value);
    }

    public static String getString(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"string."+key),PersistentDataType.STRING);
    }


    public static void removeInteger(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"int."+key));
    }

    public static void setInteger(Plugin plugin,Player player,String key,int value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"int."+key),PersistentDataType.INTEGER,value);
    }

    public static int getInteger(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"int."+key),PersistentDataType.INTEGER);
    }


    public static void removeByte(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"byte."+key));
    }

    public static void setByte(Plugin plugin,Player player,String key,Byte value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"byte."+key),PersistentDataType.BYTE,value);
    }

    public static byte getByte(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"byte."+key),PersistentDataType.BYTE);
    }


    public static void removeDouble(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"double."+key));
    }

    public static void setDouble(Plugin plugin,Player player,String key,Double value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"double."+key),PersistentDataType.DOUBLE,value);
    }

    public static double getDouble(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"double."+key),PersistentDataType.DOUBLE);
    }



    public static void removeFloat(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"float."+key));
    }

    public static void setFloat(Plugin plugin,Player player,String key,float value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"float."+key),PersistentDataType.FLOAT,value);
    }

    public static float getFloat(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"float."+key),PersistentDataType.FLOAT);
    }


    public static void removeShort(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"short."+key));
    }

    public static void setShort(Plugin plugin,Player player,String key,short value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"short."+key),PersistentDataType.SHORT,value);
    }

    public static short getShort(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"short."+key),PersistentDataType.SHORT);
    }



    public static void removeLong(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"long."+key));
    }

    public static void setLong(Plugin plugin,Player player,String key,long value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"long."+key),PersistentDataType.LONG,value);
    }

    public static long getLong(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"long."+key),PersistentDataType.LONG);
    }



    public static void removeByteArray(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"byteArray."+key));
    }

    public static void setByteArray(Plugin plugin,Player player,String key,byte[] value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"byteArray."+key),PersistentDataType.BYTE_ARRAY,value);
    }

    public static byte[] getByteArray(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"byteArray."+key),PersistentDataType.BYTE_ARRAY);
    }



    public static void removeIntegerArray(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"intArray."+key));
    }

    public static void setIntegerArray(Plugin plugin,Player player,String key,int[] value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"intArray."+key),PersistentDataType.INTEGER_ARRAY,value);
    }

    public static int[] getIntegerArray(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"intArray."+key),PersistentDataType.INTEGER_ARRAY);
    }


    public static void removeLongArray(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"longArray."+key));
    }

    public static void setLongArray(Plugin plugin,Player player,String key,long[] value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"longArray."+key),PersistentDataType.LONG_ARRAY,value);
    }

    public static long[] getLongArray(Plugin plugin, Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"longArray."+key),PersistentDataType.LONG_ARRAY);
    }



    public static void removeTagContainerArray(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"tagContainerArray."+key));
    }

    public static void setTagContainerArray(Plugin plugin,Player player,String key,org.bukkit.persistence.PersistentDataContainer[] value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"tagContainerArray."+key),PersistentDataType.TAG_CONTAINER_ARRAY,value);
    }

    public static org.bukkit.persistence.PersistentDataContainer[] getTagContainerArray(Plugin plugin, Player player, String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"tagContainerArray."+key),PersistentDataType.TAG_CONTAINER_ARRAY);
    }



    public static void removeTagContainer(Plugin plugin,Player player,String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.remove(new NamespacedKey(plugin,"tagContainer."+key));
    }

    public static void setTagContainer(Plugin plugin,Player player,String key,org.bukkit.persistence.PersistentDataContainer value){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(plugin,"tagContainer."+key),PersistentDataType.TAG_CONTAINER,value);
    }

    public static org.bukkit.persistence.PersistentDataContainer getTagContainer(Plugin plugin, Player player, String key){
        org.bukkit.persistence.PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(plugin,"tagContainer."+key),PersistentDataType.TAG_CONTAINER);
    }



    public static void removeObject(Plugin plugin,Player player,String key){
        removeByteArray(plugin,player,"object."+key);
    }

    public static void setObject(Plugin plugin,Player player,String key,Object value){
        byte[] obj;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try{
            out = new ObjectOutputStream(bos);
            out.writeObject(value);
            obj = bos.toByteArray();
            setByteArray(plugin,player,"object."+key,obj);
        } catch (Exception e) {
        } finally {
            try{
                bos.close();
            }catch (Exception e){}
        }
    }

    public static Object getObject(Plugin plugin, Player player, String key){
        ByteArrayInputStream bis = new ByteArrayInputStream(getByteArray(plugin,player,"object."+key));
        ObjectInput in = null;
        Object o=null;
        try{
            in = new ObjectInputStream(bis);
            o = in.readObject();
        } catch (Exception e){}
        finally {
            try{
            if(in!=null){
                in.close();
            }}catch (Exception e){}
        }
        return o;
    }







}
