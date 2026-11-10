/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entité.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakk
 */
public class EmployeeService {
    private final List<Employee> liste;
    private static EmployeeService instance;
    
    public EmployeeService(){
        liste = new ArrayList<>();
    }
    
    public static EmployeeService getInstance(){
        if(instance == null){
            instance = new EmployeeService();
        }
        return instance;
    }

    public void ajouter(Employee p){
        if(p != null){
            liste.add(p);
        }
    }
    
    public void modifier(Employee p){
        for(Employee _p : liste){
            if(_p.equals(p)){
                _p = new Employee(p);
            }
        }
    }
    
    public Employee trouver(Long id){
        for (Employee p : liste){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public void supprimer(Long id){
        for (Employee p : liste){
            if(p.getId() == id){
                liste.remove(p);
            }
        }
        
    }
    
    public void supprimer(Employee p){
        for (Employee _p : liste){
            if(_p.equals(p)){
                liste.remove(_p);
            }
        }
        
    }
    
    public int compter(){
        return liste.size();
    }
    
    public List<Employee> lister(){
        return this.liste;
    }
    
}