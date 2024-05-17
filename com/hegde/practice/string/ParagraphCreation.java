package com.hegde.practice.string;

import java.util.ArrayList;
import java.util.List;

public class ParagraphCreation {

    /**
     * Creates custom paragraph.
     *
     * Testing -
     * String[][] paragraphs = {
     * {"Hi", "Heo"},
     * {"Test", "Very Loog Word"},
     * {"Very Shoort Wdd", "Hi Again"}
     * };
     * String[] ans = createParagraph(paragraphs, 18);
     *
     * @param paragraphs
     * @param width
     * @return
     */
    private static String[] createParagraph(String[][] paragraphs, int width) {
        int paragraphMaxLength = width - 2;
        List<String> ans = new ArrayList<>();
        String stars = getStars(width).toString();
        ans.add(stars);
        for (String[] currentWords : paragraphs) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String currentWord : currentWords) {
                if (stringBuilder.length() + currentWord.length() > paragraphMaxLength && stringBuilder.length() != 0) {
                    ans.add(getFormattedString(stringBuilder, width).toString());
                    stringBuilder.setLength(0);
                }
                stringBuilder.append(currentWord).append(" ");
            }
            if (stringBuilder.length() != 0)
                ans.add(getFormattedString(stringBuilder, width).toString());
        }
        ans.add(stars);
        return ans.toArray(new String[0]);
    }

    private static StringBuilder getStars(int width) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*".repeat(Math.max(0, width + 2)));
        return stringBuilder;
    }

    private static StringBuilder getFormattedString(StringBuilder stringBuilder, int width) {
        StringBuilder newStringBuilder = new StringBuilder("*");
        if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        int spacedToInsert = width - (stringBuilder.length() + 2);
        System.out.println(width + " - " + stringBuilder.length() + " = " + " " + spacedToInsert + " : " + 3 / 2);
        if (spacedToInsert % 2 == 0) {
            newStringBuilder
                    .append(" ".repeat(spacedToInsert / 2))
                    .append(stringBuilder)
                    .append(" ".repeat(spacedToInsert / 2))
                    .append("*");
        } else {
            newStringBuilder
                    .append(" ".repeat(spacedToInsert != 1 ? spacedToInsert / 2 : 1))
                    .append(stringBuilder);
            if ((spacedToInsert / 2) - 1 > 0) {
                newStringBuilder.append(" ".repeat((spacedToInsert / 2) - 1));
            }
            newStringBuilder.append("*");
        }
        return newStringBuilder;
    }
}
