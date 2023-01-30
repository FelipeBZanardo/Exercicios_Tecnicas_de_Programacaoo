import java.time.Duration;
import java.time.Instant;

public class Main {

    /*Meça o tempo de execução de um bloco de código usando a classe Duration (Resposta: envie o método main)*/

    public static void main(String[] args) {

        Instant instantInicial = Instant.now();

        try {
            Thread.sleep(5500);
        } catch (InterruptedException ex) {
            System.out.println("\nErro ao executar o método sleep\n");
        }

        Instant instantFinal = Instant.now();

        Duration tempoExecucao = Duration.between(instantInicial, instantFinal);
        System.out.println("Tempo de execução do bloco try/catch: " + tempoExecucao.toMillis() + " milisegundos");

    }
}
