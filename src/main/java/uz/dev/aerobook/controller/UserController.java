package uz.dev.aerobook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.dev.aerobook.dto.UserDTO;
import uz.dev.aerobook.service.template.UserService;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 16:02
 **/

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}/profile")
    public UserDTO getUserProfile(@PathVariable Long userId) {

        return userService.getUserProfile(userId);

    }

}
