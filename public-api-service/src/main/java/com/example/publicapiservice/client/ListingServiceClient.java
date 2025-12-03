package com.example.publicapiservice.client;

import com.example.publicapiservice.dto.CreatePublicListingRequestDto;
import com.example.publicapiservice.dto.ListingResponseDto;

import java.util.List;

public interface ListingServiceClient {

    ListingResponseDto createListing(CreatePublicListingRequestDto request);

    List<ListingResponseDto> getListings(Integer pageNum, Integer pageSize, Integer userId);
}
