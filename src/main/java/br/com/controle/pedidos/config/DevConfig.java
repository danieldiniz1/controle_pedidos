package br.com.controle.pedidos.config;

import br.com.controle.pedidos.service.test.DataBaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private static final Logger LOGGER = LogManager.getLogger();
    @Autowired
    private DataBaseService dataBaseService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategyDB;

    @Bean
    public Boolean instantiateDataBase(){
        if (!"create".equals(strategyDB)){
            LOGGER.info("Banco de dados já está criado e populado");
            return Boolean.FALSE;
        }
        dataBaseService.instantiateTestDataBase();
        LOGGER.info("O Banco de dados foi populado com sucesso!");
        return Boolean.TRUE;
    }
}
