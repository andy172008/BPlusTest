

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertRemoveTest {
    public static BPTree tree;

    @BeforeClass
    public static void init() {
        //创建一个新的B+树，阶为5
        tree = new BPTree(5);

        //因为测试的是插入函数，所以这里就不使用插入函数了，手动添加数据
        tree.root.keys.add(1);
        tree.root.keys.add(5);
        tree.root.keys.add(7);
        tree.root.value.add("1");
        tree.root.value.add("5");
        tree.root.value.add("7");
        System.out.println("B+树构建完成");
    }


    @Test
    public void insertKey() {

        assertEquals(1, tree.insertKey(tree.root, 2));
        assertEquals(2, tree.insertKey(tree.root, 3));
        assertEquals(4, tree.insertKey(tree.root, 6));
    }


    @Test
    public void removeKey() {
        assertEquals(1, tree.removeKey(tree.root, 2));
        assertEquals(-1, tree.removeKey(tree.root, 1916085));
    }
}