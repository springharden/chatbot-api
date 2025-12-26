package cn.cqq.chatbot.api.domain.bilibili.model.res.message;

import cn.cqq.chatbot.api.domain.bilibili.model.vo.message.SessionListItem;
import cn.cqq.chatbot.api.domain.bilibili.model.vo.message.SystemMsg;
import lombok.Data;

import java.util.List;
/**
 * @author: chenqingquan
 * @description: 消息列表对象
 * @date: 2025/12/20 23:00
 */

@Data
public class messageData {
	private List<SessionListItem> sessionList;
	private boolean showLevel;
	private int isAddressListEmpty;
	private boolean antiDisturbCleaning;
	private SystemMsg systemMsg;
	private int hasMore;
}