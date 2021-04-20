import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {

        LocalDate agora = LocalDate.now();
        System.out.println(agora);
        System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        LocalDate data = LocalDate.of(2099, Month.JANUARY, 25);
        System.out.println(data);

        Period periodo = Period.between(agora, data);
        System.out.println(periodo);

    }
}