package com.amiti.cloud.platform.flyway;

import com.amiti.cloud.platform.config.Profiles;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Created by ramchalasani on 11/2/16.
 */
@Profile(Profiles.FLYWAY)
@Configuration
public class FlywayDataSourceConfig {

    @FlywayDataSource
    @Primary
    @Bean(name="postgresDS")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }


}
