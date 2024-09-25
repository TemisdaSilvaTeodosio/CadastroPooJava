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
public class PessoaJuridica extends Pessoa implements Serializable {
    private String CNPJ;

    public PessoaJuridica(String CNPJ, int id, String nome) {
        super(id, nome);
        this.CNPJ = CNPJ;
    }

    public PessoaJuridica(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    
    @Override
    public void imprimirInfo(){
        super.imprimirInfo();
        System.out.println("CNPJ: " + this.CNPJ);
    }

    @Override
    public void exibir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
