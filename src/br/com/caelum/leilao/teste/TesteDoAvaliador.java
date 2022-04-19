package br.com.caelum.leilao.teste;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import junit.framework.Assert;

public class TesteDoAvaliador {
	
	@Test
	public  void deveEntenderLancesEmOrdemCrescente() {
		
		// parte 1: cenario
		Usuario gesiel = new Usuario("Gesiel");
		Usuario daniel = new Usuario("Daniel");
		Usuario emanuela = new Usuario("Emanuela");
		
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(gesiel, 250.0));
		leilao.propoe(new Lance(daniel, 300.0));
		leilao.propoe(new Lance(emanuela, 400.0));
		
		// parte 2: ação
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//parte 3: Validação
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		
		Assert.assertEquals(menorEsperado,leiloeiro.getMenorLance(), 0.00001);
	}

}
