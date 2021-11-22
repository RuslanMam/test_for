package HRM;

import org.testng.annotations.Test;

public class Priority_test {

    @Test(priority = 2)
    public void method1(){

        System.out.println("Priority-->  method1");
    }
    @Test(priority = 0)
    public void method2(){

        System.out.println("Priority-->  method2");
    }
    @Test(priority = 1)
    public void method3(){

        System.out.println("Priority-->  method3");
    }
    @Test( enabled = false)
    public void method4(){

        System.out.println("Priority-->  method4");
    }
}
