package com.cryptal.ark.arkcreditservice.push;

import com.cryptal.ark.arkcreditservice.push.domain.Push;
import com.cryptal.ark.arkcreditservice.push.service.PushService;
import com.cryptal.ark.arkcreditservice.push.service.impl.PushServiceImpl;

import java.util.Date;

public class PushServiceTest {

    PushService pushService = new PushServiceImpl();

    /**
     * 用例：推送消息给订阅者
     */
    public void test_send_push(){

        Push push = new Push();
        push.setContent("");
        push.setPushTime(new Date());
        pushService.send(push);

    }


}
