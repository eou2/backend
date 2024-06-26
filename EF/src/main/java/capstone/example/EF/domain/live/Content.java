package capstone.example.EF.domain.live;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Content {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "live_room_id")
    private LiveRoom liveRoom;

    private String content;
    private Integer millisec;
    private Long memberId;

    protected Content(){}

    public static Content createContent(LiveRoom liveRoom, String content,Long memberId, Integer millisec){
        Content ct = new Content();
        ct.content = content;
        ct.liveRoom = liveRoom;
        ct.memberId = memberId;
        ct.millisec = millisec;

        liveRoom.getContents().add(ct);

        return ct;
    }
}
