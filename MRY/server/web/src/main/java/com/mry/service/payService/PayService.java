package com.mry.service.payService;

import com.mry.alipay.util.AlipayApi;
import com.mry.entity.dao.ConfigDao;
import com.mry.entity.dao.store.CustomerDao;
import com.mry.entity.dao.store.ServiceOrdersDao;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.json.PayResult;
import com.mry.json.store.SettlementJson;
import com.mry.resources.store.ServiceOrdersResource;
import com.mry.service.BaseService;
import org.cometd.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * Created by kaik on 2017/11/2.
 */
@Service
@Transactional
public class PayService extends BaseService {

    @Resource
    private ConfigDao configDao;
    @Resource
    public CustomerDao customerDao;

    @Resource
    public ServiceOrdersDao serviceOrdersDao;
    private static final Logger logger = LoggerFactory.getLogger(ServiceOrdersResource.class);



        public PayResult buildPayRequestForm(SettlementJson data,String authToken) {
            ServiceOrders s = serviceOrdersDao.findById(data.getId());

     //       CustomerMembersEnjoy customer = customerDao.findById(data.getId());
            BigDecimal money = new BigDecimal(data.getTotaoMoney());
            String securityKey = configDao.getPaySecurityKey();
            String partner = configDao.getPayPartner();
     //       String orderNo = System.nanoTime() + "_" + customer.getId();
            String orderNo =data.getServiceOrderNumber();
            String notifyUrl = configDao.getPayNotifyUrl();
            String returnUrl = configDao.getPayReturnUrl();
            String sellerEmail = configDao.getSellerEmail();

            String result = AlipayApi.buildPayRequestResult(money, partner, securityKey, sellerEmail, orderNo, notifyUrl,
                    returnUrl, authToken);

            logger.info("Recharge Request alipy content: " + result);


            return new PayResult(orderNo, result);
        }

    public boolean processPayNotify(String out_trade_no, boolean b) {
        return false;
    }


}
