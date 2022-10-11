package br.com.controle.pedidos.config;

import br.com.controle.pedidos.service.test.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TesteConfig {

    @Autowired
    private DataBaseService dataBaseService;

    @Bean
    public Boolean instantiateDataBase(){
        dataBaseService.instantiateTestDataBase();
        return Boolean.TRUE;
    }
}
