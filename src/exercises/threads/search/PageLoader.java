package exercises.threads.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class PageLoader implements Runnable {
    private String url;
    private String content;

    public PageLoader(String url) {
        this.url = url;
    }

    public boolean pageLoaded() {
//        System.out.println(url + ":\n" + content);
        return content != null;
    }

    public String getPageContent() {
        System.out.println("Printing page " + url);
        return content;
    }

    public void run() {
        String encoding = "UTF-8";
        StringBuilder buffer = new StringBuilder();
        String line = null;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader((new URI(url)).toURL().openStream(), encoding))) {
            while ((line = br.readLine()) != null) {
                buffer.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        content = buffer.toString();
//        if (content == null || content.isEmpty()) {
//            content = "A problem occured while loading the page";
//        }
//        System.out.println(content.length());
//        System.out.println(content.substring(0, 100));
    }
}
