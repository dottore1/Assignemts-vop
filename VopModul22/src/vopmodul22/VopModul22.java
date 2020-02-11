
package vopmodul22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VopModul22 {

    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("C:\\Users\\Nichlas\\Desktop\\hello.txt.txt");
        Scanner in = new Scanner(text);
        System.out.println(in.hasNext());
        
        in.next();
        while(in.hasNext()){
            System.out.println(in.next());
        }
        
        
        
    }
    
}
