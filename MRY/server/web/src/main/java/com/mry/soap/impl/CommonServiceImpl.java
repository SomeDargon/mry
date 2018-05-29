package com.mry.soap.impl;

import com.mry.soap.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;

/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/6/21 13:51
 */
@WebService(endpointInterface = "com.mry.soap.CommonService", serviceName = "commonService")
public class CommonServiceImpl implements CommonService {
    private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);


}
