package com.example.publicapiservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreatePublicListingRequestDto {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotNull
    private Integer userId;

    public String getTitle() { 
        return title; 
    }
    
    public void setTitle(String title) { 
        this.title = title; 
    }

    public String getDescription() { 
        return description; 
    }
    
    public void setDescription(String description) { 
        this.description = description; 
    }

    public Integer getUserId() { 
        return userId; 
    }
    
    public void setUserId(Integer userId) { 
        this.userId = userId; 
    }
}
