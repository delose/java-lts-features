package com.delose.java.lts.practice.wrappers.scanner;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerOperations {
    private Scanner scanner;

    /**
     * Close the scanner object
     */
    public void closeScanner() {
        // Close the scanner object
        scanner.close();
    }

    /**
     * Return the delimiter used to separate tokens
     */
    public Pattern delimiter() {
        // Return the delimiter used to separate tokens
        return scanner.delimiter();
    }

    /**
     * Return a string which matches a regular expression in the current line
     */
    public String findInLine(String regex) {
        return scanner.findInLine(regex);
    }

    /**
     * Return a string which matches a regular expression within a specified number of characters
     */
    public String findWithinHorizon(String regex, int horizon) {
        return scanner.findWithinHorizon(regex, horizon);
    }

    /**
     * Return true if another token can be found
     */
    public boolean hasNext() {
        return scanner.hasNext();
    }

    /**
     * Return true if the next token represents a boolean value
     */
    public boolean hasNextBoolean() {
        return scanner.hasNextBoolean();
    }

    /**
     * Return true if the next token represents a byte value
     */
    public boolean hasNextByte() {
        return scanner.hasNextByte();
    }

    /**
     * Return true if the next token represents a number
     */
    public boolean hasNextDouble() {
        return scanner.hasNextDouble();
    }

    /**
     * Return true if the next token represents a number
     */
    public boolean hasNextFloat() {
        return scanner.hasNextFloat();
    }

    /**
     * Return true if the next token represents an int value
     */
    public boolean hasNextInt() {
        return scanner.hasNextInt();
    }

    /**
     * Return true if another line of text is available in the scanner
     */
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * Return true if the next token represents a long value
     */
    public boolean hasNextLong() {
        return scanner.hasNextLong();
    }

    /**
     * Return true if the next token represents a short value
     */
    public boolean hasNextShort() {
        return scanner.hasNextShort();
    }

    /**
     * Return the scanner's locale
     */
    public Locale locale() {
        return scanner.locale();
    }

    /**
     * Return the next token in the scanner
     */
    public String next() {
        return scanner.next();
    }

    /**
     * Return the boolean value of the next token in the scanner
     */
    public boolean nextBoolean() {
        return scanner.nextBoolean();
    }

    /**
     * Return the byte value of the next token in the scanner
     */
    public byte nextByte() {
        return scanner.nextByte();
    }

    /**
     * Return the double value of the next token in the scanner
     */
    public double nextDouble() {
        return scanner.nextDouble();
    }

    /**
     * Return the float value of the next token in the scanner
     */
    public float nextFloat() {
        return scanner.nextFloat();
    }

    /**
     * Return the float value of the next token in the scanner
     */
    public int nextInt() {
        return scanner.nextInt();
    }

    /**
     * Return the next line of text in the scanner
     */
    public String nextLine() {
        return scanner.nextLine();
    }

    /**
     * Return the long value of the next token in the scanner
     */
    public long nextLong() {
        return scanner.nextLong();
    }

    /**
     * Return the short value of the next token in the scanner
     */
    public short nextShort() {
        return scanner.nextShort();
    }

    /**
     * Return the scanner's radix
     */
    public int radix() {
        return scanner.radix();
    }

    /**
     * Resent scanner's configuration
     */
    public void reset() {
        scanner.reset();
    }

    /**
     * Set the delimiter used by the scanner to separate tokens
     */
    public Scanner useDelimiter(Pattern pattern) {
        return scanner.useDelimiter(pattern);
    }

    /**
     * Set the locale used by the scanner
     */
    public Scanner useLocale(Locale locale) {
        return scanner.useLocale(locale);
    }

    /**
     * Set the radix used by the scanner
     */
    public Scanner useRadix(int radix) {
        return scanner.useRadix(radix);
    }

}
