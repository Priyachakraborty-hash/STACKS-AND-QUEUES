import java.io.BufferedReader;
import java.io.InputStreamReader;

class InfixEvaluation
{
    public static void main(String[] args) throws Exception
    {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     String exp =  br.readLine();





     

    }
public int operation(int v1,int v2,char optor)
{
 if(optor == '+')
  {
      return v1+v2;
  }
  else if(optor == '-')
  {
    return v1-v2;
  }
  else if(optor  == '*')
  {
   return v1*v2;
  }
  else
  {
    return v1/v2;
  }
 
}
public int precedence(char ch)
{
  if(ch == '+')
  {
      return 1;
  }
  else if(ch == '-')
  {
    return 1;
  }
  else if(ch == '*')
  {
   return 2;
  }
 else
 {
    return 2;
 }

}

}