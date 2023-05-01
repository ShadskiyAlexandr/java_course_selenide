package helpers;

import com.github.javafaker.Faker;
import models.ShippingAddressModel;

public class RandomShippingAddress {

    static Faker faker = new Faker();

    static ShippingAddressModel shippingAddress;

    public static ShippingAddressModel getRandomAddressData() {
        return shippingAddress = ShippingAddressModel.builder()
                .emailAddress(faker.internet().emailAddress())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .company(faker.company().name())
                .street(faker.address().streetName())
                .houseNumber(faker.number().digits(3))
                .apartmentNumber(faker.number().digits(3))
                .city(faker.address().cityName())
                .postcode(faker.address().zipCode())
                .phone(faker.phoneNumber().subscriberNumber(10))
                .build();
    }
}
