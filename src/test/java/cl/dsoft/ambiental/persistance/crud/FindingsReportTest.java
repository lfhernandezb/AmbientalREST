package cl.dsoft.ambiental.persistance.crud;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith( SpringRunner.class )
@SpringBootTest
public class FindingsReportTest {
    @Test
    public void iterateOverCellsOnSample() {
        DataFormatter formatter = new DataFormatter();

        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File("/Users/lfhernandez/Development/java/ambiental/report.sample.xlsx"));

            Sheet sheet1 = wb.getSheetAt(0);

            for (Row row : sheet1) {

                for (Cell cell : row) {

                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

                    System.out.print(cellRef.formatAsString());

                    System.out.print(" - ");

                    // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                    String text = formatter.formatCellValue(cell);

                    System.out.println(text);

                    // Alternatively, get the value and format it yourself
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println(cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.println(cell.getDateCellValue());
                            } else {
                                System.out.println(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        case BLANK:
                            System.out.println("BLANK type");
                            break;
                        default:
                            System.out.println("Default:"+cell.getCellType());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
