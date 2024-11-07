package io.micronaut.micropub;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.server.util.HttpHostResolver;

@Controller(MicropubController.MICROPUB)
class MicropubController {
    public static final String MICROPUB = "/micropub";

    private final HttpHostResolver httpHostResolver;

    MicropubController(HttpHostResolver httpHostResolver) {
        this.httpHostResolver = httpHostResolver;
    }

    @Get
    MicropubDiscovery discovery(@QueryValue String q, HttpRequest<?> request) {
        String host = httpHostResolver.resolve(request);
        return new MicropubDiscovery(host + MICROPUB);
    }
}
