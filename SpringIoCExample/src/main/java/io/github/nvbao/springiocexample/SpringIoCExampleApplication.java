package io.github.nvbao.springiocexample;

import io.github.nvbao.springiocexample.excercise_1.service.VehicleService;
import io.github.nvbao.springiocexample.excercise_2.service.UserServiceExcercise2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIoCExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIoCExampleApplication.class, args);

        VehicleService vehicleService = context.getBean(VehicleService.class);
        vehicleService.startBike();
        vehicleService.stopBike();
        vehicleService.startCar();
        vehicleService.stopCar();

        UserServiceExcercise2 userServiceExcercise2 = context.getBean(UserServiceExcercise2.class);
        userServiceExcercise2.getUserById(1);
        userServiceExcercise2.updateUser(2, "Alice");
    }

}
