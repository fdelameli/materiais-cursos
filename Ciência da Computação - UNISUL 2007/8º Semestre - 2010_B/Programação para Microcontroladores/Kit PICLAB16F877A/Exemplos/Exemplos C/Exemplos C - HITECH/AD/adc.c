/*
 * Read the ADC on a 16C71.
 */


#include	<pic.h>
#include	"adc.h"


void
adc_read(unsigned char channel)
{

	ADCON0 = (channel << 3) + 0xC1;		// enable ADC, RC osc.
	ADGO = 1;
	while(ADGO)
		continue;	// wait for conversion complete
}
