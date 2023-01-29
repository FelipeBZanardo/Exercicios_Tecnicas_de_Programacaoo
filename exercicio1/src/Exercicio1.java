import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Exercicio1 {
    /*Crie um programa para calcular o número de anos, meses e dias entre duas datas específicas,
    recebidas pelo usuário no formato dd/MM/yyyy, usando a classe Period.*/

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data1 = obterDataValida("primeira", formatter);
        LocalDate data2 = obterDataValida("segunda", formatter);

        Period period = Period.between(data1, data2);
        System.out.printf("%nA diferença entre as duas datas é de %d ano(s), %d mes(es) e %d dia(s)",
                period.getYears(), period.getMonths(), period.getDays());

    }

    private static LocalDate obterDataValida(String posicaoData, DateTimeFormatter formato){
        while(true){
            try{
                System.out.print("Entre com a " + posicaoData + " data no formato dd/MM/yyyy: ");
                String data1String = SCANNER.nextLine();
                return LocalDate.parse(data1String, formato);
            } catch (DateTimeParseException e){
                System.out.println("\nFormato de data inválido. Digite novamente\n");
            }
        }
    }
}
