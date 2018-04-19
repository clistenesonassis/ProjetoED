/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author ller
 */
public class No{
	private int conteudo;
	private No prox;
	private No ante;
	public No(){
		this.conteudo=0;
		this.prox=null;
		this.ante=null;
	}
	public int getConteudo(){ 
		return this.conteudo;
	}
	public No getProx(){
		return this.prox;
	}
	public void setConteudo(int c){
		this.conteudo=c;
	}
	public void setProx(No p){
		this.prox=p;
	}
	public void setAnt(No a){
		this.ante=a;
	}
	public No getAnt(){
		return this.ante;
	}
}

