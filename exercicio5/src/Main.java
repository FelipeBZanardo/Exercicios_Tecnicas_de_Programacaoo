import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    /*Crie um programa que recebe uma quantidade de segundos e converta e
    imprima em dias, horas, minutos e segundos. (Resposta: envie o método main)*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long segundos;

        while (true){
            try{
                System.out.print("\nDigite a quantidade de segundos: ");
                segundos = scanner.nextLong();
                break;
            }catch (InputMismatchException e){
                System.out.println("\nAceito apenas números. Digite novamente\n");
            }
        }

        Duration duration = Duration.of(segundos, ChronoUnit.SECONDS);
        System.out.printf("""
                %d segundo(s) equivale a:
                       %d dia(s)
                       %d hora(s)
                       %d minuto(s)
                       %d segundo(s)""",
                segundos, duration.toDays(), duration.toHours(), duration.toMinutes(), duration.toSeconds());

    }
}
