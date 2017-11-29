import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
public class Classful
{
int Ip[]=new int[4];
String Ipinit;
public void inputIp()throws IOException
{
    InputStreamReader read=new InputStreamReader(System.in);
    BufferedReader in=new BufferedReader(read);
    boolean flag;
    flag=false;
    do
    {
    System.out.print("Enter the IP Address : ");
    Ipinit=in.readLine();
   
    for(int i=0;i<4;i++)
    {
        Ip[i]=0;
    }
    int len=Ipinit.length();
    char ch,c=0;
    int a;
    for(int i=0;i<len;i++)
    {
        ch=Ipinit.charAt(i);
        a=(int)ch-48;
      
        if(ch!='.')
        {
            Ip[c]=Ip[c]*10+a;
        }
        else
        {
            if(Ip[c]>255)
            {
            System.out.println("INVALID IP ADDRESS ENTER AGAIN");
            flag=true;
            break;
            }
            flag=false;
            c++;
        }
        }
    }while(flag==true);
System.out.println();

char ch;
int a;
if((Ip[0]>=0)&&(Ip[0]<=127))
{
    System.out.println("CLASS A");
}
if((Ip[0]>=128)&&(Ip[0]<=191))
{
    System.out.println("CLASS B");
}
if((Ip[0]>=192)&&(Ip[0]<=223))
{
    System.out.println("CLASS C");
}
if((Ip[0]>=224)&&(Ip[0]<=239))
{
    System.out.println("CLASS D");
}

if((Ip[0]>=240)&&(Ip[0]<=255))
{
    System.out.println("CLASS E");
}

}
public void display()
{
    System.out.println();
    System.out.print("IP Address entered is : ");
    for(int i=0;i<4;i++)
    {
        System.out.print(Ip[i]);
        if(i!=3)
        {
            System.out.print(".");
        }
    }
    System.out.println();
    System.out.println("BINARY REPRESENTATION");
    for(int i=0;i<4;i++)
    {
        System.out.print(String.format("%8s",Integer.toBinaryString(Ip[i])).replace(" ", "0"));
        if(i!=3)
        {
            System.out.print(".");
        }
    }
       
       
}
public void getNetid()
{

}
public static void main(String args[])throws IOException
{
    /*JFrame jfrm=new JFrame("CIDR EXAMPLE");
    jfrm.setLayout(new FlowLayout());
    jfrm.setSize(620,290);
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jfrm.setVisible(true);
    */
   
    Classful obj=new Classful();
    obj.inputIp();
    /*CIDRawt a=new CIDRawt();
    a.setVisible(true);*/
   
    obj.display();
}
}