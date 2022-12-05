package com.senacrio.aluno;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senacrio.aluno.controller.AlunoController;
import com.senacrio.aluno.model.Aluno;

public class TesteFind {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BancoAcad");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		AlunoController controller = new AlunoController();
		Scanner sc = new Scanner(System.in);
		
		int op = 0;
		int id;
		
		
		
		System.out.println("1 - Pesquisar Aluno");
		System.out.println("2 - Listar alunos ordenados pelo nome");
		System.out.println("3 - Listar todos os alunos");
		op = sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("Insira o ID do Aluno:");
			id = sc.nextInt();
			controller.FindOneById(id);
			System.out.println(aluno.getNome());
			System.out.println(aluno.getEmail());
			System.out.println(aluno.getCpf());
			System.out.println(aluno.getDataDeNascimento());
			System.out.println(aluno.getNaturalidade());
			System.out.println(aluno.getEndereco());
			break;
		case 2:
			List<Aluno> listaAluno = controller.FindOneOrderByLetterName();
			for(int i = 0;i < listaAluno.size();i++) {
				System.out.println(aluno.getNome());
			}
			break;
		case 3:
			List<Aluno> listaAlunos = controller.FindAll();
			for(int i = 0;i < listaAlunos.size();i++) {
				System.out.println(aluno.getNome());
			}
			
			break;
		default:
			System.out.println("DIGITE UM NUMERO ATÉ 3");
			break;
		}
		
		entityManager.close();
		entityManagerFactory.close();
	
	}
}
