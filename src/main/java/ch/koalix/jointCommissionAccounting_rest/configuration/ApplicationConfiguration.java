package ch.koalix.jointCommissionAccounting_rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Date: 05.12.2016
 * Author: Simon Riedener
 */

@Configuration
@PropertySource("classpath:accounting.properties")
@Import(DatasourceConfiguration.class)
public class ApplicationConfiguration {

    /**
     * Configuration for PropertySourcePlaceholderConfigurer.
     * This configuration serves the handling for application properties.
     * @return {PropertySourcePlaceholderConfigurer}.
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
