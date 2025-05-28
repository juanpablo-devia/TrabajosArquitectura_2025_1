#ifndef COSTOS_H
#define COSTOS_H

// Función para calcular el punto de equilibrio
double calcular_punto_equilibrio(double costos_fijos, double precio_unitario, double costo_variable_unitario);

// Función para calcular el estado de costos de producción
double calcular_estado_costos(double materia_prima_utilizada, double mano_obra_directa, double costos_indirectos, double inventario_inicial, double inventario_final);

#endif
