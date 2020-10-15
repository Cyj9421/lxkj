package ct.com.lxkj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ct.com.lxkj.Vo.Resp;
import ct.com.lxkj.entitys.News;
import ct.com.lxkj.service.NewsService;
import ct.com.lxkj.service.impl.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsCoontroller {  
    @Autowired
    NewsService newsService;
    @Autowired
    UploadService uploadService;
    //前台显示所有的新闻列表
    @PostMapping("/api/lxkj/getList")
    public Resp getList(@RequestBody PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<News> list = newsService.getAllNews();
            pageInfo = new PageInfo(list);
        if (pageInfo.getPageNum() < pageInfo.getTotal()) {
            Resp resp = new Resp("200", "获取新闻列表成功", pageInfo);
            return resp;
        } else {
            Resp resp = new Resp("200", "没有更多的新闻了", null);
            return resp;
        }
    }

    //后台显示所有的新闻列表
    @PostMapping("/api/lxkj/getManagerList")
    public Resp getManagerList(@RequestBody PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<News> list = newsService.getAllNews();
        pageInfo = new PageInfo(list);
        if (pageInfo.getPageNum() < pageInfo.getTotal()) {
            Resp resp = new Resp("200", "获取新闻列表成功", pageInfo);
            return resp;
        } else {
            Resp resp = new Resp("200", "没有更多的新闻了", null);
            return resp;
        }
    }
    //删除新闻
    @PostMapping("/api/lxkj/delNew")
    public Resp delNewByNewId(@RequestBody News news) {
        boolean result=newsService.delNewByNewId(news.getNew_id());
        if(result){
        Resp resp=new Resp("200","删除新闻成功",null);
        return resp;
    }else {
            Resp resp=new Resp("500","删除失败，没有这条新闻",null);
            return resp;
        }
        }
    //点击新闻，可以显示所有的新闻信息
    @PostMapping("/api/lxkj/getNew")
    public Resp getNewByNewId(@RequestBody News news) {
        news=newsService.getNewByNewId(news.getNew_id());
        Resp resp=new Resp("200","获取新闻详情成功",news);
        return resp;
    }
    //添加新闻
    @PostMapping(value = "/api/lxkj/addNew")
    public Resp addNew(@RequestBody News news){
        newsService.addNew(news);
        Resp resp=new Resp("200","添加新闻成功",null);
        return resp;
    }
    //修改已发布的新闻
    @PostMapping("/api/lxkj/updateNew")
    public Resp updateNewByNewId(@RequestBody News news){
        newsService.updateNewByNewId(news);
        Resp resp=new Resp("200","修改新闻成功",null);
        return resp;
    }
//    //上传图片
//    @PostMapping(value = "/api/lxkj/uploadPic")
//    public Resp uploadPic(@RequestParam("multipartFile") MultipartFile multipartFile){
//        String fileurl=uploadService.upload(multipartFile);
//        Resp resp=new Resp("200","上传新闻图片成功",fileurl);
//        return resp;
//    }
}
