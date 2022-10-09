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

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PagamentoService pagamentoService;

	@Autowired
	private ItemPedidoService itemPedidoService;

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria informatica = Categoria.valueOf(null, "Informática");
        LOGGER.info("hashcode informatica: " + informatica.hashCode());
        Categoria escritorio = Categoria.valueOf(null, "Escritório");
        LOGGER.info("hashcode categoria: " + informatica.hashCode());
		Categoria cama = Categoria.valueOf(null, "Cama, Mesa e Banho");
		Categoria eletronico = Categoria.valueOf(null, "Eletrônicos");
		Categoria jardinagem = Categoria.valueOf(null, "Jarginagem");
		Categoria decoracao = Categoria.valueOf(null, "Decoração");
		Categoria perfumaria = Categoria.valueOf(null, "Perfumaria");

		Produto computador = Produto.novoProduto("Computador", BigDecimal.valueOf(2000.50), Arrays.asList(informatica));
		Produto impressora = Produto.novoProduto("Impressora", BigDecimal.valueOf(800.67), Arrays.asList(escritorio,informatica));
		Produto mouse = Produto.novoProduto("Mouse", BigDecimal.valueOf(100.20), Arrays.asList(informatica));
		Produto mesa = Produto.novoProduto("Mesa", BigDecimal.valueOf(300), Arrays.asList(informatica));
		Produto toalha = Produto.novoProduto("toalha", BigDecimal.valueOf(300), Arrays.asList(cama));
		Produto tv = Produto.novoProduto("TV", BigDecimal.valueOf(300), Arrays.asList(eletronico,informatica));

		informatica.setProdutos(Arrays.asList(computador,impressora,mouse,mesa,tv));
		escritorio.setProdutos(Arrays.asList(mouse));
		cama.setProdutos(Arrays.asList(toalha));

		produtoService.salvarListaProdutos(Arrays.asList(computador,impressora,mouse,mesa,toalha,tv));
		categoriaService.salvarListaCategorias(Arrays.asList(informatica,escritorio,cama,eletronico,jardinagem,decoracao,perfumaria));

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

		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido pedidoPrimeiro = Pedido.valueOf(
				LocalDateTime.of(2017, Month.SEPTEMBER, 30, 10, 32),
				null, maria, endereco_uberlandia);

		Pedido pedidoSegundo = Pedido.valueOf(
				LocalDateTime.of(2017, Month.SEPTEMBER, 30, 10, 32),
				null, maria, endereco_sp);

		Pagamento pagamentoCartao = PagamentoComCartao.valueOf(EstadoPagamento.PENDENTE,pedidoPrimeiro,6);
		pedidoPrimeiro.setPagamento(pagamentoCartao);

		PagamentoComBoleto pagamentoComBoleto = PagamentoComBoleto.valueOf(EstadoPagamento.PENDENTE, pedidoSegundo,
				LocalDateTime.of(2017, Month.OCTOBER, 20, 23, 59),
				null);
		pedidoSegundo.setPagamento(pagamentoComBoleto);

		maria.setPedidos(Arrays.asList(pedidoPrimeiro,pedidoSegundo));

		pedidoService.salvarPedidos(Arrays.asList(pedidoPrimeiro,pedidoSegundo));
		pagamentoService.salvarPagamentos(Arrays.asList(pagamentoCartao,pagamentoComBoleto));
		clienteService.atualizarCliente(maria);

		ItemPedido itemPedido1 = ItemPedido.valueOf(pedidoPrimeiro,computador,null,1,null);
		ItemPedido itemPedido2 = ItemPedido.valueOf(pedidoPrimeiro,mouse,null,2,null);
		ItemPedido itemPedido3 = ItemPedido.valueOf(pedidoSegundo,mouse,BigDecimal.valueOf(100),1,BigDecimal.valueOf(800));

		pedidoPrimeiro.setItens(Set.of(itemPedido1,itemPedido2));
		pedidoSegundo.setItens(Set.of(itemPedido3));

		computador.setItens(Set.of(itemPedido1));
		mouse.setItens(Set.of(itemPedido2,itemPedido3));

		itemPedidoService.cadastrarTodosItenPedido(Arrays.asList(itemPedido1,itemPedido2,itemPedido3));

	}
}
