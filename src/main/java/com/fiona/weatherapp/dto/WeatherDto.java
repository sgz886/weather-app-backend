package com.fiona.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fiona.weatherapp.controller.ISO3166CountryCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto {

    private long id;

    @NotBlank
    private String city;

    @ISO3166CountryCode
    private String country;

    private String description;


    public WeatherDto(String city, String country, String description) {
        this.city = city;
        this.country = country;
        this.description = description;
    }
}
