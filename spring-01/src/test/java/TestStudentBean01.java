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
 * use:测试bean的对象的创建方式
 */

public class TestStudentBean01 {

    private ClassPathXmlApplicationContext ac;

    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("bean01.xml");
    }

    /**
     * 使用无参构造创建对象并加入容器中
     */
    @Test
    public void test01() {
        Student student = (Student) ac.getBean("student1");
        System.out.println("student = " + student);
        ac.close();
    }

    /**
     * 使用工厂创建bean对象
     */
    @Test
    public void test02() {
        Student student = (Student) ac.getBean("student2");
        System.out.println("student = " + student);
    }

    /**
     * 使用静态共工厂创建bean对象
     */
    @Test
    public void test03() {
        Student student = (Student) ac.getBean("student3");
        System.out.println("student = " + student);
    }
}
