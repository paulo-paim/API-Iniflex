/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API_Iniflex.Models;

import java.text.DecimalFormat;


/**
 *
 * @author Paulo
 */
public class FuncionarioToPrint {
    
    private String nome;
    private String dataNascimento;
    private String salario;
    private String funcao;

    public FuncionarioToPrint() {
    }

    public FuncionarioToPrint(String nome, String dataNascimento, String salario, String funcao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.funcao = funcao;
    }
    
    public FuncionarioToPrint(Funcionario funcionario){
        DecimalFormat decFormat = new DecimalFormat("'R$ ' #,###,##0.00");
        DecimalFormat mFormat= new DecimalFormat("00");
        this.nome = funcionario.getNome();
        this.dataNascimento = mFormat.format(Double.valueOf(funcionario.getDataNascimento().getDayOfMonth()))+"/"+mFormat.format(Double.valueOf(funcionario.getDataNascimento().getMonth().getValue())) +"/"+funcionario.getDataNascimento().getYear();
        this.salario = decFormat.format(funcionario.getSalario());
        this.funcao = funcionario.getFuncao();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    
}
