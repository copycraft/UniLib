package com.copicraftDev.unilib.utils;

public class NameFormatter {

    /**
     * Converts "Wheel Of Doom" → "wheel_of_doom"
     */
    public static String toId(String name) {
        return name.trim()
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "_")
                .replaceAll("^_+|_+$", "");
    }

    /**
     * Returns the raw name for lang entries (can be used for formatting later)
     */
    public static String toLang(String name) {
        return name.trim();
    }

    /**
     * Converts "Wheel Of Doom" → "Wheel Of Doom" (title-case each word)
     */
    public static String toLangFormatted(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder out = new StringBuilder();
        for (String word : words) {
            out.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return out.toString().trim();
    }

    /**
     * Converts name to texture path, defaults to ID
     */
    public static String toTexture(String name) {
        return toId(name);
    }
}
