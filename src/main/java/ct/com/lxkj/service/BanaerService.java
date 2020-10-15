package ct.com.lxkj.service;

import ct.com.lxkj.entitys.ShowPic;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BanaerService {
    public void addFile(ShowPic showPic);
    public List<ShowPic> getFile();
    public String fileUpload(MultipartFile multipartFile);                    //轮播图接口
    public void delFile(@RequestBody Integer pic_id);         //根据轮播图片id删除轮播图
}
