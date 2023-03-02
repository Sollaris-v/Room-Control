package com.sollarisv.roomcontrol.controllers;


import com.sollarisv.roomcontrol.controllers.util.URL;
import com.sollarisv.roomcontrol.dtos.RoomDTO;
import com.sollarisv.roomcontrol.models.Room;
import com.sollarisv.roomcontrol.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<RoomDTO> findById(@PathVariable String id){
        Room obj = roomService.findById(id);
        return ResponseEntity.ok().body(new RoomDTO(obj));
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<RoomDTO>> findAll(){
        List<Room> list = roomService.findAll();
        List<RoomDTO> listDto = list.stream().map(x -> new RoomDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody RoomDTO objDto){
        Room obj = roomService.fromDTO(objDto);
        obj = roomService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        roomService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody RoomDTO objDto, @PathVariable String id){
        Room obj = roomService.fromDTO(objDto);
        obj.setId(id);
        obj = roomService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/vacantRoom")
    public ResponseEntity<List<RoomDTO>> vacantRoom(){
        List<Room> list = roomService.vacantRoom();
        List<RoomDTO> listDto = list.stream().map(x -> new RoomDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/occupiedRoom")
    public ResponseEntity<List<RoomDTO>> occupiedRoom(){
        List<Room> list = roomService.occupiedRoom();
        List<RoomDTO> listDto = list.stream().map(x -> new RoomDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/typeRoomSearch")
    public ResponseEntity<List<RoomDTO>> findByTypeRoom(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Room> list = roomService.findByTypeRoom(text);
        List<RoomDTO> listDto = list.stream().map(x -> new RoomDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/simpleVacantRoom")
    public ResponseEntity<List<RoomDTO>> simpleVacantRoom(){
        List<Room> list = roomService.simpleVacantRoom();
        List<RoomDTO> listDto = list.stream().map(x -> new RoomDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/luxuryVacantRoom")
    public ResponseEntity<List<RoomDTO>> luxuryVacantRoom(){
        List<Room> list = roomService.luxuryVacantRoom();
        List<RoomDTO> listDto = list.stream().map(x -> new RoomDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


}
