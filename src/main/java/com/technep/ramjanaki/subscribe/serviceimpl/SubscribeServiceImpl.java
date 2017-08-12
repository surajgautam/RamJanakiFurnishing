package com.technep.ramjanaki.subscribe.serviceimpl;

import com.technep.ramjanaki.subscribe.dao.SubscribeDao;
import com.technep.ramjanaki.subscribe.model.Subscribe;
import com.technep.ramjanaki.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by surajgautam on 8/12/17.
 */
@Service@Transactional
public class SubscribeServiceImpl implements SubscribeService{

    @Autowired private SubscribeDao subscribeDao;

    public void saveSubscriber(Subscribe subscribe) {
        subscribeDao.saveSubscriber(subscribe);
    }
}
