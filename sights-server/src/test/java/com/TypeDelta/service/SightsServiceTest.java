package com.TypeDelta.service;

import com.TypeDelta.mapper.SightsMapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = {
        SightsService.class,
        SightsMapper.class
})
@MapperScan(basePackages = "com.TypeDelta.mapper")

public class SightsServiceTest {
    @Autowired
    private SightsService sightsService;

    @Test
    public void getSightsTypeOne() throws IOException, InterruptedException {
        PythonInterpreter interp1 = new PythonInterpreter();
        interp1.execfile("C:\\Users\\delta\\PycharmProjects\\pythonProject\\main.py");
    }

    @Test
    public void top3() {
        int u_id = 6;
        List<Integer> u = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        u.add(6);
        u.add(2);
        u.add(3);
        u.add(4);
        p.add(1);
        p.add(2);
        p.add(3);
        p.add(4);
        p.add(5);
        v.add(1);
//        v.add(3);
        v.add(4);
        v.add(5);
        System.out.println(u.indexOf(u_id));
        ;

        double[][] simMatrix = new double[u.size()][p.size()];

        for (int i = 0; i < simMatrix.length; i++) {
            int t = 0;
            for (int j = 0; j < simMatrix[i].length; j++) {
                if (v.get(t) == p.get(j)) {
                    simMatrix[i][j] = 1;
                    t++;
                } else
                    simMatrix[i][j] = 0;
            }
        }
        for (int i = 0; i < p.size(); i++) {
            double v1 = 0;
            System.out.println("");
            for (int j = 0; j < u.size(); j++) {
                System.out.print(simMatrix[j][i] + " ");

            }

        }
        List<Double> doubles = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            double v1 = 0;
            double v2 = 0;
            double v3 = 0;
            System.out.println("");
            for (int j = 0; j < u.size(); j++) {
                v1 += (simMatrix[j][i] * simMatrix[0][i]);
                v2 += (simMatrix[0][i]) * (simMatrix[0][i]);
                v3 += (simMatrix[0][i]) * (simMatrix[0][i]);
            }
            v1 = v1 / (Math.sqrt(v2) * Math.sqrt(v3));

            doubles.add(v1);
        }
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < doubles.size(); i++) {
            if (!doubles.get(i).isNaN()) {
                arrayList.add(p.get(i));
//                arrayList.add(doubles.get(i));
            } else {
//                arrayList.add(0.0);
            }
        }

        System.out.println(arrayList.toString());
//

    }

    public static void quickSort(List<Double> arr, int low, int high) {
        double temp, t, q;
        int i, j;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr.get(low);

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr.get(j) && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr.get(i) && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                Double set = arr.set(i, arr.get(j));
                arr.set(j, set);
            }

        }
        //最后将基准为与i和j相等位置的数字交换
//        arr[low] = arr[i];
        arr.set(low, arr.get(i));
//        arr[i] = temp;
        arr.set(i, temp);
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }

}