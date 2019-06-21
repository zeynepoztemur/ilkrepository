/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.operatingsystem;

import java.io.File;

/**
 *
 * @author zeynepoztemur
 */
public class myclass {
    
   public static void listFilesForFolder(final File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            listFilesForFolder(fileEntry);
        } else {
            System.out.println(fileEntry.getName());
        }
    }
}
public static void main(String args[]){
    
String s1="my name is khan my name is java";
String replaceString=s1.replace("is","was");

System.out.println(replaceString);

}
}
