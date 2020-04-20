/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpiswitch;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import static com.pi4j.io.gpio.RaspiPin.GPIO_00;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 *
 * @author mark harrington
 * 
 * 
 */


public class PortController {
    
        public final static int GROUND_FLOOR  = 1 ;
        public final static int FIRST_FLOOR   = 2 ; 
        public final static int SECOND_FLOOR  = 3 ;
        public final static int GARDEN_REAR   = 4 ;
        public final static int GARDEN_FRONT  = 5 ;
        public final static int GARAGE = 6 ; 
        private int retval = 0 ;
      
        // create gpio controller
        private final  GpioController gpio ;
         // provision gpio pin #01 & #03 as an output pins and blink
        private final  GpioPinDigitalOutput led1 ,led2, led3 , led4 , led5 ,led6 , led7 , led8 ;
       
        
      
        public PortController()  
        {
             
             // set up the  gpio  for output or OUTPUT
            
            
             gpio = GpioFactory.getInstance();
         
             led1= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00); // P17
             led2= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01); // P18
             led3= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02); // P27
             led4= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03); // P22
             led5= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04); // P23
             led6= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05); // P
             led7= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06); // P22
             led8=  gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26); // P22
             
             
             led1.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
             led2.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF); 
             led3.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF); 
             led4.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF); 
             led5.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF); 
             led6.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
             led7.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
             led8.setShutdownOptions(true, PinState.LOW, PinPullResistance.OFF);
        }
    
        public void SetFloor(int  floor ,  MainSwitch m)
        {
           
             
             switch(floor)
             {
                 
                 case 1 :
                      System.out.println("Ground Floor  selected") ;
                      m.setFloor(0);
                      break ;
                 case 2 :
                      m.setLabel("First  Floor Active" , 1); 
                      m.setFloor(1);
                      break ;
                 case 3 :
                      
                      
                      break ;
                 default:      
                      
                 
             } 
             
            
             
        }
        
        
        public boolean setLight (int id , boolean state )
        {
             boolean flag = false ;
             
                 if(id == 0)
                 {
                     
                    System.out.println("Room1 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 00 on P17 ") ;
                    led1.high();
                    
                    flag = led1.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 00 on P17") ;
                                led1.low();
                                flag = led1.isHigh() ; 
                                
                            }

                 }
                 
                 if(id ==1)
                 {
                     
                    System.out.println("Room2 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 01 on P18 ") ;
                    led2.high();
                    
                    flag = led2.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 01 on P18") ;
                                led2.low();
                                flag = led2.isHigh() ; 
                                
                            }

                 }
                 
                  if(id ==2)
                 {
                     
                    System.out.println("Room3 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 02 on P27 ") ;
                    led3.high();
                    
                    flag = led3.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 02 on P27") ;
                                led3.low();
                                flag = led3.isHigh() ; 
                                
                            }

                 }
             
                   if(id ==3)
                 {
                     
                    System.out.println("Room4 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 03 on P22 ") ;
                    led4.high();
                    
                    flag = led4.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 03 on P22") ;
                                led4.low();
                                flag = led4.isHigh() ; 
                                
                            }

                 }
                   
                   
                      
                   if(id ==4)
                 {
                     
                    System.out.println("Room5 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 04 on P23 ") ;
                    led5.high();
                    
                    flag = led5.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 04 on P23") ;
                                led5.low();
                                flag = led5.isHigh() ; 
                                
                            }

                 }   
                   
                   if(id ==5)
                 {
                     
                    System.out.println("Room6 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 05 on P24 ") ;
                    led6.high();
                    
                    flag = led6.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 05 on P24") ;
                                led6.low();
                                flag = led6.isHigh() ; 
                                
                            }

                 }   
                   
                   if(id ==6)
                 {
                     
                    System.out.println("Room7 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 06 on P25 ") ;
                    led7.high();
                    
                    flag = led7.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 06 on P25") ;
                                led7.low();
                                flag = led7.isHigh() ; 
                                
                            }

                 } 
                   
                   
                  if(id ==7)
                 {
                     
                    System.out.println("Room 8 selected") ;
                    if(state== true)
                    {
                    System.out.println("About to turn on GPI 07 on P12 ") ;
                    led8.high();
                    
                    flag = led8.isHigh() ;
                    } else
                            {
                                System.out.println("About to turn  off GPI 07 on P12") ;
                                led8.low();
                                flag = led8.isHigh() ; 
                                
                            }

                 }      
                  
                  
             return flag ;
        }
        
        
        
       
}
