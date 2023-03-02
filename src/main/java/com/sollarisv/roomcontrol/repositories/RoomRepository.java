package com.sollarisv.roomcontrol.repositories;

import com.sollarisv.roomcontrol.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

    // Busca quartos vagos
    List<Room> findByStateRoomIsFalse();

    // Busca quartos ocupados
    List<Room> findByStateRoomIsTrue();

    // Busca quartos pelo tipo digitado pelo usuário
    List<Room> findByTypeRoomContainingIgnoreCase(String text);

    // Busca quartos simples vagos
    @Query("{ $and: [ { typeRoom: { $eq: 'Quarto simples' } }, { stateRoom: { $eq: false } } ] }")
    List<Room> simpleVacantRoom();

    // Busca quartos luxo vagos
    @Query("{ $and: [ { typeRoom: { $eq: 'Quarto luxo' } }, { stateRoom: { $eq: false } } ] }")
    List<Room> luxuryVacantRoom();

}
