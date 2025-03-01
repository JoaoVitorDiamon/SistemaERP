package com.system.SystemERP.Entity.Adress;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "\"Adress\"")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "\"IdAdress\"")
    private Integer IdAdress;

    @Column(name = "\"ZipCode\"")
    private String ZipCode;

    @Column(name = "\"Country\"")
    private String Country;

    @Column(name = "\"City\"")
    private String City;

    @Column(name = "\"Neighborhood\"")
    private String Neighborhood;

    @Column(name = "\"Street\"")
    private String Street;

    @Column(name = "\"Number\"")
    private String Number;

    @Column(name = "\"Complement\"")
    private String Complement;


    public Adress(Integer idAdress, String CEP, String country, String city, String neighborhood, String street, String number, String complement) {
        IdAdress = idAdress;
        this.ZipCode = CEP;
        Country = country;
        City = city;
        Neighborhood = neighborhood;
        Street = street;
        Number = number;
        Complement = complement;
    }
}
