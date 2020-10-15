package ct.com.lxkj.dao;

import ct.com.lxkj.entitys.ShowPic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BanaerDao {
    public void delFile(Integer pic_id);
    public void addFile(ShowPic showPic);
    public List<ShowPic> getFile();
}
