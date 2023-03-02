package com.sollarisv.roomcontrol.services;

import com.sollarisv.roomcontrol.dtos.RoomDTO;
import com.sollarisv.roomcontrol.models.Room;
import com.sollarisv.roomcontrol.repositories.RoomRepository;
import com.sollarisv.roomcontrol.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room create(Room room) {
        return roomRepository.insert(room);
    }

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public Room findById(String id){
        Optional<Room> obj = roomRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public Room update(Room obj){
        Room newObj = findById(obj.getId());
        updateData(newObj, obj);
        return roomRepository.save(newObj);
    }

    public void delete(String id) {
        findById(id);
        roomRepository.deleteById(id);
    }

    public List<Room> vacantRoom(){
        return roomRepository.findByStateRoomIsFalse();
    }

    public List<Room> occupiedRoom(){
        return roomRepository.findByStateRoomIsTrue();
    }

    public List<Room> findByTypeRoom(String text){
        return roomRepository.findByTypeRoomContainingIgnoreCase(text);
    }

    public List<Room> simpleVacantRoom(){
        return roomRepository.simpleVacantRoom();
    }

    public List<Room> luxuryVacantRoom(){
        return roomRepository.luxuryVacantRoom();
    }







    private void updateData(Room newObj, Room obj) {
        newObj.setNameRoom(obj.getNameRoom());
        newObj.setTypeRoom(obj.getTypeRoom());
        newObj.setFloorRoom(obj.getFloorRoom());
        newObj.setStateRoom(obj.getStateRoom());
    }

    public Room fromDTO(RoomDTO objDto) {
        return new Room(objDto.getId(), objDto.getNameRoom(), objDto.getFloorRoom(), objDto.getTypeRoom(), objDto.getStateRoom());
    }
}
