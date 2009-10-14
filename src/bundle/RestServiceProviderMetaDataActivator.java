package bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import service.metadata.ServiceMetaData;

import service.rest.metadata.RestServiceMetaData;

public class RestServiceProviderMetaDataActivator implements BundleActivator {

	private ServiceRegistration serviceRegistration;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Starting bundle ServiceProviderActivator...");
		
		String[] serviceInterfaces =  {  ServiceMetaData.class.getName() };
		
		RestServiceMetaData serviceMetaData = new RestServiceMetaData();
		
		serviceMetaData.add("host", "127.0.0.1");
		serviceMetaData.add("port", "8090");
		serviceMetaData.add("name", "SimpleRestService");
		
		serviceRegistration = context.registerService(serviceInterfaces, new RestServiceMetaData(), serviceMetaData.getMetadata());
		
		serviceMetaData.add("name", "SimpleRestService2");
		
		serviceRegistration = context.registerService(serviceInterfaces, new RestServiceMetaData(), serviceMetaData.getMetadata());

		
		System.out.println("Registered rest services metadata...");
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping bundle ServiceProviderActivator...");

		serviceRegistration.unregister();
	}
}
