import com.cheer.mybatis.dao.BlogMapper;
import com.cheer.mybatis.model.Blog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BlogTest extends AbstractMapperTest {
    private static final Logger LOGGER =  LogManager.getLogger(BlogTest.class);
    @Test
    public void getgblog(){
        Blog blog=blogMapper.getBlog(1);
        LOGGER.debug(blog);

    }
    @Test
    public void insert(){
      Blog blog=new Blog();
      blog.setId(1);
      blog.setTitle("震惊！阿光最喜欢吃的居然不是屎");
      blog.setAuthor("斯巴拉吸报社");
      blogMapper.insert(blog);
    }

    @Test
    public void delete(){
        blogMapper.delete(1);
    }

    @Test
    public void update(){
        Blog blog=blogMapper.getBlog(2);
        blog.setTitle("虚惊一场~~阿光还是很喜欢吃**的");
        blogMapper.update(blog);
    }

    @Test
    public void getall(){
        List<Blog> blogList=new ArrayList<>();
        blogList=blogMapper.getall();
        LOGGER.debug(blogList);
    }

    @Test
    public void getpage(){
        PageHelper.startPage(2,2);
        List<Blog> blogList=blogMapper.getall();
        PageInfo pageInfo=new PageInfo(blogList);
        Assert.assertEquals(2,blogList.size());
        for (Blog blog:blogList) {
            System.out.println(blog);
        }
    }
    @Test
    public void getmaplist(){
        List<Map<String,Object>> mapList= blogMapper.getmaplist();
        Assert.assertEquals(4,mapList.size());
      /*  for (Map<String,Object> map:mapList) {
            for (Map.Entry<String,Object> entry:map.entrySet()) {
                System.out.printf("key=%s,values=%s\n",entry.getKey(),entry.getValue());
            }
        }*/
      LOGGER.debug(mapList);
        System.out.println(new Gson().toJson(mapList));
    }
    @Test
    public void insertlist(){
        Blog b1=new Blog(5,"阿光脱肛了","斯巴拉吸报社");
        Blog b2=new Blog(6,"阿光脱肛好了","斯巴拉吸报社");
        Blog b3=new Blog(7,"阿光又脱肛了","斯巴拉吸报社");
        List<Blog> blogList=new ArrayList<>();
        blogList.add(b1);
        blogList.add(b2);
        blogList.add(b3);

        blogMapper.insertlist(blogList);

    }
}
