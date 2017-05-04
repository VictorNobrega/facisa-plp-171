package br.cesed.si.plp.java8;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Teste {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		
		cursos.add(new Curso("Si", 120));
		cursos.add(new Curso("Medicina", 500));
		cursos.add(new Curso("Educação Física", 100));
		cursos.add(new Curso("Enfermagem", 250));
		cursos.add(new Curso("Direito", 1000));
		cursos.add(new Curso("Jogos", 2));
		cursos.add(new Curso("Arquitetura", 800));
		
		//Ordenando e imprimindo a lista ordenada pelo número de alunos
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		cursos.forEach(c->System.out.println(c.getNome()));
		
		System.out.println();
		
		// filtrando os cursos que tem número igual ou maior a 250 alunos.
		cursos.stream()
			.filter(c-> c.getAlunos() >= 250)
			.map(c -> c.getNome())
			.forEach(System.out::println);
		
		//Espaçamento
		System.out.println();
		
		//Filtrando o somatório dos cursos que tem número igual ou maior a 250 alunos.
		int soma = cursos.stream()
			.filter(c -> c.getAlunos() >= 250)
			.mapToInt(Curso::getAlunos)
			.sum();
			
		System.out.println(soma);
		
		//Espaçamento
		System.out.println();
		
		//Filtragem dos cursos que tem a letra inicial E.
		cursos.stream()
			.filter(c -> c.getNome().startsWith("E"))
			.forEach(c -> System.out.println(c.getNome()));
		
		
			
	}

}
