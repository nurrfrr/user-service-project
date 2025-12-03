package com.example.publicapiservice.dto;

import java.util.List;

public class GetListingsResponseDto {
    private Boolean result;
    private List<ListingResponseDto> listings;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<ListingResponseDto> getListings() {
        return listings;
    }

    public void setListings(List<ListingResponseDto> listings) {
        this.listings = listings;
    }
}
