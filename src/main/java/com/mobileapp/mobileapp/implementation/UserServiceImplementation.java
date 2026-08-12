package com.mobileapp.mobileapp.implementation;

import com.mobileapp.mobileapp.UserRepository;
import com.mobileapp.mobileapp.io.entity.UserEntity;
import com.mobileapp.mobileapp.service.UserService;
import com.mobileapp.mobileapp.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("TSET");
        userEntity.setUserId("TEST");
        userEntity.setEmailVerificationToken("TRUE");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
