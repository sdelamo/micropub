package io.micronaut.micropub;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.BlockingHttpClient;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MicropubControllerTest {

    @Inject
    EmbeddedServer embeddedServer;

    @Test
    void configuration(@Client("/")HttpClient httpClient) {
        BlockingHttpClient client = httpClient.toBlocking();
        URI uri = UriBuilder.of("/micropub")
                .queryParam("q", "config")
                .build();
        HttpResponse<MicropubDiscovery> response = assertDoesNotThrow(() ->
                client.exchange(HttpRequest.GET(uri), MicropubDiscovery.class));
        assertEquals(HttpStatus.OK, response.status());
        MicropubDiscovery discovery = response.body();
        assertNotNull(discovery);
        assertEquals(embeddedServer.getURI() + "/micropub", discovery.mediaEndpoint());
    }

}