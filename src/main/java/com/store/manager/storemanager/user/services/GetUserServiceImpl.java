package com.store.manager.storemanager.user.services;

import com.store.manager.storemanager.exceptions.UserNotFoundException;
import com.store.manager.storemanager.user.User;
import com.store.manager.storemanager.user.UserDTO;
import com.store.manager.storemanager.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserServiceImpl implements GetUserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUser(String email) throws UserNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nationalId(user.getNationalId())
                .name(user.getName())
                .type(user.getType())
                .username(user.getUsername())
                .build();
    }
}
