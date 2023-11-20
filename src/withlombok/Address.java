package withlombok;

import lombok.*;

@Data

@AllArgsConstructor

 class Address {
    private String country;
    private String city;
    private String street;
    private Integer houseNumber;
}
