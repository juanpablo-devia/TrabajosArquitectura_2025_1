.globl _start


.text

_start:


       mov $0x3F, %al
       mov $0xF3, %ah

       # Salir al Sistema
       mov $60, %rax
       xor %rdi, %rdi
       syscall
