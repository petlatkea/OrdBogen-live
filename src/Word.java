import java.util.Objects;

public class Word {
    private String form;
    private String headWord;
    private int homographNumber;
    private String partOfSpeech;
    private int id;

    Word(String line) {
        String[] parts = line.split("\t");
        setForm(parts[0]);
        setHeadWord(parts[1]);
        setHomographNumber(parts[2]);
        setPartOfSpeech(parts[3]);
        setId(parts[4]);
    }

    Word(Word other) {
        this.form = other.form;
        this.headWord = other.headWord;
        this.homographNumber = other.homographNumber;
        this.partOfSpeech = other.partOfSpeech;
        this.id = other.id;
    }


    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getHeadWord() {
        return headWord;
    }

    public void setHeadWord(String headWord) {
        this.headWord = headWord;
    }

    public int getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(int homographNumber) {
        this.homographNumber = homographNumber;
    }

    // Denne her ekstra setter lavede vi for at gøre det nemmere at håndtere strenge i input-filen
    public void setHomographNumber(String possibleNumber) {
        try {
            setHomographNumber(Integer.parseInt(possibleNumber));
        } catch (NumberFormatException e) {
            // Hvis der ikke er et tal - så sæt værdien til 0
            setHomographNumber(0);
        }
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Denne her ekstra setter lavede vi for at gøre det nemmere at håndtere strenge i input-filen
    // Den har ingen try-catch, fordi vi forventer at der ALTID er et id, som ALTID er et tal
    public void setId(String possibleNumber) {
        setId(Integer.parseInt(possibleNumber));
    }
}
