#include <stdio.h>

// Declaración de la función externa en ensamblador
extern double seno_simd(double angle);

int main() {
    double angulo;
    printf("Ingrese el ángulo en grados: ");
    scanf("%lf", &angulo);

    double resultado = seno_simd(angulo);
    printf("sin(%.2f°) ≈ %.6f\n", angulo, resultado);
    return 0;
}
