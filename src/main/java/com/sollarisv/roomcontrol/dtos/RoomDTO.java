package com.sollarisv.roomcontrol.dtos;

import com.sollarisv.roomcontrol.models.Room;
import lombok.Data;

@Data
public class RoomDTO {

    private String id;
    private String nameRoom;
    private String floorRoom;
    private String typeRoom;
    private Boolean stateRoom;

    public RoomDTO(){

    }

    public RoomDTO(Room obj){
        id = obj.getId();
        nameRoom = obj.getNameRoom();
        floorRoom = obj.getFloorRoom();
        typeRoom = obj.getTypeRoom();
        stateRoom = obj.getStateRoom();
    }
}
