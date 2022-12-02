package com.fiona.weatherapp.controller;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

// 核心代码, 执行下面class的限制
@Constraint(validatedBy = CountryCodeValidator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD, CONSTRUCTOR, PARAMETER, TYPE_USE})
public @interface ISO3166CountryCode {

    // 这几个是从@NotBlank抄的
    String message() default "Country should follow ISO 3166-1 alpha-2 standard";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
