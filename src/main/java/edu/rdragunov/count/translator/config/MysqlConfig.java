package edu.rdragunov.count.translator.config;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by roman.dragunov on 09-06-02016.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("edu.rdragunov.count.translator")
@ComponentScan("edu.rdragunov.count.translator")
@EntityScan("edu.rdragunov.count.translator.entities")
public class MysqlConfig {

  public static Logger LOGGER= LoggerFactory.getLogger(MysqlConfig.class);

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://localhost:3306/translator");
    dataSource.setUsername("root");
    dataSource.setPassword("1234");
    return dataSource;
  }

  @Bean
  public Map<String, String> getHibernateProperties() {
    Map<String, String> properties = new HashMap<>();
    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//    properties.put("hibernate.hbm2ddl.auto", "create-drop");
    properties.put("hibernate.show_sql", "true");
    return properties;
  }

  @Autowired
  @Bean(name = "sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource) {
    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    sessionBuilder.scanPackages("com.rdragunov.count.translator");
    Properties properties = new Properties();
    properties.putAll(getHibernateProperties());
    sessionBuilder.addProperties(properties);
    return sessionBuilder.buildSessionFactory();
  }

  @Bean
  public PlatformTransactionManager transactionManager(){
    return new JpaTransactionManager();
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @Bean
  public JpaVendorAdapter getJpaVendorAdapter() {
    JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//    LOGGER.error("jpaVendorAdapter {}", jpaVendorAdapter);
    return jpaVendorAdapter;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(getDataSource());
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan("com.rdragunov.count.translator");
    Properties properties = new Properties();
    properties.putAll(getHibernateProperties());
    entityManagerFactoryBean.setJpaProperties(properties);
    return entityManagerFactoryBean;
  }
}
