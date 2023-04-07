package com.TypeDelta.utils;

import com.TypeDelta.pojo.Sight;

import java.util.Collections;
import java.util.List;

public class HeapSortUtils {

    /**
     * 创建堆，
     *
     * @param list 待排序列
     */
    public static void heapSort(List<Sight> list) {
        //创建堆
        for (int i = (list.size() - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(list, i, list.size());
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = list.size() - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换

            Collections.swap(list, i, 0);
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
    public static void adjustHeap(List<Sight> list, int parent, int length) {
        //将temp作为父节点
        Sight temp = list.get(parent);
//        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && list.get(lChild).getClick() > list.get(rChild).getClick()) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp.getClick() <= list.get(lChild).getClick()) {
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
