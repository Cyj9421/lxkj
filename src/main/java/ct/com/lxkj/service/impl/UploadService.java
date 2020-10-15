package ct.com.lxkj.service.impl;

import ct.com.lxkj.Vo.Resp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UploadService {

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    public String upload(MultipartFile multipartFile){
        String OriginalFilename=multipartFile.getOriginalFilename();//获取原始文件名
//        String filePath = Upload.class.getResource("/").getPath()+"images/";
        File dest=new File(UPLOAD_FOLDER+OriginalFilename);
        if (!dest.getParentFile().exists())
            dest.getParentFile().mkdirs();
        try {
            multipartFile.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            Resp.error("505","上传失败",OriginalFilename);
        }
        return "img/"+OriginalFilename;
    }


}
