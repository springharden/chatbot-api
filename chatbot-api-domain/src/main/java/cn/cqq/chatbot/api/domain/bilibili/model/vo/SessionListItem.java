package cn.cqq.chatbot.api.domain.bilibili.model.vo;

import lombok.Data;

/**
 * @author: chenqingquan
 * @description: 会话列表对象
 * @date: 2025/12/20 23:00
 */

@Data
public class SessionListItem{
	private long maxSeqno;
	private long sessionTs;
	private int groupType;
	private int setting;
	private LastMsg lastMsg;
	private int talkerId;
	private int atSeqno;
	private int unreadCount;
	private int sessionType;
	private int ackTs;
	private int liveStatus;
	private int canFold;
	private int isFollow;
	private int newPushMsg;
	private int isIntercept;
	private String groupName;
	private Object userLabel;
	private int topTs;
	private int isDnd;
	private int systemMsgType;
	private int bizMsgUnreadCount;
	private int ackSeqno;
	private int isGuardian;
	private String groupCover;
	private int status;
	private int isTrust;
	private AccountInfo accountInfo;
}