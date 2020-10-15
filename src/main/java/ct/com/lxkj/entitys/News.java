package ct.com.lxkj.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    private int new_id;                 //主键自增id
    private String new_title;          //新闻标题
    private String new_content;        //新闻内容
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date  release_time;       //发布时间
    private String picurl;             //图片路径
    private String new_url;             //新闻内容路径
    private Integer new_type;           //新闻内容类型
}
