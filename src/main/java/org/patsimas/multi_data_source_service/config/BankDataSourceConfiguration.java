package org.patsimas.multi_data_source_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(
        basePackages = "org.patsimas.multi_data_source_service.repositories.bank",
        entityManagerFactoryRef = "bankEntityManager",
        transactionManagerRef = "bankTransactionManager"
)
public class BankDataSourceConfiguration {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean bankEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(bankDataSource());
        em.setPackagesToScan(
                new String[] { "org.patsimas.multi_data_source_service.domain.bank" });

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

    @Primary
    @Bean
    public DataSource bankDataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(
                env.getProperty("bank.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("bank.datasource.url"));
        dataSource.setUsername(env.getProperty("bank.datasource.username"));
        dataSource.setPassword(env.getProperty("bank.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager bankTransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                bankEntityManager().getObject());
        return transactionManager;
    }
}
