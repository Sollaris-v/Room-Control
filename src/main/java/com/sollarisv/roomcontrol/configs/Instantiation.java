package com.sollarisv.roomcontrol.configs;


import com.sollarisv.roomcontrol.models.Room;
import com.sollarisv.roomcontrol.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void  run(String... arg0) throws Exception {

        roomRepository.deleteAll();

        Room quarto1 = new Room(null, "1001", "Primeiro andar", "Quarto simples", true);
        Room quarto2 = new Room(null, "1002", "Primeiro andar", "Quarto simples", false);
        Room quarto3 = new Room(null, "2001", "Segundo andar", "Quarto luxo", false);
        Room quarto4 = new Room(null, "2002", "Segundo andar", "Quarto luxo", true);

        roomRepository.saveAll(Arrays.asList(quarto1, quarto2, quarto3, quarto4));


    }

}
