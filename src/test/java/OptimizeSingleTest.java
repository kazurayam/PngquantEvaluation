import com.kazurayam.subprocessj.Subprocess;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptimizeSingleTest {

    private static Path sourceDir = Paths.get(".").resolve("src/test/fixtures/store");
    private static Path targetDir = Paths.get(".").resolve("build/tmp/testOutput/OptimizeSingleTest").toAbsolutePath().normalize();

    @BeforeAll
    static void beforeAll() throws IOException {
        Files.createDirectories(targetDir);
    }

    @BeforeEach
    void beforeEach() throws IOException {
        FileUtils.copyDirectory(sourceDir.toFile(), targetDir.toFile());
    }

    @Test
    public void test_pngquant() throws Exception {
        Path objectDir = targetDir.resolve("NineBreak/20230419_172442/objects");
        Map<String, Map<String, Long>> sizeRecord = new HashMap<>();
        Files.list(objectDir).forEach( png -> {
            // store the size of PNG files before size optimization
            Map<String, Long> size = new HashMap<>();
            size.put("before", png.toFile().length());
            // now optimize the file size
            Subprocess.CompletedProcess cp;
            try {
                cp = new Subprocess().run(Arrays.asList(
                        "pngquant","--ext", ".png", "--force", "--speed", "1",
                        png.toString()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cp.stdout().forEach(System.out::println);
            cp.stderr().forEach(System.err::println);
            assertEquals(0, cp.returncode());
            // store the size of png files after optimization
            size.put("after", png.toFile().length());
            // record the size information
            sizeRecord.put(png.getFileName().toString(), size);
        });
        // report how much the files were compressed
        sizeRecord.keySet().forEach( fileName -> {
            Long sizeBeforeOpt = sizeRecord.get(fileName).get("before");
            Long sizeAfterOpt = sizeRecord.get(fileName).get("after");
            Long delta = ((sizeBeforeOpt - sizeAfterOpt) * 100) / sizeBeforeOpt;
            System.out.println(String.format("%s %d -> %d (Δ%d%%)",
                    fileName, sizeBeforeOpt, sizeAfterOpt, delta));
        });
    }

}
