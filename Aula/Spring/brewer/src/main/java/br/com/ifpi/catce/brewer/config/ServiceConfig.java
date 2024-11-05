package br.com.ifpi.catce.brewer.config;

import br.com.ifpi.catce.brewer.service.CadastroCervejaService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

}
