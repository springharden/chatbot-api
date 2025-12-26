package cn.cqq.chatbot.api.domain.bilibili.model.vo.message;

import lombok.Data;

/**
 * @author: chenqingquan
 * @description: 消息类
 * @date: 2025/12/20 23:00
 */

@Data
public class LastMsg{
	private Long msgSource;
	private Long receiverId;
	private Long msgType;
	private Long msgStatus;
	private String notifyCode;
	private Long senderUid;
	private Long msgKey;
	private String content;
	private Long msgSeqno;
	private Long receiverType;
	private Long timestamp;
	private Object atUids;
	private Long newFaceVersion;
}