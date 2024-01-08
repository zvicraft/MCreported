package com.zvicraft.dev.mcreportedbungeee;



import com.zvicraft.dev.mcreportedbungeee.utils.DataContainer.HashMap;

import java.util.Date;

import static com.zvicraft.dev.mcreportedbungeee.MCreportedBungeee.plugin;


public class ReportP {


    public static HashMap<String,Integer> amount = new HashMap<>(plugin,"report-amount");
    private int id;
    private String[] msg;
    private String reported,client;
    private Date time;

    public ReportP(int id, String client, String reported, Date time, String... msg){

        this.id = id;
        this.msg = msg;
        this.time = time;
        this.reported = reported;

        this.client = client;

        if(amount.get(reported)!=null){
            amount.put(reported,((Integer) amount.get(reported)+1));
        }
        else{
            amount.put(reported,1);
        }
    }


    @Override
    public String toString() {
        String msgL ="";

        for(String key:msg){
            msgL += key;
        }


        return "id: "+id+
                ", Client: "+ client+
                ", Reported: " + reported+
                ", Time: "+time.toString() +
                ", Msg: {"+ msgL +"}\n" + "Amount:" + amount.get(client);
    }

    public int getId() {return id;}

    public String[] getMsg() {return msg;}

    public String getReported() {return reported;}

    public String getClient() {return client;}

    public Date getTime() {return time;}
    public int getAmount(String reported) {return (Integer) amount.get(reported);}

    public static HashMap<String,Integer> getAmount(){return amount;}
}
