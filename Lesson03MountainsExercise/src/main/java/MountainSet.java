import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MountainSet {

    private Set<Mountain> mountainSet;

    public MountainSet(){
        this.mountainSet = new TreeSet<Mountain>();
    }

    public static void main(String[] args){
        MountainSet ms = new MountainSet();
        MountainSet msr = new MountainSet();

        File file = new File("FranskeBjerge.csv");
        Scanner input = null;
        try {
            input = new Scanner(file);
            while(input.hasNextLine()){
                String[] word = input.nextLine().split(";");

                Mountain tempMountain = new Mountain(word[0], word[1], word[2], word[3], word[4], word[5]);
                ms.getMountainSet().add(tempMountain);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            input.close();
            System.out.println(ms.getMountainSet());
            System.out.println("-----------------------------------------");
            System.out.println(ms.sortByRange(new MountainRangeComparator()));
        }


    }
    public Set<Mountain> sortByRange(Comparator comp){
        Set<Mountain> mountainTreeSet = new TreeSet<Mountain>(comp);
        File file = new File("FranskeBjerge.csv");
        Scanner input = null;
        try {
            input = new Scanner(file);
            while(input.hasNextLine()){
                String[] word = input.nextLine().split(";");

                Mountain tempMountain = new Mountain(word[0], word[1], word[2], word[3], word[4], word[5]);
                mountainTreeSet.add(tempMountain);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            input.close();
        }


        return mountainTreeSet;
    }

    public Set<Mountain> getMountainSet() {
        return mountainSet;
    }
}
