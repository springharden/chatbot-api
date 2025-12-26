package cn.cqq.chatbot.api.domain.bilibili.service;


import cn.cqq.chatbot.api.domain.bilibili.IBiliBiliApi;
import cn.cqq.chatbot.api.domain.bilibili.model.aggregates.MessageRes;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * B站接口实现类
 *
 * @author chenqingquan
 * @version Revision:v1.0
 * @since Date: 2025/12/24
 */
@Service
public class BiliBiliApi implements IBiliBiliApi {

    @Resource(name = "om")
    private ObjectMapper objectMapper;

    @Override
    public MessageRes queryMessageList(String cookie, Long lastReceiveMessageTime) {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.vc.bilibili.com/session_svr/v1/session_svr/get_sessions?session_type=1&group_fold=1" +
                "&unfollow_fold=0&sort_rule=2&build=0&mobi_app=web&web_location=333" +
                ".40164&w_rid=e1d73f94eaaf9d04a6441694e95c2762";

        String timeStr = "&wts=" + (ObjectUtil.isNotNull(lastReceiveMessageTime) ?
                lastReceiveMessageTime.toString() : "");

        String urlSuffix = "&end_ts=1766278827032286";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "*/*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9")
                .addHeader("origin", "https://message.bilibili.com")
                .addHeader("priority", "u=1, i")
                .addHeader("referer", "https://message.bilibili.com/")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"143\", \"Chromium\";v=\"143\", \"Not A(Brand\";v=\"24\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"macOS\"")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-site")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, " +
                        "like Gecko) Chrome/143.0.0.0 Safari/537.36")
                .addHeader("Cookie", cookie)
                // 移除手动添加的 Accept-Encoding 头，让 OkHttp 自动处理
                // 移除手动添加的 Connection 头，OkHttp 会自动管理连接
                //              .addHeader("Accept-Encoding", "gzip, deflate, br")
                //              .addHeader("Connection", "keep-alive")
                .build();

        MessageRes messageRes = new MessageRes();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // 方案1：通过字节流明确指定 UTF-8 编码，避免编码推断错误
                byte[] responseBytes = response.body().bytes();
                String resJson = new String(responseBytes, StandardCharsets.UTF_8);

                // 2. 核心：将JSON解析为MessageRes对象
                messageRes = objectMapper.readValue(resJson, MessageRes.class);
                return messageRes; // 返回解析后的POJO
            } else {
                System.err.println("响应失败，状态码：" + (response != null ? response.code() : "未知"));
            }
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("JSON解析异常（字段不匹配/类型错误）：");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("请求或IO异常：");
            e.printStackTrace();
        }

        return messageRes;
    }

    @Override
    public boolean sendMessage(String cookie, String message, Long receiverId) {
        OkHttpClient client = new OkHttpClient();
        // 1. 解析Cookie字符串为键值对Map（自动处理空格、分隔符）
        // 解析Cookie为Map（基于Hutool StrUtil）
        Map<String, String> cookieMap = parseCookieToMap(cookie);

        // 2. 提取bili_jct的值，支持空值判断
        String biliJct = cookieMap.get("bili_jct");

        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "msg%5Bsender_uid%5D=1406650124&msg%5Breceiver_type%5D=1&msg" +
                "%5Breceiver_id%5D=396914695&msg%5Bmsg_type%5D=1&msg%5Bmsg_status%5D=0&msg%5Bcontent%5D=%7B%22content" +
                "%22%3A%22%E4%BD%A0%E5%A5%BD%E5%91%80%EF%BC%8C%E5%90%8C%E5%BF%97%22%7D&msg%5Bnew_face_version%5D=0" +
                "&msg%5Bcanal_token%5D=&msg%5Bdev_id%5D=079C1E6C-2DDA-49BB-B86A-06485DADC453&msg%5Btimestamp%5D" +
                "=1766325510&from_firework=0&build=0&mobi_app=web&csrf=" + biliJct);
        // todo 替换userId
        Request request = new Request.Builder()
                .url("https://api.vc.bilibili.com/web_im/v1/web_im/send_msg?w_sender_uid=1406650124&w_receiver_id" +
                        "=396914695&w_dev_id=079C1E6C-2DDA-49BB-B86A-06485DADC453&w_rid" +
                        "=287844819ffed42658c7180c3d6dce91&wts=1766325510")
                .post(body)
                .addHeader("accept", "*/*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("origin", "https://message.bilibili.com")
                .addHeader("priority", "u=1, i")
                .addHeader("referer", "https://message.bilibili.com/")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"143\", \"Chromium\";v=\"143\", \"Not A(Brand\";v=\"24\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"macOS\"")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-site")
                .addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, " +
                        "like Gecko) Chrome/143.0.0.0 Safari/537.36")
                .addHeader("Cookie", cookie)
                //                        .addHeader("Accept-Encoding", "gzip, deflate, br")
                //                        .addHeader("Connection", "keep-alive")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // 方案1：通过字节流明确指定 UTF-8 编码，避免编码推断错误
                byte[] responseBytes = response.body().bytes();
                String res = new String(responseBytes, StandardCharsets.UTF_8);

                // 方案2：若响应头已明确 Content-Type 为 UTF-8，也可直接用 string()，但方案1更稳妥
                // String res = response.body().string();

                System.out.println(res);
            } else {
                System.out.println("响应状态码：" + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 适配hutool-all 5.8.10的Cookie解析方法
     *
     * @param cookieStr Cookie字符串
     * @return 键值对Map
     */
    private static Map<String, String> parseCookieToMap(String cookieStr) {
        Map<String, String> cookieMap = new HashMap<>();
        if (StrUtil.isBlank(cookieStr)) {
            return cookieMap;
        }

        // 按分号分割Cookie项，忽略空字符串
        List<String> cookieItems = StrUtil.split(cookieStr, ';');
        for (String item : cookieItems) {
            if (StrUtil.isBlank(item)) {
                continue;
            }
            // 按等号分割键值对（只分割第一个等号，避免值中包含等号）
            List<String> keyValue = StrUtil.split(item, '=', 2);
            if (keyValue.size() != 2) {
                continue;
            }
            // 去除键值前后空格
            String key = StrUtil.trim(keyValue.get(0));
            String value = StrUtil.trim(keyValue.get(1));
            cookieMap.put(key, value);
        }
        return cookieMap;
    }
}
