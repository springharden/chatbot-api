package cn.cqq.chatbot.api.domain.vo;

import lombok.Data;

import java.util.List;
/**
 * @author: chenqingquan
 * @description: 消息列表响应对象
 * @date: 2025/12/20 23:00
 */

@Data
public class RespData {
	private List<SessionListItem> sessionList;
	private boolean showLevel;
	private int isAddressListEmpty;
	private boolean antiDisturbCleaning;
	private SystemMsg systemMsg;
	private int hasMore;
}