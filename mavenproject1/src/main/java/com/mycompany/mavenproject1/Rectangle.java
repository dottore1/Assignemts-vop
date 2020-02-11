/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Nichlas
 */
public class Rectangle extends AbstractShape {
        
        private double l1; 
        private double l2;
        
        public Rectangle(double l1, double l2){
            this.l1 = l1; 
            this.l2 = l2;
            
        }
        

    @Override
    public double getArea() {
        double area = (this.l1 * this.l2);
        return area; 
    }

    @Override
    public double getCircumference() {
        double circumference = (2*(this.l1 + this.l2));
        return circumference;
    }

    public double getL1() {
        return l1;
    }

    public void setL1(double l1) {
        this.l1 = l1;
    }

    public double getL2() {
        return l2;
    }

    public void setL2(double l2) {
        this.l2 = l2;
    }
    
    
    
    
    
    
    
}
