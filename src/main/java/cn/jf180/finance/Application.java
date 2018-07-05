package cn.jf180.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
//@EnableScheduling
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx  = SpringApplication.run(Application.class, args);
		String property = ctx.getEnvironment().getProperty("server.port");
		//log.debug(property);
	}

}