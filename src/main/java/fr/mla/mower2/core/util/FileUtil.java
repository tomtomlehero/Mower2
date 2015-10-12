package fr.mla.mower2.core.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> instructionsFromFile(String filePath) throws IOException {

        Path path = Paths.get(filePath);

        if (!Files.isRegularFile(path)) {
            throw new FileNotFoundException();
        }

        List<String> result = new ArrayList<>();
        Files.lines(path).forEach(result::add);

        return result;
    }

}
