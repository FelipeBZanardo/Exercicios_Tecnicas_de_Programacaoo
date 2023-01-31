import java.time.Duration;
import java.time.Instant;

public class Main {
    /*Compare a diferença entre dois objetos Instant e imprima o resultado em
    Horas, Minutos e Segundos. (Resposta: envie o método main)*/

    public static void main(String[] args) {
        Instant instant1 = Instant.parse("2023-01-28T16:50:25Z");
        Instant instant2 = Instant.parse("2023-01-29T10:00:00Z");

        Duration duration = Duration.between(instant1, instant2);
        System.out.printf("%nA diferença entre os dois Instants é de %d hora(s), %d minuto(s) e %d segundo(s)%n",
                duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }
}
