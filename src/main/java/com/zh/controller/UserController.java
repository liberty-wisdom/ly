package com.zh.controller;

import com.zh.bean.User;
import com.zh.bean.Version;
import com.zh.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Version version;
    @Autowired
    private HttpSession session;
    /*
     *登录成功，进入主页
     * */
    @RequestMapping("toindex")
    public String toIndex(Model model){
        model.addAttribute("v",version.getV());
        log.info("【"+session.getAttribute("newName")+"】用户登录成功，前往主页-->");
        log.info("当前系统版本：【"+version.getV()+"】");
        return "index_in";
    }
    /*
     * 退出登录
     * */
    @RequestMapping("/loginOut")
    public String loginOut(){
        if(session.getAttribute("newName")!=null){
            log.info("用户【"+session.getAttribute("newName")+" 】已注销！");
//            session.removeAttribute("newName");
            session.invalidate();
            return "index";
        }else{
            return "index";
        }
    }
    /*
    * --> 添加页面
    * */
    @RequestMapping("/toadd")
    public String toadd(){
        return "addUser";
    }

    /*
    * 添加用户
    * */
    @RequestMapping("/save")
    public String save(User user){
        userService.save(user);
        return "redirect:userList";
    }

    /*
    * 查询所有用户
    * */
    @RequestMapping("/userList")
    public String userList(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("userList",userList);
        return "findAllUser";
    }

    /*
    * 根据id删除
    * */
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
        return "redirect:/userList";
    }

    /*
    * 查询单个用户信息
    * 去修改
    * */
    @RequestMapping("/findOneUser/{id}")
    public String findOneUser(@PathVariable("id")Long id,Model model){
        User oneUser = userService.findOneUser(id);
        model.addAttribute("oneUser",oneUser);
        return "updateOneUser";
    }

    /*
    * 修改用户信息
    * */
    @RequestMapping("/updateOneUser")
    public String updateOneUser(User user){
        userService.updateOneUser(user);
        return "redirect:userList";
    }

    /*
    * 登录控制 0 存在该用户
    * */
    @RequestMapping("/loginIn")
    @ResponseBody
    public int loginIn(String name, String password){
        User namePwd = userService.findByNameAndPassword(name,password);
        if(namePwd==null){
            return -1;
        }
        log.info("【"+name+"】用户存在，允许登录");
        session.setAttribute("newName",name);
        session.setAttribute("userInfo",namePwd.getInfo());
        System.out.println(namePwd.getInfo());
        return 0;
    }

}
