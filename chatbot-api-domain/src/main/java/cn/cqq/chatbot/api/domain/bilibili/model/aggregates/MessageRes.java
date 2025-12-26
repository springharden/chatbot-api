package cn.cqq.chatbot.api.domain.bilibili.model.aggregates;

import cn.cqq.chatbot.api.domain.bilibili.model.res.messageData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: chenqingquan
 * @description: 请求响应体
 * @date: 2025/12/20 23:00
 */

@Data
public class MessageRes {
	private String msg;
	private int code;
	private messageData data;
	private String message;
	private int ttl;
}