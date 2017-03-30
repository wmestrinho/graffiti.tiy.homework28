package graffiti.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by WagnerMestrinho on 3/3/17.
 */
@Configuration
public class FileConfigurator extends WebMvcConfigurerAdapter{
    @Value("${upload.location}")
    private String uploadLocation;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/fullOfPictures/**")
                .addResourceLocations("file:"+uploadLocation);
    }
}
