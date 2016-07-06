package com.romanventskus.serenity.test;

import com.romanventskus.serenity.RestRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Roman Ventskus on 06.07.2016.
 */
@Component
public class UserRepository extends RestRepository<User> {

    public UserRepository() {
        super(User.class);
    }
}
