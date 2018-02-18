package in_memory_fs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("/a".split("/")));
    }

    class FileSystem {
        Node root = new Node(null, null);

        public List<String> ls(String path) {
            Node node = find(path);
            return node.content != null ? Arrays.asList(node.name) : new ArrayList<>(node.nodes.keySet());
        }

        public void mkdir(String path) {
            String[] parts = path.split("/");
            Node node = root;
            for (int i = 1; i < parts.length; i++) {
                node.nodes.putIfAbsent(parts[i], new Node(parts[i], null));
                node = node.nodes.get(parts[i]);
            }
        }

        public void addContentToFile(String filePath, String content) {
            String[] parts = filePath.split("/");
            Node node = root;
            for (int i = 1; i < parts.length - 1; i++)
                node = node.nodes.get(parts[i]);
            String name = parts[parts.length - 1];
            node.nodes.putIfAbsent(name, new Node(name, ""));
            node.nodes.get(name).content += content;
        }

        public String readContentFromFile(String filePath) { return find(filePath).content;}

        Node find(String path) {
            Node node = root;
            String[] parts = path.split("/");
            for (int i = 1; i < parts.length; i++)
                node = node.nodes.get(parts[i]);
            return node;
        }

        class Node {
            final String name;
            String content;
            TreeMap<String, Node> nodes = new TreeMap<>();

            Node(String name, String content) {
                this.name = name;
                this.content = content;
            }
        }
    }
}
