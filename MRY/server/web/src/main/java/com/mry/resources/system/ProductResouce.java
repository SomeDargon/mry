package com.mry.resources.system;

import com.mry.entity.store.project.ProductManagement;
import com.mry.resources.BaseResource;
import com.mry.service.system.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kaik on 2017/12/5.
 */
@Controller
@RequestMapping("/app/api/product")
public class ProductResouce extends BaseResource {
    private static final Logger logger = LoggerFactory.getLogger(ProductResouce.class);

    @Resource
    private ProductService productService;

    //ProductManagement

    /**
     * 查询所有的项目
     * @param
     * @return
     */
    @RequestMapping(value = "/findAllProduct", method = RequestMethod.GET)
    public @ResponseBody
    List<ProductManagement> findAllProduct(@RequestParam(value = "id" , required = true) Long id){
        // @RequestHeader(Constants.AUTH_TOKEN_HEADER_NAME) String authToken
        return productService.findAllProduct(id);
    }
}
