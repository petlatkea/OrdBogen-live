import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HeadWord extends Word {

    private List<String> listOfForms = new ArrayList<>();

    // Opslagsord kopierer fra Word - men tager "form" ud og gemmer i en liste.
    public HeadWord(Word word) {
        super(word);
        listOfForms.add(super.getForm());
    }

    public void addForm(String form) {
        listOfForms.add(form);
    }

    public String[] getAllForms() {
        return listOfForms.toArray(new String[listOfForms.size()]);
    }

    // Vi lavede equals automatisk med IntelliJ - vi lavede den i Word, fordi det er
    // nogle af attributterne der vi er interesseret i at sammenligne.
    // Vi satte den op til kun at kigge på id og headword - og bruge getters.
    // og så flyttede vi den fra Word og hertil.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return getId() == word.getId() && Objects.equals(getHeadWord(), word.getHeadWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeadWord(), getId());
    }

    @Override
    public String toString() {
        return getHeadWord() + " - " + getPartOfSpeech() + " id: " + getId();
    }
}
