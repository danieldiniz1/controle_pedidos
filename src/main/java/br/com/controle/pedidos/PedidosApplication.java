package br.com.controle.pedidos;

import br.com.controle.pedidos.model.*;
import br.com.controle.pedidos.model.enums.EstadoPagamento;
import br.com.controle.pedidos.model.enums.TipoCliente;
import br.com.controle.pedidos.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
