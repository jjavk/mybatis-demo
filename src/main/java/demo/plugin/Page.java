package demo.plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By jiabin on 18-5-9.
 */
public class Page<T> {
    //查询总条数
    private long count = 0;
    //当前第几页
    private int curPage = 1;
    //每页多少条
    private int pageSize = 10;
    //当前页列表
    private List<T> queryList;
    //总页数
    private int pageCount = 0;
    //是否需要计算总条数，默认计算
    private boolean executeCount = true;
    //结果页跳转ID
    private String target = "";
    //其他的参数
    private Map<String, Object> params = new HashMap<String, Object>();


    public long getCount() {
        return count;
    }
    public void setCount(long count) {
        this.count = count;
        int pageCount = (int) (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
        this.setPageCount(pageCount);
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public List<T> getQueryList() {
        return queryList;
    }
    public void setQueryList(List<T> queryList) {
        this.queryList = queryList;
    }
    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public Map<String, Object> getParams() {
        return params;
    }
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
    public boolean getExecuteCount() {
        return executeCount;
    }
    public void setExecuteCount(boolean executeCount) {
        this.executeCount = executeCount;
    }
    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Page [count=" + count + ", curPage=" + curPage + ", pageSize="
                + pageSize  + ", pageCount=" + pageCount + ", params=" + params + ", queryList=" + queryList + "]";
    }
}
