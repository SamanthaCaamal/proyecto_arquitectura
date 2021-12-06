package mx.uady.sicei.config;
/**
 * Una clase para la configuración de la seguridad web
 * @author Samantha Caamal, Montserrat Bustamante 
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*").allowCredentials(true);
    }

}