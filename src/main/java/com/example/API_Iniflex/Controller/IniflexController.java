/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.API_Iniflex.Controller;

import com.example.API_Iniflex.Models.Funcionario;
import com.example.API_Iniflex.Models.FuncionarioMaisVelho;
import com.example.API_Iniflex.Models.FuncionarioSalariosMinimos;
import com.example.API_Iniflex.Models.FuncionarioToPrint;
import com.example.API_Iniflex.Models.totalSalarios;
import com.example.API_Iniflex.Service.Utils;
import com.example.API_Iniflex.Service.convertFuncionarioToFuncionarioComSalariosMinimos;
import com.example.API_Iniflex.Service.convertFuncionarioToFuncionarioToPrint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Paulo
 */
@RestController
public class IniflexController {

    List<Funcionario> funcionarios = Utils.gerarFuncionarios();

    @GetMapping(value = "/funcionarios/listagem")
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @DeleteMapping(value = "/funcionarios/remover/{nome}")
    public List<FuncionarioToPrint> removerFuncionarioByNome(@PathVariable(value = "nome") String nome) {
        Utils.removerFuncionarioByNome(this.funcionarios, nome);
        return convertFuncionarioToFuncionarioToPrint.converterFuncionario(funcionarios);
    }

    @GetMapping(value = "/funcionarios/")
    public List<FuncionarioToPrint> getFuncionariosDataNascimento() {

        return convertFuncionarioToFuncionarioToPrint.converterFuncionario(funcionarios);
    }

    @GetMapping(value = "/funcionarios/aumentar-salario/{aumento}")
    public List<FuncionarioToPrint> aumentarSalario(@PathVariable(value = "aumento") double aumento) {
        Utils.aumentarSalario(funcionarios, aumento);
        return convertFuncionarioToFuncionarioToPrint.converterFuncionario(funcionarios);
    }

    @GetMapping(value = "/funcionarios/funcao/{funcaoChamada}")
    public List<FuncionarioToPrint> getFuncionarioByFuncao(@PathVariable(value = "funcaoChamada") String funcao) {

        Map<String, List<Funcionario>> map = Utils.gerarMap(funcionarios);
        return convertFuncionarioToFuncionarioToPrint.converterFuncionario(map.get(funcao));
    }

    @GetMapping(value = "/funcionarios/funcao")
    public List<List<FuncionarioToPrint>> getFuncionarioByFuncao() {
        List<List<FuncionarioToPrint>> retorno = new ArrayList<>();

        Map<String, List<FuncionarioToPrint>> map = Utils.gerarMap2(convertFuncionarioToFuncionarioToPrint.converterFuncionario(funcionarios));
        retorno.add(map.get("Contador"));
        retorno.add(map.get("Coordenador"));
        retorno.add(map.get("Diretor"));
        retorno.add(map.get("Eletrecista"));
        retorno.add(map.get("Gerente"));
        retorno.add(map.get("Operador"));
        retorno.add(map.get("Recepcionista"));

        return retorno;

    }

    @GetMapping(value = "/funcionarios/aniversariantes")
    public List<List<FuncionarioToPrint>> consultarAniversariantes(@RequestParam String meses) {
        String mesesIndividuais[] = meses.split(",");
        System.out.println(mesesIndividuais[0]);

        List<List<FuncionarioToPrint>> listaAniversariantes = new ArrayList<>();

        for (int i = 0; i < mesesIndividuais.length; i++) {
            listaAniversariantes.add(Utils.listaAniversariantes(funcionarios, mesesIndividuais[i]));
        }

        return listaAniversariantes;
    }

    @GetMapping(value = "/funcionarios/maiorIdade")
    public FuncionarioMaisVelho funcionarioMaiorIdade() {

        int funcMaisVelho = Utils.funcionarioMaiorIdade(funcionarios);

        FuncionarioMaisVelho maisVelho = new FuncionarioMaisVelho(funcionarios.get(funcMaisVelho).getNome(), Utils.calcularIdade(funcionarios.get(funcMaisVelho).getDataNascimento()));
        return maisVelho;
    }

    @GetMapping(value = "/funcionarios/ordemAlfabetica")
    public List<FuncionarioToPrint> ordemAlfabetica() {
        List<Funcionario> emOrdem = funcionarios;
        Utils.ordenarEmOrdemAlfabetica(emOrdem);
        return convertFuncionarioToFuncionarioToPrint.converterFuncionario(emOrdem);

    }

    @GetMapping(value = "/funcionarios/salariosTotais")
    public totalSalarios calcularTotalSalarios() {
        totalSalarios total = new totalSalarios(Utils.totalSalarios(funcionarios));
        return total;
    }

    @GetMapping(value = "/funcionarios/salariosMinimos")
    public List<FuncionarioSalariosMinimos> calcularSalariosMinimos() {
        return convertFuncionarioToFuncionarioComSalariosMinimos.converter(funcionarios);
    }
}
