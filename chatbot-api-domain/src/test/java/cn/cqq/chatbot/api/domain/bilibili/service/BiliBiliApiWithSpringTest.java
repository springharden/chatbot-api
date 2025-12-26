package cn.cqq.chatbot.api.domain.bilibili.service;

import cn.cqq.chatbot.api.domain.bilibili.model.aggregates.MessageRes;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

// 仅加载domain层的Spring上下文，不依赖外层模块
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DomainTestApplication.class)
public class BiliBiliApiWithSpringTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BiliBiliApi biliBiliApiUnderTest;

    private final String cookie = "DedeUserID=1406650124; DedeUserID__ckMd5=cf4f2bace9d50035; " +
            "enable_web_push=DISABLE; buvid4=055C4E57-7EAF-D57F-75BB-918D09AAB7A934523-023060819" +
            "-IxI84wJ0CmkUnPxeYRI4MA%3D%3D; enable_feed_channel=ENABLE; LIVE_BUVID=AUTO4617468047822448; PVID=1; " +
            "hit-dyn-v2=1; header_theme_version=OPEN; theme-tip-show=SHOWED; theme-avatar-tip-show=SHOWED; " +
            "buvid3=CC59A03D-8E85-F3FB-C7C6-0ABBB7842E4913327infoc; b_nut=1752409513; CURRENT_QUALITY=80; rpdid=|(u))" +
            "kR||)kR0J'u~YlmkRJmJ; share_source_origin=WEIXIN; bsource=search_bing; " +
            "bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9" +
            ".eyJleHAiOjE3NjY3NTMwNjUsImlhdCI6MTc2NjQ5MzgwNSwicGx0IjotMX0" +
            ".R9SYrU2kgjA0QuRor0ti4k9WaVqHqKFlnnjoaZHn8Ck; bili_ticket_expires=1766753005; " +
            "SESSDATA=d3f6b305%2C1782049788%2Ccdd88%2Ac1CjDPeHCR0VwDwVB77YS" +
            "-63G8lm5Shpzy1VTTb_qnk0SemF71niZ6xRU60bPuwuEuyM4SVjItT0tJREFkSTRNb2loWlYzY2JrSFdoSkNwTXhvNlFfTklWVjQxdWMtZlFiSGdnVlZzSXM5MTI0QUtsUGVzTG16SXlnbGNiM2I1dU9Gd3Rya2V0eG5RIIEC; bili_jct=dd6b94ae68cffd8dcc566c8ff422fd3a; sid=76fnq06x; buvid_fp=1ad4aea7f822980581373749d554380e; CURRENT_FNVAL=2000; home_feed_column=4; browser_resolution=1099-886; bp_t_offset_1406650124=1150358319664201728";


    @Test
    public void testQueryMessageList() throws Exception {
        MessageRes result = biliBiliApiUnderTest.queryMessageList(cookie, null);
        logger.info(JSON.toJSONString(result));
        assertNotNull("解析结果为空", result);
        // 其他验证逻辑...
    }
}