package com.store.manager.storemanager.user.v1;

import com.store.manager.storemanager.exceptions.UserNotFoundException;
import com.store.manager.storemanager.user.UserDTO;
import com.store.manager.storemanager.user.services.GetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserControllerV1 {

    private final GetUserService getUserService;

    @GetMapping
    public UserDTO getUser(@RequestBody String email) throws UserNotFoundException {
        return getUserService.getUser(email);
    }
}
