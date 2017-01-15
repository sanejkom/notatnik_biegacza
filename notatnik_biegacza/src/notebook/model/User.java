/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Mateusz
 */
public class User implements Serializable{
    double weight;
    int age;
    double maxHR;
    
    public User(int a, double w){
        weight = w;
        age = a;
    }
    
    public User(){
        age = 1;
        weight = 1;
    }
    
    
    //University of Oakland formula: Tmax = 206,9 – (0,67 x age)
    public void countMaxHR(){
        maxHR = 206.9 - (0.67 * age);
        //return maxHR;
    }
    
    public void setAge(int a){
        age = a;
    }
    
    public void setWeight(double w){
        weight = w;
    }
    
    public int getAge(){
        return age;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public double getMaxHR(){
        return maxHR;
    }
    
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("user.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User u = (User) ois.readObject();
        ois.close();
        
        age = u.getAge();
        weight = u.getWeight();
        countMaxHR();
    }

    //save list of runs to a file
    public void save() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("user.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }
}
