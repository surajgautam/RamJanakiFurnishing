package com.technep.ramjanaki.subscribe.service;

import com.technep.ramjanaki.subscribe.model.Subscribe;

import java.util.List;

/**
 * Created by surajgautam on 8/12/17.
 */
public interface SubscribeService {
    void saveSubscriber(Subscribe subscribe);
    List<Subscribe> getAllActiveSubscribersByEmail();
    void updateStatus(String email);
}
