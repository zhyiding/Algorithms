package _13_data_structure_designing;

import java.util.*;

// #588
public class InMemoryFileSystem {

    class FileTreeNode {
        public String name = null;
        Map<String, String> fileHash = null;
        Map<String, FileTreeNode> directoryHash = null;

        public FileTreeNode(String name) {
            this.name = name;
            fileHash = new HashMap<>();
            directoryHash = new HashMap<>();
        }
    }

    FileTreeNode root = null;

    public InMemoryFileSystem() {
        root = new FileTreeNode("~");
    }

    public List<String> ls(String path) {
        int split = path.lastIndexOf("/");
        if (split == path.length() - 1) {
            return listDirectory(root);
        } else {
            String directoryPath = path.substring(0, split);
            String last = path.substring(split + 1);
            FileTreeNode node = traverseFileTreeNodes(directoryPath);
            if (node.directoryHash.containsKey(last)) {
                return listDirectory(node.directoryHash.get(last));
            } else if (node.fileHash.containsKey(last)) {
                List<String> list = new ArrayList<String>();
                list.add(last);
                return list;
            }
        }
        return new ArrayList<>();
    }

    public List<String> listDirectory(FileTreeNode directoryNode) {
        List<String> list = new ArrayList<>();
        list.addAll(directoryNode.fileHash.keySet());
        list.addAll(directoryNode.directoryHash.keySet());
        Collections.sort(list);
        return list;
    }

    public FileTreeNode traverseFileTreeNodes(String path) {
        String[] nodeNames = path.split("/");
        FileTreeNode node = root;
        for (int i = 1; i < nodeNames.length; i++) {
            if (!node.directoryHash.containsKey(nodeNames[i])) {
                node.directoryHash.put(nodeNames[i], new FileTreeNode(nodeNames[i]));
            }
            node = node.directoryHash.get(nodeNames[i]);
        }
        return node;
    }

    public void mkdir(String path) {
        traverseFileTreeNodes(path);
    }

    public void addContentToFile(String filePath, String content) {
        int split = filePath.lastIndexOf('/');
        String directoryPath = filePath.substring(0, split);
        String fileName = filePath.substring(split + 1);
        FileTreeNode node = traverseFileTreeNodes(directoryPath);
        if (!node.fileHash.containsKey(fileName)) {
            node.fileHash.put(fileName, content);
        } else {
            StringBuilder sb = new StringBuilder(node.fileHash.get(fileName));
            sb.append(content);
            node.fileHash.put(fileName, sb.toString());
        }
    }

    public String readContentFromFile(String filePath) {
        int split = filePath.lastIndexOf('/');
        String directoryPath = filePath.substring(0, split);
        String fileName = filePath.substring(split + 1);
        FileTreeNode node = traverseFileTreeNodes(directoryPath);
        if (!node.fileHash.containsKey(fileName)) {
            return null;
        } else {
            return node.fileHash.get(fileName);
        }
    }
}
