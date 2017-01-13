/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook.model;

/**
 *
 * @author Mateusz
 */
public class User {
    double weight;
    int age;
    double maxHR;
    
    public User(double w, int a){
        weight = w;
        age = a;
    }
    
    //University of Oakland formula: Tmax = 206,9 – (0,67 x age)
    public double countMaxHR(){
        maxHR = 206.9 - (0.67 * age);
        return maxHR;
    }
}
