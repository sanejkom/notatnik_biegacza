/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateusz
 */
public class Run implements Serializable{
    double distance;
    double avgHR;
    double maxHR;
    Date date;
    //Duration time;
    int timeMinutes;
    double timeSeconds;
    double ratio;
    
    
    public Run(double dis, double a, double m, String d, int tM, double tS) throws ParseException{
        distance = dis;
        avgHR = a;
        maxHR = m;
        date = new SimpleDateFormat("dd/MM/yyyy").parse(d);
        //time = Duration.parse(t);
        timeMinutes = tM;
        timeSeconds = tS;
        ratio = dis / (a * tM); //consider changing to speed / avgHR
    }
    
    public double getDistance(){
        return distance;
    }
    
    public double getAvgHR(){
        return avgHR;
    }
    
    public double getMaxHR(){
        return maxHR;
    }
    
    public Date getDate(){
        return date;
    }
    
//    public Duration getTime(){
//        return time;
//    }
    
    public int getTimeMinutes(){
        return timeMinutes;
    }
    
    public double getTimeSeconds(){
        return timeSeconds;
    }
    
    public double getRatio(){
        return ratio;
    }
    
    public void setDistance(double d){
        distance = d;
    }
    
    public void setAvgHR(double hr){
        avgHR = hr;
    }
    
    public void setMaxHR(double hr){
        maxHR = hr;
    }
    
    public void setDate(String d){
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(d);
        } catch (ParseException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void setTime(String t){
//        time = Duration.parse(t);
//    }
    
    public void setTimeMinutes(int t){
        timeMinutes = t;
    }
    
    public void setTimeSeconds(double t){
        timeSeconds = t;
    }
    
    public void countRatio(){
        ratio = distance / avgHR;
    }
    
//    public String tekst(){
//        String s = "" + String.format("%02d", date.getDate()) + "/" + String.format("%02d", date.getMonth()+1) + "/" + (date.getYear()+1900) + "\t" + distance + "\t" + timeMinutes + "m " + timeSeconds  + "s\t" + avgHR + "\t" + maxHR;
//        return s;
//    }
    
    @Override
    public String toString(){
        //String s = "Data: " + String.format("%02d", date.getDate()) + "/" + String.format("%02d", date.getMonth()+1) + "/" + (date.getYear()+1900) + " Dystans: " + distance + ", Czas: " + timeMinutes + "m " + timeSeconds  + "s, Średnie tętno: " + avgHR + ", Maks. tętno: " + maxHR;
        String s = "" + String.format("%02d", date.getDate()) + "/" + String.format("%02d", date.getMonth()+1) + "/" + (date.getYear()+1900) + "\t" + distance + "\t" + timeMinutes + "m " + timeSeconds  + "s\t" + avgHR + "\t" + maxHR;
        return s;
    }
    
}
