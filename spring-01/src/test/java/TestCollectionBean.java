import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 作者:ZYC
 * DATE:2024/8/9
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:测试复杂属性的进行赋值
 */
public class TestCollectionBean {

    private ClassPathXmlApplicationContext ac;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("bean03.xml");
    }
    @Test
    public void test() {
        Object cb = ac.getBean("cb");
        System.out.println(cb);
    }
}
