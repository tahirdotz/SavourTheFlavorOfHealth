class TimerImpl implements Timer {
    private boolean timeUp = false;

    @Override
    public void startTimer() {
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                timeUp = true;
                System.out.println("\nTime's up!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public boolean isTimeUp() {
        return timeUp;
    }
}