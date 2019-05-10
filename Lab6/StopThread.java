package Lab6;

class StopThread extends Thread{
    long timeLimit;
    public StopThread(long timeLimit){
        this.timeLimit = timeLimit;
    }
    public void run(){
        long start = System.currentTimeMillis();
        while(timeLimit > System.currentTimeMillis() - start){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("��� ��� ��������� �������� ���!");
        System.exit(0);
    }
}