package com.bridgelabz.address_book_app.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ContactDTO {
    @NotEmpty(message = "Fullname is required and cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]*$", message = "Fullname must start with an uppercase letter and contain only alphabets and spaces")
    private String fullname;

    @NotEmpty(message = "Address is required and cannot be empty")
    private String address;

    @NotEmpty(message = "City is required and cannot be empty")
    private String city;

    @NotEmpty(message = "State is required and cannot be empty")
    private String state;

    @NotEmpty(message = "Zipcode is required and cannot be empty")
    @Size(min = 5, max = 6, message = "Zipcode must be 5 to 6 characters long")
    private String zipcode;

    @NotEmpty(message = "Phone number is required and cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be a 10-digit number")
    private String phonenumber;
}
