package cn.cqq.chatbot.api.domain.bilibili.model.vo;

import lombok.Data;

/**
 * @author: chenqingquan
 * @description: 会话列表对象
 * @date: 2025/12/20 23:00
 */

@Data
public class SessionListItem{
	private Long maxSeqno;
	private Long sessionTs;
	private Long groupType;
	private Long setting;
	private LastMsg lastMsg;
	private Long talkerId;
	private Long atSeqno;
	private Long unreadCount;
	private Long sessionType;
	private Long ackTs;
	private Long liveStatus;
	private Long canFold;
	private Long isFollow;
	private Long newPushMsg;
	private Long isIntercept;
	private String groupName;
	private Object userLabel;
	private Long topTs;
	private Long isDnd;
	private Long systemMsgType;
	private Long bizMsgUnreadCount;
	private Long ackSeqno;
	private Long isGuardian;
	private String groupCover;
	private Long status;
	private Long isTrust;
	private AccountInfo accountInfo;
}