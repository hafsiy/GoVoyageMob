/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

/**
 *
 * @author aessegh
 */
public class Chaine {
    String Name;
    String Ename;

    public Chaine(String name, String desc) {
        this.Name = name;
        this.Ename = desc;
    }

    public String getName() {
        return Name;
    }

    public String getDesc() {
        return Ename;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setDesc(String desc) {
        this.Ename = desc;
    }

    
    
}
