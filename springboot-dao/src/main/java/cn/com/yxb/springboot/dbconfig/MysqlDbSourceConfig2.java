package cn.com.yxb.springboot.dbconfig;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created on 2017/5/25.
 *
 * @author bin
 */
@Configuration
@MapperScan(basePackages = "cn.com.yxb.springboot.mapper2", sqlSessionFactoryRef = "sqlSessionFactory2")
public class MysqlDbSourceConfig2 {

    @Autowired
    @Qualifier("mySqlDbSource2")
    private DataSource mySqlDbSource2;

    @Bean
    public SqlSessionFactory sqlSessionFactory2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(mySqlDbSource2); // 使用mysql1数据源, 连接test_springboot2库
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory2()); // 使用上面配置的Factory
        return template;
    }
}

