package AtividadeDois;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[10];
		
		for(int i =0; i < 10; i++) {
			System.out.println("Digite um numero: ");
			int num = sc.nextInt();
			numeros[i] = num;
		}
		
		
		int auxiliar; 
	    for (int i = 0; i < 10; i++) {
	    	for (int j = 0; j < 9; j++) {
	    		if(numeros[j] < numeros[j + 1]) {
	    			auxiliar = numeros[j];
	    			numeros[j] = numeros[j+1];
	                numeros[j+1] = auxiliar;
	    		}
	    	}
	    }
		
	    int menor = numeros[0];
	    int maior = numeros[9];
	    int quant_menor = 0;
	    int quant_maior = 0;
	    
		for (int k = 0; k < numeros.length; k++) {
			if(numeros[k] == menor) {
				quant_menor = quant_menor + 1;
				}
			else if (numeros[k] == maior) {
				quant_maior = quant_maior + 1;
			}
		}
		System.out.println("");
		System.out.println("Numeros ordenados: ");
		for(int i : numeros) {
			System.out.println(i);
		}
		
		System.out.println("Vezes que o menor numero aparece: " + quant_menor);
		System.out.println("Vezes que o maior numero aparece: " + quant_maior);
		
	}
}
