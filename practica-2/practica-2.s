.section .rodata
pi_over_180: .double 0.017453292519943295
inv6:        .double 0.16666666666666666
inv120:      .double 0.008333333333333333

.section .text
.globl seno_simd

seno_simd:
    # xmm0 = ángulo en grados (pasado desde C)
    
    # xmm1 = π/180
    movsd pi_over_180(%rip), %xmm1
    mulsd %xmm1, %xmm0           # xmm0 = radianes

    # xmm2 = x = radianes
    movapd %xmm0, %xmm2

    # xmm3 = x^2
    movapd %xmm0, %xmm3
    mulsd %xmm0, %xmm3

    # xmm3 = x^3
    mulsd %xmm0, %xmm3

    # xmm4 = x
    movapd %xmm2, %xmm4

    # xmm5 = 1/6
    movsd inv6(%rip), %xmm5
    mulsd %xmm5, %xmm3
    subsd %xmm3, %xmm4           # xmm4 = x - x^3/6

    # xmm6 = x^2
    movapd %xmm0, %xmm6
    mulsd %xmm0, %xmm6

    # xmm6 = x^5 = x^2 * x^3
    mulsd %xmm3, %xmm6

    # xmm7 = 1/120
    movsd inv120(%rip), %xmm7
    mulsd %xmm7, %xmm6
    addsd %xmm6, %xmm4           # xmm4 = final result

    # Devolver el resultado en xmm0
    movapd %xmm4, %xmm0
    ret
