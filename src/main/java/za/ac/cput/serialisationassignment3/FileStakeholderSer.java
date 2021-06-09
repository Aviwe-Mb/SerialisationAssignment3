/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.serialisationassignment3;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author aviwembolekwa
 */
public class FileStakeholderSer    {
	///////////////////////////////////////////////////

	

                 
		  Supplier sp1 ; 
		  Customer ct2 ;
		  Supplier sp3 ;
		  Supplier sp4 ;
		  int noent=2;
		  Customer ct5 ;
		  Customer ct6 ;
		  int ent=4;
		  Supplier sp7 ; 
		  Supplier sp8 ; 
		  Customer ct9 ;
		  Customer ct10;
		  Customer ct0 ;

                  
BufferedWriter bf; 
BufferedWriter bf1;

private ObjectInputStream input;

	
public void OpenFile()
{
try{
	
	 FileInputStream streamIn = new FileInputStream("stakeholder.ser");
                            input= new ObjectInputStream(streamIn);
	System.out.println("===============File Opened======");
   }catch(Exception e)	{
	    System.out.println("=======Failed to Open======" +e.getMessage());
                        }
}	
	
	
public void CloseFile()
{
	try{
input.close();
 System.out.println("==========File Closed======");
           }catch(Exception e)	{
	    System.out.println("=======Failed to Close======" +e.getMessage());
                                }
}	
public void ReadFile() {
	try {
          while(true){
		  
			  ct0 = (Customer)input.readObject();
			  sp1 = (Supplier) input.readObject();
			  ct2 = (Customer)input.readObject();
			  sp3 = (Supplier) input.readObject();
			  sp4 = (Supplier) input.readObject();
			  ct5 = (Customer)input.readObject();
			  ct6 = (Customer)input.readObject();
			  sp7 = (Supplier) input.readObject();
			  sp8 = (Supplier) input.readObject();
			  ct9 = (Customer)input.readObject();
			  ct10 = (Customer)input.readObject();
			 
	
          
	 
	
	  }
		  } catch (IOException ex) {
	   System.out.println("============Reached End Of File========="+ ex.getMessage());
		
		  } 
	catch (ClassNotFoundException ex) {
			   System.out.println("============File Not Found========="+ ex.getMessage());
		  }


			 

}
public void RentedCustomers()
{
	
for (int i =0; i<6;i++)
{
	
if (ct0.getCanRent())
{
	 ent = ent+1;	
}
else
noent=noent+1;

}
}
public void CustomerWriteAndSortTxt() throws ParseException
{
	

SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
 


String sDate0 = ct0.getDateOfBirth();
String sDate2 = ct2.getDateOfBirth();
String sDate5 = ct5.getDateOfBirth();
String sDate6 = ct6.getDateOfBirth();
String sDate9 = ct9.getDateOfBirth();
String sDate10 = ct10.getDateOfBirth();

                      java.util.Date date1=formatter1.parse(sDate0); 
                      java.util.Date date2=formatter1.parse(sDate2);
                      java.util.Date date3=formatter1.parse(sDate5);
                      java.util.Date date4=formatter1.parse(sDate6);
                      java.util.Date date5=formatter1.parse(sDate9);
                      java.util.Date date6=formatter1.parse(sDate10);
 


     
LocalDate l0 = LocalDate.parse((CharSequence) sDate0);
LocalDate l1 = LocalDate.parse((CharSequence) sDate2);
LocalDate l2 = LocalDate.parse((CharSequence) sDate5);
LocalDate l3 = LocalDate.parse((CharSequence) sDate6);
LocalDate l4 = LocalDate.parse((CharSequence) sDate9);
LocalDate l5 = LocalDate.parse((CharSequence) sDate10);
LocalDate now = LocalDate.now();

Period Age1 = Period.between(l0, now);
Period Age2 = Period.between(l1, now);
Period Age3 = Period.between(l2, now);
Period Age4 = Period.between(l3, now);
Period Age5 = Period.between(l4, now);
Period Age6 = Period.between(l5, now);


  int s6 = Age1.getYears();
   int s7 = Age2.getYears();
    int s8 = Age3.getYears();
     int s9 = Age4.getYears();
      int s10 = Age5.getYears();
       int s11= Age6.getYears();        


          String str0 ="    " +ct0.getStHolderId()+"      "+ ct0.getFirstName()+"           "+ct0.getSurName()+"        "+"\t"+date1+"         "+s8+"\n"  ;
	  String str2 = "    "+ct2.getStHolderId()+"      "+ ct2.getFirstName()+"           "+ct2.getSurName()+"         "+"\t"+date2+"         "+s7+"\n";
	  String str5 = "    "+ct5.getStHolderId()+"      "+ ct5.getFirstName()+"           "+ct5.getSurName()+"         "+"\t"+date3+"         "+s6+"\n";
	  String str6 = "    "+ct6.getStHolderId()+"      "+ ct6.getFirstName()+"        "+ct6.getSurName()+"         "+"\t"+date4+"         "+s10+"\n";
	 String str9 ="    "+ ct9.getStHolderId()+"      "+ ct9.getFirstName()+"        "+ct9.getSurName()+"         "+"\t"+date5+"         "+s11+"\n";
        String str10 ="    "+ct10.getStHolderId()+"      "+ct10.getFirstName()+"           "+ct10.getSurName()+"       "+"\t"+date6+"         "+s11+"\n";
String []customer ={str5,str2,str0,str9,str10,str6};	  



String s = new String(customer[0]);
String s1 = new String(customer[1]);
String s2 = new String(customer[2]);
String s3 = new String(customer[3]);
String s4 = new String(customer[4]);
String s5 = new String(customer[5]);


       
       

try
{
bf = new BufferedWriter( new FileWriter("Customer.txt"));
bf.write("===================================CUSTOMERS============================================================\n");
bf.write("   ID         Name        Surname                     DateOfBirth                     Age \n");
bf.write("=========================================================================================================\n");
//bf.write();//s8
bf.write(String.format(s, customer));//s8
bf.write(String.format(s1, customer));//s7
bf.write(String.format(s2,customer));//s6
bf.write(String.format(s3, customer));//s10
bf.write(String.format(s4, customer));//s11
bf.write(String.format(s5, customer));//s9
bf.write("\nNumber of Customers who can Rent:"+ent );
bf.write("\nNumber of Customers who cannot Rent:"+noent);

bf.close();

}catch	(IOException ex) {
	   System.out.println("============Did Not Manage to Write========="+ ex.getMessage());


             	
	
 
}
}
public void CreatAndWriteSuppliertxt()
{
 String ss1 = sp1.getStHolderId()+"        "+ sp1.getName()+ "         "+sp1.getProductType()+"                       "+sp1.getProductDescription()+"\n";
 String ss3 = sp3.getStHolderId()+"        "+ sp3.getName()+ "             "+sp3.getProductType()+"                        "+sp3.getProductDescription()+"\n";
 String ss4 = sp4.getStHolderId()+"        "+ sp4.getName()+ "              "+sp4.getProductType()+"                       "+sp7.getProductDescription()+"\n";
 String ss7 = sp7.getStHolderId()+"        "+ sp7.getName()+ "             "+sp7.getProductType()+"                          "+sp7.getProductDescription()+"\n";
 String ss8 = sp8.getStHolderId()+"        "+sp8.getName()+"               "+sp8.getProductType()+"                      "+sp8.getProductDescription()+"\n";
 
 String []supplier ={ss7,ss1,ss8,ss3,ss4};
 
 
String sup1 = new String(supplier[0]);
String sup3 = new String(supplier[1]);
String sup4 = new String(supplier[2]);
String sup7 = new String(supplier[3]);
String sup8 = new String(supplier[4]);


try
{
bf1 = new BufferedWriter( new FileWriter("Supplier.txt"));
bf1.write("==========================SUPPLIERS=======================================\n");
bf1.write("ID             Name                  Prod Type                  Description \n");
bf1.write("===============================================================================\n");	
bf1.write(String.format(sup1, supplier));
bf1.write(String.format(sup3, supplier));
bf1.write(String.format(sup4, supplier));
bf1.write(String.format(sup7, supplier));
bf1.write(String.format(sup8, supplier)+"\n");
bf1.close();
}		catch	(IOException ex) {
	   System.out.println("============Did Not Manage to Write========="+ ex.getMessage());
			  }
}		
  public static void main(String args[]) throws IOException, ClassNotFoundException, ParseException  {
        ReadStakeholderSer rds = new ReadStakeholderSer();
        rds.OpenFile();
	rds.ReadFile();
	rds.CustomerWriteAndSortTxt();
	rds.CreatAndWriteSuppliertxt();
	
           }

}

    




