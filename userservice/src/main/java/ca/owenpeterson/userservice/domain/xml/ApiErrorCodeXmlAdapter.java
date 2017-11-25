package ca.owenpeterson.userservice.domain.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import ca.owenpeterson.userservice.error.ApiErrorCode;

public class ApiErrorCodeXmlAdapter extends XmlAdapter<XmlErrorCode, ApiErrorCode> 
{
	@Override
	public XmlErrorCode marshal(ApiErrorCode apiErrorCode) throws Exception 
	{
		return new XmlErrorCode(apiErrorCode);
	}

	@Override
	public ApiErrorCode unmarshal(XmlErrorCode xmlErrorCode) throws Exception 
	{
		throw new UnsupportedOperationException();
	}
}
