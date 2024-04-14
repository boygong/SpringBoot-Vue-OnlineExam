package indi.gong.xu.model.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Message {
    private Integer id;
    private Integer temp_id;//解决id为null创建的一个临时id

    private String title;

    private String content;

    private Date time;

    List<Replay> replays;   //一对多关系，评论信息
}