package com.cryptal.ark.arkcreditservice.push.service;

import com.cryptal.ark.arkcreditservice.push.domain.PushRecord;

public interface PushRecordService {

    /**
     *
     * @param pushRecord
     */
    void insert(PushRecord pushRecord);
}
