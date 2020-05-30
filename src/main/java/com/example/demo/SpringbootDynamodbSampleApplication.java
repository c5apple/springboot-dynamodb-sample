package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.repositories.SpringUserRepository;

@SpringBootApplication
public class SpringbootDynamodbSampleApplication {

	@Autowired
	private SpringUserRepository repository;

	public static void main(String[] args) {
		//		SpringApplication.run(SpringbootDynamodbSampleApplication.class, args);

		try (ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootDynamodbSampleApplication.class,
				args)) {
			SpringbootDynamodbSampleApplication app = ctx.getBean(SpringbootDynamodbSampleApplication.class);
			app.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println("処理開始");

		SpringUser taro = new SpringUser("taro", "yamada");
		repository.save(taro);

		SpringUser jiro = new SpringUser("jiro", "yamada");
		repository.save(jiro);

		SpringUser saburo = new SpringUser("saburo", "yamada");
		repository.save(saburo);

		SpringUser takeshi = new SpringUser("takeshi", "suzuki");
		repository.save(takeshi);

		List<SpringUser> result = repository.findByLastName("yamada");
		for (SpringUser user : result) {
			System.out.println(user.getFirstName() + " " + user.getLastName());
		}

		jiro.setLastName("tanaka");
		repository.save(jiro);

		repository.delete(saburo);

		System.out.println("処理終了");
	}
}
