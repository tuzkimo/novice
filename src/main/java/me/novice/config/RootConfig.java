package me.novice.config;

import me.novice.NoviceWebAppInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = {NoviceWebAppInitializer.class}, excludeFilters = {
    @ComponentScan.Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {
}
