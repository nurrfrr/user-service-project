package com.example.publicapiservice.dto;

public class ListingResponseDto {
    private Integer id;
    private Integer userId;
    private String listingType;
    private Integer price;
    private Long createdAt;
    private Long updatedAt;
    private PublicUserDto user;

    public Integer getId() { 
        return id; 
    }
    
    public void setId(Integer id) { 
        this.id = id; 
    }

    public Integer getUserId() { 
        return userId; 
    }
    
    public void setUserId(Integer userId) { 
        this.userId = userId; 
    }

    public String getListingType() { 
        return listingType; 
    }
    
    public void setListingType(String listingType) { 
        this.listingType = listingType; 
    }

    public Integer getPrice() { 
        return price; 
    }
    
    public void setPrice(Integer price) { 
        this.price = price; 
    }

    public Long getCreatedAt() { 
        return createdAt; 
    }
    
    public void setCreatedAt(Long createdAt) { 
        this.createdAt = createdAt; 
    }

    public Long getUpdatedAt() { 
        return updatedAt; 
    }
    
    public void setUpdatedAt(Long updatedAt) { 
        this.updatedAt = updatedAt; 
    }

    public PublicUserDto getUser() { 
        return user; 
    }
    
    public void setUser(PublicUserDto user) { 
        this.user = user; 
    }
}
