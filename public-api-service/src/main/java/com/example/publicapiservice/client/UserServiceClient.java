package com.example.publicapiservice.client;
import com.example.publicapiservice.dto.UserResponseDto;
import com.example.publicapiservice.dto.CreatePublicUserRequestDto;
import com.example.publicapiservice.dto.PublicUserDto;
import java.util.List;

public interface UserServiceClient {
    PublicUserDto createUser(CreatePublicUserRequestDto request);
    List<PublicUserDto> getUsers(Integer pageNum, Integer pageSize);

    UserResponseDto getUserById(Integer userId);
}
