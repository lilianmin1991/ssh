package base.collection;

import org.junit.Test;

public class NodeTest {
	@Test
    public void treeTest() {
  
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 11, 74 };
  
        Node roots = new Node();
        for (int number : randoms) {
            roots.add(number);
        }
        System.out.println(roots.values());
    }
    
}
