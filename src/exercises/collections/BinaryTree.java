package exercises.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinaryTree<T extends Comparable<T>> {
    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public static void main(String[] args) {
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int k = random.nextInt(100);
            System.out.println(k);
            binaryTree.add(k);
        }
        List<Integer> a = binaryTree.traverse();
        for (Integer i : a) {
            System.out.print(i + " ");
        }
    }

    public boolean add(T newValue) {
        if (this.value == null) {
            this.value = newValue;
            this.left = new BinaryTree<T>();
            this.right = new BinaryTree<T>();
            return true;
        } else if (this.value.compareTo(newValue) == 0) {
            return false;
        }
        else if (newValue.compareTo(this.value) < 0) {
            return this.left.add(newValue);
        } else {
            return this.right.add(newValue);
        }
    }

    public T getValue() {
        return this.value;
    }

    public List<T> traverse() {
        List<T> result = new ArrayList<T>();
        if (this.value == null) {
            return result;
        }
        result = this.left.traverse();
        result.add(this.value);
        result.addAll(this.right.traverse());
        return result;
    }
}
