/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LSE;

/**
 *
 * @author hellder
 */
public class LSE {
	private No cabeca;
	private int nElementos;
        
        /**
         * Metodo construtor.
         */
	public LSE(){
		cabeca = null;
		nElementos = 0;
	}
        
        /**
         * verifica se a lista está vazia.
         * @return 
         */
	public boolean vazia() {
	    if (nElementos == 0)
	        return true;
	    else
	        return false;
	}
        
        /**
         * retorna o tamanho da lista.
         * @return 
         */
	public int tamanho() {
		No aux = cabeca;
		int cont = 0;
		while(aux != null){
			aux = aux.getProx();
			cont++;
		}
		return cont;
	}
        
        /**
         * Busca o Elemento pela posição na lista.
         * @param pos
         * @return 
         */
	public int elemento (int pos) {
	    if (vazia()) {
	        return -1;
	    }

	    if ((pos < 1) || (pos > tamanho())){
	        return -1;
	    }
	    No aux = cabeca;
	    for (int i = 1; i < pos; i++){ 
	        aux = aux.getProx();
	    }

	    return aux.getConteudo();
	}
        
        /**
         * retorna a posição de determinando elemento.
         * @param dado
         * @return 
         */
	public int posicao (int dado) {
	    int cont = 1;
	    No aux;
	    if (vazia()) {
	        return -1;
	    }
	    aux = cabeca;
		while (aux != null) {
	        if (aux.getConteudo() == dado){
	            return cont;
	        }
	        aux = aux.getProx();
	        cont++;
	    }

	    return -1;
	}
        
        /**
         * Insere no meio da Lista.
         * @param valor
         * @return 
         */
	private boolean insereInicioLista(int valor) {
	    No novoNo = new No();
	    novoNo.setConteudo(valor);
	    novoNo.setProx(cabeca);
	    cabeca = novoNo;
	    nElementos++;
	    return true;
	}
        
        /**
         * Insere no meio da Lista.
         * @param pos
         * @param dado
         * @return 
         */
	private boolean insereMeioLista(int pos, int dado){
	    No novoNo = new No();
	    novoNo.setConteudo(dado);
	    No aux = cabeca;
	    for (int i =1; i < pos-1; i++){
	        aux = aux.getProx();
	    }
	    No p = aux.getProx();
	    novoNo.setProx(p);
	    aux.setProx(novoNo);
	    
	    nElementos++;
	    return true;
	}
        
        /**
         * insere no final da lista.
         * @param dado
         * @return 
         */
	private boolean insereFimLista(int dado){
	    No novoNo = new No();
	    novoNo.setConteudo(dado);
	    No aux = this.cabeca;
	    while(aux.getProx() != null){
	        aux = aux.getProx();
	    }

	    novoNo.setProx(null);
	    aux.setProx(novoNo);

	    this.nElementos++;
	    return true;
	}
	public boolean insere(int pos, int dado) {
            if ((vazia()) && (pos != 1)){
	        return false; /* lista vazia mas posicao inv*/
	    }

            /* inserção no início da lista (ou lista vazia)*/
	    if (pos == 1){
	        return insereInicioLista(dado);
	    }
	    /* inserção no fim da lista */
	    else if (pos == nElementos+1){
	        return insereFimLista(dado);
	   }
	   /* inserção no meio da lista */
	   else{
	        return insereMeioLista(pos, dado);
	   }
	}

	/** Remove elemento do início da lista */
	private int removeInicioLista(){
	    No p = cabeca;

	    // Dado recebe o dado removido
	    int dado = p.getConteudo();

	    // Retira o 1o elemento da lista (p)
	    cabeca = p.getProx();
	    nElementos--;
	    p = null;

	    return dado;
	}

	/** Remove elemento no meio da lista */
	private int removeNaLista(int pos){
	     No atual = null, antecessor = null;
	     int dado = -1;
	     int cont = 1;

	     atual = cabeca;
	     while((cont < pos) && (atual != null)){
	           antecessor = atual;
	           atual = atual.getProx();
	           cont++;
	     }

	     if (atual == null) { /* pos. inválida */
	        return -1;
	     }

	    /* retira o elemento da lista */
	    dado = atual.getConteudo();
	    antecessor.setProx(atual.getProx());
	    nElementos--;
	    atual = null;
	    return dado;
	}
        
        /**
         * Remove Elemento na posição de paramentro;
         * @param pos
         * @return 
         */
	public int remove(int pos) {
		// Lista vazia 
	    if (vazia()) {
	    		return -1;
	    }
	    if (pos == 1){
	        return removeInicioLista();
	    }
	    else{
	        return removeNaLista(pos);
	    }
	}
        
	static class No {
            int conteudo;
            No prox;

            public No(){
                    setProx(null);
            }

            public int getConteudo() {
                    return conteudo;
            }

            public void setConteudo(int conteudo) {
                    this.conteudo = conteudo;
            }

            public No getProx() {
                    return prox;
            }

            public void setProx(No prox) {
                    this.prox = prox;
            }	
	}
}
