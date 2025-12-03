package com.example.publicapiservice.client;
import com.example.publicapiservice.dto.UserResponseDto;
import com.example.publicapiservice.dto.CreatePublicUserRequestDto;
import com.example.publicapiservice.dto.PublicUserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
public class UserServiceClientImpl implements UserServiceClient {

    private final RestTemplate restTemplate;

    public UserServiceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PublicUserDto createUser(CreatePublicUserRequestDto request) {
        return restTemplate.postForObject(
                "http://localhost:8081/users",
                request,
                PublicUserDto.class
        );
    }

    @Override
    public List<PublicUserDto> getUsers(Integer pageNum, Integer pageSize) {
        PublicUserDto[] users = restTemplate.getForObject(
                "http://localhost:8081/users?pageNum=" + pageNum + "&pageSize=" + pageSize,
                PublicUserDto[].class
        );
        return Arrays.asList(users);
    }

    @Override
    public UserResponseDto getUserById(Integer userId) {
        return restTemplate.getForObject(
                "http://localhost:8081/users/" + userId,
                UserResponseDto.class
        );
    }

}
