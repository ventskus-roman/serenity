package com.romanventskus.serenity;

import org.springframework.web.client.RestTemplate;

/**
 * Created by Roman Ventskus on 06.07.2016.
 */
public abstract class RestRepository<T> {

    private Class<T> clazz;

    public RestRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T get(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        if (!clazz.isAnnotationPresent(RestEntity.class)) {
            throw new RuntimeException("Can`t process class without RestEntity annotation");
        }
        RestEntity annotation = clazz.getDeclaredAnnotation(RestEntity.class);
        String getEndpoint = annotation.getEndpoint();
        return restTemplate.getForObject(getEndpoint, clazz);
    }
}
