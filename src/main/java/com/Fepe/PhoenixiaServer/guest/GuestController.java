package com.Fepe.PhoenixiaServer.guest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/guest")
@CrossOrigin
public class GuestController {
    private final GuestService guestService;

    @GetMapping
    public ResponseEntity queryAllGuests(){
        List<Guest> guests = guestService.queryAllGuests();
        return ResponseEntity.ok().body(guests);
    }

    @PostMapping
    public  ResponseEntity createGuestBook(@RequestBody GuestDto guestDto){
        Guest guest = guestService.createGuestBook(guestDto);
        URI createdUri = linkTo(methodOn(GuestController.class).createGuestBook(guestDto)).slash(guest).toUri();

        return ResponseEntity.created(createdUri).body(guest);
    }
}
