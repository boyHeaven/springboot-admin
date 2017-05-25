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
@MapperScan(basePackages = "cn.com.yxb.springboot.mapper1", sqlSessionFactoryRef = "sqlSessionFactory1")
public class MysqlDbSourceConfig1 {

    @Autowired
    @Qualifier("mySqlDbSource1")
    private DataSource mySqlDbSource1;


    @Bean
    public SqlSessionFactory sqlSessionFactory1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(mySqlDbSource1); // 使用mysql1数据源, 连接test_springboot库

        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1()); // 使用上面配置的Factory
        return template;
    }
}
