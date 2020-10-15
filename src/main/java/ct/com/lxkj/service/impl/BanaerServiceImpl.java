package ct.com.lxkj.service.impl;

import ct.com.lxkj.dao.BanaerDao;
import ct.com.lxkj.entitys.ShowPic;
import ct.com.lxkj.service.BanaerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class BanaerServiceImpl implements BanaerService {
    @Autowired
    private BanaerDao banaerDao;
    @Override
    public void addFile(ShowPic showPic) {
        banaerDao.addFile(showPic);
    }

    @Override
    public List<ShowPic> getFile() {
        List<ShowPic> list=banaerDao.getFile();
        return list;
    }

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @Override
    public String fileUpload(MultipartFile multipartFile) {
        System.out.println("UPLOAD_FOLDER = " + UPLOAD_FOLDER);
        UploadService upload=new UploadService();
        String show_url=upload.upload(multipartFile);
        return show_url;
    }

    @Override
    public void delFile(Integer pic_id) {
        banaerDao.delFile(pic_id);
    }
}
