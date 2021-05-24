/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leftviewbinarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class LeftViewBinaryTree {

    int maxLvl = 0;
    
    void leftViewIteration(Node root, int lvl, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        if (maxLvl < lvl) {
            //Using Iteration
            result.add(root.N);
            maxLvl = lvl;
        }
        //without right view
        leftViewIteration(root.left, lvl+1, result);
//        leftViewIteration(root.right, lvl+1, result);
    }
    void rightViewIteration(Node root, int lvl, List<Integer> result) {
        if (root == null) {
            return;
        }
        
        if (maxLvl < lvl) {
            //Using Iteration
            result.add(root.N);
            maxLvl = lvl;
        }
        //without right view
        rightViewIteration(root.right, lvl+1, result);
//        leftViewIteration(root.right, lvl+1, result);
    }
    
    //Implement Space Optimization
    void leftView(Node root, int lvl) {
        if (root == null) {
            return;
        }
        leftView(root.left, lvl+1);
        if (maxLvl < lvl) {
            System.out.print(root.N);
            maxLvl = lvl;
        }
        
        //without right view
//        leftView(root.left, lvl+1);
//        leftView(root.right, lvl+1);
    }
    
     //Implement Space Optimization
    void rightView(Node root, int lvl) {
        if (root == null) {
            return;
        }
        rightView(root.right, lvl+1);
        if (maxLvl < lvl) {
            System.out.print(root.N);
            maxLvl = lvl;
        }
        
        //without right view
//        leftView(root.left, lvl+1);
//        leftView(root.right, lvl+1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(6);
        //Implement Space Optimization with right view
//        LeftViewBinaryTree le = new LeftViewBinaryTree();
//        le.maxLvl = 0;
//        le.leftView(root, 1);
//        le.maxLvl = 0;
//        le.rightView(root, 1);


        //Implement Space Optimization
//        LeftViewBinaryTree le = new LeftViewBinaryTree();
//        le.leftView(root, 1);
        
        //Using Iteration add List or Array
        List<Integer> result = new ArrayList<>();
        LeftViewBinaryTree le = new LeftViewBinaryTree();
        le.maxLvl = 0;
        le.leftViewIteration(root.left, 1, result);
        
        Collections.reverse(result);
        le.maxLvl = 0;
        le.rightViewIteration(root, 1, result);
        for (Integer value : result) {
            System.out.println(value);
        }
    }
    
}
