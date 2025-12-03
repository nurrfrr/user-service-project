package com.example.publicapiservice.dto;

public class CreatePublicListingResponseDto {
    private ListingResponseDto listing;

    public ListingResponseDto getListing() { 
        return listing; 
    }
    
    public void setListing(ListingResponseDto listing) { 
        this.listing = listing; 
    }
}
