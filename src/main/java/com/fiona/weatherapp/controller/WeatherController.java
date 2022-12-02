package com.fiona.weatherapp.controller;

import com.fiona.weatherapp.dto.WeatherDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("weather")
@Validated
public class WeatherController {

    @Operation(summary = "get weather by city and country")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "get the correct weather information",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = WeatherDto.class))}
        ),
        @ApiResponse(
            responseCode = "400",
            description = "invalid country supplied",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "404",
            description = "weather not found",
            content = @Content
        )
    })
    //weather?city=Melbourne&country=au
    @GetMapping
    public WeatherDto getCurrentDay(@RequestParam("city") @NotBlank String city,
                                    @ISO3166CountryCode @RequestParam("country") @NotBlank String country) {
        return new WeatherDto(city, country, "getCurrentDay raining 27/11/2022");
    }

    @GetMapping("/{country}/{city}")
    public WeatherDto getWeatherForCity(@PathVariable("city") @NotBlank String city,
                                        @PathVariable("country") @NotBlank String country) {
        return new WeatherDto(city, country, "sunny 27/11/2022");
    }

    @PostMapping("new")
    public WeatherDto createWeather(@RequestBody @Valid WeatherDto weatherDto) {
        return new WeatherDto(1, weatherDto.getCity(), weatherDto.getCountry(), weatherDto.getDescription());
    }
}
