package uz.dev.aerobook.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.dev.aerobook.entity.template.AbsLongEntity;
import uz.dev.aerobook.enums.Role;

import java.util.Collection;
import java.util.List;

/**
 * Created by: asrorbek
 * DateTime: 6/23/25 17:50
 **/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@FieldNameConstants
@Table(name = "users")
public class User extends AbsLongEntity implements UserDetails {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<Booking> bookings;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
