package com.tteam.reporter.component.xlsx;

import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDate;

@UtilityClass
public class ReportStyle {
    public static CellStyle getHeaderStyle(XSSFWorkbook workbook) {
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        Font font = getFont(workbook);
        font.setBold(true);
        font.setFontHeightInPoints((short) 11);
        headerStyle.setFont(font);
        return headerStyle;
    }

    public static CellStyle getValuesStyle(XSSFWorkbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        return cellStyle;
    }
    public static Font getFont(XSSFWorkbook workbook) {
        Font font = workbook.createFont();
        font.setFontName("Book Antiqua");
        font.setFontHeightInPoints((short) 10);
        return font;
    }

    public static void getBorderLine(XSSFSheet sheet, int firstRow, int lastRow, int frCol, int flCol) {
        CellRangeAddress borderLine = new CellRangeAddress(firstRow, lastRow, frCol, flCol);
        RegionUtil.setBorderBottom(BorderStyle.MEDIUM, borderLine, sheet);
        RegionUtil.setBorderLeft(BorderStyle.MEDIUM, borderLine, sheet);
        RegionUtil.setBorderRight(BorderStyle.MEDIUM, borderLine, sheet);
        RegionUtil.setBorderTop(BorderStyle.MEDIUM, borderLine, sheet);
    }

    public static void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }else if (value instanceof LocalDate) {
            cell.setCellValue((LocalDate) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
}
