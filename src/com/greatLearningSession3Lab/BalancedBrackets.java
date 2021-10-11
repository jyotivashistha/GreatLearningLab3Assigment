package com.greatLearningSession3Lab;

import java.util.*;
public class BalancedBrackets {
 
    static boolean areBracketsBalanced(String expr)
    {
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
          
                stack.push(x);
                continue;
            }
 
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        return (stack.isEmpty());
    }
 
    public static void main(String[] args)
    {
    	System.out.println("enter input to check the brackets are balancing or not");
    	Scanner sc=new Scanner (System.in);
    	 String expr=sc.next();
 
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}
