define(num_r, l0)   ! the number
define(field_r, l1) ! the extracted field
define(org_r, l2)   ! least significant bit of field
define(width_r, l3) ! width of field
define(mask_r, l4)  ! bit mask



.global main
main:
	save %sp, -96, %sp
	mov 0xff0, %num_r      
	mov 2, %org_r
	mov 3, %width_r
	mov 2, %o0
	
	ba test							!always executes below delay slot
	srl %num_r, %org_r, %num_r		!chops off unnecessary end digits

loop:
	call .mul				!2*2  !below is delay slot for mul		
	sub %width_r, 1, %width_r	!using %width_r as decrement comparison
	

test:
	cmp %width_r, 1		!compares %width_r with 1
	bg,a loop				!skips next line if false
	mov 2, %o1				!first instruction of loop
	
	sub %o0, 1, %mask_r		!%mask_r = 2^(%width_r) - 1
	and %num_r, %mask_r, %field_r	!masking non selected digits

	mov 1, %g1
	ta 0