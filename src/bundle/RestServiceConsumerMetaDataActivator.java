package bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

import service.metadata.ServiceMetaData;

public class RestServiceConsumerMetaDataActivator implements BundleActivator, ServiceListener {

	private ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		
		System.out.println("Starting bundle ServiceConsumerActivator...");

		String filter = "(name=SimpleRestService)";
		serviceReference = lookupMetaData(context, filter);
		printServiceInfo(context, serviceReference);
		
		filter = "(name=SimpleRestService2)";
		printServiceInfo(context, serviceReference);
	}

	private ServiceReference lookupMetaData(BundleContext context, String filter) throws Exception {
		ServiceReference[] serviceReferences = context.getServiceReferences(ServiceMetaData.class.getName(), filter);
		
		if (serviceReferences != null && serviceReferences.length>0) {
			return serviceReferences[0];
		}
		return null;
	}
	
	private void printServiceInfo(BundleContext context, ServiceReference serviceReference) {
		if (serviceReference != null) {			
			Object restService = context.getService(serviceReference);
			if (restService != null) {
				System.out.println(restService.getClass().getName());
			}
			// service.providers.rest.SimpleRestService srs = (service.providers.rest.SimpleRestService)restService;
		}
	}
	
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Stopping bundle ServiceConsumerActivator...");
		
		if (serviceReference != null) {
			context.ungetService(serviceReference);
		}
	}

	public void serviceChanged(ServiceEvent context) {
		
	}

}
