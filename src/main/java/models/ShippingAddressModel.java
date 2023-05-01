package models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ShippingAddressModel {

    String emailAddress;
    String firstName;
    String lastName;
    String company;
    String street;
    String houseNumber;
    String apartmentNumber;
    String city;
    String postcode;
    String phone;
}
