package website.elpato.www.learnmaoribyelpato;

/**
 * Created by Dell on 11/13/2017.
 */


public class Number {
    //Attributes
    private int mId;
    private String mIcon;
    private String mMaoriTranslation;
    private String mAudio;
    private String mEnglish;


    //Properties
    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        this.mIcon = icon;
    }

    public String getAudio() {
        return mAudio;
    }

    public void setAudio(String audio) {
        this.mAudio = audio;
    }

    public String getMaoriTranslation() {
        return mMaoriTranslation;
    }


    public void setMaoriTranslation(String maoriTranslation) {
        this.mMaoriTranslation = maoriTranslation;
    }

    public String getEnglish() {
        return mEnglish;
    }

    public void setEnglishWord(String mEnglish1) {
        this.mEnglish = mEnglish1;
    }


    //Constructor
    public Number(int id, String icon, String maoriTranslation, String audio, String englishWords ) {
        this.mId = id;
        this.mIcon = icon;
        this.mMaoriTranslation = maoriTranslation;
        this.mAudio = audio;
        this.mEnglish = englishWords;
    }
}