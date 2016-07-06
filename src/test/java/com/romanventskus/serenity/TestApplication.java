package com.romanventskus.serenity;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.romanventskus.serenity.test.User;
import com.romanventskus.serenity.test.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * Created by Roman Ventskus on 06.07.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(value = Application.class)
public class TestApplication {

    @Autowired
    private UserRepository userRepository;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(7777);

    @Test
    public void test() {
        stubFor(get(urlEqualTo("/user/get")).willReturn(aResponse().withStatus(200)));
        User user = userRepository.get(1L);
        verify(getRequestedFor(urlEqualTo("/user/get")));
    }
}
