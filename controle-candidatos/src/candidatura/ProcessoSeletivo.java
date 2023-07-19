package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo Seletivo");
        String [] candidatos = {"FELIPE", "MARCELO", "MAURICIO", "ANNA BEATRIZ", "BIANCA", "MATHEUS", "JULIANA", "ARTHUR", "RAQUEL", "RODOLFO"};

        for (String candidato: candidatos){
            entrarEmContato(candidato);
        }

        // analisarCandidato(1560.0);
       // analisarCandidato(2000.0);
        //analisarCandidato(2200.0);

        //selecaoCandidatos();
    }
    static void entrarEmContato(String candidato){
        int tentativasRealizadas=1;
        boolean continuarTentando=true;
        boolean atendeu=false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else {
                System.out.println("Contato realizado com sucesso!");
            }

        }while (continuarTentando && tentativasRealizadas<3);
        if (atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
        }else {
            System.out.println("Não conseguimos contato com " + candidato + ", número maximo de tentativas " + tentativasRealizadas + " realizadas.");
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCELO", "MAURICIO", "ANNA BEATRIZ", "BIANCA", "MATHEUS", "JULIANA", "ARTHUR", "RAQUEL", "RODOLFO"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salario " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga\n");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA CANDIDATO");
        } else if (salarioBase==salarioPretendido) {
            System.out.println("LIGAR PARA CANDIDATO E NEGOCIAR");
        }else {
            System.out.println("AGUARDAR RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
