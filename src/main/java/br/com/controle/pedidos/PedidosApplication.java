package br.com.controle.pedidos;

import br.com.controle.pedidos.model.*;
import br.com.controle.pedidos.model.enums.TipoCliente;
import br.com.controle.pedidos.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner {

	private static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private EnderecoService enderecoService;

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

		informatica.setProdutos(Arrays.asList(computador,impressora,mouse));
		escritorio.setProdutos(Arrays.asList(mouse));

		produtoService.salvarListaProdutos(Arrays.asList(computador,impressora,mouse));
		categoriaService.salvarListaCategorias(Arrays.asList(informatica,escritorio));

		Estado sp = Estado.valueOf("SP");
		Estado mg = Estado.valueOf("MG");

		Cidade campinas = Cidade.valueOf("Campinas", sp);
		Cidade saoPaulo = Cidade.valueOf("São Paulo", sp);
		Cidade uberlandia = Cidade.valueOf("Uberlandia", mg);

		sp.adicionarCidade(campinas);
		sp.adicionarCidade(saoPaulo);
		mg.adicionarCidade(uberlandia);

//		estadoService.salvarEstado(sp);
//		estadoService.salvarEstado(mg);

		estadoService.salvarEstados(Arrays.asList(mg,sp));
		cidadeService.salvarCidades(Arrays.asList(campinas,saoPaulo,uberlandia));

		Cliente maria = Cliente.valueOf("Maria da Silva", "maria@email.com", "123456789-80", null, TipoCliente.PESSOAFISICA);
		maria.setTelefones(Arrays.asList("19 9 9999999","11 9 888889845"));

		Cliente jose = Cliente.valueOf("jose da Silva", "jose@email.com", "987547658-80", null, TipoCliente.PESSOAFISICA);
		jose.setTelefones(Arrays.asList("19 9 88888888","11 9 777777777"));

		Cliente mariaempresa = Cliente.valueOf("empresa da maria", "empresamaria@email.com", null, "045470001-77", TipoCliente.PESSOAJURIDICA);
		mariaempresa.setTelefones(Arrays.asList("19 9 1111111","11 9 2222222222"));

		Endereco endereco_uberlandia = Endereco.valueOf("Rua flores", "300", "apto 203", "Jardim", "38220-834", maria, uberlandia);
		Endereco endereco_sp = Endereco.valueOf("Mattos", "105", "Sala 800", "centro", "38777-012", maria, saoPaulo);

		Endereco endereco_campinas = Endereco.valueOf("Rua das glicinias", "105", "portao cinza", "centro", "13050-123", jose, campinas);

		maria.setEnderecos(Arrays.asList(endereco_uberlandia,endereco_sp));

		clienteService.cadastrarCliente(maria);
		clienteService.cadastrarClientes(Arrays.asList(jose,mariaempresa));
		enderecoService.cadastrarEnderecos(Arrays.asList(endereco_uberlandia,endereco_sp,endereco_campinas));

	}
}
