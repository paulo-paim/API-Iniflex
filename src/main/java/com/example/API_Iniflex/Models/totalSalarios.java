/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API_Iniflex.Models;

import java.math.BigDecimal;

/**
 *
 * @author Paulo
 */
public class totalSalarios {
    private BigDecimal salarioTotal;

    public totalSalarios(BigDecimal salario) {
        this.salarioTotal = salario;
    }

    public BigDecimal getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(BigDecimal salario) {
        this.salarioTotal = salario;
    }
    
    
    
    
}
