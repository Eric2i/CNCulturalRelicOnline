package com.ruoyi;

import com.ruoyi.system.domain.Area;
import com.ruoyi.system.domain.Category;
import com.ruoyi.system.domain.Equipment;
import com.ruoyi.system.domain.Product;
import com.ruoyi.system.service.IAreaService;
import com.ruoyi.system.service.ICategoryService;
import com.ruoyi.system.service.IEquipmentService;
import com.ruoyi.system.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;

@SpringBootTest
public class AppTest {
    @Resource
    ICategoryService categoryService;
    @Resource
    IAreaService areaService;
    @Resource
    IEquipmentService equipmentService;
    @Resource
    IProductService productService;

    @Test
    public void insCategories(){
        File dir = new File("D:\\ruoyi\\uploadPath\\upload\\运动场\\运动场馆");
        File[] dirs = dir.listFiles();
        for (File cDir : dirs) {
            String categoryName = cDir.getName();
            Category category = new Category();
            category.setCategoryName(categoryName);
            System.out.println(categoryService.save(category));
            File[] files = cDir.listFiles();
            for (File file : files) {
                String fileName = file.getName();
                Area area = new Area();
                String name = file.getName().split("\\.")[0];
                area.setName(name);
                String intro = "这是一个" + categoryName + fileName + "的项目" ;
//                http://localhost:8080/profile/upload/shop/%E9%A5%BC%E5%B9%B2/%E7%99%BE%E9%86%87.jpg
                String img = "http://localhost:8080/profile/upload/运动场/运动场馆/" + categoryName + "/" + file.getName();
                area.setDetail("<p><h3>"+intro+"</h3></p><p><img src=\"" + img + "\" title=\"\"/></p>");
                area.setCover(img);
                area.setPrice((double) getNum(30,80));
                area.setTel("13184578954");
                area.setCategoryId(category.getId());
                System.out.println(areaService.save(area));
            }
        }
        insCategories2();
        insCategories3();
    }
    public void insCategories2(){
        String p = "运动场/器材";
        File dir = new File("D:\\ruoyi\\uploadPath\\upload\\"+p);
        File[] dirs = dir.listFiles();
        for (File cDir : dirs) {
            String categoryName = cDir.getName();
//            Category category = new Category();
//            category.setCategoryName(categoryName);
//            System.out.println(categoryService.save(category));
            File[] files = cDir.listFiles();
            for (File file : files) {
                String fileName = file.getName();
                Equipment equipment = new Equipment();
                String name = file.getName().split("\\.")[0];
                equipment.setName(name);
                String intro = "这是一个" + categoryName + fileName + "的项目" ;
//                http://localhost:8080/profile/upload/shop/%E9%A5%BC%E5%B9%B2/%E7%99%BE%E9%86%87.jpg
                String img = "http://localhost:8080/profile/upload/"+p+"/" + categoryName + "/" + file.getName();
                equipment.setDetail("<p><h3>"+intro+"</h3></p><p><img src=\"" + img + "\" title=\"\"/></p>");
                equipment.setCover(img);
                equipment.setPrice((double) getNum(30,80));
                equipment.setCategoryId(categoryService.getOneBy(new Category().setCategoryName(categoryName)).getId());
                System.out.println(equipmentService.save(equipment));
            }
        }
    }
    public void insCategories3(){
        String p = "运动场/饮料+面包";
        File dir = new File("D:\\ruoyi\\uploadPath\\upload\\"+p);
        File[] files = dir.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            Product product = new Product();
            String name = file.getName().split("\\.")[0];
            product.setName(name);
            String intro = "这是一个" + fileName + "的商品" ;
//                http://localhost:8080/profile/upload/shop/%E9%A5%BC%E5%B9%B2/%E7%99%BE%E9%86%87.jpg
            String img = "http://localhost:8080/profile/upload/"+p+"/"+ file.getName();
            product.setIntro(intro);
            product.setCover(img);
            product.setPrice((double) getNum(6,80));
            System.out.println(productService.save(product));
        }
    }
    //生成[start,end]随机数
    public int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

}
