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

    //load list of runs from a file
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("list.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        list = (ArrayList<Run>) ois.readObject();
        ois.close();
    }

    //save list of runs to a file
    public void save() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("list.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }
    
    public int size(){
        return list.size();
    }
    
}
