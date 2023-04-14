package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class MyConfig {

    @Value("${jdbc.mysql.url}")
    private String mysqlUrl;
    @Value("${jdbc.mysql.username}")
    private String mysqlUsername;
    @Value("${jdbc.mysql.password}")
    private String mysqlPassword;
    @Value("${jdbc.mysql.driverClassName}")
    private String driverClassName;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(mysqlUrl);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(mysqlUsername);
        dataSource.setPassword(mysqlPassword);

        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
