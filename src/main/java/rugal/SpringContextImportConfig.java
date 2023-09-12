package rugal;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:applicationContext.xml", "classpath:springmvc-servlet.xml"})
public class SpringContextImportConfig {
}
