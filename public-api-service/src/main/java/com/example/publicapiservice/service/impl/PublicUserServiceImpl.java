package com.example.publicapiservice.service.impl;

import com.example.publicapiservice.client.UserServiceClient;
import com.example.publicapiservice.dto.*;
import com.example.publicapiservice.service.PublicUserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublicUserServiceImpl implements PublicUserService {

    private final UserServiceClient userClient;

    public PublicUserServiceImpl(UserServiceClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public CreatePublicUserResponseDto createUser(CreatePublicUserRequestDto request) {
        PublicUserDto createdUser = userClient.createUser(request);
        CreatePublicUserResponseDto response = new CreatePublicUserResponseDto();
        response.setResult(createdUser != null);
        response.setUser(createdUser);
        return response;
    }

    @Override
    public GetPublicUsersResponseDto getUsers(Integer pageNum, Integer pageSize) {
        List<PublicUserDto> users = userClient.getUsers(pageNum, pageSize);
        GetPublicUsersResponseDto response = new GetPublicUsersResponseDto();
        response.setResult(true);
        response.setUsers(users);
        return response;
    }
}
