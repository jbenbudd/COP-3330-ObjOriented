public class Application {
    public static void main(String[] args) {
        String inputFilename = "problem2.txt";
        String outputFilename = "unique_word_counts.txt";

        DuplicateCounter duplicateCounter = new DuplicateCounter();

        duplicateCounter.count(inputFilename);
        duplicateCounter.write(outputFilename);
    }
}
