package parser;

import javax.sql.DataSource;

public interface DataBaseAccess {
    public void setDataSource(DataSource source);
    public void writeData(ShikadoRoll roll);

}
