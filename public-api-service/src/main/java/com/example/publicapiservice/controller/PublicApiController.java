package com.example.publicapiservice.controller;

import com.example.publicapiservice.dto.CreatePublicListingRequestDto;
import com.example.publicapiservice.dto.CreatePublicListingResponseDto;
import com.example.publicapiservice.dto.CreatePublicUserRequestDto;
import com.example.publicapiservice.dto.CreatePublicUserResponseDto;
import com.example.publicapiservice.dto.GetPublicListingsResponseDto;
import com.example.publicapiservice.dto.GetPublicUsersResponseDto;
import com.example.publicapiservice.service.PublicListingService;
import com.example.publicapiservice.service.PublicUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public-api")
@Validated
public class PublicApiController {

    private final PublicListingService listingService;
    private final PublicUserService userService;

    public PublicApiController(PublicListingService listingService, PublicUserService userService) {
        this.listingService = listingService;
        this.userService = userService;
    }

    // GET /public-api/listings
    @GetMapping("/listings")
    public GetPublicListingsResponseDto getListings(
            @RequestParam(name = "pageNum", defaultValue = "1") @Min(1) Integer pageNum,
            @RequestParam(name = "pageSize", defaultValue = "10") @Min(1) Integer pageSize,
            @RequestParam(name = "userId", required = false) Integer userId
    ) {
        return listingService.getPublicListings(pageNum, pageSize, userId);
    }

    // POST /public-api/users
    @PostMapping("/users")
    public CreatePublicUserResponseDto createUser(
            @Valid @RequestBody CreatePublicUserRequestDto request
    ) {
        return userService.createUser(request);
    }

    @GetMapping("/users")
    public GetPublicUsersResponseDto getUsers(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        return userService.getUsers(pageNum, pageSize);
    }


    // POST /public-api/listings
    @PostMapping("/listings")
    public CreatePublicListingResponseDto createListing(
            @Valid @RequestBody CreatePublicListingRequestDto request
    ) {
        return listingService.createListing(request);
    }
}
