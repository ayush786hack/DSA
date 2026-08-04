class MedianFinder {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {

        if(maxHeap.isEmpty() || num<=maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        //now I have to balance so........
        if(maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
          if(minHeap.size()>maxHeap.size()+1){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            double med=(maxHeap.peek()+minHeap.peek())/2.0;
            return med;
        }else if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }else if(maxHeap.size()<minHeap.size()){
            return minHeap.peek();
        }
        return 0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */