package com.store.manager.storemanager.user;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String name;
    private String nationalId;
    private UserType type;
    private String username;
    private String password;
    private String email;
}
