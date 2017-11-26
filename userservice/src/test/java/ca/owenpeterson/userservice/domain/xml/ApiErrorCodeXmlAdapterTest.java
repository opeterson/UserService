package ca.owenpeterson.userservice.domain.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ca.owenpeterson.userservice.error.ErrorCode;

public class ApiErrorCodeXmlAdapterTest 
{
	private ApiErrorCodeXmlAdapter apiErrorCodeXmlAdapter = new ApiErrorCodeXmlAdapter();
	
	@Test
	public void testMarshal()
	{
		for (ErrorCode errorCode : ErrorCode.values())
		{
			XmlErrorCode xmlErrorCode = apiErrorCodeXmlAdapter.marshal(errorCode);
			assertNotNull(xmlErrorCode);
			assertEquals(xmlErrorCode.getCode(), errorCode.getCode());
			assertEquals(xmlErrorCode.getMessage(), errorCode.getMessage());
		}
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testUnmarshal()
	{
		XmlErrorCode xmlErrorCode = apiErrorCodeXmlAdapter.marshal(ErrorCode.EMAIL_IN_USE);
		apiErrorCodeXmlAdapter.unmarshal(xmlErrorCode);
	}
}
