
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoTest {
    public static BPTree tree;
    @BeforeClass
    public static void init(){
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
    public void mockito(){
        //使用spy方法，构建一个真实对象
        BPTree mockito = Mockito.spy(tree);
        when(mockito.findNode(5)).thenReturn(null);


        assertEquals("1",mockito.find(1));

        assertEquals(null, mockito.find(5));

    }
}