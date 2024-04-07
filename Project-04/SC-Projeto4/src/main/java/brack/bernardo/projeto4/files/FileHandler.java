package brack.bernardo.projeto4.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler<T> {

    private final Predicate<String> isExpectedLine;
    private final Function<String, T> convertLineToObject;

    public FileHandler(Predicate<String> isExpectedLine, Function<String, T> convertLineToObject) {
        this.isExpectedLine = isExpectedLine;
        this.convertLineToObject = convertLineToObject;
    }
    public List<T> read(String path) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream
                    .filter(isExpectedLine)
                    .map(convertLineToObject)
                    .collect(Collectors.toList());
        }
    }
}
