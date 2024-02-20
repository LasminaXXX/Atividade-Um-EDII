package AtividadeUm;

import java.util.ArrayList;

class Funcionario {
	int id;
	double salario;
	String nome;
	
	public Funcionario(int id, double salario, String nome){
		this.id = id;
		this.salario = salario;
		this.nome = nome;
	}
	
	
	public double getsalario() {
		return salario;
	}
	public String getnome() {
		return nome;
	}
	
	public void mostrar() {
		System.out.println("Funcionario: " + nome);
		System.out.println("Salario: " + salario);
		System.out.println("");
	}
}

public class Main {
  public static void main(String[] args) {
    ArrayList<Funcionario> funcionarios = new ArrayList<>();
    funcionarios.add(new Funcionario(1, 1320, "Daniel"));
    funcionarios.add(new Funcionario(2, 1500, "Joao"));
    funcionarios.add(new Funcionario(3, 2300, "Jonatas"));
    funcionarios.add(new Funcionario(4, 1000, "Iago"));
    funcionarios.add(new Funcionario(5, 600, "Lucas"));
    
    
    System.out.println("Funcionarios em ordem decrescnete de salario");
    Funcionario auxiliar; 
    for (int i = 0; i < 5; i++) {
    	for (int j = 0; j < 4; j++) {
    		if(funcionarios.get(j).getsalario() < funcionarios.get(j + 1).getsalario()) {
    			auxiliar = funcionarios.get(j);
    			funcionarios.set(j, funcionarios.get(j+1));
                funcionarios.set(j+1, auxiliar);
    		}
    	}
    }
    
    for(Funcionario k : funcionarios) {
    	k.mostrar();
    }
    
    
    System.out.println("Funcionarios em ordem crescnete de salario");
    Funcionario auxiliar_de; 
    for (int i = 0; i < 5; i++) {
    	for (int j = 0; j < 4; j++) {
    		if(funcionarios.get(j).getsalario() > funcionarios.get(j + 1).getsalario()) {
    			auxiliar_de = funcionarios.get(j);
    			funcionarios.set(j, funcionarios.get(j+1));
                funcionarios.set(j+1, auxiliar_de);
    		}
    	}
    }
    
    for(Funcionario k : funcionarios) {
    	k.mostrar();
    }
    
    
    System.out.println("Funcionarios em ordem alfabetica");
    Funcionario auxiliar_no; 
    for (int i = 0; i < 5; i++) {
    	for (int j = 0; j < 4; j++) {
    		if(funcionarios.get(j).getnome().compareTo(funcionarios.get(j + 1).getnome()) > 0) {
    			auxiliar_no = funcionarios.get(j);
    			funcionarios.set(j, funcionarios.get(j+1));
                funcionarios.set(j+1, auxiliar_no);
    		}
    	}
    }
    
    for(Funcionario k : funcionarios) {
    	k.mostrar();
    }
    
    
  }
}
