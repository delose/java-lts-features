package com.delose.java.lts.practice.wrappers.string;

/**
 * This class provides methods for performing various operations on strings.
 * It includes methods for substring, character array conversion, case conversion,
 * trimming, and more.
 */
public class StringOperations {

    /**
     * Returns the character at a specified index of the string.
     */
    public char charAt(String str, int index) {
        return str.charAt(index);
    }

    /**
     * Returns the character (Unicode code point) at the specified index.
     */
    public int codePointAt(String str, int index) {
        return str.codePointAt(index);
    }

    /**
     * Returns the Unicode of the character before the specified index
     */
    public int codePointBefore(String str, int index) {
        return str.codePointBefore(index);
    }

    /**
     * Returns the number of Unicode values found in a string.
     */
    public int codePointCount(String str, int beginIndex, int endIndex) {
        return str.codePointCount(beginIndex, endIndex);
    }

    /**
     * Compares two strings lexicographically
     */
    public int compareTo(String str1, String str2) {
        return str1.compareTo(str2);
    }

    /**
     * Compares two strings lexicographically, ignoring case differences
     */
    public int compareToIgnoreCase(String str1, String str2) {
        return str1.compareToIgnoreCase(str2);
    }

    /**
     * Appends a string to the end of another string
     */
    public String concat(String str1, String str2) {
        return str1.concat(str2);
    }

    /**
     * Checks whether a string contains a sequence of characters
     */
    public boolean contains(String str, String substring) {
        return str.contains(substring);
    }

    /**
     * Checks whether a string contains the exact same sequence of characters
     * of the specified CharSequence or StringBuffer
     */
    public boolean contentEquals(String str, CharSequence charSequence) {
        return str.contentEquals(charSequence);
    }

    /**
     * Returns a String that represents the characters of the character array
     */
    public String copyValueOf(char[] data) {
        return String.copyValueOf(data);
    }

    /**
     * Checks whether a string ends with the specified character(s)
     */
    public boolean endsWith(String str, String suffix) {
        return str.endsWith(suffix);
    }

    /**
     * Compares two strings. Returns true if the strings are equal, and false if not
     */
    public boolean equals(String str1, String str2) {
        return str1.equals(str2);
    }

    /**
     * Compares two strings, ignoring case considerations
     */
     public boolean equalsIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    /**
     * Returns a formatted string using the specified locale, format string, and arguments
     */
    public String format(String format, Object... args) {
        return String.format(format, args);
    }

    /**
     * Converts a string into an array of bytes
    */
    public byte[] getBytes(String str) {
        return str.getBytes();
    }

    /**
     * Copies characters from a string to an array of chars
     */
    public char[] getChars(String str, int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        str.getChars(srcBegin, srcEnd, dst, dstBegin);
        return dst;
    }

    /**
     * Returns the hash code of a string
     */
    public int hashCode(String str) {
        return str.hashCode();
    }

    /**
     * Returns the position of the first found occurrence of specified characters in a string
     */
    public int indexOf(String str, int ch) {
        return str.indexOf(ch);
    }

    /**
     * Returns the canonical representation for the string object
     */
    public String intern(String str) {
        return str.intern();
    }

    /**
     * Checks whether a string is empty or not
     */
    public boolean isEmpty(String str) {
        return str.isEmpty();
    }

    /**
     * Joins one or more strings with a specified separator
     */
    public String join(CharSequence delimiter, CharSequence... elements) {
        return String.join(delimiter, elements);
    }

    /**
     * Returns the position of the last found occurrence of specified characters in a string
     */
    public int lastIndexOf(String str, int ch) {
        return str.lastIndexOf(ch);
    }

    /**
     * Returns the length of a specified string
     */
    public int length(String str) {
        return str.length();
    }

    /**
     * Searches a string for a match against a regular expression, and returns the matches
     */
    public boolean matches(String str, String regex) {
        return str.matches(regex);
    }

    /**
     * Returns the index within this String that is offset from the given index by codePointOffset code points
     */
    public int offsetByCodePoints(String str, int index, int codePointOffset) {
        return str.offsetByCodePoints(index, codePointOffset);
    }

    /**
     * Tests if two string regions are equal
     */
    public boolean regionMatches(String str1, int toffset, String str2, int ooffset, int len) {
        return str1.regionMatches(toffset, str2, ooffset, len);
    }

    /*
     * Searches a string for a specified value, and returns a new string where the specified values are replaced
     */
    public String replace(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }

    /*
     * Replaces each substring of this string that matches the given regular expression with the given replacement
     */
    public String replaceAll(String str, String regex, String replacement) {
        return str.replaceAll(regex, replacement);
    }

    /**
     * Replaces the first occurrence of a substring that matches the given regular expression with the given replacement
     */
    public String replaceFirst(String str, String regex, String replacement) {
        return str.replaceFirst(regex, replacement);
    }

    /**
     * Splits a string into an array of substrings
     */
    public String[] split(String str, String regex) {
        return str.split(regex);
    }

    /**
     * Checks whether a string starts with specified characters
     */
    public boolean startsWith(String str, String prefix) {
        return str.startsWith(prefix);
    }

    /**
     * Returns a new character sequence that is a subsequence of this sequence
     */
    public CharSequence subSequence(String str, int beginIndex, int endIndex) {
        return str.subSequence(beginIndex, endIndex);
    }

    /**
     * Returns a new string which is the substring of a specified string
     */
    public String substring(String str, int beginIndex, int endIndex) {
        return str.substring(beginIndex, endIndex);
    }

    /**
     * Converts this string to a new character array
     */
    public char[] toCharArray(String str) {
        return str.toCharArray();
    }

    /**
     * Converts a string to lower case letters
     */
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * Returns the value of a String object
     */
    public String toString(Object object) {
        return object.toString();
    }

    /**
     * Converts a string to upper case letters
     */
    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    /**
     * Removes whitespace from both ends of a string
     */
    public String trim(String str) {
        return str.trim();
    }

    /**
     * Returns the string representation of the specified value
     */
    public String valueOf(Object object) {
        return String.valueOf(object);
    }
}
