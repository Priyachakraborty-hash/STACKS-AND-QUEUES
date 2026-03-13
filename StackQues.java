import java.util.*;
public class StackQues 
{
    
    public static  boolean isDuplicateBrackets(String str)
    {
     Stack<Character> st = new Stack<>();
    for(int i=0;i<str.length();i++)
    {
      //balanced bracked tabhi hoga jab expresseion
      //ke aaage piche brackets ho aur wo kate ek k stah ek
      //dur par agar brackets ho wo duplicate brackets nahi hai,eg: ((a+b) + (c+d))
      //stack par agar kuch bache na toh wo duplicate brackets nahi hai
        char ch = str.charAt(i);
        if(ch != ')')
        {
           st.push(ch);
        }
        else
        {
            if(st.peek()=='(')
            {
                 return true;
            }
            else
                {
                while(st.peek()!='(')
                {
                    st.pop();
                }
                st.pop();
            }
        }
      
    }
    return false;
    }
    public static boolean balancedBracket(String str)
    {
         //balanced bracked tabhi hoga jab ek ke sath ek katega, 
         // like [(a+b)+{(c+d)*(e/f)}]:true.
         //jab stack empty hoga tabhi balanced bracket hoga, eg ((a+b))):ye nahi hai balanced.

    Stack<Character> st = new Stack<>();
     for(int i=0;i<str.length();i++)
     {
       char ch = str.charAt(i);
       if(ch == '{' ||ch == '[' ||ch == '(')
       {
         st.push(ch);
       }
      else if(ch ==')')
      {
        //stack ka size 0 hai, par extra bracket hai humare pas.
        //ya fir st ke peek par ye wala particular bracket nahi hai.
          if(st.size()==0 ||st.peek()!='(' )
          {
                return false;
          }
          st.pop();

      }
      else if(ch =='}')
      {
        if(st.size()==0|| st.peek()!='{')
            {
                  return false;
            }
            st.pop();

      }
      else if(ch ==']')
        {
            if( st.size()==0 ||st.peek()!='[')
                {
                      return false;
                }
                st.pop();
        }
      else
        {
           continue;
        }  
    }
return st.size() == 0;//st.iseMPTY USE NAHI KAREANGE, Qki uska implemenattion dekh lena.
}   
   //next greater element on the right
    public static int[] ngr(int[] arr)
    {    //time : o(n),space:o(n)
        //ek array milega aur usme se next greater element on right side mai nikalna hoga.
      //ek res array bana rahi hu taki usme store kar pau
      int[] res = new int[arr.length];
      //ek stack banaenge usme operations karenge,qki wahi hai jaha par hum check karenge ke
      //uske peak par jo index hai ,us index mai jo element hai wo chota hai ki nahibada hai ki nahi pichle wale se.
      Stack<Integer> st = new Stack<>();
      st.push(0);
      for(int i=1;i<arr.length;i++)
      {
         while(st.size()>0 && arr[st.peek()]<arr[i])
         {
              res[st.pop()] = arr[i];
         }
           st.push(i);
      }
    while(st.size()>0)
    {
        res[st.pop()] = -1;

    }
    return res;
 }
    //next greater on the left
    public static int[] ngl(int[] arr)
    {
     int[] res = new int[arr.length];
     Stack<Integer> st = new Stack<>();
     st.push(arr.length-1);

     for(int i=arr.length-2;i>=0;i--)
     {
     while(st.size()>0 && arr[st.peek()]<arr[i])
      {
           res[st.pop()] = arr[i];
      }
      st.push(i);

     }
    while(st.size()>0)
    {
        res[st.pop()] = -1;
    }
   return res;

    }
    //next smaller on the right
    public static int[] nsr(int[] arr)
    {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++)
        {
           while(st.size()>0 && arr[st.peek()]>arr[i])
           {
                res[st.pop()] = arr[i];
           }
         st.push(i);
        }
        while(st.size()>0)
        {
           res[st.pop()] = -1;
        }
        return res;
    }
    //next smaller element on the left
    public static int[] nsl(int[] arr)

    {
       int[] res = new int[arr.length];
       Stack<Integer> st = new Stack<>();
       st.push(arr.length-1);
       
       for(int i=arr.length-2;i>=0;i--)
       {
            while(st.size()>0 && arr[st.peek()] > arr[i])
            {
                  res[st.pop()] = arr[i];
            }
            st.push(i);
       }
      while(st.size()>0)
      {
        res[st.pop()] = -1;
      }

       return res;
        
    }
 public static int[] stockSpan(int[] arr)
 {
   //is question mai esa pucha gaya hai i stock kitne din pehle zada tha.
   //ye question based hai ngl se
    //ques: 2,5,9,3,1,12,6,8,7
    //ngl: -1,-1,-1,2,3,-1,5,5,7
    //sol: 1,2,3,1,1,6,1,2,1
   
   
   int[] res = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(arr.length-1);

    for(int i=arr.length-2;i>=0;i--)
    {
    while(st.size()>0 && arr[st.peek()]<arr[i])
     {
          res[st.pop()] = i;//bas index store karana hai isme
     }
     st.push(i);

    }
   while(st.size()>0)
   {
       res[st.pop()] = -1;
   }
//last mai res array mai jo bacha hai like greater elements on the left side,we need to just minus that
//from the index

for(int i=0;i<res.length;i++)
{
    res[i] = i - res[i];
}
return res;

 }
//did daily temperature
public static int[] leftSmallerIndex(int[] arr)
{
   int[] res = new int[arr.length];
   Stack<Integer> st = new Stack<>();
   st.push(arr.length-1);
   for(int i=arr.length-2;i>=0;i--)
   {
     while(st.size()>0 && arr[st.peek()] > arr[i])
     {
         res[st.pop()] = i;
     }

   st.push(i);

   }
while(st.size()>0)
{
   res[st.pop()] = -1;
}
return res;
}
public static int[] rightSmallerIndex(int[] arr)
{
    
    int[] res = new int[arr.length];
    Stack<Integer> st = new Stack<>();
    st.push(0);
    for(int i=1;i<arr.length;i++)
    {
      while(st.size()>0 && arr[st.peek()] > arr[i])
      {
          res[st.pop()] = i;
      }
 
    st.push(i);
 
    }
 while(st.size()>0)
 {
    res[st.pop()] = arr.length;
 }
 return res;

}
public static int largesthistogram(int[] arr)
{
  // is question mai histogram dia hua rahega ,uska largest area find karna hai
  //question mai area dia hua rahega aur unka area in arr[i] mai
  //hum left and right smaller nikalenge qki left smaller matlab us element ke immidiate left mai jab tak small milta hai tab tak baki sab bigger hai
  //same right small ke lia hai.
  //basically area tab tak hi spread hoga jab jab usme usse no se bada element tha,like 6 hai agar to wo 7 mai spread hua hoga,8 mai spread hua hoga

    int area = 0;

    int[] lsi = leftSmallerIndex(arr);
    int[] rsi = rightSmallerIndex(arr);
    int st=0; //if we want on which index it issmaller
    int end=0;

    for(int i=0;i<arr.length;i++)
    {

       int width = rsi[i] - lsi[i]-1;
       int height = arr[i];
       if(area < width * height)
       {
            area = width * height;
            st = lsi[i];
            end =rsi[i];
       }

    }

    System.out.println(" max area exist in "+ (st+1)+" -> "+(end-1)+" index ");
    return area;
}
public static int maximalRectangle(char[][] matrix)
{
    //lc 85
    //0 ya 1 ka dia hu rahega bas largest area nikalna hai using wo humara histogram method
    int res = 0;
   //res ko array mai store kar lenge aur usi ko add karte rahenge
   int[] arr = new int[matrix[0].length];
   if(matrix.length == 0 || matrix[0].length==0)
   {
       return 0;
   }

for(int i=0;i<matrix.length;i++)
{
    for(int j=0;j<matrix[0].length;j++)
    {
     
          if(matrix[i][j] =='0')
          {
               arr[j] = 0;
          }
          else
          {
              //single array mai convert =karke uska bada area nikalenge
              arr[j] += matrix[i][j] -'0';
          }

    }
    res = Math.max(res, largesthistogram(arr));

}

   return res ;
}

public static void findCelebrity(int[][] arr)
{
   Stack<Integer> st = new Stack<>();
   for(int i=0;i<arr.length;i++)
   {
       st.push(i);
   }
  while(st.size()>1)
  {
    //agar i ,j ko janata hai to wo celebrity nahi hia. 
    //only 1 can be celebrity,nobod else. Sab usko jante hai par wo kiskiko nahi janta.
    
    int i = st.pop();
    int j = st.pop();
     if(arr[i][j] == 1)
     {
          st.push(j);
     }
     else
     {
        st.push(i);
     }
  }
  int candidate = st.pop();
//humne potention candidate dhund lia hai
//usme traverese karenge and validate karenge ki wahi candidate hai ki nahi.
for(int c = 0;c<arr.length;c++)
{
      if(arr[candidate][c] == 1)
      {
          System.out.println("none");
          return;
      }
}
for(int r=0;r<arr.length;r++)
{
     if(r!=candidate && arr[r][candidate] == 0)
     {
         System.out.println("none");
         return;
     }
}
System.out.println(candidate);

}
public static class Pair implements Comparable<Pair>
{
    int st=0;
    int end=0;
    public Pair(int st,int end)
    {
    this.st = st;
    this.end = end;
    }
public int compareTo(Pair o)
{
 return this.st - o.st; 
}
}
public static void mergeOverlappingInteval(int[][]arr)
{
    //hummlogo ko intervals dia gaya hai hume sort karna hai uske according and then merge

    Pair[] pairs = new Pair[arr.length];//pair class banaya hai taki sort kar paye
    
    //fir usko array mai le rahe hai like esa 
    //0:{22,28}, 
    //1: {1,8},
    //2:{25,27},
    //3:{14,19},
    //4:{27,30},
    //5:{5,12};
   
    for(int i=0;i<arr.length;i++)
    {
       pairs[i] = new Pair(arr[i][0],arr[i][1]);
    }
    Arrays.sort(pairs);
    // for(Pair p : pairs)
    // {
      //  syso
    // }

Stack<Pair> st = new Stack<>();
st.push(pairs[0]);
for(int i=1;i<pairs.length;i++)
{

     Pair p = pairs[i];
     if(p.st <= st.peek().end)
     {
       if(p.end>st.peek().end)
       {
            st.peek().end = p.end;
       }
     }
     else
     {
        st.push(p);
     }
}
Stack<Pair> rst = new Stack<>();
while(st.size()>0)
{
   rst.push(st.pop());
}
while(rst.size()>0)
{
Pair rem = rst.pop();
System.out.println(rem.st+","+rem.end);
}

}
 public static void smallestNumberFollowingPattern(String str)
 {

      //inme ek input milega like ddiidid : op : 32146587
     // hume stack ke behaviour ka faida lena hai
     //agar d : aya toh sirf push and count++
     //agar i: aya toh fir push and count++, and then print
      int count = 1;
      Stack<Integer> st = new Stack<>();
      for(int i=0;i<str.length();i++)
      {
         st.push(count);
         count++;
         if(str.charAt(i) =='i')
         {
              while(st.size()>0)
              {
                 System.out.print(st.pop()+" ");
              }
         }

      }
      st.push(count);
      while(st.size()>0)
        {
           System.out.print(st.pop()+" ");
        }



 }
public static void fun()
    {


 String str ="ddiidid";
 smallestNumberFollowingPattern(str);


//input for mergeOverlappinginteval
// int[][] arr = {{22,28},{1,8},{25,27},{14,19},{27,30},{5,12}};
// mergeOverlappingInteval(arr);


  //input for find celebrity
//   int[][] arr ={{1,0,1,0,1},
//                 { 1,1,1,1,0},
//                 {0,0,0,0,0},
//                 {1,0,1,1,0},
//                 {0,1,1,1,0}};
//int [][] arr = {{0,0,0},{0,0,0}};
  //findCelebrity(arr);

       // int[] arr = {6,2,6,5,5,6,1,7};
        //int res = largesthistogram(arr);
        //System.out.println(res);
   // int[] arr = {10,6,12,5,3,2,4,8,1};
  // int[] arr = {2,5,9,3,1,12,6,8,7};
    //int[] res = ngl(arr);
    //int[] res = nsr(arr);
    //int[] res = nsr(arr);
    //int[] res = nsl(arr);
    //int[] res = stockSpan(arr);
// for(int i=0;i<arr.length;i++)
    // {
    //     System.out.print(res[i]+" ");
    // }
    //  String s = "((a+b))";
    //  boolean res = isDuplicateBrackets(s);
    // String s = "[(a+b)+{(c+d)*(e/f)}]";
    //  String s  = "[a+]";

    // boolean res = balancedBracket(s);
    // System.out.println(res);

    }
    public static void main(String[] args)
    {
       fun();
    }
}
