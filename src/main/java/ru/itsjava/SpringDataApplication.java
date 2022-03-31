package ru.itsjava;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.service.PetService;
import ru.itsjava.service.UserService;



@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(SpringDataApplication.class,args);
        UserService userService = context.getBean(UserService.class);
        userService.printAllUsers();

        PetService petService = context.getBean(PetService.class);
        petService.changePet("Dog", "Hamster");
        petService.printPet("Hamster");
    }
}
