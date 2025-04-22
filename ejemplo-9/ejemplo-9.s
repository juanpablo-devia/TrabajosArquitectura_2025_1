
.text

.global calculadoraCiclos

calculadoraCiclos:
   # xmm0 funcion ( xmm0, rsi, xmm1 )
    mulss %xmm1, %xmm0    # SS significa S (escalar: escalar) y S (single: float)

# Queremos realizar n ciclos (rsi = 5)
ciclos:
  cmp $0, %rdi
  je fin

  addss %xmm0, %xmm0    # xmm0 = xmm0 + xmm0

  dec %rdi
  jmp ciclos

fin:

  ret
