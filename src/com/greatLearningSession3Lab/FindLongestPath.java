package com.greatLearningSession3Lab;

import java.util.ArrayList;

public class FindLongestPath {

	static class Node
	{
	    Node left;
	    Node right;
	    int data;
	};
	 
	static Node newNode(int data)
	{
	    Node temp = new Node();
	 
	    temp.data = data;
	    temp.left = null;
	    temp.right = null;
	 
	    return temp;
	}
	public static ArrayList<Integer> longestPath(Node root)
	{
	    if(root == null)
	    {
	        ArrayList<Integer> output = new ArrayList<>();
	        return output;
	    }
	    ArrayList<Integer> right = longestPath(root.right);
	    ArrayList<Integer> left = longestPath(root.left);
	    if(right.size() < left.size())
	    {
	        left.add(root.data);
	    }
	    else
	    {
	        right.add(root.data);
	    }
	     
	    return (left.size() >
	            right.size() ? left :right);
	}
	 
	public static void main(String[] args)
	{
	    Node root = newNode(60);
	    root.left = newNode(122);
	    root.right = newNode(30);
	    root.left.right = newNode(420);
	    root.left.left = newNode(25);
	    root.left.right.right = newNode(116);
	     
	    ArrayList<Integer> output = longestPath(root);
	    int n = output.size();
	     
	    System.out.println(output.get(n - 1));
	    for(int i = n - 2; i >= 0; i--)
	    {
	        System.out.println(" -> " + output.get(i));
	    }
	}
}
