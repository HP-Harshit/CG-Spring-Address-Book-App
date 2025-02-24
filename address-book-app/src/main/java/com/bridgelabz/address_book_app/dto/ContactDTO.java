package com.bridgelabz.address_book_app.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class ContactDTO {
    @NotEmpty(message = "Name is required and cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Name must start with an uppercase letter and contain only alphabets")
    private String name;

    private String phoneNumber;
    private String email;
    private String address;
}
