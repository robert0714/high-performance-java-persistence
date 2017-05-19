package com.vladmihalcea.book.hpjp.util.providers;

 
import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.dialect.PostgreSQL95Dialect;

import org.postgresql.ds.PGSimpleDataSource;

/**
 * @author Vlad Mihalcea
 */
public class PostgreSQLDataSourceProvider implements DataSourceProvider {
	final private static String serverName ="192.168.57.80";
	
	@Override
	public String hibernateDialect() {
		return PostgreSQL95Dialect.class.getName();
	}

	@Override
	public DataSource dataSource() {
		PGSimpleDataSource dataSource = new PGSimpleDataSource();
		dataSource.setDatabaseName( "high_performance_java_persistence" );
		dataSource.setServerName( serverName );
		dataSource.setUser( username() );
		dataSource.setPassword( password()  );
		return dataSource;
	}

	@Override
	public Class<? extends DataSource> dataSourceClassName() {
		return PGSimpleDataSource.class;
	}

	@Override
	public Properties dataSourceProperties() {
		Properties properties = new Properties();
		properties.setProperty( "databaseName", "high_performance_java_persistence" );
		properties.setProperty( "serverName", serverName );
		properties.setProperty( "user", username() );
		properties.setProperty( "password", password() );
		return properties;
	}

	@Override
	public String url() {
		return null;
	}

	@Override
	public String username() {
//		return "postgres";
		return "admin";
	}

	@Override
	public String password() {
//		return "admin";
		return "postgres";
	}

	@Override
	public Database database() {
		return Database.POSTGRESQL;
	}
}
