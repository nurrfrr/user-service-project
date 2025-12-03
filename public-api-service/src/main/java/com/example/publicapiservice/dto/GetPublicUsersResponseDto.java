package com.example.publicapiservice.dto;

import java.util.List;

public class GetPublicUsersResponseDto {
    private boolean result;
    private List<PublicUserDto> users;

    public boolean isResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }

    public List<PublicUserDto> getUsers() {
        return users;
    }
    public void setUsers(List<PublicUserDto> users) {
        this.users = users;
    }
}
