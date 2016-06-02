import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class TestExecutor{
	
	public static void main(String[] args){
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1, new ThreadFactory(){
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r);
			}
		});
		
		executorService.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("f--" + Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000 * 2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("sleep end--" + Thread.currentThread().getName());
				
			}
		}, 1, TimeUnit.SECONDS);
		
		/*executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("s--" + Thread.currentThread().getName());
				
			}
		}, 0, 1, TimeUnit.SECONDS);*/
		
		//executorService.shutdown();
	}

}
