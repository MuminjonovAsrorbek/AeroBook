package uz.dev.aerobook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.dev.aerobook.dto.UserDTO;
import uz.dev.aerobook.entity.User;
import uz.dev.aerobook.exceptions.EntityNotFoundException;
import uz.dev.aerobook.mapper.UserMapper;
import uz.dev.aerobook.repository.UserRepository;
import uz.dev.aerobook.service.template.UserService;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 16:03
 **/

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserDTO getUserProfile(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId, HttpStatus.NOT_FOUND));

        return userMapper.toDto(user);
    }
}
