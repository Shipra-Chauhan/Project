package com.example.spring_step_1.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class XmlPersonDAO {

	@Autowired
	XmlJDBCConnection xmlJdbcConnection;

	public XmlJDBCConnection getXmlJdbcConnection() {
		return xmlJdbcConnection;
	}

	public void setXmlJdbcConnection(XmlJDBCConnection xmlJdbcConnection) {
		this.xmlJdbcConnection = xmlJdbcConnection;
	}
}
