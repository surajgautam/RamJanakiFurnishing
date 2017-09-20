package com.technep.ramjanaki.sales.serviceimpl;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

import com.technep.ramjanaki.sales.dao.SalesDao;
import com.technep.ramjanaki.sales.model.SalesModel;
import com.technep.ramjanaki.sales.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalesServiceImpl implements SalesService{

    @Autowired private SalesDao salesDao;

    public void saveSales(SalesModel salesModel) {

        salesDao.saveSales(salesModel);

    }
}
