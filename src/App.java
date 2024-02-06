import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // Opret en liste til at gemme alle ord
        List<Word> allTheWords = new ArrayList<>();
        try {
            Scanner filereader = new Scanner(new File("data/ddo_fullforms.csv"));

            while(filereader.hasNext()) {
                String line = filereader.nextLine();
                Word word = new Word(line);
                // put ordet i den liste
                allTheWords.add(word);
            }
            // Find ud af hvor mange ord der er i listen!
            System.out.println("Read " + allTheWords.size() + " lines");

            // Nu skal vi finde opslagsord - altså undgå dubletter
            // Så vi bruger et Set - vi kunne ikke bruge TreeSet, fordi vores Opslagsord
            // ikke ved hvordan de skal sorteres - den tager vi senere, vi skiftede bare til HashSet
            Set<HeadWord> onlyHeadWords = new HashSet<>();
            // map til hurtigt opslag
            Map<Integer, HeadWord> quickLookUp = new HashMap<>();

            for( var word : allTheWords ) {
                var headWord = new HeadWord(word);
                // put unikke opslagsord i en ny liste
                // Første gang vi addede opslagsord kom der dubletter ind i listen - fordi vi ikke i OpslagsOrd
                // havde implementeret .equals og .hashCode der kun kiggede på "headword" -
                // så Set troede at hvert eneste objekt var unikt.
                if(onlyHeadWords.add(headWord)) {
                    quickLookUp.put(headWord.getId(), headWord);
                }
            }

            System.out.println("Der er " + onlyHeadWords.size() + " opslagsord");
            System.out.println("Hurtige opslag:");
            System.out.println(quickLookUp.get(11008444));
            System.out.println(quickLookUp.get(11050951));
            System.out.println(quickLookUp.get(11002241));
            System.out.println(quickLookUp.get(11022665));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
