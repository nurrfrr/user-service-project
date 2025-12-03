package com.example.publicapiservice.dto;

public class CreatePublicUserResponseDto {
    private boolean result;
    private PublicUserDto user;

    public boolean isResult() { return result; }
    public void setResult(boolean result) { this.result = result; }

    public PublicUserDto getUser() { return user; }
    public void setUser(PublicUserDto user) { this.user = user; }
}
