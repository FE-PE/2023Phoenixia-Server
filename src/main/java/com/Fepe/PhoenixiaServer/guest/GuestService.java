package com.Fepe.PhoenixiaServer.guest;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Guest createGuestBook(GuestDto guestDto){
        Guest guest = modelMapper.map(guestDto, Guest.class);
        return guestRepository.save(guest);
    }

    public List<Guest> queryAllGuests(){
        return guestRepository.findAll();
    }

    public Guest findGuestById(Long id){
        return guestRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }
}
