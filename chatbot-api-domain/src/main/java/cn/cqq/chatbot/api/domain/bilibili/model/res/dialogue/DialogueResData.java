package cn.cqq.chatbot.api.domain.bilibili.model.res.dialogue;

import cn.cqq.chatbot.api.domain.bilibili.model.vo.dialogue.MessagesItem;
import lombok.Data;

import java.util.List;

/**
 * @author: chenqingquan
 * @description: 对话对象
 * @date: 2025/12/20 23:00
 */

@Data
public class DialogueResData {
    private Long maxSeqno;
    private List<MessagesItem> messages;
    private Integer hasMore;
    private Long minSeqno;

}