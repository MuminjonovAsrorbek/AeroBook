package uz.dev.aerobook.service.template;

import uz.dev.aerobook.dto.UserDTO;

/**
 * Created by: asrorbek
 * DateTime: 6/24/25 16:03
 **/

public interface UserService {

    UserDTO getUserProfile(Long userId);

}
