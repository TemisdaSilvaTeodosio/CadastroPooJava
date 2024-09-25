/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.IOException;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author Temis
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("Pessoa Fisica");
        
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        
        repo1.inserir(new PessoaFisica("12345678901", 30, 1, "Claison"));
        repo1.inserir(new PessoaFisica("98765432100", 25, 2, "Marta"));

        try {
            repo1.persistir("pessoas_fisicas.dat");
             System.out.println("Dados de pessoas físicas persistidos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao persistir dados de pessoas físicas: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        try {
            repo2.recuperar("pessoas_fisicas.dat");
            System.out.println("Dados de pessoas físicas recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao recuperar dados de pessoas físicas: " + e.getMessage());
        }

        for (PessoaFisica pessoa : repo2.obterTodos()) {
            pessoa.imprimirInfo();
        }
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        System.out.println("==============================");
        System.out.println("Pessoa Juridica");
        
        repo3.inserir(new PessoaJuridica("12345678000195", 3, "Transportes Kyle"));
        repo3.inserir(new PessoaJuridica("98765432000196", 4, "Manaus Energia"));
        
        try {
            repo3.persistir("pessoas_juridicas.dat");
            System.out.println("Dados de pessoas jurídicas persistidos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao persistir dados de pessoas jurídicas: " + e.getMessage());
        }
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        try {
            repo4.recuperar("pessoas_juridicas.dat");
            System.out.println("Dados de pessoas jurídicas recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
             System.err.println("Erro ao recuperar dados de pessoas jurídicas: " + e.getMessage());
        }

        System.out.println("Pessoas Jurídicas:");
        for (PessoaJuridica pessoaJuridica : repo4.obterTodos()) {
            pessoaJuridica.imprimirInfo();
        }
    }    
}
/* // TODO code application logic here
        System.out.println("===============================");
        System.out.println("Informações de Pessoa Fisica");
        Pessoa pessoafisica = new PessoaFisica("14714714702", 32, 1, "Marta");
        
       
        pessoafisica.imprimirInfo();
        
        System.out.println("===============================");
        System.out.println("Informações de Pessoa Jurídica");
        
        Pessoa pessoajuridica = new PessoaJuridica("555508000190", 2, "Transportes Kyle");
        
        pessoajuridica.imprimirInfo();*/