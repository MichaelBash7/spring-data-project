package ru.itsjava;


import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;
import ru.itsjava.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


import java.sql.SQLException;


@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringDataApplication.class,args);

        PetRepository petRepository = context.getBean(PetRepository.class);
        System.out.println("petRepository.getById() = " + petRepository.getById(1L));

        Pet pet = new Pet(0L, "Parrot");
        petRepository.save(pet);
        System.out.println("petRepository.getById(3L) = " + petRepository.getById(3L));

        Pet pet3 = petRepository.getById(3L);
        pet3.setSpecies("PARROT");
        petRepository.save(pet3);
        System.out.println("genreRepository.getById(3L) = " + petRepository.getById(3L));

        petRepository.deleteById(3L);
        System.out.println("genreRepository.findById(3L).isPresent() = " + petRepository.findById(3L).isPresent());

        UserRepository userRepository = context.getBean(UserRepository.class);
        System.out.println(userRepository.findAll());

        System.out.println("petRepository.getBySpecies(\"PARROT\").isPresent() = " + petRepository.getBySpecies("PARROT").isPresent());

        System.out.println("userRepository.findUserByNameAndPet(\"Misha\", petRepository.getById(1L)).isPresent() = " +
                userRepository.findUserByNameAndPet("Misha", petRepository.getById(1L)).isPresent());


    }
}
