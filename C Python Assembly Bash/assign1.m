define(a,14)
define(b,56)
define(c,64)
define(x,3)
define(x_r,l0)
define(y_r,l1)

.global main
main:
save %sp, -96, %sp
mov x, %o0              !initialize x
mov x, %o1              !another x
call .mul               !(x^2)
nop
mov x, %o1              !another x
call .mul               !(x^3)
nop
mov %o0, %x_r           !result in %l0
mov x, %o0              !initialize x
mov x, %o1              !another x
call .mul               !(x^2)
nop
mov a, %o1              !14 
call .mul               !14(x^2)
nop
sub %x_r, %o0, %x_r     !(x^3)-14(x^2)
mov b, %o1              !56
mov x, %o0              !x
call .mul               !56*x
nop
add %x_r, %o0, %x_r     !(x^3)-14(x^2)+56x
mov c, %l2              !64
sub %x_r, %l2, %y_r     !(x^3)-14(x^2)+56x-64, result in %l1

mov 1, %g1
ta 0
