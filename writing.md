# Writing for Assignment&nbsp;3 Part&nbsp;2 2023 #

- **LIU XUCHEN**
- **s2420193**
- **06**
- **Neel Chaudhari**
- **2023-04-03**



## Acknowledgements ##



## Code location ##

Explain why you put the code from `a3algorithms` into the specific
places in `literatureStats`. You must be specific about what went
where but you do not need to give an exhaustive list: try to find a
way to "optimise" your writing about this.

1. Verbosity : copy verbosity a3algorithms to literatureStats because they are same code and share same function.
They both defined verbosity as enumeration class, it defined five types with a specific value. 
2. SortingOrder: copy SortingOrder a3algorithms to literatureStats because they are same code and share same function.
They both defined five orders each associated with boolean value which show is reverse or not.
3. Translation: copy VowelChecker a3algorithms to literatureStats because it require move the first non-vowel 
cluster to the end of the word. This is everything up to but not including the first vowel. So it require a function 
to check it vowel or not in first character.
4. Translation: copy TrollSpeaker a3algorithms to literatureStats because they are same code and share same function.In
first two line of Translation is function with Translation. They both what every input in will convert grunt.
5. FrequencyWord: copy some code of Normaliser and SimpleFrequencyWord.java a3algorithms to literatureStats 
 because they try to achieve same function. They both normalise and count the word frequency.
6. FrequencyDocumentReader : share same reader idea with AdvancedTextFileReader and BasicTextFileReader.




## DRY programming ##

Show and explain examples of DRY programming in this assigment and
where appropriate indicate what a WET version might look like.


There is an example in FrequencyDocumentReader shown that is dry programing. The mena idea of dry programming is 
avoiding duplication and promoting code reuse. So, in code of FrequencyDocumentReader it mainly have function which read 
the document. This code reads a document file then use FrequencyReaderConfig to process the words which is inputted
in file. It converts DEFAULT_NON_WORD_CHARS which remove non-word characters and normalise word. Then store it in to 
hashmap, then it process word as todo requirement. In general, there are three function FrequencyReaderConfig which can 
get verbosity for words, Normaliser which remove non-word characters and normalise word, Verbosity can check verbosity. 
By using this function it avoid defined each function in three default settings. 
So in this wet version it duplicates same purpose code which have basic same functionality with Normaliser, 
FrequencyReaderConfig, Verbosity. It reuses similar code to get default for words.

## Relationships ##

Explain the relationships between `DataScientist` and the classes it
uses directly and indirectly, and why you think they were designed
that way. Be specific to the classes and methods in the assignment but
you might need to outline some Java concepts underpinning the
design. Also make use of advice from the course's Code Quality and
Conventions document, especially (but not only) DRY
programming. Ensure you answer covers the way the two different types
of `FrequencyDocument` are instantiated.

In DataScientist, it directly uses InformationDocument which use FrequencyWord and FrequencyDocument which use 
FrequencyReaderConfig. So DataScientist indirectly use FrequencyWord, FrequencyDocument and FrequencyReaderConfig




## Explain reading a file ##

Demonstrate how the work done for reading a file in
`literatureStats.FrequencyDocumentReader` is split between specific
methods including the one(s) that called it. This should be possible
to write about even if your code does not fully work. It is useful to
give brief explanations of how many of the JDK library methods you use
contribute to your implementation, though you are not required to
explain how those library methods work (unless you feel it is
essential). As part of your answer explain why JDK 7 or later is
recommended.

You also need to justify your algorithm design for reading a file, for
example the order of statements and the use of specific constructs.

If you were unable to make file reading work in
`FrequencyDocumentReader` then substitute any file-reading code you
did get working in `a3algorithms`.

## Explain your code for reading Project Gutenberg files ##

If you were able to make your code work read Project Gutenberg files
without their preamble and postamble, then explain your algorithm here
but only the parts that differ from your answer about reading an
entire file. Justify the relevant parts of your design.

## Explain your translate-to-dog implementation ##

If you implemented translating a word into doggie language, then
explain how your algorithm implements the specification in the `TODO`
comment. Do not give a line-by-line explanation or effectively just
restate the guidance in the `TODO` comment.

## Explain the enums ##

Explain how `enum`s are used in this assignment and the main benefits
they appear to bring. Describe several different salient points in
some detail rather than a lightning tour of everything in all `enum`s.
