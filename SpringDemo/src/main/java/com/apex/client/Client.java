package com.apex.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.apex.server.Calc;

public class Client {
	
	Calc calc = null;

	public void performOperations() {
		int v1 = calc.add(10, 2);
		int v2 = calc.sub(10, 2);
		int v3 = calc.prod(10, 2);
		int v4 = calc.div(10, 2);
		
		System.out.println("add : " + v1);
		System.out.println("sub : " + v2);
		System.out.println("prod: " + v3);
		System.out.println("div : " + v4);
	}
	
	public static void main(String args[]) {
		Client clnt = (Client) getBeanFactory().getBean("client");	
		clnt.performOperations();
	}
	
	public Calc getCalc() {
		return calc;	
	}
	public void setCalc(Calc calc) {
		this.calc = calc;	
	}

	private static BeanFactory getBeanFactory() {	
		Resource resource = new FileSystemResource("beans.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		return beanFactory;
	}	
}
