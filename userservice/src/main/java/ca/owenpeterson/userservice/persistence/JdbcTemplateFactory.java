package ca.owenpeterson.userservice.persistence;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateFactory {
	
	private static JdbcTemplate jdbcTemplate;
	
	private static JdbcTemplate configure() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/userservice");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setDatabaseProductName("PostgreSQL");
		
		return jdbcTemplate;
	}

	public static JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = configure();
		}
		
		return jdbcTemplate;
	}
}
