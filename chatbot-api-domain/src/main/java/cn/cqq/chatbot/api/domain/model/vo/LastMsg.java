package cn.cqq.chatbot.api.domain.model.vo;

import lombok.Data;

/**
 * @author: chenqingquan
 * @description: 消息类
 * @date: 2025/12/20 23:00
 */

@Data
public class LastMsg{
	private int msgSource;
	private int receiverId;
	private int msgType;
	private int msgStatus;
	private String notifyCode;
	private int senderUid;
	private long msgKey;
	private String content;
	private long msgSeqno;
	private int receiverType;
	private int timestamp;
	private Object atUids;
	private int newFaceVersion;
}