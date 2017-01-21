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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateusz
 */
public class ListOfRuns {

    public ArrayList<Run> list;

    public ListOfRuns() {
        list = new ArrayList<>();
    }

    //add run to list
    public void add(Run r) {
        list.add(r);
    }
    
    public Run get(int i){
        return list.get(i);
    }
    
    public void set(int i, Run r){
        list.set(i, r);
    }

    //load list of runs from a file
    public void load(String name) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        list = (ArrayList<Run>) ois.readObject();
        ois.close();
    }

    //save list of runs to a file
    public void save(String name) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }
    
    public int size(){
        return list.size();
    }
    
    public void updatePlan(Date d){
        for(int i = 0; i < list.size(); i++){
            Date planDate = list.get(i).getDate();
            if(planDate.compareTo(d) <= 0){
                list.remove(i);
            }
        }
        try {
            save("plan.tmp");
        } catch (IOException ex) {
            Logger.getLogger(ListOfRuns.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remove(int i){
        list.remove(i);
    }
}
