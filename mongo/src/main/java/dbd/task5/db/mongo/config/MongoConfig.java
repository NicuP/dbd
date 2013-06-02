package dbd.task5.db.mongo.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Date: 5/28/13
 * Time: 8:11 PM
 * User: nicu
 */
@Configuration
@EnableMongoRepositories(basePackages = MongoConfig.REPOSITORY_PACKAGE)
@PropertySource(MongoConfig.MONGO_PROPERTIES_PATH)
public class MongoConfig extends AbstractMongoConfiguration {
    public static final String MONGO_PROPERTIES_PATH = "classpath:mongo.properties";
    public static final String REPOSITORY_PACKAGE = "dbd.task5.db.mongo.repository";

    private static final String DATABASE_NAME = "database.name";
    private static final String DATABASE_HOST = "database.host";

    @Resource
    private Environment environment;

    @Override
    public String getDatabaseName() {
        return environment.getRequiredProperty(DATABASE_NAME);
    }

    @Override
    public Mongo mongo() throws Exception {
        String hostName = environment.getRequiredProperty(DATABASE_HOST);
        MongoClient mongoClient = new MongoClient(hostName);
        mongoClient.setWriteConcern(WriteConcern.SAFE);
        return mongoClient;
    }
}
