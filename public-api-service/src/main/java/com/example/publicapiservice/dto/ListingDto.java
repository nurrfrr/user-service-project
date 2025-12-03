package com.example.publicapiservice.dto;

import lombok.Data;

@Data
public class ListingDto {
    private Integer id;
    private String title;
    private String description;
    private Integer userId;
}
