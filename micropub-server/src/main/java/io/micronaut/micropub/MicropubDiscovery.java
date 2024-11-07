package io.micronaut.micropub;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record MicropubDiscovery(@JsonProperty("media-endpoint") String mediaEndpoint) {
}
