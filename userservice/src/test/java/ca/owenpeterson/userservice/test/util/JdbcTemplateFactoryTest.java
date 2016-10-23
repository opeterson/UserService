package ca.owenpeterson.userservice.test.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import ca.owenpeterson.userservice.persistence.JdbcTemplateFactory;

public class JdbcTemplateFactoryTest {
	
	@Test
	public void testGetJdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate();
		assertNotNull("JdbcTemplate should not be null! Did you create the database? is it running?", jdbcTemplate);
	}
}
