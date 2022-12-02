package com.fiona.weatherapp.repository;

// import static org.assertj.core.api.Assertions.assertThat; 这2个assertThat都可以
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fiona.weatherapp.model.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.OffsetDateTime;
import java.util.List;

@SpringBootTest
class WeatherRepositoryTest {

    @Autowired
    private WeatherRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    public void testWeatherRepositoryFunctions() {
        OffsetDateTime now = OffsetDateTime.now();
        Weather sydWeather = Weather.builder().city("Sydney").country("AU").description("Cloudy").updatedTime(now).build();
        Weather melWeather = Weather.builder().city("Melbourne").country("AU").description("Sunny").updatedTime(now).build();
        repository.saveAll(List.of(sydWeather, melWeather));

        assertEquals(2, repository.count());
        assertThat(repository.findByCityAndCountry("Melbourne","AU").get())
            .usingRecursiveComparison().ignoringAllOverriddenEquals().isEqualTo(melWeather);
        repository.deleteAll();
        assertEquals(0,repository.count());
    }
}