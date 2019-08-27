package com.example.spring_step_1.componentscan;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
//@ComponentScan("com.spring_step_1") - will give compilation error
public class ComponentJDBCConnection {

	
	public ComponentJDBCConnection() {
		System.out.println("JDBC Connection");
	}
}
