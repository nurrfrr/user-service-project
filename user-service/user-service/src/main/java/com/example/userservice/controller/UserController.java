package com.example.userservice.controller;

import com.example.userservice.dto.CreateUserRequestDto;
import com.example.userservice.dto.CreateUserResponseDto;
import com.example.userservice.dto.GetUsersRequestDto;
import com.example.userservice.dto.GetUsersResponseDto;
import com.example.userservice.dto.GetUserByIdResponseDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // GET /users
    @GetMapping("/users")
    public GetUsersResponseDto getUsers(
            @RequestParam(name = "pageNum", defaultValue = "1") @Min(1) Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") @Min(1) Integer pageSize
    ) {
        GetUsersRequestDto requestDto = new GetUsersRequestDto();
        requestDto.setPageNum(pageNum - 1);   // convert to zero-based index
        requestDto.setPageSize(pageSize);

        return userService.getUsers(requestDto);
    }

    // GET /users/{id}
    @GetMapping("/users/{id}")
    public GetUserByIdResponseDto getUserById(
            @PathVariable("id") @Min(1) Integer id
    ) {
        return userService.getUserById(id);
    }

    // POST /users
    @PostMapping("/users")
    public CreateUserResponseDto createUser(
            @Valid @RequestBody CreateUserRequestDto requestDto
    ) {
        return userService.createUser(requestDto);
    }
}
