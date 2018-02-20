package deneme;
import java.util.EnumSet;
import java.util.Calendar;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 import java.util.ArrayList;
import java.time.*; 


public class Deneme {

public static void main(String[] args) throws ParseException {
        
        Scanner input = new Scanner(System.in);
        String dateStr,dateStr2;
        System.out.println("Baþlangýç tarih giriniz \n");
        dateStr=input.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date baslangicDate = format.parse(dateStr);
        Calendar cal = Calendar.getInstance();
        cal.setTime(baslangicDate);       
         int tarihinGunu=cal.get(Calendar.DAY_OF_WEEK);
         System.out.println("baslangic tarihin hafta gunu: " + tarihinGunu);
         
        System.out.println("Bitiþ tarih giriniz \n");
        dateStr2=input.nextLine();     
        Date bitisDate = format.parse(dateStr2);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(bitisDate);   
         int tarihinGunu2=cal2.get(Calendar.DAY_OF_WEEK);
         System.out.println("bitiþ tarihin hafta gunu: " + tarihinGunu2);
       
         
          int start,finish;
         System.out.println("Gün baþlangici yaziniz (1-7) \n");     
         start=input.nextInt();            
         System.out.println("Gün bitiþi yaziniz (1-7)\n");        
         finish=input.nextInt();
       
         int farkAralik=0;
         if(finish>start)
             farkAralik=finish-start;
         else
             farkAralik=7-start+finish;
      
         ArrayList<String> elements = new ArrayList<>();

     
         
         String s1,s2;
       
                 
                  s1=format.format(cal.getTime());
         while(1==1)
         {
             
               cal.add(Calendar.DATE,1);
              if(cal.get(Calendar.DAY_OF_WEEK)==start) {
                  
                  s1=format.format(cal.getTime());
                  cal.add(Calendar.DATE, farkAralik);
                  s2=format.format(cal.getTime()); 
                   elements.add(s1+"-" +s2);
                  break;
              }
              else if(cal.get(Calendar.DAY_OF_WEEK)==finish)
              {
                  // cal.add(Calendar.DATE, farkAralik);
                  s2=format.format(cal.getTime()); 
                   elements.add(s1+"-" +s2);
                   break;
              }
         }
 
         
       while(cal.compareTo(cal2)<0)
        {
               
             cal.add(Calendar.DATE,7-farkAralik);
           
           
             s1=format.format(cal.getTime());
              cal.add(Calendar.DATE,farkAralik);
              if(cal.compareTo(cal2)<0)
                s2=format.format(cal.getTime());
              else
                  s2=format.format(cal2.getTime());
           
             elements.add(s1+"-" +s2);
            
            
        }
         for(int i=0; i<elements.size(); i++)
              System.out.println(elements.get(i));
          
        			

}
}