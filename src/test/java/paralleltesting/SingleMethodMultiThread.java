package paralleltesting;

import org.testng.annotations.Test;

public class SingleMethodMultiThread {
	

  @Test(threadPoolSize=1, invocationCount=3,timeOut=1000)
  public void test1() {
	  Thread.currentThread().setName("Cohort4-test1");
	  System.out.println("From Test 1 :"+ Thread.currentThread().getName()+ " Thread id:"+Thread.currentThread().getId());
  }
  
 
  @Test(invocationCount = 3)
  public void test2() {
	  Thread.currentThread().setName("Thread-test2");
	  System.out.println("From Test 2 :"+Thread.currentThread().getName()+" Thread id:"+Thread.currentThread().getId());
  }
  
  @Test(threadPoolSize = 2,invocationCount = 3)
  public void test3() {
	  Thread.currentThread().setName("Thread-test3");
	  System.out.println("From Test 3 :"+Thread.currentThread().getName()+" Thread id:"+Thread.currentThread().getId());
  }
  
  
}
