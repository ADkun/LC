import solutions.array.MaxSlidingWindow;
import solutions.array.ThreeSum;
import solutions.other.KthLargest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int len = args.length;
//        for (String arg : args) {
//            System.out.println(arg);
//
//        }
//        Scanner scan=new Scanner(System.in);
//        StringBuilder stringBuilder=new StringBuilder();
//        stringBuilder.append("123123123132");
//        stringBuilder.delete(0,2);
//        System.out.println(stringBuilder.toString());
//        stringBuilder.insert(1,"aaa");
//        System.out.println(stringBuilder.toString());

//        CountAndSay s2 = new CountAndSay();
//        System.out.println(s2.countAndSay(6));

//        ListNode head = new ListNode();
//        ListNode now = head;
//        head.val = 0;
//        int i = 1;
//        for (; i < 5; ++i) {
//            ListNode newNode = new ListNode(i, null);
//            now.next = newNode;
//            now = newNode;
//        }
//
//        ReverseList reverseList=new ReverseList();
//        reverseList.reverseList(head);

//        MergeTwoLists mergeTwoLists=new MergeTwoLists();
//        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4,null)));
//        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(4,null)));
//        mergeTwoLists.mergeTwoLists(l1,l2);

//        IsPalindrome isPalindrome = new IsPalindrome();
//        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1, null)));
//        isPalindrome.isPalindrome(head);

//        HasCycle hasCycle = new HasCycle();
//        ListNode head = new ListNode(3, null);
//        ListNode second = new ListNode(2, null);
//        head.next = second;
//        second.next = new ListNode(0, new ListNode(-4, second));
//        hasCycle.hasCycle(head);

//        System.out.println(-Double.MAX_VALUE);
////        System.out.println(Double.MIN_VALUE);
////
////        Deque<Integer> stack=new LinkedList<>();
////        stack.isEmpty();

//        BubbleSort bubbleSort = new BubbleSort();
//        int[] array = {3, 2, 1};
//        int[] array1 = {};
//        bubbleSort.bubbleSort(array1);
//        for (int i : array1) {
//            System.out.print(i + " ");
//        }
//
//        SelectSort selectSort = new SelectSort();
//        int[] arr = {4, 2, 1, 6};
//        selectSort.selectSort(arr);
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println("=====");
//        InsertSort insertSort = new InsertSort();
//        int[] arr1 = {1, 6, 2, 3, 0, 10};
//        insertSort.insertSort(arr1);
//        for (int i : arr1) {
//            System.out.print(i + " ");
//
//        }
//
//        System.out.println("-------");
//        QuickSort qs = new QuickSort();
//        int[] arr2 = {5, 2, 0, 1, 4, 1, 9, 10, 10};
//        qs.quickSort(arr2);
//        for (int i : arr2) {
//            System.out.print(i+" ");
//
//        }

//        int[] arr = {1, 3, 4, 7, 10, 15, 100};
//        OrderFind of = new OrderFind();
//        int result1 = of.orderFind(arr, 5);
//        int result2 = of.orderFind(arr, -1);
//        System.out.println("result1:" + result1);
//        System.out.println("result2:" + result2);

//        int result = BinarySearch.bs(arr, 100);
//        int result = TreeSearch.ts(arr, 1001);
//        System.out.println(result);
//
//
//        System.out.println("========");
//        int[] arr1 = {4, 1, 0, 2, 100, 55, 44};
//        MergeSort.mergeSort(arr1);
//        for (int i : arr1) {
//            System.out.print(i + " ");
//        }

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        System.out.println(list.size());
//        list.add(2);
//        System.out.println(list.size());

//        String s = "abbbbc";
//        String b = s.replace("bbb","");
//        System.out.println(b);

//        int[] arr = {4, 5, 8, 2};
//        KthLargest kth = new KthLargest(3, arr);
//        int result = kth.add(3);
//        result = kth.add(5);

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        System.out.println(list.get(-1));
//
//        long start;
//        long end;
//        start = System.nanoTime();
//        for (long i = 0;i<999999999;++i);
//        end = System.nanoTime();
//        System.out.println(end-start);
//
//        start = System.nanoTime();
//        for (long i = 0;i<999999999;i++);
//        end = System.nanoTime();
//        System.out.println(end-start);

//        int[] arr = {3, 3, 2, 1, 3, 2, 6,6 -1};
//        MaxSlidingWindow msw = new MaxSlidingWindow();
//        msw.maxSlidingWindow2(arr,3);

//        int[] arr = {-1,-1,1,0};
//        ThreeSum ts = new ThreeSum();
//        ts.threeSum(arr);

        List<String> list = new ArrayList<>(3);
        list.set(1,"123");
        System.out.println(list.get(1));
    }
}
