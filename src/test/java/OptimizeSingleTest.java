import com.kazurayam.materialstore.core.FileType;
import com.kazurayam.materialstore.core.JobName;
import com.kazurayam.materialstore.core.JobTimestamp;
import com.kazurayam.materialstore.core.Material;
import com.kazurayam.materialstore.core.MaterialstoreException;
import com.kazurayam.materialstore.core.QueryOnMetadata;
import com.kazurayam.materialstore.core.Store;
import com.kazurayam.materialstore.core.Stores;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class OptimizeSingleTest {

    private static Path sourceDir = Paths.get(".").resolve("src/test/fixtures/store");
    private static Store sourceStore;
    private static JobName jobName;
    private static JobTimestamp jobTimestamp;
    private static Path targetDir = Paths.get(".").resolve("build/tmp/testOutput/OptimizeSingleTest").toAbsolutePath().normalize();

    @BeforeAll
    static void beforeAll() throws IOException {
        sourceStore = Stores.newInstance(sourceDir);
        Files.createDirectories(targetDir);
        jobName = new JobName("NineBreak");
        jobTimestamp = new JobTimestamp("20230419_172442");
    }

    @Test
    public void test_selectSinglePNG() throws MaterialstoreException {
        Material mat = sourceStore.selectSingle(jobName, jobTimestamp, FileType.PNG);
        assertNotNull(mat);
        //System.out.println(mat.toJson(true));
        assertEquals("ninebreak.jp", mat.getMetadata().get("URL.host"));
        assertEquals("/index.php", mat.getMetadata().get("URL.path"));
        assertEquals("1_ホーム", mat.getMetadata().get("menu"));
        assertEquals(FileType.PNG, mat.getFileType());
    }

    @Test
    public void test_optimize_a_png() throws MaterialstoreException {
        Material mat = sourceStore.selectSingle(jobName, jobTimestamp, FileType.PNG,
                QueryOnMetadata.builder().put("menu", "3_ルール説明").build());
        assertNotNull(mat);
    }
}
