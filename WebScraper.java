import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class WebScraper {

    public static void main(String[] args) {

        String url = "https://example.com"; // replace with real product page

        try {

            Document doc = Jsoup.connect(url).get();

            Elements products = doc.select("div.product");

            FileWriter writer = new FileWriter("products.csv");
            writer.append("Product Name,Price\n");

            for (Element product : products) {

                String name = product.select("h2").text();
                String price = product.select(".price").text();

                writer.append(name).append(",");
                writer.append(price).append("\n");
            }

            writer.flush();
            writer.close();

            System.out.println("Data saved to products.csv");

        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
