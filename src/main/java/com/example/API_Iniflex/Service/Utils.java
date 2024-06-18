/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API_Iniflex.Service;

/**
 *
 * @author Paulo
 */
import com.example.API_Iniflex.Models.Funcionario;
import com.example.API_Iniflex.Models.FuncionarioToPrint;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Paulo
 */
public class Utils {
    
    public static List<Funcionario> gerarFuncionarios (){
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        
        listaFuncionarios.add(new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER, 18), BigDecimal.valueOf(2009.44), "Operador"));
        listaFuncionarios.add(new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), BigDecimal.valueOf(2284.38), "Operador"));
        listaFuncionarios.add(new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 02), BigDecimal.valueOf(9836.14), "Coordenador"));
        listaFuncionarios.add(new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        listaFuncionarios.add(new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 05), BigDecimal.valueOf(2234.68), "Recepcionista"));
        listaFuncionarios.add(new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), BigDecimal.valueOf(1582.72), "Operador"));
        listaFuncionarios.add(new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31), BigDecimal.valueOf(4071.84), "Contador"));
        listaFuncionarios.add(new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        listaFuncionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), BigDecimal.valueOf(1606.85), "Eletrecista"));
        listaFuncionarios.add(new Funcionario("Helena", LocalDate.of(1996, Month.SEPTEMBER, 2), BigDecimal.valueOf(2799.93), "Gerente"));
        
        
        
        return listaFuncionarios;
    }
    
    public static void removerFuncionarioByNome(List<Funcionario> funcionarios, String nome){
        
        for(int i=0; i<funcionarios.size();i++){
            if(nome.equals(funcionarios.get(i).getNome())){
                funcionarios.remove(i);
            }
        }
        
    }
    
    public static void imprimirNomes(List<Funcionario> funcionarios){
        for(int i=0;i<funcionarios.size();i++){
            System.out.println(funcionarios.get(i).getNome());
        }
    }
    
    public static void imprimirFuncionarios(List<Funcionario> funcionarios){
         
      DecimalFormat decFormat = new DecimalFormat("'R$ ' #,###,##0.00");
      for(int i=0;i<funcionarios.size();i++){
          System.out.println(funcionarios.get(i).getNome()+"\t\t"
                  +funcionarios.get(i).getDataNascimento().getDayOfMonth()+"/"+funcionarios.get(i).getDataNascimento().getMonth().getValue()+"/"+funcionarios.get(i).getDataNascimento().getYear()+"\t\t"
                  +decFormat.format(funcionarios.get(i).getSalario())+"\t\t"
                  +funcionarios.get(i).getFuncao());
      }  
        System.out.println("\n\n");
    }
    
    public static void aumentarSalario(List<Funcionario> funcionarios, double aumento){
        
        for(int i=0;i<funcionarios.size();i++){
            funcionarios.get(i).setSalario(funcionarios.get(i).getSalario().multiply(BigDecimal.valueOf(aumento)));
        }
    }
    
    
    public static Map<String,List<Funcionario>> gerarMap(List<Funcionario> funcionarios){
        
        Map<String,List<Funcionario>> map = new HashMap<>();
        map.put("Operador", Utils.getFuncionarioByFuncao(funcionarios, "Operador"));
        map.put("Coordenador", Utils.getFuncionarioByFuncao(funcionarios, "Coordenador"));
        map.put("Diretor", Utils.getFuncionarioByFuncao(funcionarios, "Diretor"));
        map.put("Recepcionista", Utils.getFuncionarioByFuncao(funcionarios, "Recepcionista"));
        map.put("Contador", Utils.getFuncionarioByFuncao(funcionarios, "Contador"));
        map.put("Gerente", Utils.getFuncionarioByFuncao(funcionarios, "Gerente"));
        map.put("Eletrecista", Utils.getFuncionarioByFuncao(funcionarios, "Eletrecista"));
        
        return map;
        

        
    }
    
        public static Map<String,List<FuncionarioToPrint>> gerarMap2(List<FuncionarioToPrint> funcionarios){
        
        Map<String,List<FuncionarioToPrint>> map = new HashMap<>();
        map.put("Operador", Utils.getFuncionarioByFuncao2(funcionarios, "Operador"));
        map.put("Coordenador", Utils.getFuncionarioByFuncao2(funcionarios, "Coordenador"));
        map.put("Diretor", Utils.getFuncionarioByFuncao2(funcionarios, "Diretor"));
        map.put("Recepcionista", Utils.getFuncionarioByFuncao2(funcionarios, "Recepcionista"));
        map.put("Contador", Utils.getFuncionarioByFuncao2(funcionarios, "Contador"));
        map.put("Gerente", Utils.getFuncionarioByFuncao2(funcionarios, "Gerente"));
        map.put("Eletrecista", Utils.getFuncionarioByFuncao2(funcionarios, "Eletrecista"));
        
        return map;
        

        
    }
    
    private static List<Funcionario> getFuncionarioByFuncao(List<Funcionario> funcionarios, String funcao){
        List<Funcionario> funcionariosDaFuncao = new ArrayList<>();
        
        for(int i=0;i<funcionarios.size();i++){
            if(funcionarios.get(i).getFuncao().compareTo(funcao)==0){
                funcionariosDaFuncao.add(funcionarios.get(i));
            }
        }
        
        return funcionariosDaFuncao;
    }
    
        private static List<FuncionarioToPrint> getFuncionarioByFuncao2(List<FuncionarioToPrint> funcionarios, String funcao){
        List<FuncionarioToPrint> funcionariosDaFuncao = new ArrayList<>();
        
        for(int i=0;i<funcionarios.size();i++){
            if(funcionarios.get(i).getFuncao().compareTo(funcao)==0){
                funcionariosDaFuncao.add(funcionarios.get(i));
            }
        }
        
        return funcionariosDaFuncao;
    }
    
    public static List<FuncionarioToPrint> listaAniversariantes(List<Funcionario> funcionarios, String mesAniversario){
        int mes = Integer.parseInt(mesAniversario);
        List<FuncionarioToPrint> aniversariantes = new ArrayList<>();
        for(int i=0; i<funcionarios.size();i++){
            if(funcionarios.get(i).getDataNascimento().getMonth().getValue()== mes){
                aniversariantes.add(new FuncionarioToPrint(funcionarios.get(i)));
            }

                
        }
        return aniversariantes;
    }
    
    public static int funcionarioMaiorIdade(List<Funcionario> funcionarios){
        
        int indiceMaiorIdade = 0;
        for(int i=0; i<funcionarios.size(); i++){
            if(calcularIdade(funcionarios.get(i).getDataNascimento()) > calcularIdade(funcionarios.get(indiceMaiorIdade).getDataNascimento())){
                indiceMaiorIdade = i;
            }
        }
        return indiceMaiorIdade;
        
    }
    
    public static int calcularIdade(LocalDate nascimento){
        
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(nascimento, dataAtual);
        return periodo.getYears();
    }
    
    public static List<Funcionario> ordenarEmOrdemAlfabetica(List<Funcionario> funcionarios){
        funcionarios.sort(new Comparator<Funcionario>(){
            @Override
            public int compare(Funcionario o1, Funcionario o2){
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        
        return funcionarios;
    }
    
    public static BigDecimal totalSalarios(List<Funcionario> funcionarios){
        BigDecimal total = new BigDecimal(0);
        for(int i=0; i<funcionarios.size();i++){
            total = total.add(funcionarios.get(i).getSalario());
        }
        
        return total;
    }
    
    public static float quantidadeSalariosMinimos(BigDecimal salario){
        float salMinimo = 1212;
        return salario.floatValue()/salMinimo;
    }
    
    
    public static String myToString(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(formatter);
    } 
    
}

