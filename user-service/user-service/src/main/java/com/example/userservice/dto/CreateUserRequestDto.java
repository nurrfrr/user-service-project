package com.example.userservice.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
package com.example.publicapiservice.dto;

public class CreateUserRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}