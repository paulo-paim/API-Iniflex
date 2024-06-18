/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API_Iniflex.Service;


import com.example.API_Iniflex.Models.FuncionarioToPrint;
import com.example.API_Iniflex.Models.Funcionario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class convertFuncionarioToFuncionarioToPrint {
    
    public static List<FuncionarioToPrint> converterFuncionario(List<Funcionario> funcionarios){
        
        List<FuncionarioToPrint> listaFuncionariosConvertidos = new ArrayList<>();
        FuncionarioToPrint func;
        
        for(int i=0;i<funcionarios.size();i++){
            func = new FuncionarioToPrint(funcionarios.get(i));
            listaFuncionariosConvertidos.add(func);
        }
        
        return listaFuncionariosConvertidos;
    }
    
}
