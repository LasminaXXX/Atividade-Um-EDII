package AtividadeCinco;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		
		// PREENCHENDO O ARRAULIST COM OS NUMEROS JÁ VERIFICANDO A EXISTENCIA DE NUMEROS DUPLICADOS
		for (int quant = 0; quant < 5; quant++) {
            System.out.println("Digite um numero: ");
            int num = sc.nextInt();
            
            boolean repetido = false;
            for (int k = 0; k < numeros.size(); k++) {
                if (num == numeros.get(k)) {
                    System.out.println("Não digite números repetidos! ");
                    repetido = true;
                    quant--;
                    break; 
                }
            }

            if (!repetido) {
                numeros.add(num);
            }
        }
		
		for (int i = 0; i < numeros.size(); i++) {
			int auxiliar;
			for (int j = 0; j < numeros.size()-1; j++) {
				if (numeros.get(j) > numeros.get(j+1)) {
					auxiliar = numeros.get(j);
					numeros.set(j, numeros.get(j+1));
					numeros.set(j+1, auxiliar);
				}
			}
		}
		
		System.out.println("Digite um numero a ser verificado na lista já ordenada: ");
		int alvo = sc.nextInt();
		
		
		
		
		int comparacoesSequencial = 0;
    	for (int i = 0; i < numeros.size()-1; i++) {
    		if (alvo == numeros.get(i)) {
    			comparacoesSequencial += 1;
    			if (i % 2 == 0) {
    				System.out.println("Numero no index: " + i + "!\nIndex par!");
    			}else {
    				System.out.println("Numero no index: " + i + "!\nIndex Impar!");
    			}
    		}
    		else{
   				comparacoesSequencial += 1;
   			}
   		}
   		System.out.println("Quantidade de comparações da busca sequencial: " + comparacoesSequencial);
    	
   		System.out.println("");
   		
   		int comparacoesBinaria = 0;
   		int[] resul = buscaBinaria(numeros, alvo);

        if (resul[0] != -1) {
            int numeroencontrado = resul[0];
            if (numeroencontrado % 2 == 0) {
            	System.out.println("Numero do index: " + numeroencontrado + "\nIndex par!");
            } else {
            	System.out.println("Numero do index: " + numeroencontrado + "\nIndex impar!");
            }
            System.out.println("Quantidade de comparações binárias: " + resul[1]);
        } else {
            System.out.println("Número não encontrado.");
        }
		
		
	}
	private static int[] buscaBinaria(ArrayList<Integer> lista, int alvo) {
        int inicio = 0;
        int fim = lista.size() - 1;
        int comparacoesBinaria = 0;
        
        while (inicio <= fim) {
        	comparacoesBinaria++;
            int meio = (inicio + fim) / 2;
            int codigoMeio = lista.get(meio);

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
