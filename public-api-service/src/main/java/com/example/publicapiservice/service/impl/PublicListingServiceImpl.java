package com.example.publicapiservice.service.impl;

import com.example.publicapiservice.client.ListingServiceClient;
import com.example.publicapiservice.client.UserServiceClient;
import com.example.publicapiservice.dto.*;
import com.example.publicapiservice.service.PublicListingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicListingServiceImpl implements PublicListingService {

    private final ListingServiceClient listingClient;
    private final UserServiceClient userClient;

    public PublicListingServiceImpl(ListingServiceClient listingClient, UserServiceClient userClient) {
        this.listingClient = listingClient;
        this.userClient = userClient;
    }

    @Override
    public GetPublicListingsResponseDto getPublicListings(Integer pageNum, Integer pageSize, Integer userId) {
        List<ListingResponseDto> listings = listingClient.getListings(pageNum, pageSize, userId);

        GetPublicListingsResponseDto response = new GetPublicListingsResponseDto();
        response.setResult(true);
        response.setListings(listings);

        return response;
    }

    @Override
    public CreatePublicListingResponseDto createListing(CreatePublicListingRequestDto request) {
        // 1. Panggil service untuk buat listing dulu
        ListingResponseDto listing = listingClient.createListing(request);

        // 2. Ambil user dari UserService via REST
        UserResponseDto userResp = userClient.getUserById(request.getUserId());

        // 3. Mapping UserResponseDto → PublicUserDto
        PublicUserDto user = new PublicUserDto();
        user.setId(userResp.getId());
        user.setName(userResp.getName());

        // 4. Set user ke listing
        listing.setUser(user);

        // 5. Buat response
        CreatePublicListingResponseDto response = new CreatePublicListingResponseDto();
        response.setListing(listing);

        return response;
    }
}
