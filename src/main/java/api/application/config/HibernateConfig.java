package api.application.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfig {
	@Autowired
	private Environment environment;

	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		return dataSource;
	};

	@Bean
	@Autowired
	public LocalSessionFactoryBean getSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
		sessionFactoryBean.setPackagesToScan("api.application.*");
		sessionFactoryBean.setHibernateProperties(properties);
		return sessionFactoryBean;
	}

//	@Autowired
//	@Bean
//	public SessionFactory getSessionFactory(LocalSessionFactoryBean sessionFactoryBean) {
//		return sessionFactoryBean.getObject();
//	}
}
