package com.technep.ramjanaki.subscribe.dao;

import com.technep.ramjanaki.subscribe.model.Subscribe;

import java.util.List;

/**
 * Created by surajgautam on 8/12/17.
 */
public interface SubscribeDao {
    void saveSubscriber(Subscribe subscribe);
    List<Subscribe> getAllActiveSubscribersByEmail();
    void updateStatus(String email);

}
