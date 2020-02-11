/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vopmodul22;

/**
 *
 * @author Nichlas
 */
public class HexFormatException extends Exception{
    public HexFormatException(String errorMessage, Throwable err){
        super(errorMessage, err);
    }
    
    public HexFormatException(String errormessage){
        super(errormessage);
    }
}
