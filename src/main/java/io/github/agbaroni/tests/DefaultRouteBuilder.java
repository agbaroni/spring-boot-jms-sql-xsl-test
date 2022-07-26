package io.github.agbaroni.tests;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DefaultRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:tm1?repeatCount=1").to("sql:classpath:sql/test1.sql?dataSource=#pippo").to("log:test");
	}
}