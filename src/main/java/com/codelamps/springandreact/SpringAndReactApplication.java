package com.codelamps.springandreact;

import com.codelamps.springandreact.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class SpringAndReactApplication {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringAndReactApplication.class, args);

    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Owner owner1 = new Owner("Andre", "Rizaldi");
            Owner owner2 = new Owner("Alice", "Briants");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            Car car = new Car("Ford", "Mustang", "Red", "ADF-111", 2017, 5_000_000, owner1);
            carRepository.save(car);

            car = new Car("Nissan", "Leaf", "Blue", "AZE-222", 2020, 10_000_000, owner2);
            carRepository.save(car);

            car = new Car("Toyota", "Fortuner", "Black", "TYS-333", 2019, 6_000_000, owner2);
            carRepository.save(car);

            // Username : user
            userRepository.save(new User("root", "$2a$10$yu14TBzZbSoJGxOrK0b2i.aqC9nwvmvK9dYgfJyesCgnqmg4bHdw6", "ROOT"));

        };
    }
}
