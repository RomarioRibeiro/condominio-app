package com.romario.condominio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.romario.condominio.domain.Administrador;
import com.romario.condominio.domain.Bloco;
import com.romario.condominio.domain.Condominio;
import com.romario.condominio.domain.Endereco;
import com.romario.condominio.repository.AdministradorRepository;
import com.romario.condominio.repository.BlocoRepository;
import com.romario.condominio.repository.CondominioRepository;
import com.romario.condominio.repository.EnderecoRepository;

@SpringBootApplication
public class CondominioAppApplication implements CommandLineRunner {

	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private CondominioRepository condominiRepository;
	
	@Autowired
	private BlocoRepository blocoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CondominioAppApplication.class, args);
		
		
		
		
		
	
	
		
		
	}

	@Override
	public void run(String... args) throws Exception {
	
		Administrador adm = new Administrador(null, "Romario Ribeiro", "123456789");
		
		administradorRepository.saveAll(Arrays.asList(adm));
		
		Endereco end = new Endereco(null, "Rua Espanha", "357", "Apt:1", "Acacia", "12345678");
		
		enderecoRepository.saveAll(Arrays.asList(end));
		
		Condominio cond = new Condominio(null, "46614436000171", end);
		
		condominiRepository.saveAll(Arrays.asList(cond));
		
		Bloco blc = new Bloco(null, "Bloco A", cond, end);
		
		
		
		blocoRepository.saveAll(Arrays.asList(blc));
		
		
		
	}

}
