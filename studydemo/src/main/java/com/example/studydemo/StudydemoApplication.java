package com.example.studydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudydemoApplication {

	public static void main(String[] args) {
        // 设置环境变量，解决Es的netty与Netty服务本身不兼容问题
        System.setProperty("es.set.netty.runtime.available.processors","false");
		SpringApplication.run(StudydemoApplication.class, args);
	}

}
