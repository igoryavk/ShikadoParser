package parser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("parser")
public class SpringConfig {
    @Bean("dataSource")
    public DataSource getDataSource(){
        DriverManagerDataSource source=new DriverManagerDataSource();
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://localhost/mybase");
        source.setUsername("spring");
        source.setPassword("yavkin85");
       return source;
    }
}
