package taxcom.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import taxcom.demo.domain.MainData;
import taxcom.demo.domain.MainDataAddition;
import taxcom.demo.service.MainService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private MainService mainService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		for (int i = 0; i < 2; i++) {
			MainData data = new MainData();
			for (int j = 0; j < 2; j++) {
				MainDataAddition addition = new MainDataAddition("parent:" + i + " position:" + j, j);
				addition.setMainData(data);
				data.getDataAdditions().add(addition);
			}
			mainService.dataSave(data);
		}
	}
}
