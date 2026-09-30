import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ServicioEmpleados servicio =
                new ServicioEmpleados(
                        "data/job_salary_prediction_dataset.csv"
                );

        int opcionPrincipal;

        do {

            System.out.println("\n======================================");
            System.out.println("        PROYECTO SALARY - JAVA");
            System.out.println("======================================");
            System.out.println("1. Predicate y Filter");
            System.out.println("2. Function y Map");
            System.out.println("3. Consumer");
            System.out.println("4. BiFunction");
            System.out.println("5. Stream y Collect");
            System.out.println("6. Estadisticas");
            System.out.println("7. Mostrar todos los empleados");
            System.out.println("8. Salir");
            System.out.println("======================================");
            System.out.print("Seleccione una opcion: ");

            opcionPrincipal = teclado.nextInt();

            switch (opcionPrincipal) {

                case 1:
                    menuPredicate(teclado, servicio);
                    break;

                case 2:
                    menuFunction(teclado, servicio);
                    break;

                case 3:
                    menuConsumer(teclado, servicio);
                    break;

                case 4:
                    menuBiFunction(teclado, servicio);
                    break;

                case 5:
                    menuStream(teclado, servicio);
                    break;

                case 6:
                    menuEstadisticas(teclado, servicio);
                    break;

                case 7:
                    servicio.mostrarTodos();
                    break;

                case 8:
                    System.out.println(
                            "Programa finalizado."
                    );
                    break;

                default:
                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcionPrincipal != 8);

        teclado.close();
    }

    // ============================================================
    // MENU PREDICATE
    // ============================================================

    public static void menuPredicate(
            Scanner teclado,
            ServicioEmpleados servicio) {

        int opcion;

        do {

            System.out.println("\n========== PREDICATE Y FILTER ==========");
            System.out.println("1. Salario mayor a 150000");
            System.out.println("2. Experiencia mayor a 10");
            System.out.println("3. Trabajadores remotos");
            System.out.println("4. Educacion PhD");
            System.out.println("5. Mas de 10 certificaciones");
            System.out.println("6. Industria Healthcare");
            System.out.println("7. Industria Technology");
            System.out.println("8. Empresas Enterprise");
            System.out.println("9. Ubicacion USA");
            System.out.println("10. Cargo AI Engineer");
            System.out.println("11. Volver");
            System.out.print("Seleccione: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    servicio.salarioMayor150000();
                    break;

                case 2:
                    servicio.experienciaMayor10();
                    break;

                case 3:
                    servicio.trabajadoresRemotos();
                    break;

                case 4:
                    servicio.educacionPhD();
                    break;

                case 5:
                    servicio.masDe10Certificaciones();
                    break;

                case 6:
                    servicio.industriaHealthcare();
                    break;

                case 7:
                    servicio.industriaTechnology();
                    break;

                case 8:
                    servicio.empresasEnterprise();
                    break;

                case 9:
                    servicio.ubicacionUSA();
                    break;

                case 10:
                    servicio.cargoAIEngineer();
                    break;

                case 11:
                    break;

                default:
                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcion != 11);
    }

    // ============================================================
    // MENU FUNCTION
    // ============================================================

    public static void menuFunction(
            Scanner teclado,
            ServicioEmpleados servicio) {

        int opcion;

        do {

            System.out.println("\n========== FUNCTION Y MAP ==========");
            System.out.println("1. Cargos en mayusculas");
            System.out.println("2. Lista de salarios");
            System.out.println("3. Lista de cargos");
            System.out.println("4. Descripcion de empleados");
            System.out.println("5. Lista de experiencia");
            System.out.println("6. Cargo y salario");
            System.out.println("7. Volver");
            System.out.print("Seleccione: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    servicio.cargosMayusculas();
                    break;

                case 2:
                    servicio.listaSalarios();
                    break;

                case 3:
                    servicio.listaCargos();
                    break;

                case 4:
                    servicio.descripcionEmpleados();
                    break;

                case 5:
                    servicio.listaExperiencia();
                    break;

                case 6:
                    servicio.cargoYSalario();
                    break;

                case 7:
                    break;

                default:
                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcion != 7);
    }

    // ============================================================
    // MENU CONSUMER
    // ============================================================

    public static void menuConsumer(
            Scanner teclado,
            ServicioEmpleados servicio) {

        int opcion;

        do {

            System.out.println("\n========== CONSUMER ==========");
            System.out.println("1. Mostrar todos");
            System.out.println("2. Mostrar empleados remotos");
            System.out.println(
                    "3. Salario superior al promedio"
            );
            System.out.println("4. Reporte detallado");
            System.out.println("5. Volver");
            System.out.print("Seleccione: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    servicio.consumerTodos();
                    break;

                case 2:
                    servicio.consumerRemotos();
                    break;

                case 3:
                    servicio.salarioMayorPromedio();
                    break;

                case 4:
                    servicio.reporteDetallado();
                    break;

                case 5:
                    break;

                default:
                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcion != 5);
    }

    // ============================================================
    // MENU BIFUNCTION
    // ============================================================

    public static void menuBiFunction(
            Scanner teclado,
            ServicioEmpleados servicio) {

        int opcion;

        do {

            System.out.println("\n========== BIFUNCTION ==========");
            System.out.println("1. Sumar dos salarios");
            System.out.println("2. Combinar cargo y educacion");
            System.out.println("3. Comparar dos salarios");
            System.out.println("4. Promedio de dos salarios");
            System.out.println("5. Volver");
            System.out.print("Seleccione: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    System.out.print(
                            "Ingrese primer salario: "
                    );

                    double salario1 =
                            teclado.nextDouble();

                    System.out.print(
                            "Ingrese segundo salario: "
                    );

                    double salario2 =
                            teclado.nextDouble();

                    servicio.sumarSalarios(
                            salario1,
                            salario2
                    );

                    break;

                case 2:

                    servicio.combinarCargoEducacion();

                    break;

                case 3:

                    System.out.print(
                            "Ingrese primer salario: "
                    );

                    double salarioA =
                            teclado.nextDouble();

                    System.out.print(
                            "Ingrese segundo salario: "
                    );

                    double salarioB =
                            teclado.nextDouble();

                    servicio.compararSalarios(
                            salarioA,
                            salarioB
                    );

                    break;

                case 4:

                    System.out.print(
                            "Ingrese primer salario: "
                    );

                    double salarioX =
                            teclado.nextDouble();

                    System.out.print(
                            "Ingrese segundo salario: "
                    );

                    double salarioY =
                            teclado.nextDouble();

                    servicio.promedioDosSalarios(
                            salarioX,
                            salarioY
                    );

                    break;

                case 5:
                    break;

                default:
                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcion != 5);
    }

    // ============================================================
    // MENU STREAM
    // ============================================================

    public static void menuStream(
            Scanner teclado,
            ServicioEmpleados servicio) {

        int opcion;

        do {

            System.out.println("\n========== STREAM Y COLLECT ==========");
            System.out.println("1. Cargos diferentes");
            System.out.println("2. Agrupar por cargo");
            System.out.println("3. Agrupar por educacion");
            System.out.println("4. Contar por industria");
            System.out.println("5. Salario total por cargo");
            System.out.println("6. Coleccion de empleados remotos");
            System.out.println("7. Volver");
            System.out.print("Seleccione: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    servicio.cargosDistintos();
                    break;

                case 2:
                    servicio.agruparPorCargo();
                    break;

                case 3:
                    servicio.agruparPorEducacion();
                    break;

                case 4:
                    servicio.contarPorIndustria();
                    break;

                case 5:
                    servicio.salarioTotalPorCargo();
                    break;

                case 6:
                    servicio.coleccionRemotos();
                    break;

                case 7:
                    break;

                default:
                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcion != 7);
    }

    // ============================================================
    // MENU ESTADISTICAS
    // ============================================================

    public static void menuEstadisticas(
            Scanner teclado,
            ServicioEmpleados servicio) {

        int opcion;

        do {

            System.out.println("\n========== ESTADISTICAS ==========");
            System.out.println("1. Salario total");
            System.out.println("2. Salario promedio");
            System.out.println("3. Salario maximo");
            System.out.println("4. Salario minimo");
            System.out.println("5. Experiencia promedio");
            System.out.println("6. Promedio de certificaciones");
            System.out.println("7. Promedio de habilidades");
            System.out.println(
                    "8. Cargo con mayor salario promedio"
            );
            System.out.println(
                    "9. Industria con mayor salario promedio"
            );
            System.out.println(
                    "10. Educacion con mayor salario promedio"
            );
            System.out.println("11. Top 10 salarios");
            System.out.println(
                    "12. Total salarial por modalidad"
            );
            System.out.println(
                    "13. Total salarial por industria"
            );
            System.out.println(
                    "14. Total salarial por educacion"
            );
            System.out.println(
                    "15. Ranking de industrias"
            );
            System.out.println("16. Volver");
            System.out.print("Seleccione: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    servicio.salarioTotal();
                    break;

                case 2:
                    servicio.salarioPromedio();
                    break;

                case 3:
                    servicio.salarioMaximo();
                    break;

                case 4:
                    servicio.salarioMinimo();
                    break;

                case 5:
                    servicio.experienciaPromedio();
                    break;

                case 6:
                    servicio.certificacionesPromedio();
                    break;

                case 7:
                    servicio.habilidadesPromedio();
                    break;

                case 8:
                    servicio.cargoMayorPromedio();
                    break;

                case 9:
                    servicio.industriaMayorPromedio();
                    break;

                case 10:
                    servicio.educacionMayorPromedio();
                    break;

                case 11:
                    servicio.top10Salarios();
                    break;

                case 12:
                    servicio.totalPorModalidad();
                    break;

                case 13:
                    servicio.totalPorIndustria();
                    break;

                case 14:
                    servicio.totalPorEducacion();
                    break;

                case 15:
                    servicio.rankingIndustrias();
                    break;

                case 16:
                    break;

                default:
                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcion != 16);
    }
}