/*
	Ha K Hwang
	CS3320 Midterm
	4/1/2015
	This C program takes brainfuck program as source and compiles it into a C program called temp.c,
	and makes object file called "midterm", which gets automatically executed, 
	and prints out the characters in English.
	
	The output will look like this:
	
	% ./bfc2 < hello.bf

	Hello World!

*/
#include <stdio.h>

int main() 
{

	unsigned char buffer[30000];
	unsigned char *cp;		//pointer cp
	cp = buffer;		//pointer cp = beginning address of buffer[30000]
	
	FILE *fp;	//file pointer
	fp = fopen("./temp.c", "w+"); 	//create file at file pointer and write streams
	
	//print these words in temp.c
	fputs( "#include <stdio.h>\n", fp );
	fputs( "int main() {\n", fp );
	
	fputs( "unsigned char buffer[30000];\n", fp );
	fputs( "unsigned char *cp;		//pointer cp\n", fp );
	fputs( "cp = buffer;		//pointer cp = beginning address of buffer[30000]\n", fp );

	//took like 2 hours to figure out why this thing was looping forever with EOF...
	//while ( (*cp = getchar()) != EOF )		
	//http://stackoverflow.com/questions/13694394/while-c-getcfile-eof-loop-wont-stop-executing
	while ( (*cp = getchar()) != 0xff )		//0xff is char equivalent of EOF (int)
	{	
		//fputs("%c", *cp);		//test value at cp
		//translates BF code to C
		switch ( *cp )
		{
			case '>':            
				fputs( "cp++; ", fp );
				break;
			case '<':             
				fputs( "cp--; ", fp );
				break;
			case '+':             
				fputs( "(*cp)++; ", fp );
				break;
			case '-':            
				fputs( "(*cp)--; ", fp );
				break;
			case '.': 		//took like 4 hours to figure this one out...tricky!!!
				fputs( "fputc(*cp, stdout); ", fp);
				//NEED TO CONVERT TO : printf ("%c", (*cp));
				
				//some of my failed attempts below
				//fputs( "%c", *cp);	
				//fputs( "printf("%c", *cp); ", fp);
				//fputs( "printf ((*cp); ", fp ) );
				//fputs( "     printf ("%c", (*cp));       ", fp);
				break;
			case ',':       
				*cp = (unsigned char)fgetc(stdin);
				break;
			case '[':          
				fputs ( "while (*cp){ ", fp );
				break;
			case ']':        
				fputs ( "} ", fp );
				break;
			default:	//if not valid bf syntax, ignore
				break;
		}	
		
	}
	fputs( "return(0);\n", fp );
	fputs( "}", fp );
	fclose(fp);		//close file
	
	system( "gcc -o midterm temp.c" );
	system( "sudo chmod 755 midterm temp.c" );
	system( "./midterm" );
	
	
	return(0);	
}