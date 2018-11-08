package com.guohaoshiye.uniqueIdentifier.distribution;

import com.guohaoshiye.uniqueIdentifier.identifier.Identifier;

import java.util.*;

/*******************************************************************************
 * Copyright (C), 2018-2018,github:Swagger-Ranger 
 * FileName: IdentifierGraph
 * Author:   liufei32@outlook.com
 * Date:     2018/11/6 15:53
 * Description: 标识码生成图
 * Aha-eureka:
 *******************************************************************************/

public class IdentifierGraph {
    private static final String NEWLINE = System.getProperty("line.separator");//设置换行符
    private Identifier identifier;

    //传入的用户对象集合(以唯一的用户码baseCode为键,标识码节点对象为值)
    private HashMap<String, IdentifierNode> NodesHashMap = new HashMap<>();
    //每个ID用户对应的下级
//    private Map<IdentifierNode, TreeSet> nextSet;

    //上级连接
    private TreeSet<String> adj;

//    private List<IdentifierNode> IdentifierList;


    /**
     * 这里使用了一个内部类标识码节点对象来存储向上回溯的链表
     * */
    private class IdentifierNode {

        //每个用户节点只能有一个上级但可以有多个下级
        String ID;                  //用户标识码
        IdentifierNode pre;                 //上一级
        TreeSet<IdentifierNode> nextNodes;    //下一级
        IdentifierNode(String IdCode) {

            int i = identifier.getBusinessLength() + identifier.getBaseLength();
            String PreCode = IdCode.substring(i, identifier.getBaseLength() + i);
            String BaseCode = IdCode.substring(identifier.getBusinessLength(), i);
            this.ID = IdCode;

            //这里如果存在必定能找到上一个节点,因为上一个节点会先于下一个节点存储(因为生成标识码时会先生成小的,同时构造函数在添加标识码时会先排序
            if (NodesHashMap.containsKey(PreCode)) {
                this.pre = NodesHashMap.get(PreCode);   //这里将节点链接存储以实现链表
                this.pre.nextNodes.add(this);           //将节点添加到其上个节点的下一级集合中
            }
            NodesHashMap.put(BaseCode, this);

            //这里需要检查输入的字符串是否符合identifier格式，如果不符合，输出到错误到日志


        }

        //是否有上一级
        boolean havePreNode() {
            return pre == null;
        }
    }


    /**
     * 需要传入一个哈希集来生成标识码的图
     * 这里需要对传入的字符串作排序,使用实现的字符集作为自定义比较器
     */
    public IdentifierGraph(Identifier identifier, Set<String> IDsets) {
        this.identifier = identifier;

        class IDComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                int[] Oo1 = identifier.alphabet.toIndices(o1);
                int[] Oo2 = identifier.alphabet.toIndices(o2);
                int compareLength = identifier.getBaseLength() + identifier.getBusinessLength();
                if (Oo1.length != Oo2.length || Oo1.length != identifier.getLengthOfID()) {
                    throw new IllegalArgumentException("there is a format error in identifiers: " + o1 + " and " + o2);
                }
                for (int i = 0; i < compareLength; i++) {
                    if (Oo1[i] < Oo2[i]) {
                        return -1;
                    } else if (Oo1[i] > Oo2[i]) {
                        return 1;
                    }
                }

                return 0;
            }
        }

        TreeSet<String> IDSortedSets = new TreeSet<>(new IDComparator());

        //将传入的ID按IDComparator排序放入IDSortedSets
        for (String IDs : IDsets) IDSortedSets.add(IDs);

        //将每个标识码生成写入图中
        for (String IDs : IDSortedSets) new IdentifierNode(IDs);
    }

    /**
     * 输入一个标识码来生成一个新的节点并增加到图中，在对应的上个节点中的map表中的值bag中增加下级节点，并添加上级连接
     */
    public void add(String IdCode) {

        //这里需要先做检查
        identifier.checkIdentifier(IdCode);
        //添加节点
        new IdentifierNode(IdCode);
    }

    /**
     * 获取每个节点的下一级集合
     */
    public Set<String> getNexts(String ID) {

        identifier.checkIdentifier(ID);
        Set<String> IDs = new HashSet<>();

        int i = identifier.getBusinessLength() + identifier.getBaseLength();
        String IDCode = ID.substring(identifier.getBusinessLength(), i);
        IdentifierNode node = NodesHashMap.get(IDCode);
        Set<IdentifierNode> nexts = node.nextNodes;
        for (IdentifierNode nodes : nexts) {
            IDs.add(nodes.ID);
        }
        return IDs;
    }

    /**
     * 获取每个节点的下一级数量
     */
    public int getNextCount(String ID) {
        return getNexts(ID).size();
    }


    /**
     * 获取每个节点的所有上一级集合
     */
    public LinkedList<String> getPreNodes(String ID) {
        identifier.checkIdentifier(ID);
        int i = identifier.getBusinessLength() + identifier.getBaseLength();
        String IDCode = ID.substring(identifier.getBusinessLength(), i);
        IdentifierNode node = NodesHashMap.get(IDCode);
        LinkedList preNodesList = new LinkedList<String>();

        //遍历所有的上一级
        while (node.havePreNode()) {
            preNodesList.add(node.ID);
            node = node.pre;
        }
        return preNodesList;
    }

    /**
     * 获取两个节点之间的上下级链接
     */
    public LinkedList<String> getInterNodesID(String pre, String next) {
        LinkedList<String> preNodesList = null;
        LinkedList<String> interNodesList = null;

        //先比较节点
        int[] Oo1 = identifier.alphabet.toIndices(pre);
        int[] Oo2 = identifier.alphabet.toIndices(next);
        int compareLength = identifier.getBaseLength() + identifier.getBusinessLength();
        if (Oo1.length != Oo2.length || Oo1.length != identifier.getLengthOfID()) {
            throw new IllegalArgumentException("there is a format error in identifiers: " + pre + " and " + next);
        }
        //比较两个节点,求出比较大即靠后的元素,然后使用后面的元素向上查找出所有的上级链表
        for (int i = 0; i < compareLength; i++) {
            if (Oo1[i] < Oo2[i]) {
                preNodesList = getPreNodes(next);
            } else if (Oo1[i] > Oo2[i]) {
                preNodesList = getPreNodes(pre);
            }
        }

        String IDpre = pre.substring(identifier.getBusinessLength(), compareLength);
        String IDnext = next.substring(identifier.getBusinessLength(), compareLength);

        //获取两个节点之间的上下级链接--即当向上链表不为空,且链表中包含了并一个元素则,从头部开始移到返回链表中
        if (preNodesList != null && (preNodesList.contains(pre) || preNodesList.contains(next))) {
            String ID = preNodesList.pollFirst();
            if (ID.equals(pre) && ID.equals(next)) {
                interNodesList.add(ID);
            } else {
                interNodesList.add(ID);
                return interNodesList;

            }

        }
        return interNodesList;

    }

    /**
     * 判断两个节点是否有上下级关系,并给出上下级长度
     */
    public boolean isConnected(String pre, String next) {
        return getInterNodesID(pre, next) == null;
    }


}
