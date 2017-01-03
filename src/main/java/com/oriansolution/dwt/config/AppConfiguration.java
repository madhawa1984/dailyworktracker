package com.oriansolution.dwt.config;

//import com.oriansolution.dwt.dto.ApplicationProperties;
import com.oriansolution.dwt.dto.ApplicationProperties;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;
import java.util.Properties;

/**
 * Created by madhawa on 11/16/16.
 */
@Configuration
@ComponentScan("com.oriansolution")
public class AppConfiguration {
    @Autowired
    private ApplicationProperties appproperty;
    private Map<String,String> datasourceDetails; // Instance variable read only.Make sure it is stateless

    @Bean(name="dataSource")
    public BasicDataSource getDataSourse() {
        datasourceDetails = appproperty.getDatasource();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");// move the driver name to the APplicati
        dataSource.setUrl(datasourceDetails.get("connectionstring"));
        dataSource.setUsername(datasourceDetails.get("uname"));
        dataSource.setPassword(datasourceDetails.get("pwd"));
        // set connection pool size with optimized value
        return dataSource;
    }

    @Bean(name="sessionFactoryBean")
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sesfac = new LocalSessionFactoryBean();
        sesfac.setDataSource(getDataSourse());
        sesfac.setPackagesToScan(new String[] { "com.oriansolution.dwt" });
        Properties hibernateProperties = hibernateProperties();
        sesfac.setHibernateProperties(hibernateProperties);
        return sesfac;
    }


    Properties hibernateProperties() {
        Properties hibernetProps = new Properties();
        hibernetProps.setProperty("hibernate.hbm2ddl.auto", datasourceDetails.get("hibernate.hbm2ddl.auto"));
        hibernetProps.setProperty("hibernate.dialect", datasourceDetails.get("hibernate.dialect"));
        hibernetProps.setProperty("hibernate.globally_quoted_identifiers", "true");
        hibernetProps.setProperty("show_sql","true");

        //x.setProperty("hibernate.current_session_context_class","thread"); // support getCurrentSession
        /*return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", datasourceDetails.get("hibernate.hbm2ddl.auto"));
                setProperty("hibernate.dialect", datasourceDetails.get("hibernate.dialect"));
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };*/
        return hibernetProps;
    }

    // add GLOBAL Cross Origin
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }


}
