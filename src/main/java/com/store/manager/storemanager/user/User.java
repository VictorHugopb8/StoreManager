package com.store.manager.storemanager.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String nationalId;
    private UserType type;
    private String username;
    private String password;

    @Override
    public String toString() {
        return String.format(
                "User[" +
                        "id=%d, " +
                        "name=%s, " +
                        "nationalId=%s, " +
                        "type=%s" +
                        "username=%s, " +
                        "password=%s" +
                        "]",
                this.id,
                this.getName(),
                this.getNationalId(),
                this.getType(),
                this.getUsername(),
                this.getPassword());
    }

}
