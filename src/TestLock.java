public class TestLock implements Runnable{
	
	
	public static void main(String[] args){
		for(int i = 0; i < 4; i++){
			new Thread(new TestLock()).start();
		}
	}

	@Override
	public void run() {
		Lock lock = new Lock("lalala");
		lock.getLock();
		
	}

}


class Lock{
	private String lockName;
	
	public Lock(String lockName){
		this.lockName = lockName;
	}
	
	public boolean getLock(){
		synchronized (lockName) {
			System.out.println(Thread.currentThread().getName() + "获取锁开始睡觉");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "获取锁睡觉完成");
		}
		
		return true;
	}
}


