package pl.sytomczak.library2;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
@ComponentScan("pl.sytomczak.library2")
@EntityScan("pl.sytomczak.library2")
public class Configuration {

}
