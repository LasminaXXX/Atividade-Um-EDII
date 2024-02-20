package AtividadeQuatro;
import java.util.ArrayList;
import java.util.Scanner;


class Alunos{
	private String nome;
	private double nota1, nota2;
	
	public Alunos(String nome, double nota_um, double nota_dois) {
		this.nome = nome;
		this.nota1 = nota_um;
		this.nota2 = nota_dois;
	}
	
	public double mediaPonderada() {
		double media = ((nota1 * 2) + (nota2 * 3)) / 5;
		return media;
	}
	public void mostrar() {
		System.out.println("\nNome: " + nome + "\nPrimeira nota: " + nota1 + "\nSegunda nota: " + nota2);
		
	}
	public double getNotaUm() {
		return nota1;
	}
	public String getNome() {
		return nome;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Alunos> listaAlunos = new ArrayList<>();
		
		int contador = 0;
		
		while (contador < 9) {
			System.out.println("Nome do aluno: ");
			String nome = sc.next();
			System.out.println("Primeira nota do aluno: ");
			double nota_um = sc.nextFloat();
			System.out.println("Primeira nota do aluno: ");
			double nota_dois = sc.nextFloat();
			
			listaAlunos.add(new Alunos(nome, nota_um, nota_dois));
			contador++;
		}
		
		Alunos auxiliar;
		for (int i = 0; i < listaAlunos.size(); i++) {
			for (int j = 0; j < listaAlunos.size()-1; j++) {
				if (listaAlunos.get(j).getNotaUm() < listaAlunos.get(j+1).getNotaUm()) {
					auxiliar = listaAlunos.get(j);
					listaAlunos.set(j, listaAlunos.get(j+1));
					listaAlunos.set(j+1, auxiliar);
				}
				
			}
		}
		
		System.out.println("Alunos Ordenados pela primeira nota: ");
		for (Alunos i : listaAlunos) {
			i.mostrar();
		}
		
		ArrayList<Alunos> alunosAprovados = new ArrayList<>();
		for (Alunos i : listaAlunos) {
			if(i.mediaPonderada() >= 7) {
				alunosAprovados.add(i);
			}
			
			Alunos auxiliar_dois;
			for (int k = 0; k < alunosAprovados.size(); k++) {
		    	for (int j = 0; j < alunosAprovados.size()-1; j++) {
		    		if(alunosAprovados.get(j).getNome().compareTo(alunosAprovados.get(j + 1).getNome()) > 0) {
		    			auxiliar_dois = alunosAprovados.get(j);
		    			alunosAprovados.set(j, alunosAprovados.get(j+1));
		    			alunosAprovados.set(j+1, auxiliar_dois);
		    		}
		    	}
		    }
		}
		
		System.out.println("");
		
		System.out.println("\n\n\nAlunos aprovados: ");
		for (Alunos i : alunosAprovados) {
			i.mostrar();
			System.out.println("Media ponderada: " + i.mediaPonderada());
		}
	    
		
	}
}
