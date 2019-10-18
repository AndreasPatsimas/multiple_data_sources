package org.patsimas.multi_data_source_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(basePackages = "org.patsimas.multi_data_source_service.repositories.officialUser",
        entityManagerFactoryRef = "officialUserEntityManager",
        transactionManagerRef= "officialUserTransactionManager"
)
public class OfficialUserDataSourceConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean officialUserEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(officialUserDataSource());
        em.setPackagesToScan(
                new String[] { "org.patsimas.multi_data_source_service.domain.officialUser" });

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.hibernate.ddl-auto",
                env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("spring.jpa.properties.hibernate.dialect",
                env.getProperty("spring.jpa.properties.hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public DataSource officialUserDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("official.user.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("official.user.datasource.url"));
        dataSource.setUsername(env.getProperty("official.user.datasource.username"));
        dataSource.setPassword(env.getProperty("official.user.datasource.password"));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager officialUserTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                officialUserEntityManager().getObject());
        return transactionManager;
    }
}
