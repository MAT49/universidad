define(a_r, l0)
define(b_r, l1)
define(c_r, l2)
define(x_r, l3)

!translate the following C while loop into assembly language

!while((a+b) * c <= x)
!{
!	x = x - 10;
!	c = (c * a) / b;
!}

	.global main
main:
	save %sp, -96, %sp
	mov 4, %a_r
	mov 2, %b_r
	mov 3, %c_r
	ba test
	mov 50, %x_r
loop:
	mov %c_r, %o0
	call .mul			!c = (c * a)
	mov %a_r, %o1		!delay slot for mul
	call .div			!(c * a) / b
	mov %b_r, %o1		!delay slot for div
	mov %o0, %c_r		!c = (c * a) / b
test:
	add %a_r, %b_r, %o0	!(a+b)
	mov %c_r, %o1
	call .mul			!(a+b) * c
	nop	
	cmp %o0, %x_r		!compares (a+b) * c <= x
	ble,a loop			!loops if above condition is true
	sub %x_r, 10, %x_r	!delay slot, first instruction in the loop
	
	mov 1, %g1
	ta 0