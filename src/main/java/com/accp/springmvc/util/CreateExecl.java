package com.accp.springmvc.util;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.filechooser.FileSystemView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExecl {
	private String [] columnName;
	private List<String[]> datalist;	
	private String title;
	private String dateType;
	public String[] getColumnName() {
		return columnName;
	}
	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}
	public List<String[]> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<String[]> datalist) {
		this.datalist = datalist;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public  boolean createExecl() {
		try {
			WritableWorkbook wbook = Workbook
					.createWorkbook(new FileOutputStream("D:/失败项目/"+title + ".xls")); // 建立excel文件
			WritableSheet wsheet = wbook.createSheet("导出数据", 0); // sheet名称
			WritableCellFormat cellFormatNumber = new WritableCellFormat();
			cellFormatNumber.setAlignment(Alignment.RIGHT);

			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK); // 定义格式、字体、粗体、斜体、下划线、颜色
			WritableCellFormat wcf = new WritableCellFormat(wf); // title单元格定义
			WritableCellFormat wcfc = new WritableCellFormat(); // 一般单元格定义
			WritableCellFormat wcfe = new WritableCellFormat(); // 一般单元格定义
			wcf.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
			wcfc.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式

			wcf.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			wcfc.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);
			wcfe.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN);

			wsheet.setColumnView(0, 20);// 设置列宽
			wsheet.setColumnView(1, 10);
			wsheet.setColumnView(2, 20);

			int rowIndex = 0;
			int columnIndex = 0;
			if (null != datalist) {
				// rowIndex++;
				columnIndex = 0;
				wsheet.setRowView(rowIndex, 500);// 设置标题行高
				wsheet.addCell(new Label(columnIndex++, rowIndex, title, wcf));
				wsheet.mergeCells(0, rowIndex, "mothly".equals(dateType) ? 5
						: 4, rowIndex);// 合并标题所占单元格
				rowIndex++;
				columnIndex = 0;
				wsheet.setRowView(rowIndex, 380);// 设置项目名行高
				for (String colname : columnName) {
					wsheet.addCell(new Label(columnIndex++, rowIndex, colname, wcf));
				}
				// 开始行循环
				for (String[] array : datalist) { // 循环列
					rowIndex++;
					columnIndex = 0;
					for (String colvalue : array) {
						wsheet.addCell(new Label(columnIndex++, rowIndex, colvalue,
								wcfe));
					}
				}
				rowIndex++;
				columnIndex = 0;
			}
			wbook.write();
			if (wbook != null) {
				wbook.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
