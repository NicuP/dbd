package dbd.task5.logic.config;

import dbd.task5.db.mongo.config.MongoConfig;
import dbd.task5.db.relational.config.JpaConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:53 PM
 * User: nicu
 */
@Configuration
@Import({JpaConfig.class, MongoConfig.class})
@ComponentScan(ApplicationConfig.API_COMPONENT_PACKAGE)
public class ApplicationConfig {
    public static final String API_COMPONENT_PACKAGE = "dbd.task5.logic.api";
}
