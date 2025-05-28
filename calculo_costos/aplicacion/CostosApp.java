import java.util.Scanner;

public class CostosApp {

    public static double leerDoubleLimpio(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String input = sc.nextLine().replace(".", "").replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada inválida. Por favor ingrese solo números.");
            }
        }
    }

    public static double calcularPuntoEquilibrio(double costosFijos, double precioUnitario, double costoVariableUnitario) {
        if (precioUnitario <= costoVariableUnitario) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor al costo variable unitario.");
        }
        return costosFijos / (precioUnitario - costoVariableUnitario);
    }

    public static double calcularEstadoCostos(double materiaPrimaUtilizada, double manoObraDirecta, double costosIndirectos, double inventarioInicial, double inventarioFinal) {
        return (materiaPrimaUtilizada + manoObraDirecta + costosIndirectos) + (inventarioInicial - inventarioFinal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Calcular Punto de Equilibrio");
            System.out.println("2. Calcular Estado de Costos de Producción");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine().trim();

            switch (opcion) {
                case "1":
                    boolean repetir;
                    do {
                        repetir = false;
                        System.out.println("\n=== Cálculo de Punto de Equilibrio ===");

                        double costosFijos = leerDoubleLimpio(sc, "Ingrese los Costos Fijos Totales: ");
                        double precioUnitario = leerDoubleLimpio(sc, "Ingrese el Precio de Venta por Unidad: ");
                        double costoVariable = leerDoubleLimpio(sc, "Ingrese el Costo Variable por Unidad: ");

                        try {
                            double puntoEquilibrio = calcularPuntoEquilibrio(costosFijos, precioUnitario, costoVariable);
                            System.out.printf("Punto de Equilibrio en unidades: %.2f\n", puntoEquilibrio);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error en el cálculo: " + e.getMessage());
                            System.out.print("¿Desea intentarlo de nuevo? (s/n): ");
                            String respuesta = sc.nextLine().trim().toLowerCase();
                            if (respuesta.equals("s")) {
                                repetir = true;
                                System.out.println();
                            }
                        }
                    } while (repetir);
                    break;

                case "2":
                    System.out.println("\n=== Cálculo de Estado de Costos de Producción ===");
                    System.out.println("Ejemplo: Materiales Usados como Madera, Harina, Telas, etc. durante la producción.");

                    double materiaPrima = leerDoubleLimpio(sc, "Ingrese el valor total de los materiales usados en producción: ");
                    double manoObra = leerDoubleLimpio(sc, "Ingrese Mano de Obra Directa: ");
                    double costosIndirectos = leerDoubleLimpio(sc, "Ingrese Costos Indirectos de Fabricación: ");
                    double inventarioInicial = leerDoubleLimpio(sc, "Ingrese Inventario Inicial de Producción: ");
                    double inventarioFinal = leerDoubleLimpio(sc, "Ingrese Inventario Final de Producción: ");

                    double estadoCostos = calcularEstadoCostos(materiaPrima, manoObra, costosIndirectos, inventarioInicial, inventarioFinal);
                    System.out.printf("Costo Total de Producción: %.2f\n", estadoCostos);
                    break;

                case "3":
                    continuar = false;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        sc.close();
    }
}
