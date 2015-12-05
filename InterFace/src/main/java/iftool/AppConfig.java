/**
 * 
 */
package iftool;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;

/**
 * @author MIT
 *
 */
@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties; // (1)
    DataSource dataSource;

    @Bean
    DataSource realDataSource() {
        // (2)
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.dataSourceProperties.getClassLoader()).url(this.dataSourceProperties.getUrl()).username(this.dataSourceProperties.getUsername()).password(this.dataSourceProperties.getPassword());
        this.dataSource = factory.build();
        return this.dataSource;
    }

    @Primary
    @Bean
    DataSource dataSource() {
        return new Log4jdbcProxyDataSource(this.dataSource);
    }
}