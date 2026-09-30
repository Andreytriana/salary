import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServicioEmpleados {

    private List<Empleado> empleados;

    public ServicioEmpleados(String archivo) {
        empleados = LectorCSVFuncional.leerCSV(archivo);
    }

    // ============================================================
    // MÉTODO GENERAL
    // ============================================================

    public void mostrarTodos() {

        empleados.stream()
                .forEach(System.out::println);
    }

    // ============================================================
    // MODULO 1 - PREDICATE Y FILTER
    // ============================================================

    // 1. Salario mayor a 150000
    public void salarioMayor150000() {

        Predicate<Empleado> filtro =
                e -> e.getSalary() > 150000;

        empleados.stream()
                .filter(filtro)
                .forEach(System.out::println);
    }

    // 2. Experiencia mayor a 10 años
    public void experienciaMayor10() {

        Predicate<Empleado> filtro =
                e -> e.getExperienceYears() > 10;

        empleados.stream()
                .filter(filtro)
                .forEach(System.out::println);
    }

    // 3. Trabajo remoto
    public void trabajadoresRemotos() {

        Predicate<Empleado> filtro =
                e -> e.getRemoteWork().equalsIgnoreCase("Yes")
                        || e.getRemoteWork().equalsIgnoreCase("Remote");

        empleados.stream()
                .filter(filtro)
                .forEach(System.out::println);
    }

    // 4. Educación PhD
    public void educacionPhD() {

        empleados.stream()
                .filter(e -> e.getEducationLevel()
                        .equalsIgnoreCase("PhD"))
                .forEach(System.out::println);
    }

    // 5. Más de 10 certificaciones
    public void masDe10Certificaciones() {

        empleados.stream()
                .filter(e -> e.getCertifications() > 10)
                .forEach(System.out::println);
    }

    // 6. Industria Healthcare
    public void industriaHealthcare() {

        empleados.stream()
                .filter(e -> e.getIndustry()
                        .equalsIgnoreCase("Healthcare"))
                .forEach(System.out::println);
    }

    // 7. Industria Technology
    public void industriaTechnology() {

        empleados.stream()
                .filter(e -> e.getIndustry()
                        .equalsIgnoreCase("Technology"))
                .forEach(System.out::println);
    }

    // 8. Empresas Enterprise
    public void empresasEnterprise() {

        empleados.stream()
                .filter(e -> e.getCompanySize()
                        .equalsIgnoreCase("Enterprise"))
                .forEach(System.out::println);
    }

    // 9. Ubicación USA
    public void ubicacionUSA() {

        empleados.stream()
                .filter(e -> e.getLocation()
                        .equalsIgnoreCase("USA"))
                .forEach(System.out::println);
    }

    // 10. Cargo AI Engineer
    public void cargoAIEngineer() {

        empleados.stream()
                .filter(e -> e.getJobTitle()
                        .equalsIgnoreCase("AI Engineer"))
                .forEach(System.out::println);
    }

    // ============================================================
    // MODULO 2 - FUNCTION Y MAP
    // ============================================================

    // 11. Cargos en mayúsculas
    public void cargosMayusculas() {

        Function<Empleado, String> funcion =
                e -> e.getJobTitle().toUpperCase();

        empleados.stream()
                .map(funcion)
                .forEach(System.out::println);
    }

    // 12. Lista de salarios
    public void listaSalarios() {

        Function<Empleado, Double> funcion =
                Empleado::getSalary;

        empleados.stream()
                .map(funcion)
                .forEach(System.out::println);
    }

    // 13. Lista de cargos
    public void listaCargos() {

        Function<Empleado, String> funcion =
                Empleado::getJobTitle;

        empleados.stream()
                .map(funcion)
                .forEach(System.out::println);
    }

    // 14. Descripción textual
    public void descripcionEmpleados() {

        Function<Empleado, String> funcion =
                e -> "Cargo: " + e.getJobTitle()
                        + " | Experiencia: "
                        + e.getExperienceYears()
                        + " | Salario: $"
                        + e.getSalary();

        empleados.stream()
                .map(funcion)
                .forEach(System.out::println);
    }

    // 15. Lista de experiencia
    public void listaExperiencia() {

        Function<Empleado, Double> funcion =
                Empleado::getExperienceYears;

        empleados.stream()
                .map(funcion)
                .forEach(System.out::println);
    }

    // 16. Cargo y salario
    public void cargoYSalario() {

        Function<Empleado, String> funcion =
                e -> e.getJobTitle()
                        + " - $" + e.getSalary();

        empleados.stream()
                .map(funcion)
                .forEach(System.out::println);
    }

    // ============================================================
    // MODULO 3 - CONSUMER
    // ============================================================

    // 17. Mostrar todos
    public void consumerTodos() {

        Consumer<Empleado> consumidor =
                e -> System.out.println(e);

        empleados.stream()
                .forEach(consumidor);
    }

    // 18. Mostrar empleados remotos
    public void consumerRemotos() {

        Consumer<Empleado> consumidor =
                e -> System.out.println(
                        e.getJobTitle()
                                + " - "
                                + e.getRemoteWork()
                );

        empleados.stream()
                .filter(e ->
                        e.getRemoteWork().equalsIgnoreCase("Yes")
                                || e.getRemoteWork().equalsIgnoreCase("Remote"))
                .forEach(consumidor);
    }

    // 19. Salario superior al promedio
    public void salarioMayorPromedio() {

        double promedio = empleados.stream()
                .mapToDouble(Empleado::getSalary)
                .average()
                .orElse(0);

        System.out.println("Salario promedio: $" + promedio);
        System.out.println("\nEmpleados con salario superior al promedio:");

        Consumer<Empleado> consumidor =
                e -> System.out.println(
                        e.getJobTitle()
                                + " - $"
                                + e.getSalary()
                );

        empleados.stream()
                .filter(e -> e.getSalary() > promedio)
                .forEach(consumidor);
    }

    // 20. Reporte detallado
    public void reporteDetallado() {

        Consumer<Empleado> consumidor =
                e -> System.out.println(
                        "Cargo: " + e.getJobTitle()
                                + " | Experiencia: "
                                + e.getExperienceYears()
                                + " años | Salario: $"
                                + e.getSalary()
                );

        empleados.stream()
                .forEach(consumidor);
    }

    // ============================================================
    // MODULO 4 - BIFUNCTION
    // ============================================================

    // 21. Sumar dos salarios
    public void sumarSalarios(double salario1, double salario2) {

        BiFunction<Double, Double, Double> funcion =
                (a, b) -> a + b;

        System.out.println(
                "Resultado: $" +
                        funcion.apply(salario1, salario2)
        );
    }

    // 22. Combinar cargo y educación
    public void combinarCargoEducacion() {

        BiFunction<String, String, String> funcion =
                (cargo, educacion) ->
                        "Cargo: " + cargo
                                + " | Educación: " + educacion;

        empleados.stream()
                .limit(10)
                .forEach(e ->
                        System.out.println(
                                funcion.apply(
                                        e.getJobTitle(),
                                        e.getEducationLevel()
                                )
                        )
                );
    }

    // 23. Comparar dos salarios
    public void compararSalarios(
            double salario1,
            double salario2) {

        BiFunction<Double, Double, String> funcion =
                (a, b) -> {

                    if (a > b) {
                        return "El primer salario es mayor.";
                    } else if (b > a) {
                        return "El segundo salario es mayor.";
                    } else {
                        return "Los salarios son iguales.";
                    }
                };

        System.out.println(
                funcion.apply(salario1, salario2)
        );
    }

    // 24. Promedio de dos salarios
    public void promedioDosSalarios(
            double salario1,
            double salario2) {

        BiFunction<Double, Double, Double> funcion =
                (a, b) -> (a + b) / 2;

        System.out.println(
                "Promedio: $" +
                        funcion.apply(salario1, salario2)
        );
    }

    // ============================================================
    // MODULO 5 - STREAM Y COLLECT
    // ============================================================

    // 25. Cargos diferentes
    public void cargosDistintos() {

        List<String> cargos =
                empleados.stream()
                        .map(Empleado::getJobTitle)
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());

        cargos.forEach(System.out::println);
    }

    // 26. Agrupar por cargo
    public void agruparPorCargo() {

        Map<String, List<Empleado>> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getJobTitle
                        ));

        resultado.forEach(
                (cargo, lista) ->
                        System.out.println(
                                cargo + " -> "
                                        + lista.size()
                        )
        );
    }

    // 27. Agrupar por educación
    public void agruparPorEducacion() {

        Map<String, List<Empleado>> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getEducationLevel
                        ));

        resultado.forEach(
                (educacion, lista) ->
                        System.out.println(
                                educacion + " -> "
                                        + lista.size()
                        )
        );
    }

    // 28. Contar por industria
    public void contarPorIndustria() {

        Map<String, Long> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getIndustry,
                                Collectors.counting()
                        ));

        resultado.forEach(
                (industria, cantidad) ->
                        System.out.println(
                                industria + " -> "
                                        + cantidad
                        )
        );
    }

    // 29. Salario total por cargo
    public void salarioTotalPorCargo() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getJobTitle,
                                Collectors.summingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.forEach(
                (cargo, salario) ->
                        System.out.println(
                                cargo + " -> $"
                                        + salario
                        )
        );
    }

    // 30. Colección de trabajadores remotos
    public void coleccionRemotos() {

        List<Empleado> remotos =
                empleados.stream()
                        .filter(e ->
                                e.getRemoteWork()
                                        .equalsIgnoreCase("Yes")
                                        ||
                                        e.getRemoteWork()
                                                .equalsIgnoreCase("Remote"))
                        .collect(Collectors.toList());

        System.out.println(
                "Cantidad de empleados remotos: "
                        + remotos.size()
        );

        remotos.stream()
                .limit(10)
                .forEach(System.out::println);
    }

    // ============================================================
    // MODULO 6 - ESTADISTICAS
    // ============================================================

    // 31. Salario total
    public void salarioTotal() {

        double total =
                empleados.stream()
                        .mapToDouble(Empleado::getSalary)
                        .sum();

        System.out.println(
                "Salario total: $" + total
        );
    }

    // 32. Salario promedio
    public void salarioPromedio() {

        double promedio =
                empleados.stream()
                        .mapToDouble(Empleado::getSalary)
                        .average()
                        .orElse(0);

        System.out.println(
                "Salario promedio: $" + promedio
        );
    }

    // 33. Salario máximo
    public void salarioMaximo() {

        double maximo =
                empleados.stream()
                        .mapToDouble(Empleado::getSalary)
                        .max()
                        .orElse(0);

        System.out.println(
                "Salario máximo: $" + maximo
        );
    }

    // 34. Salario mínimo
    public void salarioMinimo() {

        double minimo =
                empleados.stream()
                        .mapToDouble(Empleado::getSalary)
                        .min()
                        .orElse(0);

        System.out.println(
                "Salario mínimo: $" + minimo
        );
    }

    // 35. Experiencia promedio
    public void experienciaPromedio() {

        double promedio =
                empleados.stream()
                        .mapToDouble(
                                Empleado::getExperienceYears
                        )
                        .average()
                        .orElse(0);

        System.out.println(
                "Experiencia promedio: "
                        + promedio + " años"
        );
    }

    // 36. Promedio de certificaciones
    public void certificacionesPromedio() {

        double promedio =
                empleados.stream()
                        .mapToInt(
                                Empleado::getCertifications
                        )
                        .average()
                        .orElse(0);

        System.out.println(
                "Promedio de certificaciones: "
                        + promedio
        );
    }

    // 37. Promedio de habilidades
    public void habilidadesPromedio() {

        double promedio =
                empleados.stream()
                        .mapToInt(
                                Empleado::getSkillsCount
                        )
                        .average()
                        .orElse(0);

        System.out.println(
                "Promedio de habilidades: "
                        + promedio
        );
    }

    // 38. Cargo con mayor salario promedio
    public void cargoMayorPromedio() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getJobTitle,
                                Collectors.averagingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(
                        e -> System.out.println(
                                "Cargo: " + e.getKey()
                                        + " | Promedio: $"
                                        + e.getValue()
                        )
                );
    }

    // 39. Industria con mayor salario promedio
    public void industriaMayorPromedio() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getIndustry,
                                Collectors.averagingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(
                        e -> System.out.println(
                                "Industria: " + e.getKey()
                                        + " | Promedio: $"
                                        + e.getValue()
                        )
                );
    }

    // 40. Educación con mayor salario promedio
    public void educacionMayorPromedio() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getEducationLevel,
                                Collectors.averagingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(
                        e -> System.out.println(
                                "Educación: " + e.getKey()
                                        + " | Promedio: $"
                                        + e.getValue()
                        )
                );
    }

    // 41. Top 10 salarios
    public void top10Salarios() {

        empleados.stream()
                .sorted(
                        Comparator.comparingDouble(
                                Empleado::getSalary
                        ).reversed()
                )
                .limit(10)
                .forEach(
                        e -> System.out.println(
                                e.getJobTitle()
                                        + " - $"
                                        + e.getSalary()
                        )
                );
    }

    // 42. Total salarial por modalidad
    public void totalPorModalidad() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getRemoteWork,
                                Collectors.summingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.forEach(
                (modalidad, total) ->
                        System.out.println(
                                modalidad
                                        + " -> $"
                                        + total
                        )
        );
    }

    // 43. Total salarial por industria
    public void totalPorIndustria() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getIndustry,
                                Collectors.summingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.forEach(
                (industria, total) ->
                        System.out.println(
                                industria
                                        + " -> $"
                                        + total
                        )
        );
    }

    // 44. Total salarial por educación
    public void totalPorEducacion() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getEducationLevel,
                                Collectors.summingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.forEach(
                (educacion, total) ->
                        System.out.println(
                                educacion
                                        + " -> $"
                                        + total
                        )
        );
    }

    // 45. Ranking de industrias por salario
    public void rankingIndustrias() {

        Map<String, Double> resultado =
                empleados.stream()
                        .collect(Collectors.groupingBy(
                                Empleado::getIndustry,
                                Collectors.summingDouble(
                                        Empleado::getSalary
                                )
                        ));

        resultado.entrySet()
                .stream()
                .sorted(
                        Map.Entry
                                .<String, Double>comparingByValue()
                                .reversed()
                )
                .forEach(
                        e -> System.out.println(
                                e.getKey()
                                        + " -> $"
                                        + e.getValue()
                        )
                );
    }
}