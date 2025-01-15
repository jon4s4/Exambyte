package jonas.exambyte.adapter.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataConfig {
    public DataSource configDB(){
        return DataSourceBuilder.create()
                .url("jdbc:postgresql://localhost:5432/quizze")
                .username("user")
                .password("4") //replace with environment variables username and password
                .build();
    }

}
