package com.example.publicapiservice.service;

import com.example.publicapiservice.dto.CreatePublicUserRequestDto;
import com.example.publicapiservice.dto.CreatePublicUserResponseDto;
import com.example.publicapiservice.dto.GetPublicUsersResponseDto;

public interface PublicUserService {
    CreatePublicUserResponseDto createUser(CreatePublicUserRequestDto request);
    GetPublicUsersResponseDto getUsers(Integer pageNum, Integer pageSize);
}
