package com.Fepe.PhoenixiaServer.club;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {

    private final ClubRepository clubRepository;
    private final ModelMapper modelMapper;

    public Club findClubById(Integer id) {
        return clubRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    public List<Club> queryAllClubs() {
        return clubRepository.findAll();
    }

    public Club createClub(ClubDto clubDto) {
        Club club = modelMapper.map(clubDto, Club.class);
        return clubRepository.save(club);
    }

    public Integer deleteClub(Integer id) {
        clubRepository.deleteById(id);
        return id;
    }

    public Club updateClub(Integer clubId, ClubDto clubDto) {
        Club club = findClubById(clubId);
        club.setNumber(clubDto.getNumber());
        club.setName(clubDto.getName());
        club.setDescription(clubDto.getDescription());
        club.setImageUrl(clubDto.getImageUrl());

        return clubRepository.save(club);
    }


}
