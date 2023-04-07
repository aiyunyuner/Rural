package com.TypeDelta.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 堆排序演示
 *
 * @author Lvan
 */
class ABC {
    private String name;
    private Integer click;

    public ABC(String name, Integer click) {
        this.name = name;
        this.click = click;
    }

    @Override
    public String toString() {
        return "abc{" +
                "name='" + name + '\'' +
                ", click=" + click +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }
}

public class HeapSort {

    public static void main(String[] args) {
        List<ABC> list = new ArrayList<>();
        list.add(new ABC("a", 16));
        list.add(new ABC("a", 7));
        list.add(new ABC("a", 3));
        list.add(new ABC("a", 20));
        list.add(new ABC("a", 17));
        list.add(new ABC("a", 8));
        System.out.println(list.toString());
//        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(list);
        System.out.println(list.toString());
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }
    }


    /**
     * 创建堆，
     *
     * @param list 待排序列
     */
    private static void heapSort(List<ABC> list) {
        //创建堆
        for (int i = (list.size() - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(list, i, list.size());
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = list.size() - 1; i >0; i--) {
            //将堆顶元素与末尾元素进行交换

            Collections.swap(list, i, 0);
//            int temp = arr[i];
//            arr[i] = arr[0];
//            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(list, 0, i);
        }
    }

    /**
     * 调整堆
     *
     * @param list   待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(List<ABC> list, int parent, int length) {
        //将temp作为父节点
        ABC temp = list.get(parent);
//        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && list.get(lChild).getClick() < list.get(rChild).getClick()) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp.getClick() >= list.get(lChild).getClick()) {
                break;
            }

            // 把孩子结点的值赋给父结点
            list.set(parent, list.get(lChild));

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        list.set(parent, temp);

    }
}