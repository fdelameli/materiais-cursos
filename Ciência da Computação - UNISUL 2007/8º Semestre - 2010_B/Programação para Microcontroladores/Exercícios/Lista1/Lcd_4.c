#define LCD_DB4   PIN_D4 // NIBLE de dados 
#define LCD_DB5   PIN_D5 
#define LCD_DB6   PIN_D6 
#define LCD_DB7   PIN_D7 
#define LCD_RS    PIN_E2 
#define LCD_E     PIN_E1 
//#define USE_LCD_RW   1 
#define lcd_type 2 // 0=5x7, 1=5x10, 2=2 lines 
#define lcd_line_two 0x40 // LCD RAM address for the 2nd line 
int8 const LCD_INIT_STRING[4] = 
{ 
   0x20 | (lcd_type << 2), // Func set: 4-bit, 2 lines, 5x8 dots 
   0xc,                    // Display on 
   1,                      // Clear display 
   6                       // Increment cursor 
 }; 

void lcd_send_nibble(int8 nibble){ 
   // Obs:  !! converte uma exprecao inteira 
   // para uma booleana (1 or 0). 
   output_bit(LCD_DB4, !!(nibble & 1)); 
   output_bit(LCD_DB5, !!(nibble & 2)); 
   output_bit(LCD_DB6, !!(nibble & 4)); 
   output_bit(LCD_DB7, !!(nibble & 8)); 
   delay_cycles(1); 
   output_high(LCD_E); 
   delay_us(2); 
   output_low(LCD_E); 
   delay_us(2);//teste 
} 
// Envia um byte para o LCD. 
void lcd_send_byte(int8 address, int8 n){ 
   output_low(LCD_RS); 
   delay_us(60); 
   if(address) 
      output_high(LCD_RS); 
   else 
      output_low(LCD_RS); 
   delay_cycles(1); 
   output_low(LCD_E); 
   lcd_send_nibble(n >> 4); 
   delay_us(2); //teste 
   lcd_send_nibble(n & 0xf); 
} 
void lcd_init(void){ 
   int8 i; 
   output_low(LCD_RS); 
   output_low(LCD_E); 
   delay_ms(15); 
   for(i=0 ;i < 3; i++){ 
      lcd_send_nibble(0x03); 
      delay_ms(5); 
   } 
   lcd_send_nibble(0x02); 
   for(i=0; i < sizeof(LCD_INIT_STRING); i++){ 
      lcd_send_byte(0, LCD_INIT_STRING[i]); 
    } 
   delay_ms(15); 
} 
// Posicoes válidas: 
// de x=1 a x=16 y 
// de y=1 a y=2 
void lcd_gotoxy(int8 x, int8 y){ 
   int8 address; 
   if(x > 0 && y > 0){ 
      if(y > 1) 
         address = lcd_line_two; 
      else 
         address=0; 
      address += x-1; 
      lcd_send_byte(0, 0x80 | address); // Manda cursor a la posición 
   } 
} 

void lcd_putc(char c){ 
    if(c>'\0'){ 
      switch(c){ 
         case '\f': 
            lcd_send_byte(0,1); 
            lcd_send_byte(0,2); 
            delay_ms(2); 
            break; 
         case '\n': 
            lcd_gotoxy(1,2); 
            delay_ms(2); 
            break; 
         case '\b': 
            lcd_send_byte(0,0x10); 
            delay_ms(2); 
            break; 
         case '\t': 
            lcd_send_byte(0,0x14); 
            delay_ms(2); 
            break; 
         default: 
            lcd_send_byte(1,c); 
            delay_ms(2); 
            break; 
      } 
   } 
} 


void lcd_setcursor(short visible, short blink) { 
   lcd_send_byte(0, 0xC|(visible<<1)|blink); 
} 
