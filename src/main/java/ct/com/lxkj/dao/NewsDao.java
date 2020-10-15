package ct.com.lxkj.dao;

import ct.com.lxkj.entitys.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsDao {
    public List<News> getAllNews();
    public boolean delNewByNewId(Integer new_id);
    public News getNewByNewId(Integer new_id);
    public void addNew(News news);
    public void updateNewByNewId(News news);

}
