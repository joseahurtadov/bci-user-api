package com.bci.technicalchalenge.pe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * |description|.<br/>
 * <b>Class</b>: SpringAsyncConfig<br/>
 * <b>Copyright</b>: &copy; 2021 Intercorp Retail.<br/>
 * <b>Company</b>: Intercorp Retail.<br/>
 *
 * @author Intercorp Retail <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>PM42722316 : Jose Hurtado</li>
 * </ul>
 * <u>Create</u>:<br/>
 * <ul>
 * <li>Jul. 09, 2021 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */
@Configuration
@EnableAsync
public class SpringAsyncConfig {

  @Bean(name = "threadPoolTaskExecutor")
  public Executor threadPoolTaskExecutor() {
    return new ThreadPoolTaskExecutor();
  }

}
