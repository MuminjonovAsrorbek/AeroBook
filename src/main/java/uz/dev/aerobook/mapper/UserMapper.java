package uz.dev.aerobook.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.dev.aerobook.dto.BookingDTO;
import uz.dev.aerobook.dto.UserDTO;
import uz.dev.aerobook.entity.Booking;
import uz.dev.aerobook.entity.User;
import uz.dev.aerobook.mapper.template.BaseMapper;
import uz.dev.aerobook.utils.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 16:06
 **/

@Component
@RequiredArgsConstructor
public class UserMapper implements BaseMapper<User, UserDTO> {

    private final BookingMapper bookingMapper;


    @Override
    public User toEntity(UserDTO dto) {
        return null;
    }

    @Override
    public UserDTO toDto(User user) {

        List<BookingDTO> bookingDTOS = CommonUtil.getOrDefault(user.getBookings(), new ArrayList<Booking>()).stream()
                .map(bookingMapper::toDto).toList();

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName(),
                user.getRole(),
                bookingDTOS
        );

    }

    @Override
    public List<UserDTO> toDto(List<User> users) {

        return users.stream().map(this::toDto).collect(Collectors.toList());

    }
}
