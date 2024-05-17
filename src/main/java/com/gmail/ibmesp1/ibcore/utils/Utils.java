package com.gmail.ibmesp1.ibcore.utils;

/**
 * Utils class use to add static methods.
 *
 * @author IB
 * @version 1.1
 * @since 0.0.1
 */

public class Utils {

    /**
     * Capitalizes the first letter of a string
     *
     * @param string String you want to capitalize
     * @return String with the first letter capitalized
     *
     * @author IB
     * @since 0.0.1
     */
    public static String capitalizeFirstLetter(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    /**
     * Returns the language string
     *
     * @param languageData An object from {@link DataManager} that manages the language files
     * @param path The String path at the languageData
     * @return String with the first letter capitalized
     *
     * @author IB
     * @since 1.1.2
     */
    public static String getLanguageString(DataManager languageData, String path) {
        if(languageData.getConfig().getString(path) == null)
            return path;

        return languageData.getConfig().getString(path);
    }
}
