package ct.com.lxkj.controller;

import ct.com.lxkj.Vo.Resp;
import ct.com.lxkj.entitys.ShowPic;
import ct.com.lxkj.service.BanaerService;
import ct.com.lxkj.service.impl.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
public class BanaerController {

    @Autowired
    private BanaerService banaerService;
    @Autowired
    private UploadService uploadService;
    //上传轮播图
    @PostMapping(value = "/api/lxkj/fileUpload")
    public Resp fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String fileurl=uploadService.upload(multipartFile);
        Resp resp=new Resp("200","上传轮播图成功",fileurl);
        return resp;
    }
    //增加轮播图
    @PostMapping(value = "/api/lxkj/addFile")
    public Resp<ShowPic> addFile(@RequestBody ShowPic showPic){
        banaerService.addFile(showPic);
       List<ShowPic> list=banaerService.getFile();
        Resp resp=new Resp("200","增加轮播图成功",list);
        return resp;
    }
    //删除轮播图
    @PostMapping(value = "/api/lxkj/delFile")
    public Resp delFile(@RequestBody ShowPic showPic ){
        banaerService.delFile(showPic.getPic_id());
        List<ShowPic> list=banaerService.getFile();
        Resp resp=new Resp("200","删除轮播图成功",list);
        return resp;
    }
    //轮播图列表
    @PostMapping(value = "/api/lxkj/BanaerList")
    public Resp BanaerList(){
        List<ShowPic> list=banaerService.getFile();
        Resp resp=new Resp("200","获取轮播图列表成功",list);
        return resp;
    }
    //轮播图后台管理列表
    @PostMapping(value = "/api/lxkj/BanaerManagerList")
    public Resp BanaerManagerList(){
        List<ShowPic> list=banaerService.getFile();
        Resp resp=new Resp("200","获取轮播图列表成功",list);
        return resp;
    }
}
