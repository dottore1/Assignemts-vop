/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author erso
 */
public class ShapeFacade {

    //Singleton Stufff:
    private static ShapeFacade instance = null;

    public static ShapeFacade getInstance() {
        if (instance == null) {
            instance = new ShapeFacade();
        }
        return instance;
    }

    private ShapeFacade() {
    }
    //---------------------------

    // enum som kendes af GUI'en
    public enum SHAPES {
        CIRCLE, ELLIPSE, RECTANGLE, SQUARE
    };

    // Facadens public metoder
    public String getShapeInfo(SHAPES shape, double... parametre) {
        if (shape == SHAPES.CIRCLE) {
            Circle c = new Circle(parametre[0]);
            return c.toString();

        } else if (shape == SHAPES.ELLIPSE) {
            Ellipse e = new Ellipse(parametre[0], parametre[1]);
            return e.toString();
        } else if (shape == SHAPES.RECTANGLE) {
            Rectangle r = new Rectangle(parametre[0], parametre[1]);
            return r.toString();

        } else if (shape == SHAPES.SQUARE) {
            Square s = new Square(parametre[0]);
            return s.toString();
        } else {
            return "Error";
        }

    }

}
