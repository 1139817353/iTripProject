package cn.ekgc.itrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>爱旅行-注册中心启动类</b>
 */
@EnableEurekaServer
@SpringBootApplication
public class ItripEurekaServerStarter {
	public static void main(String[] args) {
		SpringApplication.run(ItripEurekaServerStarter.class,args);
	}
}
