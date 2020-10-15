package ct.com.lxkj.service.impl;

import ct.com.lxkj.Vo.FileVo;
import ct.com.lxkj.dao.NewsDao;
import ct.com.lxkj.entitys.News;
import ct.com.lxkj.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;

    @Override
    public List<News> getAllNews() {
        return newsDao.getAllNews();

    }

    @Override
    public boolean delNewByNewId(Integer newId) {
        boolean result = newsDao.delNewByNewId(newId);
        return result;
    }

    @Override
    public News getNewByNewId(Integer newId) {
        return newsDao.getNewByNewId(newId);
    }

    @Override
    public void addNew(News news) {
        news.setRelease_time(new Date());
        newsDao.addNew(news);
    }

    @Override
    public void updateNewByNewId(News news) {
        news.setRelease_time(new Date());
        newsDao.updateNewByNewId(news);
    }

    @Override
    public String upload(FileVo fileVo) {
        UploadService upload = new UploadService();
        String picurl = upload.upload(fileVo.getMultipartFile());
        return picurl;
    }

}
