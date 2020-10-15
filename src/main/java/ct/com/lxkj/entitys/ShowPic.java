package ct.com.lxkj.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowPic {
    private Integer pic_id; //上传的图片的id
    private String show_url;//上传图片的路径
}
