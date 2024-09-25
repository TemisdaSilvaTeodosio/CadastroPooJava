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
public class PessoaFisicaRepo implements Serializable {
    
    private List<PessoaFisica> listaPessoaFisica = new ArrayList<>();
    
    public void inserir(PessoaFisica pessoa) {
        listaPessoaFisica.add(pessoa);
    }
    
    public void alterar(PessoaFisica pessoa) {
        for (int i = 0; i < listaPessoaFisica.size(); i++) {
            if (listaPessoaFisica.get(i).getId() == pessoa.getId()) {
                listaPessoaFisica.set(i, pessoa);
                return;
            }
        }
    } 
    public void excluir(int id) {
        listaPessoaFisica.removeIf(pessoa -> pessoa.getId() == id);
    }
    
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : listaPessoaFisica) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; 
    }
    
    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(listaPessoaFisica);
    }
    
    public void persistir(String nomeArquivo) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaFisica);
        }
    }
    
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaFisica = (ArrayList<PessoaFisica>) ois.readObject();
        }
    }
}


/* public boolean salvar (PessoaFisica pessoafisica);
    public boolean deletar(int id);
    public List<PessoaFisica> listar();
    public boolean alterar(PessoaFisica pessoafisica);*/