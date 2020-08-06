package com.store.manager.storemanager.user.services;

import com.store.manager.storemanager.exceptions.UserNotFoundException;
import com.store.manager.storemanager.user.UserDTO;

@FunctionalInterface
public interface GetUserService {

    UserDTO getUser(String email) throws UserNotFoundException;

}
