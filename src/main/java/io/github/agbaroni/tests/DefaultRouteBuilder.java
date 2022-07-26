package io.github.agbaroni.tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DefaultRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		var is = getClass().getResourceAsStream("/xml/msg.xml");
		var isr = new InputStreamReader(is);
		var br = new BufferedReader(isr);
		var sw = new StringWriter();

		br.transferTo(sw);

		br.close();
		isr.close();
		is.close();

		from("timer:tm1?repeatCount=1").setBody(simple(sw.toString())).to("jms:queue:pluto?connectionFactory=#paperino").to("log:test");

		from("jms:queue:pluto?connectionFactory=#paperino").to("xslt:xsl/tr1.xsl").to("log:test").to("sql:classpath:sql/test1.sql?dataSource=#pippo");
	}
}