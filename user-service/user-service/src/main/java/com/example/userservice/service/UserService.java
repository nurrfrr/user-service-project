package com.example.userservice.service;

import com.example.userservice.dto.CreateUserRequestDto;
import com.example.userservice.dto.CreateUserResponseDto;
import com.example.userservice.dto.GetUsersResponseDto;
import com.example.userservice.dto.GetUsersRequestDto;
import com.example.userservice.dto.GetUserByIdResponseDto;

public interface UserService {
    // GET/users
    GetUsersResponseDto getUsers(GetUsersRequestDto requestDto);

    // GET/users by their id
    GetUserByIdResponseDto getUserById(Integer id);

    // POST /users
    CreateUserResponseDto createUser(CreateUserRequestDto requestDto);
}