package cn.cqq.chatbot.api.domain.bilibili;


import cn.cqq.chatbot.api.domain.bilibili.model.aggregates.MessageRes;

/**
 * B站Api
 *
 * @author chenqingquan
 * @version Revision:v1.0
 * @since Date: 2025/12/23
 */
public interface IBiliBiliApi {

    /**
     * 查询消息列表最新的20条消息
     * @param cookie cookie信息
     * @param lastReceiveMessageTime 截止日期，会查询这个时间点之前的20条（这个时间是对话最新一条消息的时间，最新一条消息可能是好友的信息，也可能是你的回复）
     * @return 截止时间点的20条消息
     */
    MessageRes queryMessageList(String cookie, Long lastReceiveMessageTime);

    /**
     * 发送消息
     * @param cookie cookie信息
     * @param message 消息内容
     * @param receiverId 目标用户id
     * @return 发送结果
     */
    boolean sendMessage(String cookie, String message, Long receiverId);
}
