/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjsoup;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Student
 */
public class TestJSoup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String URL = "http://smolgu.ru/";
        try {
            getDataFromURL(URL);
        } catch (IOException ex) {
            Logger.getLogger(TestJSoup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getDataFromURL(String URL) throws IOException{
        Document html = Jsoup.connect(URL).get();
        String title = html.title();
        System.out.println(title);
        Elements news = html.select(".lmenu ul[umi:sortable] li a");
        for (Element facultet: news){
            System.out.println(facultet.text()+": "+
                               facultet.absUrl("href"));
        }
        
    }
    
}
