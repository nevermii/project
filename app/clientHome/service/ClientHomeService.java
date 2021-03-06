package com.xzsd.app.clientHome.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientHome.dao.ClientHomeDao;
import com.xzsd.app.clientHome.entity.ClientHomeInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 客户端首页管理实现类
 * @Author peng
 * @Date 2020-03-25
 */
@Service
public class ClientHomeService {
    @Resource
    private ClientHomeDao clientHomeDao;
    /**
     * listRotationCharHome 查询首页轮播图
     * @return AppResponse
     * @Author peng
     * @Date 2020-04-13
     */
    public AppResponse listRotationCharHome(){
        List<ClientHomeInfo> clientHomeInfoList = clientHomeDao.listRotationCharHome();
        return AppResponse.success("查询成功",clientHomeInfoList);
    }

    /**
     * listHotGoods 查询热门商品
     * @return AppResponse
     * @Author peng
     * @Date 2020-04-13
     */
    public AppResponse listHotGoods(){
        String hotGoodsNum = clientHomeDao.findHotGoodsNum();
        ClientHomeInfo clientHomeInfo = new ClientHomeInfo();
        clientHomeInfo.setHotGoodsNum(Integer.parseInt(hotGoodsNum));
        List<ClientHomeInfo> clientHomeInfoList = clientHomeDao.listHotGoods(clientHomeInfo);
        return AppResponse.success("查询成功",clientHomeInfoList);
    }

}
