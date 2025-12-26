package cn.cqq.chatbot.api.domain.bilibili.model.aggregates;

import cn.cqq.chatbot.api.domain.bilibili.model.res.answer.AnswerData;
import lombok.Data;

@Data
public class AnswerRes {
	private int code;
	private AnswerData data;
	private String message;
	private int ttl;
}