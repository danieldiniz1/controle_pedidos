package br.com.controle.pedidos;

import br.com.controle.pedidos.model.Categoria;
import br.com.controle.pedidos.model.Produto;
import br.com.controle.pedidos.service.CategoriaService;
import br.com.controle.pedidos.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProdutoService produtoService;

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria informatica = Categoria.valueOf(null, "Informática");
        LOGGER.info("hashcode informatica: " + informatica.hashCode());
        Categoria escritorio = Categoria.valueOf(null, "Escritório");
        LOGGER.info("hashcode categoria: " + informatica.hashCode());

		Produto computador = Produto.novoProduto("Computador", BigDecimal.valueOf(2000.50), Arrays.asList(informatica));
		Produto impressora = Produto.novoProduto("Impressora", BigDecimal.valueOf(800.67), Arrays.asList(escritorio,informatica));
		Produto mouse = Produto.novoProduto("Mouse", BigDecimal.valueOf(100.20), Arrays.asList(informatica));
		produtoService.salvarListaProdutos(Arrays.asList(computador,impressora,mouse));

		informatica.setProdutos(Arrays.asList(computador,impressora,mouse));
		escritorio.setProdutos(Arrays.asList(mouse));

		categoriaService.salvarListaCategorias(Arrays.asList(informatica,escritorio));
	}
}
