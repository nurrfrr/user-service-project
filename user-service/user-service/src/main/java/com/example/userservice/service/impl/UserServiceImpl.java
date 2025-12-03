package com.example.userservice.service.impl;

import com.example.userservice.dto.CreateUserRequestDto;
import com.example.userservice.dto.CreateUserResponseDto;
import com.example.userservice.dto.GetUserByIdResponseDto;
import com.example.userservice.dto.GetUsersRequestDto;
import com.example.userservice.dto.GetUsersResponseDto;
import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public GetUsersResponseDto getUsers(GetUsersRequestDto requestDto) {

        PageRequest pageRequest = PageRequest.of(
                requestDto.getPageNum(),
                requestDto.getPageSize()
        );

        List<User> users = userRepository.findAll(pageRequest).getContent();

        List<UserDto> userDtoList = users.stream()
                .map(this::convertUserToUserDto)
                .collect(Collectors.toList());

        GetUsersResponseDto responseDto = new GetUsersResponseDto();
        responseDto.setResult(true);   // <---- WAJIB
        responseDto.setUsers(userDtoList);

        return responseDto;
    }

    @Override
    public GetUserByIdResponseDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        GetUserByIdResponseDto responseDto = new GetUserByIdResponseDto();
        responseDto.setResult(true);

        UserDto userDto = convertUserToUserDto(user);
        responseDto.setUser(userDto);

        return responseDto;
    }


    @Override
    public CreateUserResponseDto createUser(CreateUserRequestDto requestDto) {
        User user = new User();
        user.setName(requestDto.getName());
        user.setCreatedAt(System.currentTimeMillis());
        user.setUpdatedAt(System.currentTimeMillis());

        User savedUser = userRepository.save(user);

        CreateUserResponseDto responseDto = new CreateUserResponseDto();
        responseDto.setResult(true);
        responseDto.setUser(convertUserToUserDto(savedUser));

        return responseDto;
    }



    private UserDto convertUserToUserDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
