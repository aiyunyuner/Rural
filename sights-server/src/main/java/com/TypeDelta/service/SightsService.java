package com.TypeDelta.service;

import com.TypeDelta.mapper.SightsMapper;
import com.TypeDelta.pojo.*;
import com.TypeDelta.utils.HeapSortUtils;
import com.TypeDelta.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SightsService {
    @Autowired
    private SightsMapper sightsMapper;

    public Sight getSightsById(ReadUser readUser) {
        sightsMapper.addClick(readUser.getId());
        sightsMapper.addRead(readUser);
        return sightsMapper.getSightsById(readUser.getId());
    }

    public List<Sight> getSightsAll() {
        return sightsMapper.getSightsAll();
    }

    public Integer getAllNumber() {
        return sightsMapper.getAllNumber();
    }

    public List<IndexSightsType> getSightsTypeAll() {
        return sightsMapper.getSightsTypeAll();
    }

    public IndexSightsType getSightsTypeOne(Integer id) {
        return sightsMapper.getSightsTypeOne(id);
    }

    public List<Sight> getSightsAllByType(Integer id) {
        return sightsMapper.getSightsAllByType(id);
    }


    public Integer insertSight(Sight sight) {
        return sightsMapper.insertSight(sight);
    }

    public Integer updateSight(Sight sight) {
        return sightsMapper.updateSight(sight);
    }

    public Integer deleteSight(Integer id) {
        return sightsMapper.deleteSight(id);
    }

    public Integer countTypeSight(Integer pageInfo) {
        return sightsMapper.countTypeSight(pageInfo);
    }

    public List<Sight> getSightsAllByTypeTwo(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return sightsMapper.getSightsAllByTypeTwo(pageInfo);
    }

    public List<Sight> getSightsAllByUser(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return sightsMapper.getSightsAllByUser(pageInfo);
    }

    public Integer countTypeSightByUser(Integer u_id) {
        return sightsMapper.countTypeSightByUser(u_id);
    }

    public Integer insertComment(Comment comment) {

        comment.setTime(TimeUtils.setTime());
        return sightsMapper.insertComment(comment);
    }

    public List<Comment> getCommentAll(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return sightsMapper.getCommentAll(pageInfo);
    }

    public Integer commentCunt(Integer id) {
        return sightsMapper.commentCunt(id);
    }

    public List<Sight> top3() {
        List<Sight> list = sightsMapper.getSightsAll();
        HeapSortUtils.heapSort(list);
        for (Sight s : list) {
            System.out.println(s.getName() + s.getClick().toString());
        }


        List<String> ls = new ArrayList<>();
        ls.add(list.get(0).getImage());
        return list;
    }

    public List<Sight> Beast(Integer u_id) {

        List<Integer> u = sightsMapper.getU_id();
        List<Integer> p = sightsMapper.getP_id();

//        int u_id = 6;
//        List<Integer> u = new ArrayList<>();
//        List<Integer> p = new ArrayList<>();
//        List<Integer> v = new ArrayList<>();
        System.out.println(u.indexOf(u_id));
        ;

        double[][] simMatrix = new double[u.size()][p.size()];

        for (int i = 0; i < simMatrix.length; i++) {
            List<Integer> v = sightsMapper.getValue(u.get(i));
            System.out.println(v);
            System.out.println(v.isEmpty());
            int t = 0;
            for (int j = 0; j < simMatrix[i].length; j++) {
                if (v.size() - 1 >= t && !v.isEmpty()) {
                    if (v.get(t) == p.get(j)) {
                        simMatrix[i][j] = 1;
                        t++;
                    } else simMatrix[i][j] = 0;
                } else simMatrix[i][j] = 0;
            }
        }
//        for (int i = 0; i < p.size(); i++) {
//            double v1 = 0;
//            System.out.println("");
//            for (int j = 0; j < u.size(); j++) {
//                System.out.print(simMatrix[j][i] + " ");
//            }
//
//        }

        for (int i = 0; i < u.size(); i++) {
            double v1 = 0;
            System.out.println("");
            for (int j = 0; j < p.size(); j++) {
                System.out.print(simMatrix[i][j] + " ");
            }

        }

        List<Sight> sightList = new ArrayList<>();
        List<Double> doubles = null;
        List<Integer> integerList = null;
        List<Integer> addList = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int k = 0; k < p.size(); k++) {
            doubles = new ArrayList<>();
            integerList = new ArrayList<>();
            for (int i = 0; i < p.size(); i++) {
                double v1 = 0;
                double v2 = 0;
                double v3 = 0;
                System.out.println("");
                for (int j = 0; j < u.size(); j++) {
                    v1 += (simMatrix[j][i] * simMatrix[j][k]);
                    v2 += (simMatrix[j][k]) * (simMatrix[j][k]);
                    v3 += (simMatrix[j][i]) * (simMatrix[j][i]);
                }
                v1 = v1 / (Math.sqrt(v2) * Math.sqrt(v3));

                doubles.add(v1);
            }

            for (int i = 0; i < doubles.size(); i++) {
                if (doubles.get(i) > 0.7) {
                    integerList.add(p.get(i));
                }
            }


            map.put(k, integerList);

        }
        int result = 0;
        System.out.println(map.toString());
        for (int j = 0; j < p.size(); j++) {
            double simMatrix1 = simMatrix[u.indexOf(u_id)][j];
//            System.out.println(simMatrix1);
            if (simMatrix1 == 0) {
                List<Integer> integers = map.get(j);
                System.out.println(integers);
                for (Integer l : integers) {
                    System.out.println(l);
                    if (sightsMapper.notRead(l, u_id) == null && addList.indexOf(l) == -1 && result < 3) {
                        addList.add(l);
                        sightList.add(sightsMapper.getSightsById(l));
                        result++;
                    }
                }
            }
        }

        if (sightList.isEmpty()) {
            sightList = sightsMapper.TOP3();
        }
        return sightList;
    }

    public List<Sight> getMore(PageInfo pageInfo) {
        pageInfo.setStart((pageInfo.getStart() - 1) * pageInfo.getPageSize());
        return sightsMapper.getMore(pageInfo);
    }

    public Integer getCount() {
        return sightsMapper.getCount();
    }
}
