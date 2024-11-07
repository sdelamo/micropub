package io.micronaut.micropub;

import io.micronaut.json.JsonMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(startApplication = false)
class MicropubDiscoveryTest {

    @Test
    void microPubDiscoverySerialization(JsonMapper jsonMapper) throws IOException {
        MicropubDiscovery discovery = new MicropubDiscovery("https://media.example.com/micropub");
        String json = jsonMapper.writeValueAsString(discovery);
        assertEquals("""
                {"media-endpoint":"https://media.example.com/micropub"}""", json);
    }
}