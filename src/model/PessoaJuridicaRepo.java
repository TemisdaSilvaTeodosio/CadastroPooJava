/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Temis
 */
public class PessoaJuridicaRepo implements Serializable{
   private List<PessoaJuridica> listaPessoaJuridica = new ArrayList<> ();
   
   public void inserir (PessoaJuridica pessoa) {
       listaPessoaJuridica.add(pessoa);
   }
   
   public void alterar(PessoaJuridica pessoa) {
        for (int i = 0; i < listaPessoaJuridica.size(); i++) {
            if (listaPessoaJuridica.get(i).getId() == pessoa.getId()) {
                listaPessoaJuridica.set(i, pessoa);
                return;
            }
        }
   }
   
   public void excluir(int id) {
        listaPessoaJuridica.removeIf(pessoa -> pessoa.getId() == id);
    }
   
   public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : listaPessoaJuridica) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; 
    }
   
   public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(listaPessoaJuridica); 
    }
   
   public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaJuridica);
        }
    }
   
   public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaJuridica = (ArrayList<PessoaJuridica>) ois.readObject();
        }
    }
}