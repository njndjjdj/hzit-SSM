import com.zyc.entity.Student;
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
 * use:测试bean对象赋值的方式
 */
public class TestStudentBean02 {

    private ClassPathXmlApplicationContext ac;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("bean02.xml");
    }

    /**
     * 第一种方式，通过setter
     */
    @Test
    public void test01() {
        Student student = (Student) ac.getBean("student1");
        System.out.println(student);
    }

    /**
     * 通过构造方法为属性赋值
     */
    @Test
    public void test02() {
        Student student = (Student) ac.getBean("student2");
        System.out.println(student);
    }

    /**
     * p标签给bean属性赋值
     */
    @Test
    public void test03() {
        Student student = (Student) ac.getBean("student3");
        System.out.println(student);
    }

    /**
     * 使用spEL表达式进行bean属性赋值
     */
    @Test
    public void test04() {
        Student student = (Student) ac.getBean("student4");
        System.out.println(student);
    }
}
