package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.model.FileJson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileParsingTest {

    private ClassLoader cl = FileParsingTest.class.getClassLoader();
    private final ObjectMapper mapper = new ObjectMapper();

    List<String> zipFileParsingTest() throws Exception {
        List<String> fileNames = new ArrayList<>();

        try (ZipInputStream zip = new ZipInputStream(
                cl.getResourceAsStream("zip_test.zip")
        )) {
            ZipEntry entry;

            while ((entry = zip.getNextEntry()) != null) {
                System.out.println(entry.getName());
                fileNames.add(entry.getName());
            }
        return fileNames;
        }
    }

    @Test
    @DisplayName("Чтение файла PDF")
    void pdfFileParsingTest() throws Exception {

        PDF pdf = new PDF(URI.create("file:///C:/Users/Pavel/IdeaProjects/qa_guru_new/src/test/resources/" + zipFileParsingTest().get(0)));
        Assertions.assertTrue(pdf.text.contains("распространенных"));
    }

    @Test
    @DisplayName("Чтение файла XLSX")
    void xlsFileParsingTest() throws Exception {

        XLS xls = new XLS(URI.create("file:///C:/Users/Pavel/IdeaProjects/qa_guru_new/src/test/resources/" + zipFileParsingTest().get(1)));
        Row headerRow = xls.excel.getSheetAt(0).getRow(0);
        Assertions.assertTrue(headerRow.getCell(0).getStringCellValue().contains("тест"));
    }

    @Test
    @DisplayName("Чтение файла CSV")
    void csvFileParsingTest() throws Exception {

        try (InputStream is = cl.getResourceAsStream(zipFileParsingTest().get(2));
             CSVReader csvReader = new CSVReader(new InputStreamReader(is))) {

            List<String[]> data = csvReader.readAll();
            Assertions.assertEquals(2, data.size());
            Assertions.assertArrayEquals(
                    new String[] {"file", "csv"},
                    data.get(0)
            );
            Assertions.assertArrayEquals(
                    new String[] {"автор","Павел"},
                    data.get(1)
            );
        }
    }

    @Test
    @DisplayName("JSON")
    void jsonParsingTest() throws Exception {
        try (Reader reader = new InputStreamReader(
                cl.getResourceAsStream("FileJson.json")
        )) {
            FileJson actual = mapper.readValue(reader, FileJson.class);

            Assertions.assertEquals("0001", actual.getId());
            Assertions.assertEquals("donut", actual.getType());
            Assertions.assertEquals("Regular", actual.getBatter().getTaste());
            Assertions.assertEquals("Chocolate", actual.getBatter().getTopping());
        }
    }
}
