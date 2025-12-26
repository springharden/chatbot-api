package cn.cqq.chatbot.api.domain.bilibili.model.res.answer;

import cn.cqq.chatbot.api.domain.bilibili.model.vo.answer.KeyHitInfos;
import lombok.Data;

/**
 * @author: chenqingquan
 * @description: 回答对象
 * @date: 2025/12/20 23:00
 */

@Data
public class AnswerData {
	private String msgContent;
	private long msgKey;
	private KeyHitInfos keyHitInfos;
}