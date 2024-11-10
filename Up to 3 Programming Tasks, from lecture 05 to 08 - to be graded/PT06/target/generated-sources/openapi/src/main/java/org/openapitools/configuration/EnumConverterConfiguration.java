package org.openapitools.configuration;

import com.dse.model.AvailabilityEnum;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class EnumConverterConfiguration {

    @Bean(name = "org.openapitools.configuration.EnumConverterConfiguration.availabilityEnumConverter")
    Converter<String, AvailabilityEnum> availabilityEnumConverter() {
        return new Converter<String, AvailabilityEnum>() {
            @Override
            public AvailabilityEnum convert(String source) {
                return AvailabilityEnum.fromValue(source);
            }
        };
    }

}
