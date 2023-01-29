import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Main {
    /*Converta um objeto Instant para um LocalDateTime e vice-versa. (resposta: envie o método main)*/

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse("28/01/2023 13:50", formatter);
        ZoneOffset zoneOffsetDataHora = ZoneId.systemDefault().getRules().getOffset(dataHora);

        Instant dataHoraInstant = dataHora.toInstant(zoneOffsetDataHora);

        LocalDateTime dataHoraConvertida = LocalDateTime.ofInstant(dataHoraInstant, ZoneId.systemDefault());

        System.out.println(dataHora.format(formatter) + "(LocalDateTime) convertida para Instant(UTC): " + dataHoraInstant);
        System.out.println(dataHoraInstant + "(Instant) convertida para LocalDateTime: " + dataHoraConvertida.format(formatter));
    }
}
