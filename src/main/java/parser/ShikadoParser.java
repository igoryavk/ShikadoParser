package parser;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("parser")
public class ShikadoParser implements Parser {
    private Connection jsoup;
    private List<ShikadoRoll> list;
    private List<String> targets;
    @Override
    public List getData() {
        list=new ArrayList<>();
        for(String target:targets)
        {
            jsoup= Jsoup.connect(target);
            Document document=null;
            try {
                document=jsoup.get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements elements=document.getElementsByClass("woo-entry-inner clr");
            for(Element element:elements)
            {
                ShikadoRoll roll=new ShikadoRoll();
                roll.setName(element.child(1).child(0).text());
                roll.setPrice(element.child(2).child(0).text());
                roll.setComposition(element.child(3).text());
                list.add(roll);
            }
        }
        return list;
    }

    @Override
    public void setTargeList(List<String> targets) {
        this.targets=targets;
    }
}
