package ml.zvicraft.dev.mcreported.location;

import java.io.File;

public enum Language {


    ENGLISH(new File("plugins//MCreported_Plugin//locales", "english.yml")),


    HEBREW(new File("plugins//MCreported_Plugin//locales", "he.yml"));

    private File filePath;

    Language(final File filePath) {
        this.filePath = filePath;
    }

    public File getFilePath() {
        return filePath;
    }
}