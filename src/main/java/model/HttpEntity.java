package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import util.HttpRequestUtils;

public class HttpEntity {

	public HttpEntity(String method, String url) {
		this.method = method;
		this.url = url;
		this.params = new ConcurrentHashMap<>();
	}

	String method;
	String url;
	Map<String, String> params;
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getParams() {
		
		int idx = url.indexOf("?");
		
		String param = url.substring(idx+1);

		if ( param != null && !param.isEmpty() )
			params = HttpRequestUtils.parseQueryString(param);
		
		return params;
	}
	
}
