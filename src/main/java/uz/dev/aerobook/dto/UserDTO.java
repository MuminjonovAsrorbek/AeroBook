package uz.dev.aerobook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.dev.aerobook.enums.Role;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link uz.dev.aerobook.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private Role role;
    private List<BookingDTO> bookings;
}