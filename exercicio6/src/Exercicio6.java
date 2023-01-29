import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Exercicio6 {
    /*Para gestão dos períodos de vacinação, você é responsável por criar um programa que
    receba a data de vacina e imprima as próximas 3 doses baseado nas seguintes regras:
        - As doses devem ser ministradas de 3 em 3 meses;
        - Como os postos de vacinação só abrem em dias da semana se a data da vacinação for sábado,
        deve ser antecipada para sexta, caso dê num domingo deve ser ministrada na segunda.
        (Resposta: via github, cole o link do projeto)*/

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataPrimeiraDose = obterDataValida(formato);
        int quantidadeDosesFuturas = 3;
        long periodoVacinaEmMeses = 3;
        LocalDate[] proximasDoses = obterDatasProximasVacinas(dataPrimeiraDose,quantidadeDosesFuturas, periodoVacinaEmMeses);

        for (int i = 0; i < proximasDoses.length; i++) {
            System.out.printf("Dose %d: %s%n", (i+1), proximasDoses[i].format(formato));
        }

    }

    private static LocalDate obterDataValida(DateTimeFormatter formato){
        while(true){
            try{
                System.out.print("Entre com a data da vacina no formato dd/MM/yyyy: ");
                String data1String = SCANNER.nextLine();
                return LocalDate.parse(data1String, formato);
            } catch (DateTimeParseException e){
                System.out.println("\nFormato de data inválido. Digite novamente\n");
            }
        }
    }

    private static LocalDate[] obterDatasProximasVacinas(LocalDate dataPrimeiraDose, int quantidadeDosesFuturas, long periodoVacinaEmMeses){
        LocalDate[] datasProximasDoses = new LocalDate[quantidadeDosesFuturas];

        for (int i = 1; i <= quantidadeDosesFuturas; i++) {
            LocalDate proximaVacina = dataPrimeiraDose.plusMonths(i*periodoVacinaEmMeses);
            if(proximaVacina.getDayOfWeek().equals(DayOfWeek.SATURDAY))
                proximaVacina = proximaVacina.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            if(proximaVacina.getDayOfWeek().equals(DayOfWeek.SUNDAY))
                proximaVacina = proximaVacina.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            datasProximasDoses[i-1] = proximaVacina;
        }
        return datasProximasDoses;
    }
}
