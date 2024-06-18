/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API_Iniflex.Service;

import com.example.API_Iniflex.Models.FuncionarioSalariosMinimos;
import java.util.List;
import com.example.API_Iniflex.Models.Funcionario;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Paulo
 */
public class convertFuncionarioToFuncionarioComSalariosMinimos {

    public static List<FuncionarioSalariosMinimos> converter(List<Funcionario> funcionarios) {

        
        FuncionarioSalariosMinimos convertido = new FuncionarioSalariosMinimos();
        List<FuncionarioSalariosMinimos> lista = new ArrayList<>();
        

        for (int i = 0; i < funcionarios.size(); i++) {
            convertido = new FuncionarioSalariosMinimos();
            convertido.setFuncao(funcionarios.get(i).getFuncao());
            convertido.setNome(funcionarios.get(i).getNome());
            convertido.setSalario(funcionarios.get(i).getSalario());
            convertido.setDataNascimento(funcionarios.get(i).getDataNascimento());
            convertido.setSalariosMinimos(quantidadeSalariosMinimos(funcionarios.get(i).getSalario()));
            lista.add(convertido);
        }

        return lista;

    }

    private static String quantidadeSalariosMinimos(BigDecimal salario) {
        DecimalFormat df = new DecimalFormat("%.2f");
        float salMinimo = 1212;
        float ret=0;
        ret=  salario.floatValue() / salMinimo;
        return String.format("%.2f", ret);
    }
}
