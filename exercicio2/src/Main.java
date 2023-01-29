import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

public class Main {

    /*Meça o tempo de execução de um bloco de código usando a classe Duration (Resposta: envie o método main)*/

    public static void main(String[] args) {

        long tempoInicial = System.currentTimeMillis();

        try {
            Thread.sleep(5500);
        } catch (InterruptedException ex) {
            System.out.println("\nErro ao executar o método sleep\n");
        }

        long tempoFinal = System.currentTimeMillis();

        Instant instantInicial = Instant.ofEpochMilli(tempoInicial);
        Instant instantFinal = Instant.ofEpochMilli(tempoFinal);

        Duration tempoExecucao = Duration.between(instantInicial, instantFinal);
        System.out.println("Tempo de execução do bloco try/catch: " + tempoExecucao.toMillis() + " milisegundos");

    }
}
