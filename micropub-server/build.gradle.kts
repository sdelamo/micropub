plugins {
    `java-library`
    alias(libs.plugins.btn)
}
dependencies {
    annotationProcessor(mn.micronaut.inject.java)
    annotationProcessor(mn.micronaut.serde.processor)
    implementation(mn.micronaut.serde.jackson)
    implementation(mn.micronaut.http.server)
    testAnnotationProcessor(mn.micronaut.inject.java)
    testRuntimeOnly(mn.logback.classic)
    testImplementation(mn.micronaut.test.junit5)
    testImplementation(mn.micronaut.http.server.netty)
    testImplementation(mn.micronaut.http.client)
}

tasks.test {
    useJUnitPlatform()
}