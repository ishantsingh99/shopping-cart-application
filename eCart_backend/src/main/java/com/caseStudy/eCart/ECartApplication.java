package com.caseStudy.eCart;

import org.hibernate.SessionFactory;
//import org.omg.CORBA.Environment;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
@EnableJpaAuditing
public class ECartApplication {

	//@Autowired
	//private Environment env;
	public static void main(String[] args) {
		SpringApplication.run(ECartApplication.class, args);
	}
}


