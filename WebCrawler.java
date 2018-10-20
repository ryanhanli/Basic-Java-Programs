import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WebCrawler {

    private final Set<URL> links;
    private final long startTime;

    private WebCrawler(final URL startURL) {
        this.links = new HashSet<>();
        this.startTime = System.currentTimeMillis();
        crawl(initURLS(startURL));
    }

    private void crawl(final Set<URL> urls) { //Start at website
        urls.removeAll(this.links);  //Remove already visited websites
        if(!urls.isEmpty()) {  
            final Set<URL> newURLS = new HashSet<>();
            try {
                this.links.addAll(urls);
                for(final URL url : urls) { //Add website including starting website to list of visited sites
                    System.out.println("time = " + (System.currentTimeMillis() - this.startTime)+ " connected to : " + url); //Enumerate the URLS we have
                    final Document document = Jsoup.connect(url.toString()).get();
                    final Elements linksOnPage = document.select("a[href]");  //Then go to the starting URL and for each one repeat the same process
                    for(final Element element : linksOnPage) {
                        final String urlText = element.attr("abs:href");
                        final URL discoveredURL = new URL(urlText);
                        newURLS.add(discoveredURL);
                    }
                }
            } catch(final Exception | Error ignored) {
            }
            crawl(newURLS);
        }
    }

    private Set<URL> initURLS(final URL startURL) {
        return Collections.singleton(startURL);
    }

    public static void main(String[] args) throws IOException {

        final WebCrawler spider = new WebCrawler(new URL("https://www.google.com/search?rlz=1C1CHBF_enUS776US776&ei=aM_GW9u0KKec_QbTyKzwAg&q=vr+benefits&oq=vr+benefits&gs_l=psy-ab.3..0l2j0i22i30l8.352213.356575..356669...6.0..0.82.890.17......0....1..gws-wiz.......0i71j0i131j0i67j0i10.BhXGazI63Z0"));

    }

}
