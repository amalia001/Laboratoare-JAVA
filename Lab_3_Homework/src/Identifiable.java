import java.util.Comparator;
import java.util.List;

/**
 * @author Gradinariu Amalia-Laura
 */
public interface Identifiable {
    String getAddress();
    public static void sortIdentifiables(List<Node> list)
    {
        list.sort(Comparator.comparing(Node::getAddress));
    }
}
