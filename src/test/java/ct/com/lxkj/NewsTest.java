package ct.com.lxkj;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ct.com.lxkj.dao.BanaerDao;
import ct.com.lxkj.dao.NewsDao;
import ct.com.lxkj.entitys.ShowPic;
import ct.com.lxkj.service.NewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsTest {
    @Autowired
    NewsDao newsDao;
    @Autowired
    BanaerDao banaerDao;
//    @Test
//   public void update(){
//        News news=new News(19,"成都区块链","成都链向科技",new Date(),"images/2.jpg");
//        newsDao.updateNewByNewId(news);
//    }
//    @Test
//    public void add(){
//        News news=new News(25,"成都区块链","成都链向科技",new Date(),"images/2.jpg",);
//        newsDao.addNew(news);
//    }
    @Test
    public void addFile(){
        ShowPic showPic=new ShowPic(3,"images/3.jpg");
        banaerDao.addFile(showPic);
    }

    @Autowired
    NewsService newsService;

    @Test
    public void name() {
        PageHelper.startPage(11, 3);
        PageInfo pageInfo = new PageInfo(newsService.getAllNews());

    }
}
