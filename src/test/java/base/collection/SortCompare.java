package base.collection;
 
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
 
public class SortCompare {
 
	@Test
    public void sortCompareTest() {
        //初始化随机数
        int total = 40000;
        System.out.print("初始化一个长度是"+total+"的随机数字的数组...");
        int[] originalNumbers = new int[total];
        for (int i = 0; i < originalNumbers.length; i++) {
            originalNumbers[i] = (int)(Math.random()*total);
        }
        System.out.println("初始化完毕");
        System.out.println("启动不同算法排序：");
         
        //从初始化了的随机数组复制过来，以保证，每一种排序算法的目标数组，都是一样的
        int[] use4sort;
         
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByArrays = performance(new ArraysSort(use4sort),"Arrays.sort()");
        
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByQuickSort = performance(new QuickSort(use4sort,0,use4sort.length-1),"快速");
        
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByTree = performance(new TreeSort(use4sort),"二叉树");
        
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByHeap = performance(new MaxHeapifySort(use4sort),"堆");
        
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersBySelection = performance(new SelectionSort(use4sort),"选择法");
         
        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByBubbling = performance(new BubblingSort(use4sort),"冒泡法");
        
       /**  
        System.out.println("查看排序结果，是否是不同的数组对象");
        System.out.println(sortedNumbersBySelection);
        System.out.println(sortedNumbersByBubbling);
        System.out.println(sortedNumbersByTree);
        System.out.println(sortedNumbersByHeap);
        System.out.println(sortedNumbersByArrays);
        System.out.println(sortedNumbersByQuickSort);
        */
         
        StringBuffer sb = new StringBuffer();
        if(!Arrays.equals(sortedNumbersByArrays, sortedNumbersByBubbling)) {
        	sb.append("[冒泡法]");
        }else if(!Arrays.equals(sortedNumbersByArrays, sortedNumbersByTree)) {
        	sb.append("[二叉树]");
        }else if(!Arrays.equals(sortedNumbersByArrays, sortedNumbersByHeap)) {
        	sb.append("[堆排序]");
        }else if(!Arrays.equals(sortedNumbersByArrays, sortedNumbersBySelection)) {
        	sb.append("[选择法]");
        }else if(!Arrays.equals(sortedNumbersByArrays, sortedNumbersByQuickSort)) {
        	sb.append("[快速排序]");
        }
        if(sb.length()==0) {
        	System.out.print("所有排序均正确");
        }else {
        	System.out.print(sb.append("不正确！"));
        }
         
    }
     
    interface Sort{
        void sort();
        int[] values();
    }
     
    private static int[] performance(Sort algorithm, String type) {
        long start = System.currentTimeMillis();
        algorithm.sort();
        int sortedNumbers[] = algorithm.values();
        long end = System.currentTimeMillis();
        System.out.printf("耗时 %d 毫秒（%s排序）%n",end-start,type);
        return sortedNumbers;
    }
    //选择法排序
    static class SelectionSort implements Sort{
 
        int numbers[];
        SelectionSort(int [] numbers){
            this.numbers = numbers;
        }
         
        @Override
        public void sort() {
            for (int j = 0; j < numbers.length-1; j++) {
                for (int i = j+1; i < numbers.length; i++) {
                    if(numbers[i]<numbers[j]){  
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    }
                }
            }
        }
 
        @Override
        public int[] values() {
            // TODO Auto-generated method stub
            return numbers;
        }
         
    }
     
    //冒泡法排序
    static class BubblingSort implements Sort{
        int numbers[];
        BubblingSort(int [] numbers){
            this.numbers = numbers;
        }
        @Override
        public void sort() {
            for (int j = 0; j < numbers.length; j++) {
                for (int i = 0; i < numbers.length-j-1; i++) {
                    if(numbers[i]>numbers[i+1]){  
                        int temp = numbers[i];
                        numbers[i] = numbers[i+1];
                        numbers[i+1] = temp;
                    }
                }
            }
        }
        @Override
        public int[] values() {
            // TODO Auto-generated method stub
            return numbers;
        }
         
    }
     
    //二叉树排序
    static class TreeSort implements Sort{
        int numbers[];
        Node n;
         
        TreeSort(int [] numbers){
            n =new Node();
            this.numbers = numbers;
        }
        @Override
        public void sort() {
         
            for (int i : numbers) {
                n.add(i);
            }
        }
        @Override
        public int[] values() {
            List<Object> list = n.values();
            int sortedNumbers[] = new int[list.size()];
            for (int i = 0; i < sortedNumbers.length; i++) {
                sortedNumbers[i] = Integer.parseInt(list.get(i).toString());
            }
            return sortedNumbers;
        }
    }
    
    static class MaxHeapifySort implements Sort{
        int numbers[];
        
        MaxHeapifySort(int[] numbers){
        	this.numbers = numbers;
        }
        
		@Override
		public void sort() {
			for (int i = numbers.length - 1; i > 0; i--) {
		        max_heapify(numbers, i);

		        //堆顶元素(第一个元素)与Kn交换
		        int temp = numbers[0];
		        numbers[0] = numbers[i];
		        numbers[i] = temp;
		    }
			
		}
		
		public static void max_heapify(int[] numbers,int n) {
			int child;
			for (int i = (n - 1) / 2; i >= 0; i--) {
	            //左子节点位置
	            child = 2 * i + 1;
	            //右子节点存在且大于左子节点，child变成右子节点
	            if (child != n && numbers[child] < numbers[child + 1]) {
	                child++;
	            }
	            //交换父节点与左右子节点中的最大值
	            if (numbers[i] < numbers[child]) {
	                int temp = numbers[i];
	                numbers[i] = numbers[child];
	                numbers[child] = temp;
	            }
	        }
		}
		@Override
		public int[] values() {
            return numbers;
        }
    } 
    
    static class ArraysSort implements Sort{
    	int[] numbers;
    	ArraysSort(int[] numbers){
    		this.numbers= numbers;
    	}
    	
		@Override
		public void sort() {
			Arrays.sort(numbers);
		}

		@Override
		public int[] values() {
			return numbers;
		}
    }
    
    static class QuickSort implements Sort{
    	int[] numbers;
    	int l;
    	int h;
    	
    	QuickSort(int[] numbers, int l, int h){
    		this.numbers= numbers;
    		this.l= l;
    		this.h= h;
    	}
    	
    	@Override
    	public void sort() {
                sort(numbers, l, h);
    	}
    	
    	public void sort(int[] numbers, int l, int h) {
    		if(l<h) {
    			int mid = getmid(numbers,l,h);
    			sort(numbers, l, mid-1);
    			sort(numbers, mid+1, h);
    		}
    	}
    	
    	@Override
    	public int[] values() {
    		return numbers;
    	}
    	
    	//获取中间值
        private int getmid(int[] numbers, int l, int h) {
            int temp=numbers[l];
            while (l<h) {
                while (l<h&&temp<=numbers[h]) {
                    h--;
                }
                numbers[l]=numbers[h];
                numbers[h]=numbers[l];
                while (l<h&&temp>=numbers[l]) {
                    l++;
                }
                numbers[h]=numbers[l];
                numbers[l]=temp;    
            }
            return l;
        }
    }
 
}