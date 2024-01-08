package ml.zvicraft.dev.mcreported;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;

public class Disutils {
    private final JDA jda;

    private final long channelId;

    private final String content;

    public Disutils(JDA jda, long channelId, String content) {
        this.jda = jda;
        this.channelId = channelId;
        this.content = content;
    }

    public void doThing() {
        TextChannel channel = this.jda.getTextChannelById(this.channelId);
        if (channel != null)
            channel.sendMessage(this.content).queue();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public JDA getJda() {
        return this.jda;
    }

    public String getContent() {
        return this.content;
    }
}
