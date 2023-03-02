package com.sollarisv.roomcontrol.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Document(collection="room")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String nameRoom;
    private String floorRoom;
    private String typeRoom;
    private Boolean stateRoom;
}
