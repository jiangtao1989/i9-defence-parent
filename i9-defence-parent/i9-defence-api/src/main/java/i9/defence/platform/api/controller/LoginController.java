package i9.defence.platform.api.controller;

import i9.defence.platform.dao.vo.ManagerLoginDto;
import i9.defence.platform.model.Manager;
import i9.defence.platform.service.ManagerService;
import i9.defence.platform.utils.BusinessException;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/** 
 * 创建时间：2018年1月4日 下午8:20:44
 * @author  lby
 * @version  
 * 
 */
@Controller
@RequestMapping("")
public class LoginController {
    
    @Autowired
    private ManagerService managerService;
    
    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }
    
    
    @RequestMapping("/")
    public String defaultPage() {
        return "redirect:/index.html";
    }
    
    @RequestMapping("/login.html")
    public String toLogin(@ModelAttribute ManagerLoginDto managerLoginDto) {
        return "login";
    }
    
    
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute @Valid ManagerLoginDto manager,BindingResult bindingResult){
        try {
            managerService.login(manager);
            return new ModelAndView("redirect:index.html");
        } catch (BusinessException e) {
            return new ModelAndView("login").addObject("exception", e);
        }
        
    }
    

    @RequestMapping("/regist.html")
    public String toRegist() {
        return "regist";
    }
    
    @RequestMapping("/currentUser")
    @ResponseBody
    public HashMap<String, Object> current() {
        HashMap<String, Object> result = new HashMap<String, Object>();
        Manager manager = managerService.getLoginManager();
        result.put("data", manager);
        return result;
    }
    
    /*@RequestMapping(value = "/regist.zhtml", method = RequestMethod.POST)
    public ModelAndView regist(@Valid UserDto userDto, Errors errors,HttpSession session) {
        if (errors.hasErrors()) {
            List<ObjectError> list = errors.getAllErrors();
            String errorString = list.get(list.size()-1).getDefaultMessage();
            return new ModelAndView("regist").addObject("exception",new BusinessException(errorString));
        }
        try {
            userService.regist(userDto,session);
        } catch (BusinessException e) {
            return new ModelAndView("regist").addObject("exception",e);
        }
        
        return new ModelAndView("regist").addObject("exception",new BusinessException("注册成功"));
    }*/

}

