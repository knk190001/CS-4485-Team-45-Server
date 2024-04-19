package edu.utdallas.cs4485.team45.server;

import ch.qos.logback.classic.Logger;
import edu.utdallas.cs4485.team45.server.components.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class MainConfig {
    Log logger = LogFactory.getLog(MainConfig.class);
    @Bean
    public IDatabase createDatabase() {
        Environment environment = new Environment();
        logger.info(environment.toString());
        if (environment.isValid()) {
            try {
                return new Database(new DatabaseConnectionManager(environment));
            } catch (SQLException e) {
                logger.error("Failed to initialize database connection");
                logger.error("Falling back to dummy database");
            }
        } else {
            logger.info("Environment does not contain one or more DB related variables, falling back to dummy database.");
        }
        return new FakeDatabase();
    }
}
