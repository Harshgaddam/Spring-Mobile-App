package com.mobileapp.mobileapp.implementation;

import com.mobileapp.mobileapp.UserRepository;
import com.mobileapp.mobileapp.io.entity.UserEntity;
import com.mobileapp.mobileapp.service.UserService;
import com.mobileapp.mobileapp.shared.dto.UserDto;
import com.mobileapp.mobileapp.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Record already exists!");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setEncryptedPassword(publicUserId);
        userEntity.setUserId("TEST");

        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
