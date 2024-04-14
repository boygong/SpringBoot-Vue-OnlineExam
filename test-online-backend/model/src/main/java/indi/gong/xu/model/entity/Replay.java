package indi.gong.xu.model.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Replay {
    private Integer messageId;

    private Integer replayId;

    private String replay;

    private Date replayTime;
}