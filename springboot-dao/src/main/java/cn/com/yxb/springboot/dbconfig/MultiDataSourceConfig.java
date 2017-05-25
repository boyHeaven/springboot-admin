package cn.com.yxb.springboot.dbconfig;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created on 2017/5/25.
 * <p>
 * 需要配置application.properteis中对应属性的前缀
 *
 * @author bin
 */
@Configuration
public class MultiDataSourceConfig {

    /**
     * Data source 1 data source.
     *
     * @return the data source
     */
    @Bean(name = "mySqlDbSource1")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    /**
     * Data source 2 data source.
     *
     * @return the data source
     */
    @Bean(name = "mySqlDbSource2")
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().build();
    }

}
