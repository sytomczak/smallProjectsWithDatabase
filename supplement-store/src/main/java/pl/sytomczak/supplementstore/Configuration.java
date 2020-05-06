package pl.sytomczak.supplementstore;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("pl.sytomczak.supplementstore")
@EntityScan("pl.sytomczak.supplementstore")
public class Configuration {
}
