
.data
mensaje: .asciz "%ld \n"

.text
.global main
.extern printf   #Indico que quiero usar la funcion printf de libc

main:

  subq $8, %rsp

  mov $4, %rax    # rax=4
  mov $5, %rbx    # rbx=5
  add %rbx, %rax  # rax=rax+rbx

  # Bloque de impresion
  # printf ("%ld \n", rax);
  #           rdi   , rsi

  mov $mensaje, %rdi
  mov %rax, %rdi
  xorq %rax, %rax
  call printf

  addq $8, %rsp


  mov $60, %rax   # Indico que vamos a usar la funcion exit
  mov $0, %rdi    # Indico que el argumento tiene un valor de 0
  syscall         # No es parte de ensamblador pero llama a las opciones del sistema


