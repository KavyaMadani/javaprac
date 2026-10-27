import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

public class FolderTreeReport {
    public static void main(String[] args) {
        Path folder = Paths.get("logs");
        Path report = Paths.get("folder_report.txt");

        try {
            Files.createDirectories(folder);

            Files.writeString(
                folder.resolve("sample1.txt"),
                "This is the first sample file."
            );

            Files.writeString(
                folder.resolve("sample2.txt"),
                "This is the second sample file."
            );

            try (var writer = Files.newBufferedWriter(report)) {
                writer.write("FOLDER TREE REPORT");
                writer.newLine();
                writer.write("==================");
                writer.newLine();

                Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(
                            Path file, BasicFileAttributes attrs) throws IOException {

                        writer.write("Name: " + file.getFileName());
                        writer.newLine();

                        writer.write("Path: " + file.toAbsolutePath());
                        writer.newLine();

                        writer.write("Size: " + attrs.size() + " bytes");
                        writer.newLine();

                        writer.write("Modified: " +
                            Instant.ofEpochMilli(attrs.lastModifiedTime().toMillis()));
                        writer.newLine();

                        writer.write("------------------");
                        writer.newLine();

                        return FileVisitResult.CONTINUE;
                    }
                });
            }

            System.out.println("Folder report generated successfully.");
            System.out.println("Report saved to: " + report.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}