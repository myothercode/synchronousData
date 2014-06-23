package com.service.impl;

import com.service.LogTestService;
import org.springframework.stereotype.Service;

/**
 * Created by wula on 2014/6/23.
 */
@Service("LogTestService")
public class LogTestServiceImpl implements LogTestService {

    @Override
    public void testLog(){
        Integer.parseInt("sddd");
    }
}
