package dbd.task5.db.relational.config;

import com.jolbox.bonecp.BoneCPDataSource;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:47 PM
 * User: nicu
 */
@Configuration
@EnableTransactionManagement
@PropertySource(JpaConfig.DATABASE_PROPERTIES_PATH)
@EnableJpaRepositories(basePackages = JpaConfig.REPOSITORY_PACKAGE,
        entityManagerFactoryRef = JpaConfig.ENTITY_MANAGER_FACTORY_BEAN_NAME)
public class JpaConfig {

    private static final String DATABASE_DRIVER = "db.driver";
    private static final String DATABASE_PASSWORD = "db.password";
    private static final String DATABASE_URL = "db.url";
    private static final String DATABASE_USERNAME = "db.username";

    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    public static final String DATABASE_PROPERTIES_PATH = "classpath:jpa.properties";
    public static final String REPOSITORY_PACKAGE = "dbd.task5.db.relational.repository";
    public static final String ENTITY_MANAGER_FACTORY_BEAN_NAME = "entityManagerFactoryBean";

    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();

        dataSource.setDriverClass(environment.getRequiredProperty(DATABASE_DRIVER));
        dataSource.setJdbcUrl(environment.getRequiredProperty(DATABASE_URL));
        dataSource.setUsername(environment.getRequiredProperty(DATABASE_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

        Properties jpaProperties = new Properties();
        jpaProperties.put(HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty(HIBERNATE_HBM2DDL_AUTO));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
}

