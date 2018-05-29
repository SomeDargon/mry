package com.mry.resources;

import com.mry.alipay.config.AlipayConfig;
import com.mry.alipay.util.AlipayWebsiteNotify;
import com.mry.entity.dao.ConfigDao;
import com.mry.json.PayResult;
import com.mry.json.store.SettlementJson;
import com.mry.service.payService.PayService;
import com.mry.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kaik on 2017/11/16.
 */
@Controller
@RequestMapping("/app/api/pay")
public class PayResource extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(PayResource.class);

    private static final String RECEIVE_CHARSET = "ISO-8859-1";

//
//    @Resource
//    private PayService payService;
//
//    @Resource
//    private ConfigDao configDao;
//
//    @RequestMapping(value = "/pay", method = RequestMethod.POST)
//    public @ResponseBody
//    PayResult buildPayResult(
//            @RequestHeader(value = Constants.AUTH_TOKEN_HEADER_NAME, required = true) String authToken,
//            @RequestBody SettlementJson data) {
//
//        logger.info("Receive buildPayResult request, request parameter: "
//                + data.getTotaoMoney());
//
//        return payService.buildPayRequestForm(data,authToken);
//    }
//
//    @RequestMapping(value = "/notify", method = RequestMethod.POST)
//    @ResponseBody
//    public String asyncNotify(HttpServletRequest request) throws Exception {
//        Map<String, String> params = getAllParameters(request);
//
//        String out_trade_no = getParam(request, "out_trade_no");
//        String trade_no = getParam(request, "trade_no");
//        String trade_status = getParam(request, "trade_status");
//
//        logger.info("Alipay WEBSITE notify parameters, out_trade_no: " + out_trade_no + ", trade_no: " + trade_no
//                + ", trade_status: " + trade_status);
//
//        boolean result = false;
//        String partner = configDao.getPayPartner();
//        String key = configDao.getPaySecurityKey();
//        if (AlipayWebsiteNotify.verify(params, partner, key)) {
//            if (AlipayConfig.TRADE_FINISHED.equals(trade_status) || AlipayConfig.TRADE_SUCCESS.equals(trade_status)) {
//                result = payService.processPayNotify(out_trade_no, true);
//                logger.info("################### WEBSITE PAY SUCCESS. ###################");
//            } else {
//                logger.info("################### WEBSITE Pay Failure, trade_status: " + trade_status);
//            }
//        } else {
//            result = false;
//            payService.processPayNotify(out_trade_no, false);
//            logger.info("################### WEBSITE PAY FAILURE. ###################");
//        }
//        return result ? AlipayConfig.SUCCESS : AlipayConfig.FAIL;
//    }
//
//    private String getParam(HttpServletRequest request, String name) throws UnsupportedEncodingException {
//        return new String(request.getParameter(name).getBytes(RECEIVE_CHARSET), AlipayConfig.input_charset);
//    }
//
//    private Map<String, String> getAllParameters(HttpServletRequest request) {
//        Map<String, String> params = new HashMap<String, String>();
//        Map<String, String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
//            }
//            params.put(name, valueStr);
//        }
//        return params;
//    }
}
