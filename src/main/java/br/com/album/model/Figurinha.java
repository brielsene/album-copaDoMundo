package br.com.album.model;

public class Figurinha {
	
	private String jogador, selecao;
	private int numero;
	private int id;
	
	
	public String getJogador() {
		return jogador;
	}
	public void setJogador(String jogador) {
		this.jogador = jogador;
	}
	public String getSelecao() {
		return selecao;
	}
	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean ehIgual (String jogador, int numero, String selecao) {
		if(this.jogador.equals(jogador) & this.numero == numero & this.selecao.equals(selecao)) {
			return true;
			
		}else {
			return false;
					}
		
	}
	
	

}
