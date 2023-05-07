package com.Fepe.PhoenixiaServer.club;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/club")
@CrossOrigin
public class ClubController {

    private final ClubService clubService;

    @GetMapping
    public ResponseEntity queryAllClubs() {
        List<Club> clubs = this.clubService.queryAllClubs();
        return ResponseEntity.ok().body(clubs);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findClub(@PathVariable Integer id) {
        Club club = this.clubService.findClubById(id);
        return ResponseEntity.ok().body(club);
    }

    @PostMapping
    public ResponseEntity createClub(@RequestBody ClubDto clubDto) {
        Club club = this.clubService.createClub(clubDto);
        URI createdUri = linkTo(methodOn(ClubController.class).createClub(clubDto)).slash(club).toUri();
        return ResponseEntity.created(createdUri).body(club);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClub(@PathVariable Integer id) {
        this.clubService.deleteClub(id);
        return ResponseEntity.ok().body(id);
    }
}
