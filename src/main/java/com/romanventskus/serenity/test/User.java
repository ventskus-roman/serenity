package com.romanventskus.serenity.test;

import com.romanventskus.serenity.RestEntity;

/**
 * Created by Roman Ventskus on 06.07.2016.
 */
@RestEntity(getEndpoint = "http://localhost:7777/user/get")
public class User {

    private Long id;
}
