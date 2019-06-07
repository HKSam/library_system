package cn.edu.jxnu.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 主启动类
 */
@SpringBootApplication
@EnableCaching
@EnableScheduling
@Slf4j
public class Application {

	/**
	 * 主方法
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.debug("启动成功");
	}

}