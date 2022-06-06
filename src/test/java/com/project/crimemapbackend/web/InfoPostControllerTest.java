package com.project.crimemapbackend.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class) // junit 5
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InfoPostControllerTest {
    @Autowired
    private TestRestTemplate testrestTemplate;

    @Test
    public void Test() {
        String body = this.testrestTemplate.getForObject("/", String.class);
        assertThat(body).contains("main page");

    }
}
