package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.UserRequest.*;
import com.kxg.suyoushop.response.TokenResponse;
import com.kxg.suyoushop.response.UserResponse.*;

public interface UserDubboService {

    LoginUserResponse login(LoginUserRequest request);

    LoginUserResponse loginBySms(LoginUserBySmsRequest request);

    UpdateUserImgResponse updateUserImg(UpdateUserImgRequest request);

    UpdateUserPasswordByPhoneResponse updateUserPasswordByPhone(UpdateUserPasswordByPhoneRequest request);

    UpdateUserPasswordByIdResponse updateUserPasswordById(UpdateUserPasswordByIdRequest request);

    UpdateUserNickNameResponse updateUserNickName(UpdateUserNickNameRequest request);

    InvestMoneyResponse investMoney(InvestMoneyRequest request);

    FindUserByIdResponse findUserById(FindUserByIdRequest request);

    DeleteUserResponse deleteUser(DeleteUserRequest request);

    FindAllUserResponse findAllUser(FindAllUserRequest request);

}
