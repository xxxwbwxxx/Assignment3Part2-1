package literatureStats;

import static literatureStats.FrequencyWord.VOWELS;

/**
 * Code to translate words according to the language is directly inside this enum.
 */
public enum Translation {
    NONE {@Override public String translate(String word) {return word;}},
    // TODO: put the code for translating troll directly inside the overriden method
    TROLL {@Override public String translate(String word) {
        word = "grunt";
        return word;
        }
    },
    /* TODO: translate into British doggie speak. Dogs from different countries
        speak different doggie languages. British dogs speak like this:
        1. Move the first non-vowel cluster to the end of the word.
            This is everything up to but not including the first vowel.
        2. Append "ay" to the word unless:
           2.1 the word originally began with "b" in which case it ends "bark"
               before -> eforebark, but -> utbark
           2.2 the word originally began with "g" in which case it ends "grrrowl"
               with 3 rs but the "g" is the one that was originally at the start
               of the word:
               good	->	oodgrrrowl, great -> eatgrrrrowl, gutenberg -> utenberggrrrowl
           2.3 the word originally began with "r" in which case it ends "rrruf"
               with 3 rs but the first of those is the "r" that was originally
               at the start of the word:
               ross	->	ossrrruf, room	->	oomrrruf
           2.4 the word originally began with "w" in which case
               2.4.1 it ends "woof" with the "w" being the one that was
                     originally at the start of the word
                     was -> aswoof, who -> owhoof
               2.4.2 unless the word orginally began "wo" in which case it ends
                     "woofWoof" (note the one capital W) where the first "w" is
                     the one that was originally at the start of the word:
                     work -> orkwoofWoof, would -> ouldwoofWoof
        Other examples:
          3 -> 3ay, a -> aay, ay -> ayay, ebook -> ebookay, under -> underay
          An empty word is unchanged.
     */
    DOG {
        @Override
        public String translate(String word) {
            int firstVowel = 0;
            String clusterAtBack,result;
            String firstLetter = word.substring(0,1);
            String secondLetter = "";


            if(word.length() > 1){
                secondLetter = word.substring(1,2);
                for (int i = 0; i < word.length(); i++) {
                    if(i == word.length()-1){
                        break;
                    }

                    String s = word.substring(i,i+1);

                    if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u")){
                        firstVowel = i;
                        break;
                    }
                }
            }

            if(firstVowel == 0){
                clusterAtBack = word;
            }
            else{
                clusterAtBack = word.substring(firstVowel)+word.substring(0,firstVowel);
            }


            if (firstLetter.equals("b")){
                result = clusterAtBack+"ark";
            }
            else if (firstLetter.equals("g")){
                result = clusterAtBack+"rrrowl";
            }
            else if (firstLetter.equals("r")){
                result = clusterAtBack+"rruf";
            }
            else if (firstLetter.equals("w")){
                if(secondLetter.equals("o")){
                    result = clusterAtBack+"oofWoof";
                }
                else{
                    result = clusterAtBack+"rruf";
                }
            }
            else  {
                result = clusterAtBack + "ay";
            }


            return result;
        }
    };

    /**
     * TODO: Translates the word component of a {@link FrequencyWord}.
     *
     * @param frequencyWord
     * @return
     */
    public String translate(FrequencyWord frequencyWord) {

        return translate(frequencyWord.normalised);
    }

    /**
     * The base pattern for translating. DO NOT CHANGE THIS IN ANY WAY.
     *
     * @param word
     * @return
     */
    public abstract String translate(String word);


    public static void main(String[] args) {
        Translation trans = Translation.DOG;
        FrequencyWord test = new FrequencyWord("under");
        System.out.println(trans.translate(test));
    }

}
