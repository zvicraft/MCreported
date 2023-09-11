package ml.zvicraft.dev.mcreported;

import kotlin.Metadata;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 9, 0},
        k = 1,
        d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\b\u0010\r\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"},
        d2 = {"Lml/zvicraft/dev/mcreported/Disutils;", "", "jda", "Lnet/dv8tion/jda/api/JDA;", "channelId", "", "content", "", "(Lnet/dv8tion/jda/api/JDA;JLjava/lang/String;)V", "doThing", "", "getChannelId", "getContent", "getJda", "MCreported"}
)
public final class Disutils {
    private final JDA jda;
    private final long channelId;
    private final String content;

    public final void doThing() {
        TextChannel channel = this.jda.getTextChannelById(this.channelId);
        if (channel != null) {
            MessageCreateAction var10000 = channel.sendMessage((CharSequence)this.content);
            if (var10000 != null) {
                var10000.queue();
            }
        }

    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Nullable
    public final JDA getJda() {
        return this.jda;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public Disutils(@Nullable JDA jda, long channelId, @Nullable String content) {
        this.jda = jda;
        this.channelId = channelId;
        this.content = content;
    }
}
