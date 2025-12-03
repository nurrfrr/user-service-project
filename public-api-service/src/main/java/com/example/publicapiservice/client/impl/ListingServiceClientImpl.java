package com.example.publicapiservice.client;

import com.example.publicapiservice.dto.CreatePublicListingRequestDto;
import com.example.publicapiservice.dto.GetListingsResponseDto;
import com.example.publicapiservice.dto.ListingResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ListingServiceClientImpl implements ListingServiceClient {

    private final RestTemplate restTemplate;

    public ListingServiceClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ListingResponseDto createListing(CreatePublicListingRequestDto request) {
        return restTemplate.postForObject(
                "http://localhost:8082/listings",
                request,
                ListingResponseDto.class
        );
    }

    @Override
    public List<ListingResponseDto> getListings(Integer pageNum, Integer pageSize, Integer userId) {

        String url = "http://localhost:8082/listings?pageNum=" + pageNum + "&pageSize=" + pageSize;

        if (userId != null) {
            url += "&userId=" + userId;
        }

        GetListingsResponseDto response = restTemplate.getForObject(
                url,
                GetListingsResponseDto.class
        );

        return response.getListings();
    }
}
