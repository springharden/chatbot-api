package cn.cqq.chatbot.api.domain.bilibili.model.aggregates;

import cn.cqq.chatbot.api.domain.bilibili.model.res.dialogue.DialogueResData;
import lombok.Data;

@Data
public class DialogueRes {
    private String msg;
    private Integer code;
    private DialogueResData data;
    private String message;
    private Integer ttl;

}
