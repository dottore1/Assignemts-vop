/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

public class Ellipse extends AbstractShape{
    
    private double r1;
    private double r2;
    
    public Ellipse(double r1, double r2){
        this.r1 = r1;
        this.r2 = r2;
    }
    
    @Override
    public double getArea() {
        double area = PI*this.r1*this.r2;
        return area;
    }

    @Override
    public double getCircumference() {
        double circumference = ((2*PI)*Math.sqrt(0.5*(Math.pow(this.r1, 2) + Math.pow(this.r2, 2))));
        return circumference; 
        
       
    }

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }
    
    
}
