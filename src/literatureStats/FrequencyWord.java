package literatureStats;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This is the proper class for storing a word and its frequency count.
 */
public class FrequencyWord implements Comparable<FrequencyWord> {
    public static final String DEFAULT_WORD_STATS_PATTERN = "%4d\t%s%n";

    /**
     * TODO: Store the set of vowels [a, e, i, o, u] ("y" is not considered a vowel.
     */
    public static final Set<String> VOWELS = new HashSet<>(Arrays.asList("a","e","i","o","u"));

    protected final String normalised; // TODO: you'll need to initialise this elsewhere

    protected int count;

    /**
     * TODO: Create constructor.
     *
     * @param word
     */
    FrequencyWord(String word) {
        count = 1;
        normalised = normalise(word);
    }

    /**
     * TODO: normalise means a word is entirely lowercase and
     *  has no leading or trailing whitespace.
     *
     * @param word
     * @return
     */
    public static String normalise(String word) {
        return word.toLowerCase().strip();
    }

    /**
     * TODO: getter for the normalised form of the word.
     *
     * @return
     */
    public String getNormalised() {
        return normalised;
    }


    /**
     * TODO: getter for the current frequency of the word.
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * TODO: increment the frequency count by one
     */
    public void incrementCount() {
        count++;
    }

    /**
     * TODO: gets a String of this object's data (frequency and normalised word-form)
     *  formatted according to the default word statistics pattern.
     *
     * @return
     */
    @Override
    public String toString() {

        return String.format(DEFAULT_WORD_STATS_PATTERN, count, normalised);
    }

    /**
     * TODO: gets a String of this object's data (frequency and normalised word-form)
     *  formatted according to the provided word statistics pattern.
     *
     * @param wordStatePattern
     * @return
     */
    public String toString(String wordStatePattern) {

        return String.format(wordStatePattern, count, normalised);
    }

    /**
     * TODO: A FrequencyWord knows how to compare itself with another FrequencyWord.
     *  You will have to research how this is done.
     *
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(FrequencyWord other) {

        return Integer.compare(count, other.count);
    }
}
