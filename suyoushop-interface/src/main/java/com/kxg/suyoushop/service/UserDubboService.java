package com.kxg.suyoushop.service;

import com.kxg.suyoushop.request.PhoneNumberCodeRequest;
import com.kxg.suyoushop.request.userRequest.*;
import com.kxg.suyoushop.response.PhoneNumberCodeResponse;
import com.kxg.suyoushop.response.userResponse.*;

public interface UserDubboService {

    RegisterResponse register(RegisterRequest request);

    LoginUserResponse login(LoginUserRequest request);

    LoginBySmsOtherResponse loginBySms(LoginUserBySmsRequest request);

    UpdateUserImgResponse updateUserImg(UpdateUserImgRequest request);

    UpdateUserPasswordByPhoneResponse updateUserPasswordByPhone(UpdateUserPasswordByPhoneRequest request);

    UpdateUserPasswordByIdResponse updateUserPasswordById(UpdateUserPasswordByIdRequest request);

    UpdateUserNickNameResponse updateUserNickName(UpdateUserNickNameRequest request);

    InvestMoneyResponse investMoney(InvestMoneyRequest request);

    FindUserByIdResponse findUserById(FindUserByIdRequest request);

    DeleteUserResponse deleteUser(DeleteUserRequest request);

    FindAllUserResponse findAllUser(FindAllUserRequest request);


}
