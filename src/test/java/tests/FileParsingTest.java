package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileParsingTest {

    private ClassLoader cl = FileParsingTest.class.getClassLoader();

    @Test
    @DisplayName("Чтение файла PDF")
    void pdfFileParsingTest() throws Exception {

        PDF pdf = new PDF(URI.create("file:///C:/Users/Pavel/IdeaProjects/qa_guru_new/src/test/resources/used-words.pdf"));
        Assertions.assertTrue(pdf.text.contains("распространенных"));
    }

    @Test
    @DisplayName("Чтение файла XLSX")
    void xlsFileParsingTest() throws Exception {

        XLS xls = new XLS(URI.create("file:///C:/Users/Pavel/IdeaProjects/qa_guru_new/src/test/resources/XLSX-file.xlsx"));
        Row headerRow = xls.excel.getSheetAt(0).getRow(0);
        Assertions.assertTrue(headerRow.getCell(0).getStringCellValue().contains("тест"));
    }

    @Test
    @DisplayName("Чтение файла CSV")
    void csvFileParsingTest() throws Exception {

        try (InputStream is = cl.getResourceAsStream("CSV-file.csv");
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
}
