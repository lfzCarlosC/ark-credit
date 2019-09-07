package com.cryptal.ark.arkcreditservice.push.service.impl;

import com.cryptal.ark.arkcreditservice.push.dao.PushMessageDao;
import com.cryptal.ark.arkcreditservice.push.domain.PushMessage;
import com.cryptal.ark.arkcreditservice.push.domain.SendResult;
import com.cryptal.ark.arkcreditservice.push.event.PushMessageReceived;
import com.cryptal.ark.arkcreditservice.push.event.PushMessageSent;
import com.cryptal.ark.arkcreditservice.push.service.PushMessageService;
import com.cryptal.ark.arkcreditservice.rank.domain.RankMessageType;
import com.cryptal.ark.arkcreditservice.rank.service.RankMessageTypeService;
import com.cryptal.ark.arkcreditservice.user.service.UserRankService;
import com.cryptal.ark.arkcreditservice.user.domain.Device;
import com.cryptal.ark.arkcreditservice.user.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PushMessageServiceImpl implements PushMessageService {

    @Autowired
    private RankMessageTypeService rankMessageTypeService;

    @Autowired
    private UserRankService userRankService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private PushMessageDao pushMessageDao;

    /**
     * 向指定设备发送消息
     * @param device
     */
    private SendResult sendPushMessage(Device device) {
        return new SendResult();
    }

    @Override
    public void receiveMsg(Long messageTypeId, String content) {

        PushMessage pushMessage = new PushMessage();
        pushMessage.setContent(content);
        pushMessage.setMessageTypeId(messageTypeId);
        pushMessage.setPushTime(new Date());
        pushMessageDao.save(pushMessage);

        publisher.publishEvent(new PushMessageReceived(this,pushMessage));
    }

    @Override
    public void send(PushMessage pushMessage) {
        List<RankMessageType> rankMessageTypeList = rankMessageTypeService.findByMessageTypeId(pushMessage.getMessageTypeId());
        for (RankMessageType rankMessageType : rankMessageTypeList) {
            List<Long> userIds = userRankService.findUserIdsByRankId(rankMessageType.getRankId());
            List<Device> devices = deviceService.findByIds(userIds);
            for (Device device : devices) {
                SendResult sendResult = sendPushMessage(device);
                publisher.publishEvent(new PushMessageSent(this,pushMessage,device,rankMessageType,sendResult));
            }
        }
    }
}
