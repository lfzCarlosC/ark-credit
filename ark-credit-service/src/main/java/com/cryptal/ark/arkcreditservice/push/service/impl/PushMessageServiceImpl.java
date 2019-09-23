package com.cryptal.ark.arkcreditservice.push.service.impl;

import com.cryptal.ark.arkcreditservice.push.dao.PushMessageDao;
import com.cryptal.ark.arkcreditservice.push.entity.PushMessageEntity;
import com.cryptal.ark.arkcreditservice.push.entity.SendResult;
import com.cryptal.ark.arkcreditservice.push.event.PushMessageReceived;
import com.cryptal.ark.arkcreditservice.push.event.PushMessageSent;
import com.cryptal.ark.arkcreditservice.push.service.PushMessageService;
import com.cryptal.ark.arkcreditservice.rank.domain.RankMessageType;
import com.cryptal.ark.arkcreditservice.rank.service.RankMessageTypeService;
import com.cryptal.ark.arkcreditservice.member.service.MemberService;
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
    private MemberService memberService;

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

        PushMessageEntity pushMessageEntity = new PushMessageEntity();
        pushMessageEntity.setContent(content);
        pushMessageEntity.setMessageTypeId(messageTypeId);
        pushMessageEntity.setPushTime(new Date());
        pushMessageDao.save(pushMessageEntity);

        publisher.publishEvent(new PushMessageReceived(this, pushMessageEntity));
    }



    @Override
    public void send(PushMessageEntity pushMessageEntity) {
        List<RankMessageType> rankMessageTypeList = rankMessageTypeService.findByMessageTypeId(pushMessageEntity.getMessageTypeId());
        for (RankMessageType rankMessageType : rankMessageTypeList) {
            List<Long> memberUserIds = memberService.findUserIdsByRankId(rankMessageType.getRankId());
            List<Device> devices = deviceService.findByIds(memberUserIds);
            for (Device device : devices) {
                SendResult sendResult = sendPushMessage(device);
                publisher.publishEvent(new PushMessageSent(this, pushMessageEntity,device,rankMessageType,sendResult));
            }
        }
    }
}
