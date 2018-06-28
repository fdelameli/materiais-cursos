/*

KeyGhost

Designed by Shane Tolmie Apr 99.

Microprocessor: see mainkg.c

Compiled with:	see mainkg.c

Overall goal: 	Delay Routines

*/

#ifndef __DELAY_C
#define __DELAY_C


#if defined(_16F876) || defined(_16F877) || defined(_16F873) || defined(_16F874) 
	#include <pic.h>
#else
	#include	<pic18.h>
#endif
#include 	"main.h"
#include	"delay.h"


#define	MHZ	*1000000			/* number of kHz in a MHz */
#define	KHZ	*1000			/* number of kHz in a kHz */

 #if	PIC_CLK >= 12MHZ
  #if PIC_CLK >= 20MHZ
   void DelayUs(unsigned char x)
   {
    unsigned char count,_dcnt;
    for(count=0;count<x;count++)
    {
     _dcnt= ((PIC_CLK)/(8MHZ));     //-- 1us worth of delay
     while(--_dcnt !=0);
    }
   }
  #else
   void DelayUs(unsigned char x) { 
	  unsigned char _dcnt; 
	  _dcnt = (x)*((PIC_CLK)/(12MHZ)); 
	  while(--_dcnt != 0) continue; 
	   }
  #endif
 #else

  void DelayUs(unsigned char x)	{
		unsigned char _dcnt; 
	    _dcnt = (x)/(12MHZ/(PIC_CLK))|1; 
			  while(--_dcnt != 0) 
				  continue; 
		}
 #endif


/* void DelayUs(unsigned char x) { 
	unsigned char delayus_variable;

	delayus_variable=(unsigned char)(x/DelayDivisor); 
	WaitFor1Us; 
	asm("decfsz delayus_variable,f"); 
	Jumpback;

#define FREQ_MULT	(PIC_CLK)/(4)

unsigned char _dcnt; 
  if(x>=4) _dcnt=(x*(FREQ_MULT)/2); 
  else _dcnt=1; 
  while(--_dcnt > 0) {
	asm("nop");
	asm("nop");
	continue; }
}
*/

void DelayBigUs(unsigned int cnt)
{
	unsigned char	i;

	i = (unsigned char)(cnt>>8);
	while(i>=1) 
	{
		i--;		
		DelayUs(253);
		CLRWDT();
	} 
	DelayUs((unsigned char)(cnt & 0xFF));
}


void DelayMs(unsigned char cnt)
{
	unsigned char	i;
	do {
		i = 4;
		do {
			DelayUs(250);
			CLRWDT();
		} while(--i);
	} while(--cnt);
}
/*
//this copy is for the interrupt function
void DelayMs_interrupt(unsigned char cnt)
{
	unsigned char	i;
	do {
		i = 4;
		do {
			DelayUs(250);
		} while(--i);
	} while(--cnt);
}
*/

void DelayBigMs(unsigned int cnt)
{
	unsigned char	i;
	do {
		i = 4;
		do {
			DelayUs(250);
			CLRWDT();
		} while(--i);
	} while(--cnt);
}


void DelayS(unsigned char cnt)
{
	unsigned char i;
	do {
		i = 4;
		do {
			DelayMs(250);
			CLRWDT();
		} while(--i);
	} while(--cnt);
}


#endif

