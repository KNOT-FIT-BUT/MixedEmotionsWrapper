package cz.vutbr.mefw;

import org.ini4j.Ini;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Config crate class. It loads, holds and provide access to ini configuration file.
 */
public class Config {

    Ini ini;
    /**
     * @param
     * @throww
     * @return
     */
    public Config() throws IOException {
        Ini ini = new Ini();
        ini.load(new FileReader("config.ini"));
    }


    /** Getter for ini key from default section
     * @param key is the key string from the ini file
     * @return the value of the key
     */
    public String get(String key){
        return this.get("defualt", key);
    }

    /**
     * @param sectionKey specify section name in the ini file
     * @param key is the key string in the selected section
     * @return
     */
    public String get(String sectionKey, String key){
        Ini.Section section = ini.get(sectionKey);
        return section.get(key);
    }

}
