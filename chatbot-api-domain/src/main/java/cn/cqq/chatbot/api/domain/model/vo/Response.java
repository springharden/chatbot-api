package cn.cqq.chatbot.api.domain.model.vo;

import lombok.Data;

/**
 * @author: chenqingquan
 * @description: 请求响应体
 * @date: 2025/12/20 23:00
 */

@Data
public class Response{
	private String msg;
	private int code;
	private RespData data;
	private String message;
	private int ttl;
}