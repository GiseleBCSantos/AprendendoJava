package br.com.ifpi.catce.brewer.config;

import br.com.ifpi.catce.brewer.service.CadastroCervejaService;
import br.com.ifpi.catce.brewer.storage.FotoStorage;
import br.com.ifpi.catce.brewer.storage.local.FotoStorageLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

    @Bean
    public FotoStorage fotoStorage(){
        return new FotoStorageLocal();
    }

}
