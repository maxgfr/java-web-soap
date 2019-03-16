package main;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.frontend.ServerFactoryBean;

import service.TheWorld;
import service.TheWorldImpl;


public class Server {

	protected static void startServer() throws Exception {
		TheWorldImpl ws = new TheWorldImpl();
		ServerFactoryBean serverFactoryBean = new ServerFactoryBean();
		serverFactoryBean.setServiceClass(TheWorld.class);
		serverFactoryBean.setAddress("http://localhost:8000/theworld");
		serverFactoryBean.setServiceBean(ws);
		serverFactoryBean.setFeatures(Collections.singletonList(new LoggingFeature()));
		serverFactoryBean.create();
	}

	public static void main(String[] args) throws Exception {
		startServer();
		System.out.println("Server is ready...");
		shutdownServer(10);
	}

	protected static void shutdownServer(int durationInMinutes) throws InterruptedException {
		System.out.println("Server will be shut down in 10 minutes!");
		Thread.sleep(TimeUnit.MINUTES.toMillis(durationInMinutes));
		System.out.println("Server is existing");
		System.exit(0);
	}

}
