package th.in.pureapp.dictionary.model;

/**
 * Created by pakkapon on 23/11/2560.
 */

public class Word {
    private int id;
    private String search,result,type,synonym,antonym,relate,define,classifier,sample,tag,language;
    public Word(int id, String search, String language) {
        this.id = id;
        this.search = search;
        this.language = language;
    }

    public Word(int id, String search, String result, String type, String synonym, String antonym, String relate, String define, String classifier, String sample, String tag, String language) {
        this.id = id;
        this.search = search;
        this.result = result;
        this.type = type;
        this.antonym = antonym;
        this.synonym = synonym;
        this.relate = relate;
        this.define = define;
        this.classifier = classifier;
        this.sample = sample;
        this.tag = tag;
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAntonym() {
        return antonym;
    }

    public void setAntonym(String antonym) {
        this.antonym = antonym;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public String getRelate() {
        return relate;
    }

    public void setRelate(String relate) {
        this.relate = relate;
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return this.search;//super.toString();
    }
}
