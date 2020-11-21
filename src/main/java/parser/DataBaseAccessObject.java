package parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component("shikado")
public class DataBaseAccessObject implements DataBaseAccess{
    private DataSource dataSource;
    private JdbcTemplate template;
    @Override
    @Autowired
    public void setDataSource(DataSource source) {
        dataSource=source;
        template=new JdbcTemplate(dataSource);
    }

    @Override
    public void writeData(ShikadoRoll roll) {
        String SQL="INSERT INTO shikado(name,price,composition) values(?,?,?)";
        template.update(SQL,roll.getName(),roll.getPrice(),roll.getComposition());
    }
}
