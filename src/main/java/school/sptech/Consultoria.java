package school.sptech;
import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public void contratar(Desenvolvedor desenvolvedor){
        if (vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double somaSalarios = 0.0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            somaSalarios += desenvolvedores.get(i).calcularSalario();
        }
        return somaSalarios;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int quantidade = 0;
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if(desenvolvedores.get(i) instanceof DesenvolvedorMobile){
                quantidade++;
            }
        }
        return quantidade;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> maiorSalario = new ArrayList<>();
        for (int i = 0; i < desenvolvedores.size(); i++) {
            if (desenvolvedores.get(i).calcularSalario() > salario){
                maiorSalario.add(desenvolvedores.get(i));
            }
        }
        return maiorSalario;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(!desenvolvedores.isEmpty()){
            int id = 0;
            double salario = desenvolvedores.get(0).calcularSalario();

            for (int i = 0; i < desenvolvedores.size(); i++) {
                if(salario > desenvolvedores.get(i).calcularSalario()){
                    salario = desenvolvedores.get(i).calcularSalario();
                    id = i;
                }
            }
            return desenvolvedores.get(id);
        }else {
            return null;
        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> escolhaDesenvolvedor = new ArrayList<>();
        for (Desenvolvedor desenvolvedore : desenvolvedores) {
            if (desenvolvedore instanceof DesenvolvedorMobile) {
                if (((DesenvolvedorMobile) desenvolvedore).getLinguagem().equals(tecnologia)) {
                    escolhaDesenvolvedor.add(desenvolvedore);
                } else if (((DesenvolvedorMobile) desenvolvedore).getPlataforma().equals(tecnologia)) {
                    escolhaDesenvolvedor.add(desenvolvedore);
                }
            } else if (desenvolvedore instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) desenvolvedore).getBackend().equals(tecnologia)) {
                    escolhaDesenvolvedor.add(desenvolvedore);
                } else if (((DesenvolvedorWeb) desenvolvedore).getFrontend().equals(tecnologia)) {
                    escolhaDesenvolvedor.add(desenvolvedore);
                } else if (((DesenvolvedorWeb) desenvolvedore).getSgbd().equals(tecnologia)) {
                    escolhaDesenvolvedor.add(desenvolvedore);
                }
            }
        }
        return escolhaDesenvolvedor;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double soma = 0.0;
        List<Desenvolvedor> salarioTech = buscarPorTecnologia(tecnologia);
        for (Desenvolvedor desenvolvedore : salarioTech) {
            soma += desenvolvedore.calcularSalario();
        }
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
