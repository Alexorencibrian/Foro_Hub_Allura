package com.Allura.Foro_Hub_Allura;

import com.Allura.Foro_Hub_Allura.service.DataInitializerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ForoHubAlluraApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ForoHubAlluraApplication.class, args);
        
        DataInitializerService dataInitializerService = context.getBean(DataInitializerService.class);
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("¿Desea borrar los datos generados? (S/N)");
            String respuesta = scanner.nextLine();
            
            if (respuesta.equalsIgnoreCase("S")) {
                dataInitializerService.borrarDatos();
            }
        }));
    }
}