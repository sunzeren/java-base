package com.example;

import com.example.ioc.Dao;
import com.example.mvc.listener.EnvironmentListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DemoApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("b")
    Dao a;

    public static void main(String[] args) {
        // SpringApplication.run(DemoApplication.class, args);
        // 或者使用以上代码
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.addListeners(new EnvironmentListener());
        application.run(args);
    }


    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        a.saySomeThing();
    }

    /**
     * @Author SuZeRen
     * @Description 测试Spring注入Bean时,如果一个接口拥有两个实现类,
     * 而未指定具体使用哪一个实现时,项目运行时候会报错,提示需要指定对应的Bean
     * 当@Autowired注入的对象为Static时,因为静态属性,所以会在之前被加载,则无法注入,注入为null值
     * @Date 21:27 2019/3/4
     **/
    private void testIocBean(){
        a.saySomeThing();
    }

}

