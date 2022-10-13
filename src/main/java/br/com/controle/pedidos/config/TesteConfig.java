package br.com.controle.pedidos.config;

import br.com.controle.pedidos.service.test.DataBaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DataBaseService dataBaseService;

    @Bean
    public Boolean instantiateDataBase(){
        dataBaseService.instantiateTestDataBase();
        LOGGER.info("O Banco de dados foi populado com sucesso!");
        return Boolean.TRUE;
    }
}
