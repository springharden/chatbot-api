package cn.cqq.chatbot.api.test;

import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenqingquan
 * @description: 单元测试
 * @date: 2025/12/20 23:00
 */
public class ApiTest {

    @Test
    public void test_query_un_read_message() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://api.bilibili.com/x/msgfeed/at?platform=web&build=0&mobi_app=web" +
                "&web_location=333.40164");
        httpGet.addHeader("Cookie", "home_feed_column=5; DedeUserID=1406650124; DedeUserID__ckMd5=cf4f2bace9d50035; " +
                "buvid_fp=dc9c7880fffe0eafad48a27bf348e139; enable_web_push=DISABLE; " +
                "buvid4=055C4E57-7EAF-D57F-75BB-918D09AAB7A934523-023060819-IxI84wJ0CmkUnPxeYRI4MA%3D%3D; " +
                "enable_feed_channel=ENABLE; LIVE_BUVID=AUTO4617468047822448; PVID=1; hit-dyn-v2=1; " +
                "header_theme_version=OPEN; theme-tip-show=SHOWED; theme-avatar-tip-show=SHOWED; " +
                "buvid3=CC59A03D-8E85-F3FB-C7C6-0ABBB7842E4913327infoc; b_nut=1752409513; " +
                "browser_resolution=1920-886; CURRENT_FNVAL=4048; CURRENT_QUALITY=80; rpdid=|(u))kR||)" +
                "kR0J'u~YlmkRJmJ; ogv_device_support_hdr=0; " +
                "SESSDATA=bbbbca46%2C1781651329%2C7ad6b%2Ac1CjBxAqaT0EMnFRS0QPr1c9d63jIpXEbFRJa7wo4555ClMLBYNtOS3k" +
                "-yEEhUDOOf8ssSVmJ0YkRoMzdWelMycDFrNnlNbEtrbWtlcnVsOW5BV1dFNEdISE1SaHhGQ3g5NjR2QXk1VW9EeVBZU212cWVPbTF3RHoyYWlVVHJrdUxVT1BUai1jWml3IIEC; bili_jct=5d5a4e05e3362fffccc822e3472da23d; sid=851fsq1x; share_source_origin=WEIXIN; bsource=share_source_weixinchat; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NjY0OTU0NDksImlhdCI6MTc2NjIzNjE4OSwicGx0IjotMX0.3tzYxR0G3UWVrHxLLCbQssD030hCY0ROXJVHtSekrX4; bili_ticket_expires=1766495389; bp_t_offset_1406650124=1148648918385426432\n");
        httpGet.addHeader("Content-Type", "application/json; charset=utf-8");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_replay_message() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.bilibili.com/x/v2/reply/add");
        post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        post.addHeader("Referer", "https://www.bilibili.com/video/BV1901816628/");
        post.addHeader("Cookie", "home_feed_column=5; DedeUserID=1406650124; DedeUserID__ckMd5=cf4f2bace9d50035; " +
                "buvid_fp=dc9c7880fffe0eafad48a27bf348e139; enable_web_push=DISABLE; " +
                "buvid4=055C4E57-7EAF-D57F-75BB-918D09AAB7A934523-023060819-IxI84wJ0CmkUnPxeYRI4MA%3D%3D; " +
                "enable_feed_channel=ENABLE; LIVE_BUVID=AUTO4617468047822448; PVID=1; hit-dyn-v2=1; " +
                "header_theme_version=OPEN; theme-tip-show=SHOWED; theme-avatar-tip-show=SHOWED; " +
                "buvid3=CC59A03D-8E85-F3FB-C7C6-0ABBB7842E4913327infoc; b_nut=1752409513; " +
                "browser_resolution=1920-886; CURRENT_FNVAL=4048; CURRENT_QUALITY=80; rpdid=|(u))kR||)" +
                "kR0J'u~YlmkRJmJ; ogv_device_support_hdr=0; " +
                "SESSDATA=bbbbca46%2C1781651329%2C7ad6b%2Ac1CjBxAqaT0EMnFRS0QPr1c9d63jIpXEbFRJa7wo4555ClMLBYNtOS3k" +
                "-yEEhUDOOf8ssSVmJ0YkRoMzdWelMycDFrNnlNbEtrbWtlcnVsOW5BV1dFNEdISE1SaHhGQ3g5NjR2QXk1VW9EeVBZU212cWVPbTF3RHoyYWlVVHJrdUxVT1BUai1jWml3IIEC; bili_jct=5d5a4e05e3362fffccc822e3472da23d; sid=851fsq1x; share_source_origin=WEIXIN; bsource=share_source_weixinchat; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NjY0OTU0NDksImlhdCI6MTc2NjIzNjE4OSwicGx0IjotMX0.3tzYxR0G3UWVrHxLLCbQssD030hCY0ROXJVHtSekrX4; bili_ticket_expires=1766495389; bp_t_offset_1406650124=1148648918385426432");

        // sourceId(commend_root_id)、 videoId
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("oid", "1901816628"));
        params.add(new BasicNameValuePair("type", "1"));
        params.add(new BasicNameValuePair("message", "让我看看"));
        params.add(new BasicNameValuePair("scene", "msg"));
        params.add(new BasicNameValuePair("plat", "1"));
        params.add(new BasicNameValuePair("from", "im-reply"));
        params.add(new BasicNameValuePair("build", "0"));
        params.add(new BasicNameValuePair("mobi_app", "web"));
        params.add(new BasicNameValuePair("root", "283999425121"));
        params.add(new BasicNameValuePair("parent", "283999425121"));
        // 确保csrf值与Cookie中的bili_jct完全一致
        params.add(new BasicNameValuePair("csrf", "5d5a4e05e3362fffccc822e3472da23d"));

        // 5. 封装表单请求体（关键修正：使用UrlEncodedFormEntity）
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);
        post.setEntity(formEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
