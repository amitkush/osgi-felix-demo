package service.rest.metadata;

import java.util.Properties;

import service.metadata.ServiceMetaData;

public class RestServiceMetaData implements ServiceMetaData {

	private Properties metadata;

	public RestServiceMetaData() {
		this.metadata = new Properties();
	}
	
	public RestServiceMetaData(Properties metadata) {
		this.metadata = metadata;
	}
	

	public Properties getMetadata() {
		return metadata;
	}

	public void setMetadata(Properties metadata) {
		this.metadata = metadata;
	}
	
	public void add(String name, String value) {
		metadata.put(name, value);
	}
	
	public String get(String name) {
		return metadata.getProperty(name);
	}
	
}
