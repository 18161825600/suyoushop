package com.kxg.suyoushop.provider.dubboservice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kxg.suyoushop.constant.SuYouShopConstants;
import com.kxg.suyoushop.dto.ShopsDto;
import com.kxg.suyoushop.provider.dao.ShopsDao;
import com.kxg.suyoushop.provider.pojo.Shops;
import com.kxg.suyoushop.provider.service.ShopsService;
import com.kxg.suyoushop.request.shopsRequest.*;
import com.kxg.suyoushop.response.shopResponse.*;
import com.kxg.suyoushop.service.ShopsDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0.0")
public class ShopsDubboServiceImpl implements ShopsDubboService {

    @Autowired
    private ShopsService shopsService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public RegisterShopsResponse registerShop(RegisterShopRequest request) {
        Shops shops = new Shops();
        RegisterShopsResponse response = new RegisterShopsResponse();
        if (request.getCode().equals(stringRedisTemplate.opsForValue().get(request.getPhoneNumber()))){
            BeanUtils.copyProperties(request,shops);
            shops.setCreateTime(new Date());
            shops.setUpdateTime(new Date());
            shops.setImgUrl("aa");
            shops.setStatus((short)0);
            response.setInteger(shopsService.register(shops));
        }else {
            response.setInteger(0);
        }
        return response;
    }

    @Override
    public LoginShopsResponse loginShop(LoginShopRequest request) {
        Shops login = shopsService.login(request.getPhoneNumber(), request.getPassword());
        LoginShopsResponse response = new LoginShopsResponse();
        if(login!=null){
            ShopsDto shopsDto = new ShopsDto();
            BeanUtils.copyProperties(login,shopsDto);
            response.setShopsDto(shopsDto);
            response.setToken(token(shopsDto));
            response.setMsg(SuYouShopConstants.LOGIN_SUCCESS);
        }else {
            response.setMsg(SuYouShopConstants.PHONE_OR_PWD_NOT_RIGHT);
        }
        return response;
    }

    @Override
    public LoginShopBySmsResponse loginShopBySms(LoginShopBySmsRequest request) {
        Shops shopsByPhone = shopsService.findShopsByPhone(request.getPhoneNumber());
        LoginShopBySmsResponse response = new LoginShopBySmsResponse();
        ShopsDto shopsDto = new ShopsDto();
        if(shopsByPhone!=null){
            if(request.getCode().equals(stringRedisTemplate.opsForValue().get(request.getPhoneNumber()))){
                BeanUtils.copyProperties(shopsByPhone,shopsDto);
                response.setShopsDto(shopsDto);
                response.setMsg(SuYouShopConstants.LOGIN_SUCCESS);
                response.setToken(token(shopsDto));
            }else {
                response.setMsg(SuYouShopConstants.CODE_IS_NOT_RIGHT);
            }
        }else {
            if(request.getCode().equals(stringRedisTemplate.opsForValue().get(request.getPhoneNumber()))){
                Shops shops = new Shops();
                shops.setPhoneNumber(request.getPhoneNumber());
                shops.setCreateTime(new Date());
                shops.setUpdateTime(new Date());
                shopsService.register(shops);

                BeanUtils.copyProperties(shops,shopsDto);
                response.setShopsDto(shopsDto);
                response.setMsg(SuYouShopConstants.LOGIN_SUCCESS);
                response.setToken(token(shopsDto));
            }else {
                response.setMsg(SuYouShopConstants.CODE_IS_NOT_RIGHT);
            }
        }
        return response;
    }

    @Override
    public DeleteShopsResponse delete(DeleteShopsRequest request) {
        DeleteShopsResponse response = new DeleteShopsResponse();
        response.setInteger(shopsService.delete(request.getId()));
        return response;
    }

    @Override
    public UpdateShopNameResponse updateShopName(UpdateShopNameRequest request) {
        UpdateShopNameResponse response = new UpdateShopNameResponse();
        Shops shops = shopsService.findShopsById(request.getId());
        shops.setName(request.getName());
        shops.setUpdateTime(new Date());

        response.setInteger(shopsService.update(shops));
        return response;
    }

    @Override
    public UpdateShopImgResponse updateShopImg(UpdateShopImgRequest request) {
        UpdateShopImgResponse response = new UpdateShopImgResponse();
        Shops shops = shopsService.findShopsById(request.getId());
        shops.setImgUrl(request.getImg());
        shops.setUpdateTime(new Date());

        response.setInteger(shopsService.update(shops));
        return response;
    }

    @Override
    public UpdateShopPasswordByIdResponse updateShopPasswordById(UpdateShopPasswordByIdRequest request) {
        UpdateShopPasswordByIdResponse response = new UpdateShopPasswordByIdResponse();
        Shops shops = shopsService.findShopsById(request.getId());
        shops.setPassword(request.getPassword());
        shops.setUpdateTime(new Date());

        response.setInteger(shopsService.update(shops));
        return response;
    }

    @Override
    public UpdateShopPasswordByPhoneResponse updateShopPasswordByPhone(UpdateShopPasswordByPhoneRequest request) {
        UpdateShopPasswordByPhoneResponse response = new UpdateShopPasswordByPhoneResponse();
        Shops shops = shopsService.findShopsByPhone(request.getPhoneNumber());
        if(shops!=null){
            if(request.getCode().equals(stringRedisTemplate.opsForValue().get(request.getPhoneNumber()))){
                shops.setPassword(request.getPassword());
                shops.setUpdateTime(new Date());

                response.setInteger(shopsService.update(shops));
            }else {
                response.setMsg(SuYouShopConstants.CODE_IS_NOT_RIGHT);
            }
        }else {
            response.setMsg(SuYouShopConstants.PHONE_NUMBER_NOT_RIGHT);
        }
        return response;
    }

    @Override
    public UpdateShopResponse updateShop(UpdateShopRequest request) {
        UpdateShopResponse response = new UpdateShopResponse();
        ShopsDto shopsDto = request.getShopsDto();
        Shops shops = shopsService.findShopsById(shopsDto.getId());
        BeanUtils.copyProperties(shopsDto,shops);
        response.setInteger(shopsService.update(shops));
        return response;
    }

    @Override
    public FindShopsByIdResponse findShopsById(FindShopsByIdRequest request) {
        FindShopsByIdResponse response = new FindShopsByIdResponse();
        Shops shops = shopsService.findShopsById(request.getId());
        ShopsDto shopsDto = new ShopsDto();
        BeanUtils.copyProperties(shops,shopsDto);
        response.setShopsDto(shopsDto);
        return response;
    }

    @Override
    public FindShopByNameResponse findShopsByName(FindShopByNameRequest request) {
        FindShopByNameResponse response = new FindShopByNameResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Shops> shopsByName = shopsService.findShopsByName(request.getName());
        PageInfo<Shops> pageInfo = new PageInfo<>(shopsByName);

        List<Shops> shopsList = pageInfo.getList();
        response.setShopsDtoList(changeShopDto(shopsList));
        response.setTotal(shopsService.countShopsByName(request.getName()));
        return response;
    }

    @Override
    public FindAllShopResponse findAllShops(FindAllShopRequest request) {
        FindAllShopResponse response = new FindAllShopResponse();
        PageHelper.startPage(1,request.getPageNum()*10);
        List<Shops> allShops = shopsService.findAllShops();
        PageInfo<Shops> pageInfo = new PageInfo<>(allShops);

        List<Shops> shopsList = pageInfo.getList();
        response.setShopsDtoList(changeShopDto(shopsList));
        response.setTotal(shopsService.countAllShops());
        return response;
    }

    private String token(ShopsDto shopsDto){
        String token = UUID.randomUUID().toString()+":"+shopsDto.getPhoneNumber()+":"+shopsDto.getId()+":shop";
        stringRedisTemplate.opsForValue().set(token,shopsDto.toString(),30, TimeUnit.MINUTES);
        return token;
    }

    private List<ShopsDto> changeShopDto(List<Shops> shopsList){
        List<ShopsDto> list = new ArrayList<>();
        for (Shops shops : shopsList) {
            ShopsDto shopsDto = new ShopsDto();
            BeanUtils.copyProperties(shops,shopsDto);
            list.add(shopsDto);
        }
        return list;
    }
}
