/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author Temis
 */
public class CadastroPOOParte2 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (  Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            PessoaJuridicaRepo repo2 = new PessoaJuridicaRepo();
            int opcao;
            do {
                System.out.println("=============================");
                System.out.println("Menu:");
                System.out.println("1 - Incluir Pessoa");
                System.out.println("2 - Alterar Pessoa");
                System.out.println("3 - Excluir Pessoa");
                System.out.println("4 - Buscar pelo ID");
                System.out.println("5 - Exibir todos");
                System.out.println("6 - Salvar dados");
                System.out.println("7 - Recuperar dados");
                System.out.println("0 - Finalizar Programa");
                System.out.println("=============================");
                opcao = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcao) {
                    case 1: //adicionar
                        System.out.print("Tipo (F - Física/ J - Jurídica):\n");
                        String tipo = scanner.nextLine();
                        if (tipo.equalsIgnoreCase("F")) {
                            System.out.print("Informe o ID:\n");
                            int id = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Informe o nome da Pessoa Física:\n");
                            String nome = scanner.nextLine();
                            System.out.print("Informe o CPF da Pessoa Física:\n");
                            String cpf = scanner.nextLine();
                            System.out.print("Informe o Idade da Pessoa Física:\n");
                            int idade = scanner.nextInt();
                            repo1.inserir(new PessoaFisica(cpf, idade, id, nome));
                        } else if (tipo.equalsIgnoreCase("J")) {
                            System.out.print("Informa o ID:\n");
                            int id = scanner.nextInt();
                            scanner.nextLine(); 
                            System.out.print("Informe o nome da Pessoa Jurídica:\n");
                            String nome = scanner.nextLine();
                            System.out.print("Informe o CNPJ da Pessoa Jurídica:\n");
                            String cnpj = scanner.nextLine();
                            repo2.inserir(new PessoaJuridica(cnpj, id, nome));
                        } else {
                            System.out.println("Tipo inválido!");
                        }
                        break;
                        
                    case 2: // Alterar
                        System.out.print("Tipo (F - Física/ J - Jurídica):\n");
                        String tipoAlterar = scanner.nextLine();
                        if (tipoAlterar.equalsIgnoreCase("F")) {
                            System.out.print("ID da pessoa física:\n");
                            int id = scanner.nextInt();
                            PessoaFisica pessoa = repo1.obter(id);
                            if (pessoa != null) {
                                System.out.println("Dados atuais:");
                                pessoa.imprimirInfo();
                                System.out.print("Informe o novo nome:\n");
                                scanner.nextLine();
                                String nome = scanner.nextLine();
                                System.out.print("Informe o novo CPF:\n");
                                String cpf = scanner.nextLine();
                                System.out.print("Informe a nova idade:\n");
                                int idade = scanner.nextInt();
                                repo1.alterar(new PessoaFisica(cpf, idade, id, nome));
                            } else {
                                System.out.println("Pessoa física não encontrada.");
                            }
                        } else if (tipoAlterar.equalsIgnoreCase("J")) {
                            System.out.print("ID da pessoa jurídica:\n");
                            int id = scanner.nextInt();
                            PessoaJuridica pessoa = repo2.obter(id);
                            if (pessoa != null) {
                                System.out.println("Dados atuais:");
                                pessoa.imprimirInfo();
                                System.out.print("Informe o novo nome:\n");
                                scanner.nextLine(); 
                                String nome = scanner.nextLine();
                                System.out.print("Informe o novo CNPJ:\n");
                                String cnpj = scanner.nextLine();
                                repo2.alterar(new PessoaJuridica(cnpj, id, nome));
                            } else {
                                System.out.println("Pessoa jurídica não encontrada.");
                            }
                        } else {
                            System.out.println("Tipo inválido!");
                        }
                        break;
                        
                    case 3: //excluir
                        System.out.print("Tipo (F - Física/ J - Jurídica):\n");
                        String tipoExcluir = scanner.nextLine();
                        if (tipoExcluir.equalsIgnoreCase("F")) {
                            System.out.print("ID da pessoa física:\n");
                            int id = scanner.nextInt();
                            repo1.excluir(id);
                        } else if (tipoExcluir.equalsIgnoreCase("J")) {
                            System.out.print("ID da pessoa jurídica:\n");
                            int id = scanner.nextInt();
                            repo2.excluir(id);
                        } else {
                            System.out.println("Tipo inválido!");
                        }
                        System.out.println("Excluido com sucesso");
                        break;
                        
                    case 4: // buscar por Id
                        System.out.print("Tipo (F - Física/ J - Jurídica):\n");
                        String tipoObter = scanner.nextLine();
                        if (tipoObter.equalsIgnoreCase("F")) {
                            System.out.println("ID da pessoa física:\n");
                            int id = scanner.nextInt();
                            PessoaFisica pessoa = repo1.obter(id);
                            if (pessoa != null) {
                                pessoa.imprimirInfo();
                            } else {
                                System.out.println("Pessoa física não encontrada.");
                            }
                        } else if (tipoObter.equalsIgnoreCase("J")) {
                            System.out.print("ID da pessoa jurídica:\n");
                            int id = scanner.nextInt();
                            PessoaJuridica pessoa = repo2.obter(id);
                            if (pessoa != null) {
                                pessoa.imprimirInfo();
                            } else {
                                System.out.println("Pessoa jurídica não encontrada.");
                            }
                        } else {
                            System.out.println("Tipo inválido!");
                        }
                        break;
                        
                    case 5: //exibir todos
                        System.out.print("Tipo (F - Física/ J - Jurídica):\n");
                        String tipoExibirTodos = scanner.nextLine();
                        if (tipoExibirTodos.equalsIgnoreCase("F")) {
                            List<PessoaFisica> pessoas = repo1.obterTodos();
                            for (PessoaFisica pessoa : pessoas) {
                                pessoa.imprimirInfo();
                            }
                        } else if (tipoExibirTodos.equalsIgnoreCase("J")) {
                            List<PessoaJuridica> pessoas = repo2.obterTodos();
                            for (PessoaJuridica pessoa : pessoas) {
                                pessoa.imprimirInfo();
                            }
                        } else {
                            System.out.println("Tipo inválido!");
                        }
                        break;
                        
                    case 6: //Salvar 
                        System.out.print("Prefixo dos arquivos:\n");
                        String prefixoSalvar = scanner.nextLine();
                        repo1.persistir(prefixoSalvar + ".fisica.bin");
                        repo2.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                        break;
                        
                    case 7: //Recuperar
                        System.out.print("Prefixo dos arquivos:\n");
                        String prefixoRecuperar = scanner.nextLine();
                        repo1.recuperar(prefixoRecuperar + ".fisica.bin");
                        repo2.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso.");
                        break;
                        
                    case 0: //Sair
                        System.out.println("Saindo...");
                        break;
                        
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
           
        }
    }  
}
