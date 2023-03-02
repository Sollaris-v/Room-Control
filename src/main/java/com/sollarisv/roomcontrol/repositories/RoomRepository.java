package com.sollarisv.roomcontrol.repositories;

import com.sollarisv.roomcontrol.models.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

}
