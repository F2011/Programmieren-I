package exercises.threads.search;

import java.util.LinkedList;
import java.util.ListIterator;

public class SearchEngine {
    private LinkedList<String> queue;
    private int working = 0;

    public SearchEngine(LinkedList<String> queue) {
        this.queue = queue;
        LinkedList<PageLoader> threads = new LinkedList<>();
        for (String url : queue) {
            PageLoader loader = new PageLoader(url);
            threads.add(loader);
            (new Thread(loader)).start();
            working++;
            System.out.println("Started loading: " + url);
        }
        while (working > 0) {
            ListIterator<PageLoader> iterator = threads.listIterator();
            while (iterator.hasNext()) {
                if (iterator.next().pageLoaded()) {
                    working--;
                    iterator.previous();
                    System.out.println(iterator.next().getPageContent().substring(0, 100));
                    iterator.remove();
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("https://www.youtube.com/");
        queue.add("https://www.google.com/");
        queue.add("https://www.rust-lang.org/");
        queue.add("https://www.berrybase.de/");
        queue.add("https://www.iai.kit.edu/");
        SearchEngine engine = new SearchEngine(queue);
    }
}
