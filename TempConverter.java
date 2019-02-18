/*
COMP110 Lab 2: Temperature Converter
Student: Redhwan Ahmed
Date: 1/30/18
File: TempConverter.java
Description: This is a program which will take two inputs from the user (Farenheit and Celcius)
and output 4 results (double, float, fixed point, and printf) for each input from the user. The
first input will be for Farenheit which will be converted to celsius and the second will be the
vice-versa of that.
*/

import java.util.*;
import javax.swing.*;

   class TempConverter
   {
      static final double conv = 5./9.; // global  
      public static void main (String args[])
      {
         Scanner scan = new Scanner (System.in); // preprares for user input for future calculation
         int inpFlag = 2, JOPFlag = 2, JOPinp = 0; //initialized at 2 to allow the loop to work and JOPinp for input for GUI
         String JOPInpS = "";
         Boolean x = true;
         double f = 90, c = 35, inpC = 0, newF = 0, newC = 0, inpnewF = 0,  fixedF = 0, inpfixedF = 0, fixedC = 0, JOPnewF = 0, JOPfixedF = 0, JOPinpf; // Initializes the F, C, and new F and C Variables. The variables are F = 90 and C 
         float ffc = 0, inpffc = 0, cff = 0, JOPffc = 0; // Initializes the float variables and fixed variables.
                      
         newF = CtoF(c); // Sends the variables inputted to the methods above main and then stores them in newF.
         newC = FtoC(f); // Sends the variables inputted to the methods above main and then stores them in newC.
         ffc = (float) newF; // Creates a float variable of the above.
         cff = (float) newC;
         fixedC = (int) (cff * 100) / 100.0; // Creates a fixed float variable of the above.
         fixedF = (int) (ffc * 100) / 100.0; // Creates a fixed float variable.
         
         /* *Debugging purposes only*
         System.out.println("F: "+f);
         System.out.println("C: "+c);
         System.out.println("NewF: "+newF);
         System.out.println("NewC: "+newC);
         System.out.println("ffc: "+ffc);
         System.out.println("cff: "+cff);
         System.out.println("FixedC: "+fixedC);
         System.out.println("FixedF: "+fixedF);
         */
                    
         System.out.println("Convert F to C: \n"+f+" degreesF is equal to "+newC+" degrees C in Double \n\t Float: "+cff+"\n\t Fixed: "+fixedC); // Outputs the result for F to C.
         /*System.out.println(f+" degrees F is equal to "+newC+" degrees C in Double");
         System.out.println("\tin Float:  "+cff);
         System.out.println("\tin Fixed:  "+fixedC);*/
         System.out.printf("\t in Format: %10.2f, %10.2e\n", newC, newC);
         
         System.out.println("\nConvert C to F: \n"+c+" degreesC is equal to "+newC+" degreesF in Double \n\t Float: "+ffc+"\n\t Fixed: "+fixedF); // Outputs the result for C to F. 
         /*System.out.println(c+" degreesC is equal to "+newF+" degreesF in Double");
         System.out.println("\tin Float:  "+ffc);
         System.out.println("\tin Fixed:  "+fixedF);*/
         System.out.printf("\t in Format: %10.2f, %10.2e\n", newF, newF);
         
         System.out.println("\n Would you like to print it out in GUI? '1' for yes, '0' for no.");
         while ((inpFlag != 0) || (inpFlag != 1))
         {
            inpFlag = scan.nextInt();
            
            if (inpFlag == 1)
            {
               JOptionPane.showMessageDialog(null, "Convert F to C: \n"+f+" degreesF is equal to "+newC+" degrees C in Double \n\t    Float: "+cff+"\n\t    Fixed: "+fixedC+
               "\n    in Format: "+String.format("%10.2f", newC)+"    "+String.format("%10.2e\n", newC)+"\nConvert C to F: \n"+c+" degreesC is equal to "+newC+" degreesF in Double \n\t    Float: "
               +ffc+"\n\t    Fixed: "+fixedF+"\t\n    in Format: "+String.format("%10.2f", newF)+"    "+String.format("%10.2e\n", newF)); 
               break;
            }
            
            else if (inpFlag > 1)
            {
               System.out.println("Please try again: ");
            }
            
            else
            {
               break;
            }
         }
            
         System.out.println("\nInput Celcius temperature: ");
         inpC = scan.nextDouble(); // Takes in user input for celcius.
         
         inpnewF = CtoF(inpC); // Sends the variables inputted to the methods above main and then stores them in newF.
         inpffc = (float) inpnewF;
         inpfixedF = (int) (inpffc * 100) / 100.0; // Creates a fixed float variable of the above.       
                
         System.out.println("\nConvert C to F: \n"+inpC+" degreesC is equal to "+inpnewF+" degreesF in Double \n\t Float: "+inpffc+"\n\t Fixed: "+inpfixedF); // Outputs the result for C to F.; // Outputs the result for C to F. 
         /*System.out.println(inpC+" degreesC is equal to "+inpnewF+" degreesF in Double");
         System.out.println("\tin Float:  "+inpffc);
         System.out.println("\tin Fixed:  "+inpfixedF);*/
         System.out.printf("\t in Format: %10.2f, %10.2e\n", inpnewF, inpnewF);
         
         System.out.println("\nWould you like to input into GUI? '1' for yes, '0' for no.");
         
         while ((JOPFlag != 0) || (JOPFlag != 1))
         {
            JOPFlag = scan.nextInt(); 
            if (JOPFlag == 1)
            {
               JOPInpS = JOptionPane.showInputDialog("Enter Celcius Temperature: (Any Decimal points will be disregarded)");
               JOPinpf = Double.parseDouble(JOPInpS.trim());
               JOPinp = (int) JOPinpf;
               JOPnewF = CtoF(JOPinp);
               JOPffc = (float) JOPnewF;
               JOPfixedF = (int) (JOPffc * 100)/100;
               JOptionPane.showMessageDialog(null, "Convert C to F: \n"+JOPinp+" degreesC is equal to "+JOPnewF+" degreesF in Double \n\t Float: "+JOPffc+"\n\t Fixed: "+JOPfixedF+"\t\n in Format:"
               +String.format("%10.2f", JOPnewF)+"    "+String.format("%10.2e\n", JOPnewF)); 
               break;
            }
            
            else if (JOPFlag > 1)
            {
               System.out.println("Please try again: ");
            }
            
            else
            {
               break;
            }
         }       
       }   
       
      public static double FtoC (double f) // This converts the users F input into C
      {
         double CfromF = (f-32) * conv;
         return CfromF;
      }
      
      public static double CtoF (double c) // This converts the users C input into F
      {
         double FfromC = (c / conv) + 32;
         return FfromC;
      }   
    }   
