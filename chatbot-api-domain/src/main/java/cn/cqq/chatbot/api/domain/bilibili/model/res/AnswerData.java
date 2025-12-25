package cn.cqq.chatbot.api.domain.bilibili.model.res;

import cn.cqq.chatbot.api.domain.bilibili.model.vo.KeyHitInfos;
import lombok.Data;

@Data
public class AnswerData {
	private String msgContent;
	private long msgKey;
	private KeyHitInfos keyHitInfos;
}