/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4queen;

import java.util.PriorityQueue;

/**
 *
 * @author Yash
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static boolean check(String str,int row,int col)
    {
        col--;
        int [][]chessBoard=ChessBoard(str);
        int j=0,k=0;
        /* Check upper diagonal on left side */
        for ( j = row, k =col; j >= 0 && k >= 0; j--, k--) 
        {
            if (chessBoard[j][k] == 1) 
                return false; 
        }
        /* Check upper diagonal on right side */
        for (j = row, k = col; j >= 0 && k < str.length(); j--, k++) 
            if (chessBoard[j][k] == 1) 
                return false; 
        /* Check lower diagonal on left side */
        for (j = row, k = col; j <str.length() && k >= 0; j++, k--) 
            if (chessBoard[j][k] == 1) 
                return false; 
        /* Check lower diagonal on right side */
        for (j = row, k = col; j<str.length() && k < str.length(); j++, k++) 
            if (chessBoard[j][k] == 1) 
                return false;   
        return true;
    }
    static int [][] ChessBoard(String str)
    {
        int [][]chessBoard=new int[4][4];
        for(int i=0;i<str.length();i++)
        {
            for(int j=0;j<str.length();j++)
            {
                int val=Integer.parseInt(String.valueOf(str.charAt(i)))-1;
                if(j==val)
                    chessBoard[i][j]=1;
                else
                    chessBoard[i][j]=0;
            }
        }
        return chessBoard;
    }
    static void printMAtrix(String str)
    {
        int [][]chessBoard=ChessBoard(str);
        for(int i=0;i<str.length();i++)
        {
            for(int j=0;j<str.length();j++)
            {
                System.out.print(chessBoard[i][j]+" ");
            }
            System.out.println("");
        }
    }
    static String reverse(String input)
    {
        StringBuilder input1 = new StringBuilder(); 
  
        // append a string into StringBuilder input1 
        input1.append(input); 
  
        // reverse StringBuilder input1 
        input1 = input1.reverse(); 
        return input1.toString();
    }
    public static void main(String[] args) {
        PriorityQueue<String> queue=new PriorityQueue<>();
        PriorityQueue<String> ans=new PriorityQueue<>();
        queue.add("1000");queue.add("2000");
        boolean flag=true;
        while(flag)
        {
            if(queue.size()==0)
                break;
            int index;
            String str=queue.poll();
            if(str.contains("0"))
            {
                index=str.indexOf("0");
            }     
            else
            {       
                ans.add(str);
                ans.add(reverse(str));
                continue;
            }
            for(int i=1;i<5;i++)
            {
                String temp=String.valueOf(i);
                if(!str.contains(temp) && check(str,index,i))
                {
                    String newStr;
                    if(index==0)
                        newStr=(str.substring(0)) + temp + (str.substring(index+1));
                    else if(index==str.length()-1)
                        newStr=(str.substring(0, index)) + temp;
                    else
                        newStr=(str.substring(0, index)) + temp + (str.substring(index+1));
                    
                    queue.add(newStr);                            
                }                    
            }
        }
        for(String str:ans)
        {
            System.out.println("["+str.charAt(0)+","+str.charAt(1)+","+str.charAt(2)+","+str.charAt(3)+"]");
            printMAtrix(str);
            System.out.println("---------");   
            
        }
    } 
}
