//package com.kute.appletmanage.datastruct.service;
//
//import com.kute.appletcore.dao.SysDataStructAttributeMapper;
//import com.kute.appletcore.dao.SysDataStructDefineMapper;
//import com.kute.appletcore.dao.SysDataStructNodeAttributeMapper;
//import com.kute.appletcore.dao.SysDataStructNodeMapper;
//import com.kute.appletcore.entity.SysDataStructAttribute;
//import com.kute.appletcore.entity.SysDataStructDefine;
//import com.kute.appletcore.entity.SysDataStructNode;
//import com.kute.appletcore.entity.SysDataStructNodeAttribute;
//import com.kute.appletcore.util.JsonUtil;
//import com.kute.appletcore.util.tree.TreeNode;
//import com.kute.appletcore.util.tree.TreeNodeData;
//import com.kute.appletcore.vo.SysDataStructAttributeVO;
//import com.kute.appletcore.vo.SysDataStructDefineVO;
//import com.kute.appletcore.vo.SysDataStructNodeAttributeVO;
//import com.kute.appletmanage.datastruct.dao.DataStructMapper;
//import com.kute.appletmanage.datastruct.impl.DataStructService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Name: 数据结构
// * @Description: 数据结构
// */
//@Service
//public class DataStructServiceImpl implements DataStructService {
//
//    @Autowired
//    private DataStructMapper dataStructMapper;
//
//    @Autowired
//    private SysDataStructDefineMapper sysDataStructDefineMapper;
//
//    @Autowired
//    private SysDataStructAttributeMapper sysDataStructAttributeMapper;
//
//    @Autowired
//    private SysDataStructNodeMapper sysDataStructNodeMapper;
//
//    @Autowired
//    private SysDataStructNodeAttributeMapper sysDataStructNodeAttributeMapper;
//
//
//    /**
//     * 获取数据结构定义列表
//     */
//    public List<SysDataStructDefineVO> getDataStructDefineList() throws Exception {
//        return dataStructMapper.getDataStructDefineList();
//    }
//
//    /**
//     * 获取数据结构定义信息
//     *
//     * @param structCode 数据结构编码
//     */
//    public SysDataStructDefine getDataStructDefineInfo(String structCode) throws Exception {
//        return sysDataStructDefineMapper.selectByPrimaryKey(structCode);
//    }
//
//    /**
//     * 获取数据结构属性列表
//     */
//    public List<SysDataStructAttributeVO> getDataStructAttributeList(String structCode) throws Exception {
//        return dataStructMapper.getDataStructAttributeList(structCode);
//    }
//
//    /**
//     * 获取数据结构属性信息
//     */
//    public SysDataStructAttributeVO getDataStructAttributeInfo(String structCode, String attributeCode)
//            throws Exception {
//        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("structCode", structCode);
//        parameterMap.put("attributeCode", attributeCode);
//        return dataStructMapper.getDataStructAttributeInfo(parameterMap);
//    }
//
//    /**
//     * 新建数据结构定义
//     */
//    @Transactional
//    public void addDataStructDefine(SysDataStructDefine dsd) throws Exception {
//        sysDataStructDefineMapper.insert(dsd);
//    }
//
//    /**
//     * 编辑数据结构定义
//     */
//    @Transactional
//    public void editDataStructDefine(SysDataStructDefine dsd) throws Exception {
//        sysDataStructDefineMapper.updateByPrimaryKey(dsd);
//    }
//
//    /**
//     * 删除数据结构定义
//     */
//    @Transactional
//    public void removeDataStructDefine(String structCode) throws Exception {
//        // 1.删除当前数据结构的数据节点扩展属性列表
//        dataStructMapper.removeDataStructNodeAttributeListByStructCode(structCode);
//
//        // 2.删除当前数据结构的数据节点列表
//        dataStructMapper.removeDataStructNodeList(structCode);
//
//        // 3.删除当前数据结构的扩展属性列表
//        dataStructMapper.removeDataStructAttributeList(structCode);
//
//        // 4.删除数据结构定义
//        sysDataStructDefineMapper.deleteByPrimaryKey(structCode);
//    }
//
//    /**
//     * 新建数据结构属性
//     */
//    @Transactional
//    public void addDataStructAttribute(SysDataStructAttribute dsa) throws Exception {
//        sysDataStructAttributeMapper.insert(dsa);
//    }
//
//    /**
//     * 编辑数据结构属性
//     */
//    @Transactional
//    public void editDataStructAttribute(SysDataStructAttribute dsa) throws Exception {
//        sysDataStructAttributeMapper.updateByPrimaryKey(dsa);
//    }
//
//    /**
//     * 删除数据结构属性
//     */
//    @Transactional
//    public void removeDataStructAttribute(String structCode, String attributeCode) throws Exception {
//        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("structCode", structCode);
//        parameterMap.put("attributeCode", attributeCode);
//
//        // 1.删除当前数据结构节点的扩展属性列表
//        dataStructMapper.removeDataStructNodeAttributeListByAttributeCode(parameterMap);
//
//        // 2.删除当前数据结构扩展属性
//        sysDataStructAttributeMapper.deleteByPrimaryKey(attributeCode, structCode);
//    }
//
//    /**
//     * 获取数据结构节点树
//     */
//    public String getDataStructNodeTree(String structCode) throws Exception {
//        // 1.根据数据结构编码获取数据结构定义信息
//        SysDataStructDefine dsd = sysDataStructDefineMapper.selectByPrimaryKey(structCode);
//
//        // 2.根节点编码
//        String rootNodeCode = "";
//
//        if ("auto".equals(dsd.getNodeCodeRule())) {
//            // 如果编码规则是自动则将编码规则前缀作为根节点编码
//            rootNodeCode = dsd.getRulePrefix();
//        } else if ("manual".equals(dsd.getNodeCodeRule())) {
//            // 如果编码规则是手动则将根节点编码默认为ROOT
//            rootNodeCode = "ROOT";
//        }
//
//        // 3.创建根节点
//        TreeNodeData tnd = new TreeNodeData();
//        tnd.setNodeCode(rootNodeCode);
//        tnd.setNodeName(dsd.getStructName());
//        tnd.setParentNodeCode("-1");
//
//        TreeNode rootNode = new TreeNode();
//        rootNode.setText(dsd.getStructName());
//        rootNode.setData(tnd);
//        List<TreeNodeData> subTreeList = dataStructMapper.getDataStructNodeTree(structCode);
//        // 4.递归生成子树
//        List<TreeNode> sublist = this.generateSubTree(subTreeList, rootNodeCode);
//        rootNode.setNodes(sublist);
//
//        TreeNode topNode = new TreeNode();
//        topNode.setText(dsd.getStructName());
//        List<TreeNode> tnList = new ArrayList<TreeNode>();
//        tnList.add(rootNode);
//        topNode.setNodes(tnList);
//
//        String json = JsonUtil.getJSONFromObject(topNode);
//
//        json = json.replaceAll("\"nodes\":\\[\\],", "");
//
//        return json;
//    }
//
//    /**
//     * 递归生成子树
//     */
//    public List<TreeNode> generateSubTree(List<TreeNodeData> list, String parentNode) throws Exception {
//        List<TreeNode> subNodeList = new ArrayList<TreeNode>();
//        for (TreeNodeData menu : list) {
//            TreeNode subNode = new TreeNode();
//            subNode.setText(menu.getNodeName());
//            subNode.setData(menu.getTreeNodeData());
//            String menuId = menu.getNodeCode();
//            String parentCode = menu.getParentNodeCode();
//            if (parentNode.equals(parentCode) ) {
//                List<TreeNode> menuLists = generateSubTree(list, menuId);
//                subNode.setNodes(menuLists);
//                subNodeList.add(subNode);
//            }
//        }
//
//        return subNodeList;
//    }
//
//    /**
//     * 获取数据结构节点信息
//     */
//    public SysDataStructNode getDataStructNodeInfo(String structCode, String nodeCode) throws Exception {
//        return sysDataStructNodeMapper.selectByPrimaryKey(nodeCode, structCode);
//    }
//
//    /**
//     * 新建数据结构节点
//     */
//    @Transactional
//    public void addDataStructNode(SysDataStructNode dsn) throws Exception {
//        String structCode = dsn.getStructCode();
//
//        SysDataStructDefine dsd = sysDataStructDefineMapper.selectByPrimaryKey(structCode);
//
//        String nodeCode = "";
//        if ("auto".equals(dsd.getNodeCodeRule())) {
//            Map<String, Object> parameterMap = new HashMap<>();
//            parameterMap.put("structCode", structCode);
//            parameterMap.put("parentCode", dsn.getParentNodeCode());
//            parameterMap.put("length", String.valueOf(dsd.getRuleLength()));
//
//            nodeCode = dsn.getParentNodeCode() + dataStructMapper.getDataStructNodeCode(parameterMap);
//        } else if ("manual".equals(dsd.getNodeCodeRule())) {
//            nodeCode = dsn.getNodeCode();
//        }
//
//        dsn.setNodeCode(nodeCode);
//
//        sysDataStructNodeMapper.insert(dsn);
//    }
//
//    /**
//     * 编辑数据结构节点
//     */
//    @Transactional
//    public void editDataStructNode(SysDataStructNode dsn) throws Exception {
//        sysDataStructNodeMapper.updateByPrimaryKey(dsn);
//    }
//
//    /**
//     * 删除数据结构节点
//     *
//     * @param structCode 数据结构编码
//     * @param nodeCode   数据节点编码
//     */
//    @Transactional
//    public void removeDataStructNode(String structCode, String nodeCode) throws Exception {
//        // 1.删除当前数据结构节点的扩展属性列表
//        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("structCode", structCode);
//        parameterMap.put("nodeCode", nodeCode);
//        dataStructMapper.removeDataStructNodeAttributeListByNodeCode(parameterMap);
//
//        // 2.删除当前数据结构节点
//        sysDataStructNodeMapper.deleteByPrimaryKey(nodeCode, structCode);
//
//        // 3.递归删除当前数据结构节点的子节点
//        removeSubDataStructNode(structCode, nodeCode);
//    }
//
//    /**
//     * 递归删除当前数据结构节点的子节点
//     *
//     * @param structCode 数据结构编码
//     * @param nodeCode   数据节点编码
//     */
//    private void removeSubDataStructNode(String structCode, String nodeCode) throws Exception {
//        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("structCode", structCode);
//        parameterMap.put("parentCode", nodeCode);
//
//        List<TreeNodeData> subTreeList = dataStructMapper.getDataStructNodeTreeByParent(parameterMap);
//        for (TreeNodeData vo : subTreeList) {
//            // 1.删除当前数据结构节点的扩展属性列表
//            Map<String, Object> subParameterMap = new HashMap<>();
//            subParameterMap.put("structCode", structCode);
//            subParameterMap.put("nodeCode", nodeCode);
//            dataStructMapper.removeDataStructNodeAttributeListByNodeCode(subParameterMap);
//
//            // 2.删除当前数据结构节点
//            sysDataStructNodeMapper.deleteByPrimaryKey(nodeCode, structCode);
//
//            removeSubDataStructNode(structCode, vo.getNodeCode());
//        }
//    }
//
//    /**
//     * 获取数据结构节点属性列表
//     *
//     * @param structCode 数据结构编码
//     * @param nodeCode   数据节点编码
//     */
//    public List<SysDataStructNodeAttributeVO> getDataStructNodeAttributeList(String structCode, String nodeCode)
//            throws Exception {
//        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("structCode", structCode);
//        parameterMap.put("parentCode", nodeCode);
//        return dataStructMapper.getDataStructNodeAttributeList(parameterMap);
//    }
//
//    /**
//     * 保存数据结构节点属性
//     */
//    @Transactional
//    public void saveDataStructNodeAttributes(List<SysDataStructNodeAttribute> dsnaList) throws Exception {
//        for (SysDataStructNodeAttribute dsnaQuery : dsnaList) {
//            SysDataStructNodeAttribute dsnaEntity = sysDataStructNodeAttributeMapper.selectByPrimaryKey(
//                    dsnaQuery.getStructCode(), dsnaQuery.getNodeCode(), dsnaQuery.getAttributeCode());
//            if (dsnaEntity != null) {
//                sysDataStructNodeAttributeMapper.updateByPrimaryKey(dsnaQuery);
//            } else {
//                sysDataStructNodeAttributeMapper.insert(dsnaQuery);
//            }
//        }
//    }
//
//    public List<SysDataStructNode> getDataStructNodeList() throws Exception {
//        return sysDataStructNodeMapper.selectAll();
//    }
//}
