package ct.com.lxkj.service;

import ct.com.lxkj.Vo.FileVo;
import ct.com.lxkj.entitys.News;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface NewsService {

    public List<News> getAllNews();//用于显示所有新闻列表
    public boolean delNewByNewId(@RequestBody Integer new_id);//删除新闻
    public News getNewByNewId(@RequestBody Integer new_id);//查看新闻
    public void addNew(@RequestBody News news);                         //发布新的新闻
    public void updateNewByNewId(@RequestBody News news);               //修改新闻
    public String upload(FileVo fileVo);                      //上传文件的接口
//    public String fileUpload(FileVo showPicVo); //轮播图接口
//    public void addFile(ShowPic showPic);                   //保存轮播图片路径
//    public List<ShowPic> getFile();                         //获取图片路径用于轮播

}
