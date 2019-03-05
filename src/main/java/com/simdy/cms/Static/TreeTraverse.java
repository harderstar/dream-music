package com.simdy.cms.Static;

import com.simdy.cms.entity.base.TreeTypeEnt;
import com.simdy.cms.entity.tree.TreeEnt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeTraverse<T extends TreeTypeEnt> {

    public TreeEnt<T> getTreeEnts(List<T> ts){

        Set<Integer> parents = new HashSet<>();
        List<TreeEnt<T>> parentsL = new ArrayList<>();
        TreeEnt<T> result = null;
        parents.add(0);

        while (ts.size() != 0){

            for (TreeTypeEnt t:ts) {
                System.out.println(parents);
                if(parents.contains(t.getParentId())){
                    ts.remove(t);
                    System.out.println(t);
                    TreeEnt<T> treeEnt = new TreeEnt<>();
                    treeEnt.setValue(t.getValue());
                    treeEnt.setId(t.getId());
                    if(t.getParentId() == 0) result = treeEnt;
                    if(t.getIsParent() == 1){
                        treeEnt.setChildren(new ArrayList<>());
                    }
                    for (TreeEnt<T> t2:parentsL) {
                        if(t2.getId() == t.getParentId()) {
                            t2.getChildren().add(treeEnt);
                            break;
                        }
                    }
                    parentsL.add(treeEnt);
                    parents.add(t.getId());
                    break;
                }

            }

        }
        return result;
    }

}
