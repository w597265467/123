package model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class TableColumn {
    public String columnName;
    public String columnType;
    public String dataType;
    public String characterMaximumLength;
    public String isNullable;
    public String columnDefault;
    public String columnComment;

    public TableColumn(String columnName, String columnType, String dataType, String characterMaximumLength, String isNullable, String columnDefault, String columnComment) {
        this.columnName = columnName;
        this.columnType = columnType;
        this.dataType = dataType;
        this.characterMaximumLength = characterMaximumLength;
        this.isNullable = isNullable;
        this.columnDefault = columnDefault;
        this.columnComment = columnComment;
    }

}
