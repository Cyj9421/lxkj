$(function() {

    $.post({
        url:'/api/lxkj/getList',
        success: function (data) {
            for(var i = 0; i < data.length; i++) {
                var text = "<tr>\n" +
                    "                    <td>"+data[i].new_title+"</td>\n" +
                    "                    <td>"+data[i].new_content+"</td>\n" +
                    "                    <td>"+data[i].release_time+"</td>\n" +
                     "                   <td><img width='100px' height='40px' src="+data[i].picurl+"></td>\n" +
                    "                    <td>\n" +
                    "                        <a href=\"/api/lxkj/delNew?new_id="+data[i].new_id+"\"  class=\"btn btn-danger\">删除</a>\n" +
                    "                        <a href=\"update.html?new_id="+data[i].new_id+"\" class=\"btn btn-success\">修改</a>\n" +
                    "                    </td>\n" +
                    "                </tr>"
                var obj = $(".pool");
                obj.append(text);
            }

        }
    });

});