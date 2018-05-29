package com.mry.soap;

import javax.jws.WebService;

/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/6/21 13:30
 */
@WebService
public interface LKangService {
    String funMain(String xmlString);
}
