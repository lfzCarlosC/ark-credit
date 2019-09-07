package com.cryptal.ark.arkcreditservice.push;

import com.cryptal.ark.arkcreditservice.push.service.PushMessageService;
import com.cryptal.ark.arkcreditservice.push.service.impl.PushMessageServiceImpl;

public class PushServiceTest {

    PushMessageService pushMessageService = new PushMessageServiceImpl();

    /**
     * 用例：推送消息给订阅者
     * 1. 从MQ接受到消息
     * 2. 根据消息的类型，获取允许发送消息的等级列表
     * 3. 获取该等级下的所有可用用户
     * 4. 获取用户下的所有设备
     * 5. 推送消息给用户
     * 7. 消息已发送事件，记录发送记录
     */
    public void test_send_push(){

        String content = "";
        Long messageTypeId = 1L;

        pushMessageService.receiveMsg(messageTypeId,content);

    }


}
