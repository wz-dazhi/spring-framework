package com.webflux.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @projectName: spring
 * @package: com.webflux.test
 * @className: WebFluxConfiguration
 * @description:
 * @author: zhi
 * @date: 2022/1/14
 * @version: 1.0
 */
@Configuration
@EnableWebFlux
@ComponentScan
public class WebFluxConfiguration implements WebFluxConfigurer {

	@Override
	public void configureHttpMessageCodecs(ServerCodecConfigurer configurer) {
		ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
		ServerCodecConfigurer.ServerDefaultCodecs defaultCodecs = configurer.defaultCodecs();
		defaultCodecs.jackson2JsonDecoder(new Jackson2JsonDecoder(objectMapper));
		defaultCodecs.jackson2JsonEncoder(new Jackson2JsonEncoder(objectMapper));
	}

}
