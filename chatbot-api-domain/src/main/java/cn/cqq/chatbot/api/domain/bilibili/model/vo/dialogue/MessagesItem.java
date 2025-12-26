package cn.cqq.chatbot.api.domain.bilibili.model.vo.dialogue;

import lombok.Data;

import java.util.List;

/**
 * @author: chenqingquan
 * @description: 消息对象
 * @date: 2025/12/20 23:00
 */

@Data
public class MessagesItem {
    private Integer msgSource;
    private Integer receiverId;
    private Integer msgType;
    private Integer msgStatus;
    private String notifyCode;
    private Integer senderUid;
    private Long msgKey;
    private String content;
    private Long msgSeqno;
    private Integer receiverType;
    private Integer timestamp;
    private List<Integer> atUids;
}