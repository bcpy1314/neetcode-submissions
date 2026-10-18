class Logger {

    int printInterval = 10;
    private Map<String, Integer> processingMessage;

    public Logger() {
        processingMessage = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {

        if (!this.processingMessage.containsKey(message)){
            this.processingMessage.put(message, timestamp);
            return true;
        }
        Integer oldTimeStamp = this.processingMessage.get(message);
        if (timestamp - oldTimeStamp >= 10){
            this.processingMessage.put(message, timestamp);
            return true;
        } else{
            return false;
        }

        
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();

 */
