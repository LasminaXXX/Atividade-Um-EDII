package AtividadeTres;

import java.util.ArrayList;


class Produto{
	private int codigo;
	private String descricao;
	private double preco;
	
	
	public Produto(int codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void display() {
		System.out.println("Codigo: " + codigo + "\nDescricao: " + descricao + "\nPreço: " + preco);
	}
	
	
	
	
	
}

public class Main {
	public static void main(String[] args) {
		ArrayList<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(new Produto(12, "Camiseta", 29.99));
        listaProdutos.add(new Produto(2, "Calça Jeans", 49.99));
        listaProdutos.add(new Produto(9, "Tênis", 79.99));
        listaProdutos.add(new Produto(3, "Relógio", 99.99));
        listaProdutos.add(new Produto(5, "Mochila", 39.99));
        listaProdutos.add(new Produto(10, "Fone de Ouvido", 19.99));
        listaProdutos.add(new Produto(7, "Livro", 14.99));
        listaProdutos.add(new Produto(8, "Caneca", 9.99));
        listaProdutos.add(new Produto(4, "Laptop", 899.99));
        listaProdutos.add(new Produto(6, "Mouse", 19.99));
        listaProdutos.add(new Produto(11, "Teclado", 29.99));
        listaProdutos.add(new Produto(1, "Monitor", 199.99));
		
        System.out.println("Produtos Desorganizados: ");
        for(Produto i : listaProdutos) {
        	i.display();
        }
         System.out.println("");
        Produto auxiliar_de; 
        for (int i = 0; i < listaProdutos.size(); i++) {
        	for (int j = 0; j < listaProdutos.size()-1; j++) {
        		if(listaProdutos.get(j).getCodigo() > listaProdutos.get(j + 1).getCodigo()) {
        			auxiliar_de = listaProdutos.get(j);
        			listaProdutos.set(j, listaProdutos.get(j+1));
        			listaProdutos.set(j+1, auxiliar_de);
        		}
        	}
        }
        
        System.out.println("Produtos Organizados: ");
        for(Produto i : listaProdutos) {
        	i.display();
        }
        // chavo do produto a ser encontrado
        int chave = 12;
        
        System.out.println("");
    	int comparacoesSequencial = 0;
    	for (Produto i: listaProdutos) {
    		if (chave == i.getCodigo()) {
    			comparacoesSequencial += 1;
    			i.display();
    		}
    		else{
   				comparacoesSequencial += 1;
   			}
   		}
   		System.out.println("Quantidade de comparações da busca sequencial: " + comparacoesSequencial);
    	
   		System.out.println("");
   		
   		int comparacoesBinaria = 0;
   		int[] resul = buscaBinaria(listaProdutos, chave);

        if (resul[0] != -1) {
            Produto produtoEncontrado = listaProdutos.get(resul[0]);
            produtoEncontrado.display();
            System.out.println("Quantidade de comparações binárias: " + resul[1]);
        } else {
            System.out.println("Produto não encontrado.");
        }
        
   		   
	}
	
	
	private static int[] buscaBinaria(ArrayList<Produto> lista, int alvo) {
        int inicio = 0;
        int fim = lista.size() - 1;
        int comparacoesBinaria = 0;
        
        while (inicio <= fim) {
        	comparacoesBinaria++;
            int meio = (inicio + fim) / 2;
            int codigoMeio = lista.get(meio).getCodigo();

            if (codigoMeio == alvo) {
                return new int[]{meio, comparacoesBinaria};
            } else if (codigoMeio < alvo) {
                inicio = meio + 1;
            } else {
                fim = meio - 1; 
            }
        }
        return new int[]{-1, comparacoesBinaria}; 
    }
	
	
}
