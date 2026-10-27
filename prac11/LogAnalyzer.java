import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) {
        Path folder = Paths.get("logs");
        String keyword = "ERROR";
        int totalLines = 0;
        int totalMatches = 0;

        try {
            Files.createDirectories(folder);

            Files.write(folder.resolve("log1.txt"), List.of(
                "INFO Application started",
                "ERROR Database connection failed",
                "INFO User logged in"
            ));

            Files.write(folder.resolve("log2.txt"), List.of(
                "INFO Server running",
                "ERROR File not found",
                "ERROR Network failure",
                "INFO Application stopped"
            ));

            try (DirectoryStream<Path> files = Files.newDirectoryStream(folder, "*.txt")) {
                for (Path file : files) {
                    int fileLines = 0;
                    int fileMatches = 0;

                    try (var reader = Files.newBufferedReader(file)) {
                        String line;

                        while ((line = reader.readLine()) != null) {
                            fileLines++;

                            if (line.contains(keyword)) {
                                fileMatches++;
                            }
                        }
                    }

                    BasicFileAttributes attributes = Files.readAttributes(
                        file, BasicFileAttributes.class
                    );

                    totalLines += fileLines;
                    totalMatches += fileMatches;

                    System.out.println("File: " + file.getFileName());
                    System.out.println("Size: " + attributes.size() + " bytes");
                    System.out.println("Lines: " + fileLines);
                    System.out.println("Keyword Matches: " + fileMatches);
                    System.out.println();
                }
            }

            System.out.println("Total Lines: " + totalLines);
            System.out.println("Total ERROR Messages: " + totalMatches);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}