package parser;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Here i create and fill parsing target list
        List<String> targets=new ArrayList<>();
        targets.add("http://ug.shikado.ru/product-category/rolly");
        targets.add("http://ug.shikado.ru/product-category/rolly/page/2");
        targets.add("http://ug.shikado.ru/product-category/rolly/page/3");
        targets.add("http://ug.shikado.ru/product-category/rolly/page/4");
        targets.add("http://ug.shikado.ru/product-category/rolly/page/5");
        targets.add("http://ug.shikado.ru/product-category/rolly/page/6");
        targets.add("http://ug.shikado.ru/product-category/rolly/page/7");

        //Create Spring Context from configuration file(Annotation configured file)
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);

        //Obtain Beans from context
        DataBaseAccess shikadoDao=context.getBean("shikado",DataBaseAccessObject.class);
        Parser parser=context.getBean("parser",ShikadoParser.class);

        //Provide list of targets to the parser
        parser.setTargeList(targets);

        //Create list of ShikadoRoll objects and obtain it from parser
        System.out.println("Obtain information from Shikado ...");
        List<ShikadoRoll> list = parser.getData();

        //Write Data to the database using DataBaseObject
        for(ShikadoRoll roll:list)
        {
            shikadoDao.writeData(roll);
            System.out.println("Item recorded");
        }


    }
}
