import java.util.Random;

public class IdDoctorGenerator {
    private static final String PREFIJO = "ZNH";
    private static final String SUFIJO = "MD";
    private static final Random random = new Random();

    public static String IdZaunGenerator() {
        return String.format("%s-%d%s%d-%s%s",
                PREFIJO,
                random.nextInt(10),
                generarLetra(),
                random.nextInt(10),
                SUFIJO,
                generarLetra()
        );
    }

    private static char generarLetra() {
        return (char) ('A' + random.nextInt(26)); // Letra aleatoria de A-Z
    }
}