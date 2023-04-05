package Cipher;
public class CipherData
{

    /*Caesar Cipher Encryption Function */
   public String CaesarCipherEncryption(String P,int K) // Caesar Cipher Encryption Function
   {
    P=P.toLowerCase();
    int t;
    String st="";
    String C="";
    for(int i=0;i<P.length();i++)
    {
        char ch=P.charAt(i);
        if(Character.isLetter(ch))
        {
            st=st+ch;
        }
        else // this condition is not there now but will be used to remove whitespace if needed in future
        {
            st=st+ch;
        }
    }
    /*Encryption Logic */
    for(int i=0;i<st.length();i++)
    {
        char ch=st.charAt(i);
        if(Character.isLetter(ch))
        {
            t=(((int)ch-97)+K)%26;
            t=t+97;
            C=C+(char)t;
        }
        else
        {
            C=C+ch;
        }
    }
    C=C.toUpperCase();
    return C;
    }


    /*Caesar Cipher Decryption Function */
    public String CaesarCipherDecryption(String C,int K) // Caesar Cipher Decryption Function
    {
        C=C.toUpperCase();
        int t;
        String st="";
        String P="";
        for(int i=0;i<C.length();i++)
        {
            char ch=C.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
            else // this condition is not there now but will be used to remove whitespace if needed in future
            {
                st=st+ch;
            }
        }
        /*Decryption Logic */
        for(int i=0;i<st.length();i++)
        {
            char ch=st.charAt(i);
            if(Character.isLetter(ch))
            {
                t=(((int)ch-65)-K)%26;
                if(t<0)
                {
                    t=65+26+t;
                }
                else
                {
                    t=t+65;
                }
                P=P+(char)t;
            }
            else
            {
                P=P+ch;
            }
        }
        P=P.toLowerCase();
        return P;
    }


    /*Caesar Cipher Hack Function */
    public String[] CaesarCipherHack(String C) // Caesar Cipher Hack Function
    {
        // Using BruteForce Attack To Crack the PlainText
        C=C.toUpperCase();
        String P[] = new String[26];
        for(int i=0;i<26;i++)
        {
            P[i]="";
        }
        int t;
        String st="";
        for(int i=0;i<C.length();i++)
        {
            char ch=C.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
            else // this condition is not there now but will be used to remove whitespace if needed in future
            {
                st=st+ch;
            }
        }
        /*Brute Force Attack Logic */
        for(int K=0;K<26;K++)
        {
            for(int i=0;i<st.length();i++)
            {
                char ch=st.charAt(i);
                if(Character.isLetter(ch))
                {
                    t=(((int)ch-65)+K)%26;
                    t=t+65;
                    P[K]=P[K]+(char)t;
                }
                else
                {
                    P[K]=P[K]+ch;
                }
            }
        }
        for(int K=0;K<26;K++)
        {
            P[K]=P[K].toLowerCase();
        }
        return P;
    }



    /*Mono Alphabetic Cipher Encryption Function */
    public String MonoAlphabeticCipherEncryption(String P,char K[]) // Mono Alphabetic Cipher Encryption Function
    {
        P=P.toLowerCase();
        String C="";
        String st="";
        String str="";
        char A[] = new char[26];
        for(int i=97;i<=122;i++)
        {
            A[i-97]=(char)i;
        }
        for(int i=0;i<26;i++)
        {
            K[i]=Character.toUpperCase(K[i]);
        }
        for(int i=0;i<P.length();i++)
        {
            char ch=P.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
            else // this condition is not there now but will be used to remove whitespace if needed in future
            {
                st=st+ch;
            }
        }
        /*Encryption Logic */
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<st.length();j++)
            {
                char ch=st.charAt(j);
                if(ch==A[i])
                {
                    str=str+K[i];
                }
                else
                {
                    str=str+ch;
                }
            }
            st=str;
            str="";
        }
        C=st;
        C=C.toUpperCase();
        return C;
    }


    /*Mono Alphabetic Cipher Decryption Function */
    public String MonoAlphabeticCipherDecryption(String C,char K[]) // Mono Alphabetic Cipher Decryption Function
    {
        C=C.toUpperCase();
        String P="";
        String st="";
        String str="";
        char L[] = new char[26];
        for(int i=65;i<=90;i++)
        {
            L[i-65]=(char)i;
        }
        for(int i=0;i<26;i++)
        {
            K[i]=Character.toLowerCase(K[i]);
        }
        for(int i=0;i<C.length();i++)
        {
            char ch=C.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
            else // this condition is not there now but will be used to remove whitespace if needed in future
            {
                st=st+ch;
            }
        }
        /*Decryption Logic */
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<st.length();j++)
            {
                char ch=st.charAt(j);
                if(ch==L[i])
                {
                    str=str+K[i];
                }
                else
                {
                    str=str+ch;
                }
            }
            st=str;
            str="";
        }
        P=st;
        P=P.toLowerCase();
        return P;
    }


    /*Vignere Cipher Encryption Function */
    public String VignereCipherEncrypiton(String P,String K) //Vignere Cipher Encryption Function
    {
        P=P.toLowerCase();
        K=K.toLowerCase();
        String st="";
        String C="";
        int t;
        int j=0;
        for(int i=0;i<P.length();i++)
        {
            char ch=P.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
            else // this condition is not there now but will be used to remove whitespace if needed in future
            {
                st=st+ch;
            }
        }
        /*Encryption Logic */
        for(int i=0;i<st.length();i++)
        {
            char ch=st.charAt(i);
            if(Character.isLetter(ch))
            {
                t=(((int)ch-97)+((int)K.charAt(j)-97))%26;
                t=t+97;
                C=C+(char)t;
                j=++j%K.length();
            }
            else
            {
                C=C+ch;
            }
        }
        C=C.toUpperCase();
        return C;
    }



    /*Vignere Cipher Decryption Function */
    public String VignereCipherDecryption(String C,String K) // Vignere Cipher Decryption Function
    {
        C=C.toUpperCase();
        K=K.toUpperCase();
        String st="";
        String P="";
        int t;
        int j=0;
        for(int i=0;i<C.length();i++)
        {
            char ch=C.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
            else // this condition is not there now but will be used to remove whitespace if needed in future
            {
                st=st+ch;
            }
        }
        /*Decryption Logic */
        for(int i=0;i<st.length();i++)
        {
            char ch=st.charAt(i);
            if(Character.isLetter(ch))
            {
                t=(((int)ch-65)-((int)K.charAt(j)-65))%26;
                if(t<0)
                {
                    t=t+26+65;
                }
                else
                {
                    t=t+65;
                }
                P=P+(char)t;
                j=++j%K.length();
            }
            else
            {
                C=C+ch;
            }
        }
        P=P.toLowerCase();
        return P;
    }


    /*PlayFair Cipher Encryption Function */
    public String PlayFairCipherEncryption(String P,String K) // PlayFair Cipher Encryption Function
    {
        String C="";
        P=P.toLowerCase();
        K=K.toLowerCase();
        String st="";// To Store the Plain Text without Spaces Numbers Special Characters etc
        String str="";// To Store the Key without Spaces Numbers Special Characters etc
        String Ptemp="";// To Store the Plaintext in a format which would be encrypted
        String PF[][]=new String[5][5];// PlayFair Cipher Table Structure
        String a[]=new String[25];// Array for Storing Letters
        String PF_Temp[];// Temporary Structure to Store the Elements for the PlayFair Cipher table
        int t=0;//Temporary value for Storing the current valuer of PF_Temp[] 
        boolean x;//Boolean Varialbe for Removing Duplicates in the logic
        int r1,r2,c1,c2;//To Store the index in Encryption Logic
        /*To Store Empty Spaces in Playfair Cipher Table */
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                PF[i][j]="";
            }
        }

        /* To Remove WhiteSpaces Numbers Special Characters etc from the PlainText*/
        for(int i=0;i<P.length();i++)
        {
            char ch=P.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
        }

        /* To Remove WhiteSpaces Numbers Special Characters etc from the Key*/
        for(int i=0;i<K.length();i++)
        {
            char ch=K.charAt(i);
            if(Character.isLetter(ch))
            {
                str=str+ch;
            }
        }

        /*For Now We are Considering i and j to be equal so replacing all j with i */
        st=st.replace('j','i');
        str=str.replace('j','i');

        /*For Loop for Storing Alphabets */
        for(int i=97;i<122;i++)
        {
            if(i>=106)
            {
                a[i-97]=Character.toString((char)i+1);
            }
            else
            {
                a[i-97]=Character.toString((char)i);
            }
        }



        /*Logic To Store the Key and Remaining Alphabets and removing duplicates in the Temporary PlayFair Cipher Structure */
        PF_Temp=new String[str.length()+25];//Defining Size for removing Array Out of bounds Error
        for(int i=0;i<str.length();i++)
        {
            x=true;
            char ch=str.charAt(i);
            for(int j=i;j>=0;j--)
            {
                if(Character.toString(ch).equals(PF_Temp[j]))
                {
                    x=false;
                }
            }
            if(x)
            {
                PF_Temp[t]=Character.toString(ch);
                t++;
            }
        }
        for(int i=0;i<25;i++)
        {
            x=true;
            for(int j=t;j>=0;j--)
            {
                if(a[i].equals(PF_Temp[j]))
                {
                    x=false;
                }
            }
            if(x)
            {
                PF_Temp[t]=a[i];
                t++;
            }
        }

        /*Code to create the Actual PlayFair Cipher Structure */
        t=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                PF[i][j]=PF_Temp[t];
                t++;
            }
        }

        /*Logic to Convert Plaintext into Text that can be Encrypted*/
        Ptemp=st+" ";
        do
        {
            st="";
            x=false;
            for(int i=0;i<Ptemp.length();i=i+2)
            {
                try
                {
                    if(Ptemp.charAt(i)==Ptemp.charAt(i+1))
                    {
                        st=st+Ptemp.charAt(i)+"x";
                        st=st+Ptemp.substring(i+1,Ptemp.length());
                        x=true;
                        break;
                    }
                    else
                    {
                        st=st+Ptemp.charAt(i)+Ptemp.charAt(i+1);
                    }
                }
                catch(Exception e)
                {
                    break;
                }
            }
            Ptemp=st;
        }
        while(x);
        Ptemp=Ptemp.trim();
        st=Ptemp;
        if(st.length()%2!=0)// If the size of the plaintext is odd
        {
            st=st+"x";
        }

        /*Encryption Logic */
        for(int i=0;i<st.length();i=i+2)
        {
            r1=-1;
            r2=-1;
            c1=-1;
            c2=-1;
            for(int j=0;j<5;j++)
            {
                for(int k=0;k<5;k++)
                {
                    if(Character.toString(st.charAt(i)).equals(PF[j][k]))
                    {
                        r1=j;
                        c1=k;
                    }
                    if(Character.toString(st.charAt(i+1)).equals(PF[j][k]))
                    {
                        r2=j;
                        c2=k;
                    }
                }
            }
            if((r1==r2)&&(c1==c2))
            {
                C=C+PF[r1][(c1+1)%5]+PF[r2][(c2+1)%5];
            }
            else if((r1==r2)&&(c1!=c2))
            {
                C=C+PF[r1][(c1+1)%5]+PF[r2][(c2+1)%5];
            }
            else if((r1!=r2)&&(c1==c2))
            {
                C=C+PF[(r1+1)%5][c1]+PF[(r2+1)%5][c2];
            }
            else
            {
                C=C+PF[r1][c2]+PF[r2][c1];
            }
        }
        C=C.toUpperCase();
        return C;
    }

    /*PlayFair Cipher Decryption Function */
    public String PlayFairCipherDecryption(String C,String K) // PlayFair Cipher Encryption Function
    {
        String P="";
        C=C.toUpperCase();
        K=K.toUpperCase();
        String st="";// To Store the Cipher Text without Spaces Numbers Special Characters etc
        String str="";// To Store the Key without Spaces Numbers Special Characters etc
        String Ctemp="";// To Store the CipherText in a format which would be encrypted
        String PF[][]=new String[5][5];// PlayFair Cipher Table Structure
        String a[]=new String[25];// Array for Storing Letters
        String PF_Temp[];// Temporary Structure to Store the Elements for the PlayFair Cipher table
        int t=0;//Temporary value for Storing the current valuer of PF_Temp[] 
        boolean x;//Boolean Varialbe for Removing Duplicates in the logic
        int r1,r2,c1,c2;//To Store the index in Encryption Logic
        /*To Store Empty Spaces in Playfair Cipher Table */
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                PF[i][j]="";
            }
        }

        /* To Remove WhiteSpaces Numbers Special Characters etc from the CipherText*/
        for(int i=0;i<C.length();i++)
        {
            char ch=C.charAt(i);
            if(Character.isLetter(ch))
            {
                st=st+ch;
            }
        }

        /* To Remove WhiteSpaces Numbers Special Characters etc from the Key*/
        for(int i=0;i<K.length();i++)
        {
            char ch=K.charAt(i);
            if(Character.isLetter(ch))
            {
                str=str+ch;
            }
        }

        /*For Now We are Considering i and j to be equal so replacing all j with i */
        st=st.replace('j','i');
        str=str.replace('j','i');

        /*For Loop for Storing Alphabets */
        for(int i=65;i<90;i++)
        {
            if(i>=74)
            {
                a[i-65]=Character.toString((char)i+1);
            }
            else
            {
                a[i-65]=Character.toString((char)i);
            }
        }


        /*Logic To Store the Key and Remaining Alphabets and removing duplicates in the Temporary PlayFair Cipher Structure */
        PF_Temp=new String[str.length()+25];//Defining Size for removing Array Out of bounds Error
        for(int i=0;i<str.length();i++)
        {
            x=true;
            char ch=str.charAt(i);
            for(int j=i;j>=0;j--)
            {
                if(Character.toString(ch).equals(PF_Temp[j]))
                {
                    x=false;
                }
            }
            if(x)
            {
                PF_Temp[t]=Character.toString(ch);
                t++;
            }
        }
        for(int i=0;i<25;i++)
        {
            x=true;
            for(int j=t;j>=0;j--)
            {
                if(a[i].equals(PF_Temp[j]))
                {
                    x=false;
                }
            }
            if(x)
            {
                PF_Temp[t]=a[i];
                t++;
            }
        }

        /*Code to create the Actual PlayFair Cipher Structure */
        t=0;
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                PF[i][j]=PF_Temp[t];
                t++;
            }
        }

        /*Logic to Convert CipherText into Text that can be Decrypted*/
        Ctemp=st+" ";
        do
        {
            st="";
            x=false;
            for(int i=0;i<Ctemp.length();i=i+2)
            {
                try
                {
                    if(Ctemp.charAt(i)==Ctemp.charAt(i+1))
                    {
                        st=st+Ctemp.charAt(i)+"x";
                        st=st+Ctemp.substring(i+1,Ctemp.length());
                        x=true;
                        break;
                    }
                    else
                    {
                        st=st+Ctemp.charAt(i)+Ctemp.charAt(i+1);
                    }
                }
                catch(Exception e)
                {
                    break;
                }
            }
            Ctemp=st;
        }
        while(x);
        Ctemp=Ctemp.trim();
        st=Ctemp;
        if(st.length()%2!=0)// If the size of the CipherText is odd
        {
            st=st+"x";
        }

        /*Decryption Logic */
        for(int i=0;i<st.length();i=i+2)
        {
            r1=-1;
            r2=-1;
            c1=-1;
            c2=-1;
            for(int j=0;j<5;j++)
            {
                for(int k=0;k<5;k++)
                {
                    if(Character.toString(st.charAt(i)).equals(PF[j][k]))
                    {
                        r1=j;
                        c1=k;
                    }
                    if(Character.toString(st.charAt(i+1)).equals(PF[j][k]))
                    {
                        r2=j;
                        c2=k;
                    }
                }
            }
            if((r1==r2)&&(c1==c2))
            {
                c1=c1-1;
                c2=c2-1;
                if(c1<0)
                {
                    c1=5;
                }
                if(c2<0)
                {
                    c2=5;
                }
                P=P+PF[r1][c1]+PF[r2][c2];
            }
            else if((r1==r2)&&(c1!=c2))
            {
                c1=c1-1;
                c2=c2-1;
                if(c1<0)
                {
                    c1=5;
                }
                if(c2<0)
                {
                    c2=5;
                }

                P=P+PF[r1][c1]+PF[r2][c2];
            }
            else if((r1!=r2)&&(c1==c2))
            {
                r1=r1-1;
                r2=r2-1;
                if(r1<0)
                {
                    r1=5;
                }
                if(r2<0)
                {
                    r2=5;
                }
                P=P+PF[r1][c1]+PF[r2][c2];
            }
            else
            {
                P=P+PF[r1][c2]+PF[r2][c1];
            }
        }
        P=P.toLowerCase();
        return P;
    }
}