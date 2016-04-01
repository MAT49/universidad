define(first,14)
define(second,56)
define(third,64)
define(x_r,l0)
define(y_r,l1)
define(i_r,l2)
define(max_r,l4)


	.global main
main:
	save %sp, -96, %sp
	
	mov -2, %i_r		!initialize x = %i_r
	mov 0, %y_r			!initialize y = 0
	mov 0, %max_r		!initialize max = 0
	ba test
	mov %i_r, %o0       !x
	
loop:	
	cmp %y_r, %max_r
	bg,a next
	mov %y_r, %max_r
	
next:	
	mov %i_r, %o1          !another x
	call .mul              !(x^2)
	nop
	mov %i_r, %o1          !another x
	call .mul              !(x^3)
	nop
	mov %o0, %x_r          !result in %x_r
	mov %i_r, %o0          !initialize x
	mov %i_r, %o1          !another x
	call .mul              !(x^2)
	nop
	mov first, %o1             !14 
	call .mul              !14(x^2)
	nop
	sub %x_r, %o0, %x_r    !(x^3)-14(x^2)
	mov second, %o1             !56
	mov %i_r, %o0          !x
	call .mul              !56*x
	nop
	add %x_r, %o0, %x_r   	!(x^3)-14(x^2)+56x
	mov third, %l3              !64
	sub %x_r, %l3, %y_r     !(x^3)-14(x^2)+56x-64, stored in %y_r	
	add %i_r, 1, %i_r		!counter++

test:
	cmp %i_r, 8			!compare counter with 8
	ble,a loop			!loop if counter <= 8
	mov %i_r, %o0       !initialize x, first step of loop
		
	mov 1, %g1
	ta 0
