package com.example.publicapiservice.dto;

import java.util.List;

public class GetPublicListingsResponseDto {
    private boolean result;
    private List<ListingResponseDto> listings;

    public boolean isResult() { 
        return result; 
    }
    
    public void setResult(boolean result) { 
        this.result = result; 
    }

    public List<ListingResponseDto> getListings() { 
        return listings; 
    }
    
    public void setListings(List<ListingResponseDto> listings) { 
        this.listings = listings; 
    }
}
