package config;

import model.Order;
import model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Configuration
public class JpaConfig {

    @Value("${jpa.hibernate.mysql.driver}")
    private String mysqlDriver;
    @Value("${jpa.hibernate.mysql.url}")
    private String mysqlUrl;
    @Value("${jpa.hibernate.mysql.username}")
    private String mysqlUser;
    @Value("${jpa.hibernate.mysql.password}")
    private String mysqlPassword;
    @Value("${jpa.hibernate.showSql}")
    private String hibernateShowSql;
    @Value("${jpa.hibernate.autoStrategy}")
    private String hibernateAutoStrategy;
    @Value("${jpa.hibernate.dialect}")
    private String hibernateDialect;

    @Bean
    SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", mysqlDriver);
        properties.put("hibernate.connection.url", mysqlUrl);
        properties.put("hibernate.connection.username", mysqlUser);
        properties.put("hibernate.connection.password", mysqlPassword);
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateAutoStrategy);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(properties).build();
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(Product.class);
        metadataSources.addAnnotatedClass(Order.class);
        Metadata metadata = metadataSources.buildMetadata();

        return metadata.getSessionFactoryBuilder().build();
    }
}

