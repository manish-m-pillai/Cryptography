/*For Imporant Inforamation on Comments Scroll to Last */
package Cipher;
import java.io.*;


public class Cipher extends CipherData {
    public static void main(String[] args) throws IOException  {
       InputStreamReader in = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(in);
       CipherData cd = new Cipher();
       PrintStream Sop = System.out;// This is made to avoid wring System.out. for printing
       String WrongSt1="You have Entered Wrong Statement";
       String WrongSt2="Please Enter it Again!!!";
       String WrongCh="You have Entered Wrong Choice";
       String EnterPlainText="Enter the Plain Text";
       String EnterCipherText="Enter the Cipher Text";
       String EnterKey="Enter the Key Value";
       String EnterYourChoice="Enter your Choice";
       String OutputPlainText="Plain Text => ";
       String OutputCipherText="Cipher Text => ";
       String ErrNumber="You have Entered a Digit instead of an Alphabet";
       String ErrWhiteSpace="You have Entered WhiteSpace instead of an Alphabet";
       String ErrSpSymbol="You have Entered a Special Character instead of an Alphabet";
       String NoInput="You have Entered Nothing";
       String LargeKeySize="The Key Size is Large";
       String RemovalMsg="!!!!!!!!!!Remember Numbers WhiteSpaces Special Characters will be removed from the Plaintext!!!!!!!!!!";
       String ErrNoLetterInput="No Alphabet Found in the Text";
       String Design="*********************************************************************************************";
       int ch=0,chi=0;
       int z=0;
       String choice="Yes";
       while((choice.equalsIgnoreCase("Yes"))||(choice.equalsIgnoreCase("Y")))//It is the outer loop for Main Menu
       {
        z=0;
        Sop.println(Design);
        Sop.println("                                       CIPHER");
        Sop.println(Design);
        Sop.println();
        Sop.println("Enter 1 for Caesar Cipher");
        Sop.println("Enter 2 for MonoAlphabetic Cipher");
        Sop.println("Enter 3 for Vignere Cipher");
        Sop.println("Enter 4 for PlayFair Cipher");
        Sop.println(EnterYourChoice);
        try
        {
          ch=Integer.parseInt(br.readLine());
        }
        catch(Exception e)
        {
          Sop.println();
          Sop.println(WrongSt1);
          Sop.println(WrongSt2);
          Sop.println();
          continue;
        }
        switch(ch)
        {
          /*@@@@@@@@@@@@@@@@@@   Caesar Cipher    @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
          case 1: //If User Entered for Caesar Cipher
          { // this bracket is for distinguishing Local Variables (LV)
          String P,C; 
          int K;
          do // This do is for caesar Cipher if user enters wrong input to repeat again (do1)
          {
            Sop.println();
            Sop.println("Enter 1 for Caesar Cipher Encryption");
            Sop.println("Enter 2 for Caesar Cipher Decryption");
            Sop.println("Enter 3 to Crack Caesar Cipher Encrypted Message");
            Sop.println(EnterYourChoice);
            try
            {
              chi=Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
              Sop.println();
              Sop.println(WrongSt1);
              Sop.println(WrongSt2);
              continue;
            }
            switch(chi)
            {
              /*@@@@@@@@@@@@@@@@@@   Caesar Cipher Encryption   @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
              case 1: // if user entered for Caesar Cipher Encryption
              do // this do is for not entering anything
              {
                Sop.println();
                Sop.println(EnterPlainText);
                P=br.readLine().trim();
                if(P.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
              }
              while(true);
              do // this do is used if user inputs wrong key (do2)
              {
                try
                {
                Sop.println(EnterKey);
                K=Integer.parseInt(br.readLine());
                }
                catch(Exception e)
                {
                  Sop.println();
                  Sop.println(WrongSt1);
                  Sop.println(WrongSt2);
                  Sop.println();
                continue;
                }
                break;
              }
              while(true);// end of do2
              C=cd.CaesarCipherEncryption(P, K);
              Sop.println();
              Sop.println(OutputPlainText+P.toLowerCase());
              Sop.println(OutputCipherText+C);
              Sop.println();
              z=1;// to stop do1
              break;
              /*@@@@@@@@@@@@@@@@@@   Caesar Cipher Decryption   @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
              case 2: // if User Entered for Caesar Cipher Decryption
              do
              {
                Sop.println();
                Sop.println(EnterCipherText);
                C=br.readLine().trim();
                if(C.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
              }
              while(true);
              do
              {
                try
                {
                  Sop.println(EnterKey);
                  K=Integer.parseInt(br.readLine());
                }
                catch(Exception e)
                {
                  Sop.println();
                  Sop.println(WrongSt1);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
              }
              while(true);
              P=cd.CaesarCipherDecryption(C, K);
              Sop.println();
              Sop.println(OutputCipherText+C.toUpperCase());
              Sop.println(OutputPlainText+P);
              Sop.println();
              z=1;// to stop do1
              break;
              /*@@@@@@@@@@@@@@@@@@   Caesar Cipher Crack   @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
              case 3: // If USer Entered for Cracking Caesar Cipher Text
              do
              {
                Sop.println();
                Sop.println(EnterCipherText);
                C=br.readLine().trim();
                if(C.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
              }
              while(true);
              String Pl[]=new String[26];
              Pl=cd.CaesarCipherHack(C);
              z=1;//to stop do1
              Sop.println();
              Sop.println("The Text Obtained Using Brute-Force Attack are:-");
              Sop.println("Index     Key         Text");
              for(int i=0;i<26;i++)
              {
                if(i<10)
                {
                  Sop.println(i+"         "+(26-i)+"          "+Pl[i]);
                }
                else if((26-i)<10)
                {
                  Sop.println(i+"        "+(26-i)+"           "+Pl[i]);
                }
                else
                {
                  Sop.println(i+"        "+(26-i)+"          "+Pl[i]);
                }
              }
              Sop.println();
              break;
              default:
              Sop.println();
              Sop.println(WrongCh);
              Sop.println(WrongSt2);
              Sop.println();
              }
          }
          while(z==0);
          break;
          }// End of LV
          /*@@@@@@@@@@@@@@@@@@   MonoAlphabetic Cipher    @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
          case 2: // if User Entered for MonoAlphabetic Cipher
          { //this bracket is for distinguishing Local Variables (LV)
          String C,P;
          String temp="";
          char t=' ';
          int x;
          char K[]=new char[26];
          char A[]=new char[26];
          do // This do is for MonoAlphabetic Cipher if user enters wrong input to repeat again (do1)
          {
            Sop.println();
            Sop.println("Enter 1 for MonoAlphabetic Cipher Encryption");
            Sop.println("Enter 2 for MonoAlphabetic Cipher Decryption");
            try
            {
              chi=Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
              Sop.println();
              Sop.println(WrongSt1);
              Sop.println(WrongSt2);
              Sop.println();
              continue;
            }
            switch(chi)
            {
              /*@@@@@@@@@@@@@@@@@@   MonoAlphabetic Cipher Encryption   @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
              case 1:
              for(int i=97;i<=122;i++)
              {
                A[i-97]=(char)i;
              }
              do
              {
                Sop.println();
                Sop.println(EnterPlainText);
                P=br.readLine().trim();
                if(P.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
              }
              while(true);
              /*Here in future New Statements would be added for Reading From File for Key */
              Sop.println(EnterKey);
              for(int i=0;i<26;)
              {
                Sop.println();
                Sop.println("Enter Encryption Key for "+A[i]);
                temp=br.readLine();
                temp=temp+" ";
                t=temp.charAt(0);
                x=0;
                if(Character.isLetter(t))
                {
                  x=1;
                  t=Character.toLowerCase(t);
                  for(int j=i;j>=0;j--)
                  {
                    if(t==K[j])
                    {
                      Sop.println();
                      Sop.println(t+" has Already been Used for "+A[j]);
                      Sop.println(WrongSt2);
                      Sop.println();
                      x=0;
                      break;
                    }
                  }
                  if(x==1)
                  {
                    K[i]=t;
                    i++;
                  }
                }
                
                else if(Character.isDigit(t))
                {
                  Sop.println();
                  Sop.println(ErrNumber);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
                else if(Character.isWhitespace(t))
                {
                  Sop.println();
                  Sop.println(ErrWhiteSpace);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
                else
                {
                  Sop.println();
                  Sop.println(ErrSpSymbol);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
              }

              C=cd.MonoAlphabeticCipherEncryption(P, K);
              Sop.println();
              Sop.println(OutputPlainText+P.toLowerCase());
              Sop.println(OutputCipherText+C);
              Sop.println();
              z=1;//to stop do1
              break;
              /*@@@@@@@@@@@@@@@@@@   MonoAlphabetic Cipher Decryption   @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
              case 2:
              for(int i=65;i<=90;i++)
              {
                A[i-65]=(char)i;
              }
              do
              {
                Sop.println();
                Sop.println(EnterCipherText);
                C=br.readLine().trim();
                if(C.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
              }
              while(true);
              /*Here in future New Statements would be added for Reading From File for Key */
              Sop.println(EnterKey);
              for(int i=0;i<26;)
              {
                Sop.println();
                Sop.println("Enter Decryption Key for "+A[i]);
                temp=br.readLine();
                temp=temp+" ";
                t=temp.charAt(0);
                x=0;
                if(Character.isLetter(t))
                {
                  x=1;
                  t=Character.toLowerCase(t);
                  for(int j=i;j>=0;j--)
                  {
                    if(t==K[j])
                    {
                      Sop.println();
                      Sop.println(t+" has Already been Used for "+A[j]);
                      Sop.println(WrongSt2);
                      Sop.println();
                      x=0;
                      break;
                    }
                  }
                  if(x==1)
                  {
                    K[i]=t;
                    i++;
                  }
                }
                
                else if(Character.isDigit(t))
                {
                  Sop.println();
                  Sop.println(ErrNumber);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
                else if(Character.isWhitespace(t))
                {
                  Sop.println();
                  Sop.println(ErrWhiteSpace);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
                else
                {
                  Sop.println();
                  Sop.println(ErrSpSymbol);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
              }

              P=cd.MonoAlphabeticCipherDecryption(C, K);
              Sop.println();
              Sop.println(OutputCipherText+C.toUpperCase());
              Sop.println(OutputPlainText+P);
              Sop.println();
              z=1;//to stop do1
              break;
              default:// if user enters other number
              Sop.println(WrongCh);
              Sop.println(WrongSt2); 
            }
          }
          while(z==0);// end of do1
          break;
        }//End of LV

        case 3: // If User Entered for Vignere Cipher Encryption
        {//this bracket is for distinguishing Local Variables (LV)
          String P,C,K;
          do
          {
            Sop.println();
            Sop.println("Enter 1 for Vignere Cipher Encryption");
            Sop.println("Enter 2 for Vignere Cipher Decryption");
            Sop.println(EnterYourChoice);
            try
            {
              chi=Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
              Sop.println();
              Sop.println(WrongSt1);
              Sop.println(WrongSt2);
              continue;
            }
            switch(chi)
            {
              case 1:
               do
               {
                Sop.println();
                Sop.println(EnterPlainText);
                P=br.readLine().trim();
                if(P.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
               }
               while(true);
               P=P.toLowerCase();
               doLocalVariable:
               do
               {
                Sop.println(EnterKey);
                K=br.readLine().trim();
                if(K.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                else if(P.length()<K.length())
                {
                  Sop.println();
                  Sop.println(LargeKeySize);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                else
                {
                  for(int i=0;i<K.length();i++)
                  {
                    if(Character.isLetter(K.charAt(i)))
                    {}
                    else
                    {
                      Sop.println();
                      Sop.println(WrongSt1);
                      Sop.println(WrongSt2);
                      Sop.println();
                      continue doLocalVariable;
                    }
                  }
                  break;
                }
               }
               while(true);
               K=K.toLowerCase();
               C=cd.VignereCipherEncrypiton(P, K);
               Sop.println();
               Sop.println(OutputPlainText+P);
               Sop.println(OutputCipherText+C);
               Sop.println();
               z=1;// to stop do1
               break;
               case 2:
               do
               {
                Sop.println();
                Sop.println(EnterCipherText);
                C=br.readLine().trim();
                if(C.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                break;
               }
               while(true);
               C=C.toUpperCase();
               doLocalVariable:
               do
               {
                Sop.println(EnterKey);
                K=br.readLine().trim();
                if(K.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                else if(C.length()<K.length())
                {
                  Sop.println();
                  Sop.println(LargeKeySize);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                else
                {
                  for(int i=0;i<K.length();i++)
                  {
                    if(Character.isLetter(K.charAt(i)))
                    {}
                    else
                    {
                      Sop.println();
                      Sop.println(WrongSt1);
                      Sop.println(WrongSt2);
                      Sop.println();
                      continue doLocalVariable;
                    }
                  }
                  break;
                }
               }
               while(true);
               K=K.toUpperCase();
               P=cd.VignereCipherDecryption(C, K);
               Sop.println();
               Sop.println(OutputCipherText+C);
               Sop.println(OutputPlainText+P);
               Sop.println();
               z=1;// to stop do1
               break;
               default:
               Sop.println();
               Sop.println(WrongCh);
               Sop.println(WrongSt2);
               Sop.println();
            }
          }
          while(z==0);//end of do1
        }// End of LV
        break;
        /*@@@@@@@@@@@@@@@@@@   PlayFair Cipher    @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        case 4://If user entered for PlayFair Cipher
        { //this bracket is for distinguishing Local Variable(LV)
          String P,C,K;
          String Pk="";
          String Ck="";
          do // This do is for caesar Cipher if user enters wrong input to repeat again (do1)
          {
            Sop.println();
            Sop.println("Enter 1 for PlayFair Cipher Encryption");
            Sop.println("Enter 2 for PlayFair Cipher Decryption");
            Sop.println(EnterYourChoice);
            try
            {
              chi=Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
              Sop.println();
              Sop.println(WrongSt1);
              Sop.println(WrongSt2);
              continue;
            }
            switch(chi)
            {
              /*@@@@@@@@@@@@@@@@@@   PlayFair Cipher Encryption   @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
              case 1:
              boolean b;
              do // this do is for not entering anything or not entering a letter to repeat again
              {
                b=false;
                Sop.println();
                Sop.println(EnterPlainText);
                Sop.println(RemovalMsg);
                P=br.readLine().trim();
                if(P.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                for(int i=0;i<P.length();i++)
                {
                  if(Character.isLetter(P.charAt(i)))
                  {
                    b=true;
                    break;
                  }
                }
                if(b==false)
                {
                  Sop.println();
                  Sop.println(ErrNoLetterInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
              }
              while(!b);
              do // this do is for not entering anything or not entering a letter to repeat again
              {
                b=false;
                Sop.println();
                Sop.println(EnterKey);
                Sop.println(RemovalMsg);
                K=br.readLine().trim();
                if(K.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                for(int i=0;i<K.length();i++)
                {
                  if(Character.isLetter(K.charAt(i)))
                  {
                    b=true;
                    break;
                  }
                }
                if(b==false)
                {
                  Sop.println();
                  Sop.println(ErrNoLetterInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
              }
              while(!b);
              for(int i=0;i<P.length();i++)
              {
                if(Character.isLetter(P.charAt(i)))
                {
                  Pk=Pk+P.charAt(i);
                }
              }
              C=cd.PlayFairCipherEncryption(P, K);
              Sop.println();
              Sop.println(OutputPlainText+Pk.toLowerCase());
              Sop.println(OutputCipherText+C);
              Sop.println();
              z=1;// to stop do1
              break;
              /*@@@@@@@@@@@@@@@@@@   PlayFair Cipher Decryption   @@@@@@@@@@@@@@@@@@@@@@@@@@@*/
              case 2:
              do // this do is for not entering anything or not entering a letter to repeat again
              {
                b=false;
                Sop.println();
                Sop.println(EnterCipherText);
                Sop.println(RemovalMsg);
                C=br.readLine().trim();
                if(C.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                for(int i=0;i<C.length();i++)
                {
                  if(Character.isLetter(C.charAt(i)))
                  {
                    b=true;
                    break;
                  }
                }
                if(b==false)
                {
                  Sop.println();
                  Sop.println(ErrNoLetterInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
              }
              while(!b);
              do // this do is for not entering anything or not entering a letter to repeat again
              {
                b=false;
                Sop.println();
                Sop.println(EnterKey);
                Sop.println(RemovalMsg);
                K=br.readLine().trim();
                if(K.isEmpty())
                {
                  Sop.println();
                  Sop.println(NoInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                  continue;
                }
                for(int i=0;i<K.length();i++)
                {
                  if(Character.isLetter(K.charAt(i)))
                  {
                    b=true;
                    break;
                  }
                }
                if(b==false)
                {
                  Sop.println();
                  Sop.println(ErrNoLetterInput);
                  Sop.println(WrongSt2);
                  Sop.println();
                }
              }
              while(!b);
              for(int i=0;i<C.length();i++)
              {
                if(Character.isLetter(C.charAt(i)))
                {
                  Ck=Ck+C.charAt(i);
                }
              }
              P=cd.PlayFairCipherDecryption(C, K);
              Sop.println();
              Sop.println(OutputCipherText+Ck.toUpperCase());
              Sop.println(OutputPlainText+P);
              Sop.println();
              Sop.println("Do you want to Remove all Occurence of 'x' in the Plaintext?");
              Sop.println("Press Y or write Yes for Yes");
              Sop.println("Press any other button for No");
              String x=br.readLine();
              String Px="";
              if((x.equalsIgnoreCase("Y"))||(x.equalsIgnoreCase("Yes")))
              {
                for(int i=0;i<P.length();i++)
                {
                  if(P.charAt(i)!='x')
                  {
                    Px=Px+P.charAt(i);
                  }
                }
                Sop.println();
                Sop.println(OutputCipherText+Ck.toUpperCase());
                Sop.println(OutputPlainText+Px);
                Sop.println();
              }
              z=1;// to stop do1
              break;
              default:
              Sop.println();
              Sop.println(WrongCh);
              Sop.println(WrongSt2);
              Sop.println();
              
            }
          }
          while(z==0);//end of (do1)
        }
        break;
        default:
        Sop.println();
        Sop.println(WrongCh);
        Sop.println(WrongSt2);
        Sop.println();
        }
        if((ch>=1)&&(ch<=4))
        {
          Sop.println(Design);
          Sop.println("Enter Y or Yes if you Want to Input Again");
          Sop.println("Enter any Other Button to Quit");
          choice=br.readLine();
        }
       }
       Sop.println(Design);
       Sop.println("Thanking You");
       Sop.println("This Program was made by Manish M Pillai");
       Sop.println(Design);
     }
}

/*
 * Important Notes 
 * 
 * Sop-> This variable is made to Avoid wring System.out for printing
 * 
 * LV -> Local variables i.e C,P and K 
 * where C->Cipher Text
 *       P->Plain Text
 *       K->Key
 * 
 *
 * do1 -> This Do is made for Internal Choice of the type of Cipher method i.e it takes Input for Encryption,Decryption
 *        and Cracking
 *        It has variable z to stop
 *        It repeats if user enters wrong choice or not a number
 * 
 * 
 * Note:In future if you want to show key in the output:-
 * Caesar Cipher Direct Print
 * MonoAlphabetic Cipher Print both the Array
 * Vignere Cipher Print Directly
 * PlayFair Cipher Use the for loop technique used for Plaintext to remove extar characters other than plaintext then print it out
 * 
 * 
 * 
 * 
 *
 * 
 * 
 * 
 * 
 * 
 */     