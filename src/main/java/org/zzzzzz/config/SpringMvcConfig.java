package org.zzzzzz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.zzzzzz.validator.UserValidator;

@ComponentScan({"com.zzzzzz"})
@Import(UserValidator.class)
@PropertySource("classpath:errorMessages.properties")
public class SpringMvcConfig {

}


