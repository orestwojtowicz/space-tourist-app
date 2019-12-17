package com.space.spacetourist.bootstrap;

import com.space.spacetourist.entities.FlightEntity;
import com.space.spacetourist.entities.TouristEntity;
import com.space.spacetourist.repository.FlightRepository;
import com.space.spacetourist.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoadData implements CommandLineRunner {

    private final FlightRepository flightRepository;
    private final TouristRepository touristRepository;


    LoadData(FlightRepository flightRepository, TouristRepository touristRepository) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;
    }




    @Override
    public void run(String... args) throws Exception {

        buildDatabase();
        System.out.println("DATABASE INITIALIZED SUCCESSFULLY ");

    }
    private final void buildDatabase() {

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
}
