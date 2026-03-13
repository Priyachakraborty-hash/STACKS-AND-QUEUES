import java.util.*;


public class Evaluation 
{
    
    //INFIX EVALUATION : value1 operator value2 , eg : (5+4)*2 = 18,5+4*2 = 13
    //priorities : //B=3,/=2,*-2,+ =1,- =1
    //greater prioritty operator on lower priority operator can pushed
   //
   //helper functions

   public static int priority(char op)
   {
    if(op == '/' || op=='*') return 2;
    else if(op == '+' || op=='-') return 1;
    else return 0;

}
   public static int evaluate(int val1,int val2,char op)
   {
     if(op =='*')
     {
        return val1*val2;
     }
    else if(op=='/')
    {
        return val1 / val2;
    }
    else if(op=='+')
    {
         return val1 + val2;
    }
    else if(op =='-')
    {
        return val1 - val2;
    }
    else
    {
        return 0;
    }

   }
   
    public static int infixEvaluation(String str)
    {
     Stack<Charcter> ostack = new Stack<>(); //operator stack
     Stack<Integer> vstack = new Stack<>(); //value stack





        return 0;

    }
    public static void evaluation()
    {

    }
    public static void main(String[] args)
    {
       evaluation();
    }
}
