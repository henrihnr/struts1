package app.util;

import java.sql.Connection;

import javax.sql.DataSource;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseTableGenerator {

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		DataSource dataSource = (DataSource)ctx.getBean("dataSource");
		
		Configuration cfg = new AnnotationConfiguration()
			.configure("hibernate.cfg.xml");
		
		Connection con = dataSource.getConnection();
		
		new SchemaExport(cfg, con).create(true, true);
		
		con.close();
		ctx.registerShutdownHook();
	}
}
