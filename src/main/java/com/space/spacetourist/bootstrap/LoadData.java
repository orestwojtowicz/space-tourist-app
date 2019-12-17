package com.space.spacetourist.bootstrap;

import com.space.spacetourist.entities.FlightEntity;
import com.space.spacetourist.entities.TouristEntity;
import com.space.spacetourist.entities.UserEntity;
import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.repository.TouristRepository;
import com.space.spacetourist.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class LoadData implements CommandLineRunner {

    private final FlightRepository flightRepository;
    private final TouristRepository touristRepository;
    private final UserRepository userRepository;


    LoadData(FlightRepository flightRepository,
             TouristRepository touristRepository,
             UserRepository userRepository) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        buildDatabase();
        createUser();
        System.out.println("DATABASE INITIALIZED SUCCESSFULLY ");

    }
    private void buildDatabase() {

        TouristEntity touristEntity1 = TouristEntity.builder()

                .firstName("Pawel")
                .lastName("Gawel")
                .gender("Male")
                .country("Poland")
                .remarsk("good")
                .birthDate(new Date())
                .build();

        TouristEntity touristEntity2 = TouristEntity.builder()

                .firstName("Damian")
                .lastName("Tramian")
                .gender("Female")
                .country("Germany")
                .remarsk("Bad")
                .birthDate(new Date())
                .build();






        FlightEntity flightEntity1 = FlightEntity.builder()
                .departureDate(new Date())
                .arrivalDate(new Date())
                .numberSeats(500)
                .ticketPrice(1500.40)
                .build();



        FlightEntity flightEntity2 = FlightEntity.builder()
                .departureDate(new Date())
                .arrivalDate(new Date())
                .numberSeats(1000)
                .ticketPrice(100.40)
                .build();


      /*  List<FlightEntity> flightEntities = new ArrayList<>();
        flightEntities.add(flightEntity1);
        flightEntities.add(flightEntity2);*/



        // touristEntity1.setFlightEntities(flightEntities);


        // flightRepository.saveAll(flightEntities);
        touristRepository.save(touristEntity1);
        touristRepository.save(touristEntity2);

        flightRepository.save(flightEntity1);
        flightRepository.save(flightEntity2);

        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        touristEntity1.addFlight(flightEntity1);
        //  touristEntity1.addFlight(flightEntity2);
        touristEntity2.addFlight(flightEntity1);
        touristEntity2.addFlight(flightEntity1);
        touristEntity2.addFlight(flightEntity1);
        touristEntity2.addFlight(flightEntity1);



        // flightEntity1.setTouristEntities(touristEntities);
        // touristEntityRepository.saveAll(touristEntities);

        touristRepository.save(touristEntity1);
        touristRepository.save(touristEntity2);

        flightRepository.save(flightEntity1);
        flightRepository.save(flightEntity2);

    }
    private void createUser() {

        UserEntity userEntity = new UserEntity(UUID.randomUUID().toString(), "damian", "damian");
        userRepository.save(userEntity);
    }
}
