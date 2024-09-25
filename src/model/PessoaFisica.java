/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Temis
 */
public class PessoaFisica extends Pessoa implements Serializable {
    private String CPF;
    private int idade;

    public PessoaFisica(String CPF, int idade, int id, String nome) {
        super(id, nome);
        this.CPF = CPF;
        this.idade = idade;
    }

    public PessoaFisica(String CPF, int idade) {
        this.CPF = CPF;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    /**
     *
     */
    @Override
    public void imprimirInfo() {
        super.imprimirInfo();
        System.out.println("CPF: " + this.CPF);
        System.out.println("Idade: "+ this.idade);
    }

    /**
     *
     */
    @Override
    public void exibir() {
        throw new UnsupportedOperationException("Not supported yet."); // 
    }
}
