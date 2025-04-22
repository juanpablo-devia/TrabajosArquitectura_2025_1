#Programa que ilustra el uso de la convencion de llamadas de System V
.data

mensaje: .asciz "Numero1 %d numero2 %d \r\n"

.text
.global main
.extern printf        #similar al include stdio.h

main:
_start:
    subq $8, %rsp     #Alineamos los datos

    mov $4, %rax
    mov $5, %rbx

    movq $mensaje, %rdi
    movq %rax, %rsi
    movq %rbx, %rdx


    # RAX se pone en 0 para indicar que necesitamos 0 registros de punto flotante
    movq $0, %rax     #rax=0  toca memoria
    xorq %rax. %rax   #rax=0  no toca memoria

    call printf

    addq $8, %rsp

    #Llamamos la funcion salir
    call salir


salir:

    #Salir al sistema
    mov $60, %rax
    mov $0, %rdi
    syscall
    ret
