package com.fiona.weatherapp.repository;

import com.fiona.weatherapp.model.Weather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findByCityAndCountry(String city, String country);

    Optional<Weather> findByCityLike(String city);

    Page<Weather> findByCountry(String country, Pageable pageable);

    List<Weather> findAllByCountry(String country);
}
