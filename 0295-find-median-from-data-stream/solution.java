class MedianFinder {
    PriorityQueue<Integer> leftHalf = new PriorityQueue(Collections.reverseOrder());
    PriorityQueue<Integer> rightHalf = new PriorityQueue();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (leftHalf.peek() == null) {
            leftHalf.add(num);
            return;
        }
        if (rightHalf.peek() == null) {
            if (num > leftHalf.peek()) {
                rightHalf.add(num);
            } else {
                rightHalf.add(leftHalf.poll());
                leftHalf.add(num);
            }
            return;
        }
        if (num > rightHalf.peek()) {
            rightHalf.add(num);
        } else {
            leftHalf.add(num);
        }
        if (rightHalf.size() > leftHalf.size()) {
            leftHalf.add(rightHalf.poll());
        } else if (leftHalf.size() > rightHalf.size()) {
            rightHalf.add(leftHalf.poll());
        }
    }
    
    public double findMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0;
        } else if (leftHalf.size() > rightHalf.size()) {
            return leftHalf.peek();
        } else {
            return rightHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */