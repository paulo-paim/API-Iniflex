/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API_Iniflex.Models;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 *
 * @author Paulo
 */
public class FuncionarioSalariosMinimos {

    private String nome;
    private String dataNascimento;
    private String salario;
    private String funcao;
    private String salariosMinimos;

    public FuncionarioSalariosMinimos() {
    }

    public FuncionarioSalariosMinimos(Funcionario funcionario) {
        DecimalFormat decFormat = new DecimalFormat("'R$ ' #,###,##0.00");
        DecimalFormat mFormat = new DecimalFormat("00");
        this.nome = funcionario.getNome();
        this.dataNascimento = mFormat.format(Double.valueOf(funcionario.getDataNascimento().getDayOfMonth())) + "/" + mFormat.format(Double.valueOf(funcionario.getDataNascimento().getMonth().getValue())) + "/" + funcionario.getDataNascimento().getYear();
        this.salario = decFormat.format(funcionario.getSalario());
        this.funcao = funcionario.getFuncao();
    }

//    public FuncionarioSalariosMinimos(String nome, LocalDate dataNascimento, BigDecimal salario, String salariosMinimos, String funcao) {
//        this.nome = nome;
//        this.dataNascimento = dataNascimento;
//        this.salario = salario;
//        this.salariosMinimos = salariosMinimos;
//        this.funcao = funcao;
//    }
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

    public void setDataNascimento(LocalDate dataNascimento) {
        DecimalFormat mFormat = new DecimalFormat("00");
        this.dataNascimento = mFormat.format(Double.valueOf(dataNascimento.getDayOfMonth())) + "/" + mFormat.format(Double.valueOf(dataNascimento.getMonth().getValue())) + "/" + dataNascimento.getYear();
        
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        DecimalFormat decFormat = new DecimalFormat("'R$ ' #,###,##0.00");
        this.salario = decFormat.format(salario);
    }

    public String getSalariosMinimos() {
        return salariosMinimos;
    }

    public void setSalariosMinimos(String salariosMinimos) {
        this.salariosMinimos = salariosMinimos;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
