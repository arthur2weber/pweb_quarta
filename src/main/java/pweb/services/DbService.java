package pweb.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pweb.domain.Categoria;
import pweb.domain.Cidade;
import pweb.domain.Cliente;
import pweb.domain.Endereco;
import pweb.domain.Estado;
import pweb.domain.ItemPedido;
import pweb.domain.Pedido;
import pweb.domain.Produto;
import pweb.domain.enums.TipoCliente;
import pweb.repositories.CategoriaRepository;
import pweb.repositories.CidadeRepository;
import pweb.repositories.ClienteRepository;
import pweb.repositories.EnderecoRepository;
import pweb.repositories.EstadoRepository;
import pweb.repositories.ItemPedidoRepository;
import pweb.repositories.PedidoRepository;
import pweb.repositories.ProdutoRepository;

@Service
public class DbService {
	
	@Autowired
	private CategoriaRepository catRep;
	
	@Autowired
	private EstadoRepository estRep;
	
	@Autowired
	private ProdutoRepository prodRep;
	
	@Autowired
	private CidadeRepository cidRep;
	
	@Autowired
	private ClienteRepository clieRep;
	
	@Autowired
	private EnderecoRepository endRep;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Estado e1 = new Estado(null, "Paraná");
		Estado e2 = new Estado(null, "Santa Catarina");
		Estado e3 = new Estado(null, "Rio Grande do Sul");
		
		Cidade c1 = new Cidade(null, "Curitiba", e1);
		Cidade c2 = new Cidade(null, "Tubarão", e2);
		Cidade c3 = new Cidade(null, "Gravatal", e2);
		Cidade c4 = new Cidade(null, "Laguna", e2);
		Cidade c5 = new Cidade(null, "Porto Alegre", e3);
		Cidade c6 = new Cidade(null, "Guaíba", e3);
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2, c3, c4));
		e3.getCidades().addAll(Arrays.asList(c5, c6));
		
		Cliente cli1 = new Cliente(null, "Arthur", "arthur@gmail.com", "99999999", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("4444444", "5555555"));
		
		Endereco en1 = new Endereco(null, "Rua tal tal  ", "929", "Apto 123", "Dehon"     , "88705999", cli1, c2);
		Endereco en2 = new Endereco(null, "Av tal tal ", "112", "Casa"    , "Pouso Baixo", "88735999", cli1, c3);
		cli1.getEnderecos().addAll(Arrays.asList(en1, en2));
		
		estRep.saveAll(Arrays.asList(e1,e2,e3));
		cidRep.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
		clieRep.saveAll(Arrays.asList(cli1));
		endRep.saveAll(Arrays.asList(en1, en2));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		catRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRep.saveAll(Arrays.asList(p1,p2,p3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, en1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, en2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}