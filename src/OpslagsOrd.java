import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OpslagsOrd extends Word {

    private List<String> listOfForms;

    // Opslagsord kopierer fra Word - men tager "form" ud og gemmer i en liste.
    public OpslagsOrd(Word word) {
        super(word);

        listOfForms = new ArrayList<>();

        listOfForms.add(super.getForm());
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

    // hashCode lavede vi sammen med equals - fik editoren til at lave den automatisk
    @Override
    public int hashCode() {
        return Objects.hash(getHeadWord(), getId());
    }
}
