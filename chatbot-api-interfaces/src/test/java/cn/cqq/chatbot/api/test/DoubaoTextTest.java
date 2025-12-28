package cn.cqq.chatbot.api.test;

import com.volcengine.ark.runtime.model.responses.request.CreateResponsesRequest;
import com.volcengine.ark.runtime.model.responses.request.ResponsesInput;
import com.volcengine.ark.runtime.model.responses.response.ResponseObject;
import com.volcengine.ark.runtime.service.ArkService;

public class DoubaoTextTest {
    public static void main(String[] args) {
        String apiKey = System.getenv("ARK_API_KEY");
        // The base URL for model invocation
        ArkService arkService = ArkService.builder().apiKey(apiKey).baseUrl("https://ark.cn-beijing.volces" +
                ".com/api/v3").build();

        CreateResponsesRequest request = CreateResponsesRequest.builder()
                .model("doubao-seed-1-6-251015")
                .previousResponseId("resp_0217669442463851888091dae27cb68a8dc76ef712c2eb13ed873")
                //resp_021766944437107a2bd775fb99c5b6935942e64060e78fabc804c
                .input(ResponsesInput.builder().stringValue("为何你会选择讲北极熊这个冷笑话").build())
                //                .stream(Boolean.TRUE)
                // .thinking(ResponsesThinking.builder().type(ResponsesConstants.THINKING_TYPE_DISABLED).build()) //
                // Manually disable deep thinking
                .build();

        ResponseObject resp = arkService.createResponse(request);
        System.out.println(resp);

        arkService.shutdownExecutor();
    }
}