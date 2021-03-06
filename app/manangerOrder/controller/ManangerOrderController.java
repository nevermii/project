package com.xzsd.app.manangerOrder.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.manangerOrder.entity.ManangerOrderInfo;
import com.xzsd.app.manangerOrder.service.ManangerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Description 店长订单管理
 * @author peng
 * @time 2020-04-22
 */
@RestController
@RequestMapping("/manangerOrder")
public class ManangerOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ManangerOrderController.class);
    @Resource
    private ManangerOrderService manangerOrderService;
    /**
     * listManagerOrders 查询店长订单列表
     * @param manangerOrderInfo
     * @return AppResponse
     * @author peng
     * @Date 2020-04-22
     */
    @RequestMapping(value = "listManagerOrders")
    public AppResponse listManagerOrders(ManangerOrderInfo manangerOrderInfo){
        try{
            return manangerOrderService.listManagerOrders(manangerOrderInfo);
        }catch (Exception e){
            logger.error("查询订单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * updateManangerOrderState 修改店长订单状态
     * @param manangerOrderInfo
     * @return AppResponse
     * @author peng
     * @Date 2020-04-22
     */
    @PostMapping("updateManangerOrderState")
    public AppResponse updateManangerOrderState(ManangerOrderInfo manangerOrderInfo){
        try{
            return manangerOrderService.updateManangerOrderState(manangerOrderInfo);
        }catch (Exception e){
            logger.error("修改店长订单状态错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * listManagerOrderDeepen 查询店长订单详情
     * @param orderId
     * @return AppResponse
     * @author peng
     * @Date 2020-04-22
     */
    @RequestMapping(value = "listManagerOrderDeepen")
    public AppResponse listManagerOrderDeepen(String orderId){
        try{
            return manangerOrderService.listManagerOrderDeepen(orderId);
        }catch (Exception e){
            logger.error("查询店长订单详情异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
