package com.cssl.controller;


import com.cssl.pojo.Sp_index_pictures;
import com.cssl.pojo.Sp_product;
import com.cssl.pojo.Sp_product_category;
import com.cssl.pojo.Sp_user;
import com.cssl.service.Sp_index_picturesService;
import com.cssl.service.Sp_product_categoryService;
import com.cssl.service.Sp_userService;
import com.cssl.util.SendCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Sp_userController {
    @Autowired
    private Sp_userService sp_userService;
    @Autowired
    private Sp_index_picturesService sp_index_picturesService;
    @Autowired
    private Sp_product_categoryService sp_product_categoryService;
    //发送给注册用户的验证码创建全局变量接收
    int getcode=0;
    /*
    登录
     */
     /*
    登录
     */
    @RequestMapping("Login")
    public String Login(Sp_user users,Model model,HttpSession session){
        boolean flag=false;
        //判断用户名是否为空
        if(sp_userService.Login(users)!=null){
            flag=true;

        }//判断手机号是否为空
        else if(sp_userService.Login1(users)!=null){
            flag=true;

        }//判断电子邮箱是否为空
        else if(sp_userService.Login2(users)!=null){
            flag=true;
        }

        if(flag){
            //如果该用户不是管理员，则进入首页index.html
            if(users.getSu_isadmin()!=1){
                session.setAttribute("users",users);
                return LoadIndex(model);
            }else{
                //该用户为管理员
                System.out.println("管理员进入后台页面");
                return "register.html";
            }

        }else{
            //如果该用户为空，则跳回登录页面
            return "login.html";
        }

    }

    @RequestMapping(path="/Register",method = RequestMethod.GET)
    public String Register(){
        return "Register.html";
    }

    //判断用户是否存在
    @ResponseBody
    @RequestMapping("/Su_account")
    public boolean Su_account(String su_account){
        if(sp_userService.Is_Exists_User(su_account)) {
            return false;
        }
        return true;
    }
    //注册
    @RequestMapping(path = "/Register",method = RequestMethod.POST)
    public String Register(Sp_user user,
                           @RequestParam int phoneCode,
                           HttpSession session,
                           Model model){
        System.out.println(getcode+"验证码");
        if(getcode!=phoneCode){
            session.setAttribute("codemess","验证码输入错误");
            model.addAttribute("user",user);
            return "register.html";
        }else{
            System.out.println(user.getSu_id()+user.getSu_account()+"进入注册");
            if(sp_userService.Register(user)){
                //失败
                return "index.html";
            }else {
                //注册成功直接访问主页面
                //成功
                session.setAttribute("user",user);
                return LoadIndex(model);
            }
        }

    }
    /*
    商品--首页
     */
    //特别推荐：每次随机挑选四个商品
    @RequestMapping("/Special_Recommendation")
    public void Special_Recommendation(Model model){
        model.addAttribute("special",sp_userService.Special_Recommendation());
//        System.out.println(sp_userService.Special_Recommendation().size());
    }
    //商品热门：根据销量
    @RequestMapping("/Commodity_Hot")
    public void Commodity_Hot(Model model){
        model.addAttribute("commodity",sp_userService.Commodity_Hot());
    }
    //新品上架：根据上架时间
    @RequestMapping("/New_Product")
    public void New_Product(Model model){
        model.addAttribute("new_product",sp_userService.New_Product());
    }



    //访问主页面
    public String LoadIndex(Model model){
        //1、特别推荐--lisisi
        Special_Recommendation(model);
        //2、热门推荐
        Commodity_Hot(model);
        //3、新品上架
        New_Product(model);


        //图片轮播部分--王婷
        List<Sp_index_pictures> picList=sp_index_picturesService.Index_pictures();
        model.addAttribute("picList",picList);
        //首页图片轮播旁边悬浮二级分类显示该分类的商品--王婷
        model.addAttribute("cateList",sp_product_categoryService.FindAllCategory());
        model.addAttribute("list1",sp_userService.selectBySpc_id(6));
        model.addAttribute("list2",sp_userService.selectBySpc_id(7));
        model.addAttribute("list3",sp_userService.selectBySpc_id(8));
        model.addAttribute("list4",sp_userService.selectBySpc_id(9));
        model.addAttribute("list5",sp_userService.selectBySpc_id(10));
        model.addAttribute("list6",sp_userService.selectBySpc_id(11));
        model.addAttribute("list7",sp_userService.selectBySpc_id(12));
        model.addAttribute("list8",sp_userService.selectBySpc_id(13));
        model.addAttribute("list9",sp_userService.selectBySpc_id(14));

        //左边商品二级分类名称
        List<Sp_product_category> spc=sp_userService.selectSpc_name(18);
        List<Sp_product_category> spc1=sp_userService.selectSpc_name(3);
        List<Sp_product_category> spc2=sp_userService.selectSpc_name(5);
        model.addAttribute("spc",sp_userService.selectSpc_name(18));
        model.addAttribute("spc1",spc1);
        model.addAttribute("spc2",spc2);
        //二级分类下的子类
        //女装
        List<Sp_product> sp1=sp_userService.selectBySpc_id(6);
        model.addAttribute("sp1",sp1);
        //男装
        List<Sp_product> sp2=sp_userService.selectBySpc_id(7);
        model.addAttribute("sp2",sp2);
        //生鲜
        List<Sp_product> sp3=sp_userService.selectBySpc_id(12);
        model.addAttribute("sp3",sp3);
        //零食
        List<Sp_product> sp4=sp_userService.findls();
        model.addAttribute("sp4",sp4);
        //化妆品
        List<Sp_product> sp5=sp_userService.selectBySpc_id(16);
        model.addAttribute("sp5",sp5);
        //护肤品
        List<Sp_product> sp6=sp_userService.selectBySpc_id(17);
        model.addAttribute("sp6",sp6);

        //中间 首页二级分类下随机产生的六个商品图片
        //男女服饰
        List<Sp_product> cloths=sp_userService.selectCenter(spc.get(0).getSpc_id(),spc.get(1).getSpc_id());
        model.addAttribute("cloths",cloths);
        //生鲜
        List<Sp_product> food=sp_userService.selectCenter(spc1.get(0).getSpc_id(),spc1.get(1).getSpc_id());
        model.addAttribute("food",food);
        //护肤彩妆
        List<Sp_product> skin=sp_userService.selectCenter(spc2.get(0).getSpc_id(),spc2.get(1).getSpc_id());
        model.addAttribute("skin",skin);

        //右边的商品排行
        //男女服饰
        List<Sp_product> rank1=sp_userService.selectRank(spc.get(0).getSpc_id(),spc.get(1).getSpc_id());
        //零食生鲜
        List<Sp_product> rank2=sp_userService.selectRank(spc1.get(0).getSpc_id(),spc1.get(1).getSpc_id());
        //彩妆护肤
        List<Sp_product> rank3=sp_userService.selectRank(spc2.get(0).getSpc_id(),spc2.get(1).getSpc_id());
        model.addAttribute("rank1",rank1);
        model.addAttribute("rank2",rank2);
        model.addAttribute("rank3",rank3);
        return "index.html";
    }


    //获取验证码
    @ResponseBody
    @RequestMapping(path = "/code",method = RequestMethod.POST)
    public void Code(String phone){
        System.out.println(phone+"来取验证码了");
       //创建对象 发送验证码  并获取发送过去的验证码
        SendCode sendCode=new SendCode();
        int code=sendCode.getCode(phone);
        getcode=code;
        System.out.println(getcode);
    }
      /*
       商品详情--goods.html
     */
    /**
     * 调用
     * @param sp_id
     * @param model
     * @return
     */
    @RequestMapping("/goods")
    public String goods(int sp_id,int spc_file_id,Model model){
        //1、商品详情
        Commodity_Details(sp_id,model);
        //2、图片介绍
        Picture_Details(sp_id,model);
        //3、查询评论条数
        Sc_Concent_Count(sp_id,model);
        //4、查询运费
        Sel_Sp_Freight(sp_id,model);
        //5、根据商品id查询商品评论
        Sel_Sp_Comments(sp_id,model);
        //6、当前位置
        Current_Location(sp_id,model);
        //7、获取商品子类
        Get_Subclass(spc_file_id,model);
        return "goods.html";
    }
    //商品详情
    @RequestMapping("/Commodity_Details")
    public void Commodity_Details(int sp_id,Model model){
        model.addAttribute("details",sp_userService.Commodity_Details(sp_id));
    }
    //图片介绍（小图片）
    @RequestMapping("/Picture_Details")
    public void Picture_Details(int sp_id,Model model){
        model.addAttribute("picture",sp_userService.Picture_Details(sp_id));
    }
    //查询评论条数
    public void Sc_Concent_Count(int sp_id,Model model){
//        System.out.println(sp_userService.Sc_Concent_Count(sp_id));
        model.addAttribute("Sc_Concent_Count",sp_userService.Sc_Concent_Count(sp_id));
    }
    //查询运费
    public void Sel_Sp_Freight(int sp_id,Model model){
//        System.out.println(sp_userService.Sel_Sp_Freight(sp_id));
        model.addAttribute("Sel_Sp_Freight",sp_userService.Sel_Sp_Freight(sp_id));
    }
    //根据商品id查询商品评价
    public void Sel_Sp_Comments(int sp_id,Model model){
        model.addAttribute("Sel_Sp_Comments",sp_userService.Sel_Sp_Comments(sp_id));
    }
    //当前位置
    public void Current_Location(int sp_id,Model model){
        model.addAttribute("Current_Location",sp_userService.Current_Location(sp_id));
    }
    //获取商品子类
    public void Get_Subclass(int spc_file_id,Model model){
        model.addAttribute("Get_Subclass",sp_userService.Get_Subclass(spc_file_id));
    }

}
