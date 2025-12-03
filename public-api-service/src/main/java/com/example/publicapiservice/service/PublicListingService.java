package com.example.publicapiservice.service;

import com.example.publicapiservice.dto.CreatePublicListingRequestDto;
import com.example.publicapiservice.dto.CreatePublicListingResponseDto;
import com.example.publicapiservice.dto.GetPublicListingsResponseDto;

public interface PublicListingService {
    GetPublicListingsResponseDto getPublicListings(Integer pageNum, Integer pageSize, Integer userId);
    CreatePublicListingResponseDto createListing(CreatePublicListingRequestDto request);
}
