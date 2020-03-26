package exercise_text_analyser;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextAnalyzer {

    private File file;

    public TextAnalyzer(String fileName) {
        file = new File("C:\\Users\\Nichlas\\Documents\\vop\\Lesson03PreparationExercises\\Lesson03PreparationExercises\\" + fileName);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        TextAnalyzer ta = new TextAnalyzer("alice30.txt");

        // Opgave 2A. Find alle unikke ord i filen
        Set<String> set = ta.findUniqueWords(true);
        System.out.println(set);
        System.out.println("Number of unique words: " + set.size());

        System.out.println("\n------------------------------------------------------------------\n");

        // Opgave 2B. Tæl forekomster af ord
        Map<String, Integer> map = ta.countWords(true);
        System.out.println(map);
//
        System.out.println("\n------------------------------------------------------------------\n");

        // Opgave 2C. Benyt en mappe til at gruppere ord efter længde
		Map<Integer, Set<String>> map2 = ta.lengtOfWords(true);
		System.out.println(map2);

    }

    // Opgave 2A
    // Parameteren sorted afgør om der skal benyttes et sorteret Set
    //
    public Set<String> findUniqueWords(boolean sorted) {
        Set<String> set = null;
        Scanner input = null;
        if (sorted) {
            set = new TreeSet<String>();
            try {
                input = new Scanner(this.file);
                while (input.hasNext()) {
                    String word = input.next();
                    set.add(clean(word));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                input.close();
            }

        } else {
            set = new HashSet<String>();
            try {
                input = new Scanner(this.file);
                while (input.hasNext()) {
                    String word = input.next();
                    set.add(clean(word));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                input.close();
            }

        }

        // gennemlæs filen et ord ad gangen
        // kald clean() metoden på hvert ord
        // og tilføj ordet til settet.

        return set;
    }

    // Opgave 2B:   Nearly as Listing 21.9 from Liang
    //
    public Map<String, Integer> countWords(boolean sorted) {
        Map<String, Integer> map = null;
        Scanner input = null;
        if (sorted) {
            map = new TreeMap<String, Integer>();
            
            try {
                input = new Scanner(this.file);

                while (input.hasNext()) {
                    int count = 1;
                    String word = clean(input.next());
                    if (!map.containsKey(word)) {
                        map.put(word, count);
                    } else {
                        int temp = map.get(word);
                        temp += 1;
                        map.put(word, temp);
                    }


                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                input.close();
            }


        } else {
            map = new HashMap<String, Integer>();
			try {
				input = new Scanner(this.file);
				while(input.hasNext()){
					int count = 1;
					String word = clean(input.next());
					if (!map.containsKey(word)) {
						map.put(word, count);
					} else {
						int temp = map.get(word);
						temp += 1;
						map.put(word, temp);
					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				input.close();
			}
		}
        // gennemlæs filen et ord ad gangen
        // kald clean() metoden på hvert ord
        // benyt mappen til at tælle forekomsten af hvert ord

        return map;
    }

    // Opgave 2C:     Udvidelse af P15.1
    //
    public Map<Integer, Set<String>> lengtOfWords(boolean sorted) {
        Map<Integer, Set<String>> mapOfSets = null;
        Scanner input = null;
        if (sorted) {
            mapOfSets = new TreeMap<Integer, Set<String>>();
			try {
				input = new Scanner(this.file);
				while(input.hasNext()){
					String word = clean(input.next());
					if(!mapOfSets.containsKey(word.length())){
						Set<String> values = new TreeSet<String>();
						values.add(word);
						mapOfSets.put(word.length(), values);
					} else{
						mapOfSets.get(word.length()).add(word);
					}

				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				input.close();
			}
		} else {
            //mapOfSets = // usorteret
        }
        // gennemlæs filen et ord ad gangen
        // kald clean() metoden på hvert ord
        // Indsæt hvert ord i det Set<String> som er værdi til ordlængden som key
        // Hint: nyt Set<String> skal oprettes hver gang en længde opdages første gang.


        return mapOfSets;

    }

    // Denne metode forsøger at fjerne alt 'snavs' fra en String,
    // så kun bogstaver bevares og store gøres til små
    private String clean(String s) {
        String r = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
