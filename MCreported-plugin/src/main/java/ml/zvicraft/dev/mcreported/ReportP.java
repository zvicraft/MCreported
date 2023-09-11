package ml.zvicraft.dev.mcreported;


import java.util.Date;


public class ReportP {



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
                ", Msg: {"+ msgL +"}\n";
    }

    public int getId() {return id;}

    public String[] getMsg() {return msg;}

    public String getReported() {return reported;}

    public String getClient() {return client;}

    public Date getTime() {return time;}
}
