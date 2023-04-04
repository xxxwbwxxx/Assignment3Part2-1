package literatureStats;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static a3algorithms.Normaliser.normalise;

public class FrequencyDocumentReader {
    private FrequencyDocumentReader() {} // 01/04/2023 updated to have private visibility

    public static final String DEFAULT_NON_WORD_CHARS = "[^a-zA-Z0-9'\\s]+";

    /**
     * TODO: Reads the named document file using default settings. Use the
     *  defaults for information not provided.
     *
     * @param dictionaryFileName
     * @return
     */
    public static Map<String, FrequencyWord> readDocument(String dictionaryFileName) {
        return readDocument(new FrequencyReaderConfig(dictionaryFileName, null, null, Verbosity.SILENT));
    }

    /**
     * TODO: Reads a document using default settings for those not provided.
     *
     * @param dictionaryFileName
     * @param nonWordChars
     * @return
     */
    public static Map<String, FrequencyWord> readDocument(String dictionaryFileName, String nonWordChars) {
        return readDocument(new FrequencyReaderConfig(dictionaryFileName, null, null, Verbosity.SILENT), nonWordChars);
    }

    /**
     * TODO: reads a document using the default set of non-word characters.
     *
     * @param config
     * @return
     */
    public static Map<String, FrequencyWord> readDocument(FrequencyReaderConfig config) {

        return readDocument(config, DEFAULT_NON_WORD_CHARS);
    }

    /** TODO read the file specified in the configuration and obey the
     *   start and stop markers.
     *   If the configuration has a non-zero verbosity then print the following messages:
     *   if the word is new:
     *   Added normalisedWord
     *   if the word already exists:
     *   Incremented normalisedWord to newCount
     *   In both cases substitute normalisedWord with the actual normalised form.
     *   If a word already exists print the count that includes the instance you
     *   are processing.
     *
     * @param config
     * @param nonWordChars
     * @return
     */
    public static Map<String, FrequencyWord> readDocument(FrequencyReaderConfig config, String nonWordChars) {
        Map<String, FrequencyWord> result = new HashMap<>();
        boolean started = false;

        try (final Scanner sc = new Scanner(new File(config.DOCUMENT_FILENAME))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if(config.STOP_MARKER == null || config.START_MARKER == null){
                    started = !started;
                }
                else if (line.contains(config.START_MARKER) || line.contains(config.STOP_MARKER)) {
                    started = !started;
                    continue;
                }

                if (started) {
                    String[] words = normalise(line.replaceAll(nonWordChars, "")).split("\\s+");
                    for (String word : words) {
                        if (word.length() > 0) {
                            if (!result.containsKey(word)) {
                                result.put(word, new FrequencyWord(word));
                                if (config.getVerbosity() != Verbosity.SILENT) {
                                    System.out.printf("Added %s\n", word);
                                }
                            } else {
                                FrequencyWord count = result.get(word);
                                count.incrementCount();
                                if (config.getVerbosity() != Verbosity.SILENT) {
                                    System.out.printf("Incremented %s to %d\n", word, count.getCount());
                                }
                            }
                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


}
