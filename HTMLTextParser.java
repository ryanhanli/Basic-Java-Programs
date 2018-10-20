import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class HTMLParser {

    public static void main(String[] args) throws IOException {

    	String url = "https://www.google.com/";

        Document document;
        try {
            document = Jsoup.connect(url).get();
            Elements paragraphs = document.select("p");

            Element firstParagraph = paragraphs.first();
            Element lastParagraph = paragraphs.last();
            Element p;
            int i=1;
            p=firstParagraph;
            System.out.println(p.text());
            while (p!=lastParagraph){
                p=paragraphs.get(i);
                System.out.println(p.text());
                i++;
            } 
    } catch (IOException e) {
        e.printStackTrace();
    }
    	    
    	
    }
}
