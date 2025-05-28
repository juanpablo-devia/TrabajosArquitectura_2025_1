#include "costos.h"

// Cálculo del punto de equilibrio
double calcular_punto_equilibrio(double costos_fijos, double precio_unitario, double costo_variable_unitario) {
    if (precio_unitario <= costo_variable_unitario) {
        return -1; // Error
    }
    return costos_fijos / (precio_unitario - costo_variable_unitario);
}

// Cálculo del estado de costos de producción
double calcular_estado_costos(double materia_prima_utilizada, double mano_obra_directa, double costos_indirectos, double inventario_inicial, double inventario_final) {
    double costo_total = materia_prima_utilizada + mano_obra_directa + costos_indirectos;
    costo_total += inventario_inicial;
    costo_total -= inventario_final;
    return costo_total;
}
