package model;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

import java.util.ArrayList;
import java.util.List;

public class Table {
    //TABLENAME 表名,
    //  COLUMNNAME 列名,
    //  COLUMNTYPE 数据类型,
    //    DATATYPE 字段类型,
    //  CHARACTERMAXIMUMLENGTH 长度,
    //  ISNULLABLE 是否为空,
    //  COLUMNDEFAULT 默认值,
    //  COLUMNCOMMENT 备注
    public String tableName;
    public List<TableColumn> columnList = new ArrayList<>();

}
