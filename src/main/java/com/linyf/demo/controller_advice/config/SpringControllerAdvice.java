package com.linyf.demo.controller_advice.config;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @ControllerAdvice注解是Spring3.2中新增的注解，学名是Controller增强器，作用是给Controller控制器添加统一的操作或处理。
 *  *  *
 *  *  * 对于@ControllerAdvice，我们比较熟知的用法是结合@ExceptionHandler用于全局异常的处理，但其作用不止于此。
 *  *  * ControllerAdvice拆开来就是Controller Advice，关于Advice，在Spring的AOP中，是用来封装一个切面所有属性的，包括切入点和需要织入的切面逻辑。
 *  *  * 这里ControllerAdvice也可以这么理解，其抽象级别应该是用于对Controller进行切面环绕的，而具体的业务织入方式则是通过结合其他的注解来实现的。
 *  *  * @ControllerAdvice是在类上声明的注解，其用法主要有三点：
 *  *  *
 *  *  * 1.结合方法型注解@ExceptionHandler，用于捕获Controller中抛出的指定类型的异常，从而达到不同类型的异常区别处理的目的。
 *  *  *
 *  *  * 2.结合方法型注解@InitBinder，用于request中自定义参数解析方式进行注册，从而达到自定义指定格式参数的目的。
 *  *  *
 *  *  * 3.结合方法型注解@ModelAttribute，表示其注解的方法将会在目标Controller方法执行之前执行。--数据预处理
 *  *  *
 *  *  * 从上面的讲解可以看出，@ControllerAdvice的用法是将其声明在某个bean上，然后在该bean的方法上使用其他的注解来指定不同的织入逻辑。
 *  *  * 不过这里@ControllerAdvice并不是使用AOP的方式来织入业务逻辑的，而是Spring内置对其各个逻辑的织入方式进行了内置支持。
 *  *  *
 *  *  * https://www.cnblogs.com/yanggb/p/10859907.html
 *  *
 *  *
 *  * 在启动应用之后，被@ExceptionHandler、@InitBinder和@ModelAttribute注解的方法都会作用在被@RequestMappping注解的方法上。
 *  * 比如@ModelAttribute注解的方法参数model上设置的值，所有被@RequestMapping注解的方法中都可以通过ModelMap获取。
 *
 *
 *  小结
 * 关于@ControllerAdvice注解的三种使用方式对应的注解，这三种注解如果应用于@ControllerAdvice注解所标注的类中，
 * 那么它们表示会对@ControllerAdvice所指定的范围内的方法都有效；如果单纯地将这三种注解应用于某个Controller中，那么它们将只会对该Controller类中的所有接口有效，
 * 并且此时是不需要在该Controller上标注@ControllerAdvice注解的。
 * 另外的还有@RestControllerAdvice注解，用法和@ControllerAdvice注解类似，只是当需要返回值到响应头的时候就不用在方法上添加@ResponseBody注解了。
 */
@ControllerAdvice
public class SpringControllerAdvice {
    /**
     * 应用到所有被@RequestMapping注解的方法，在其执行之前初始化数据绑定器
     *
     * 对于@InitBinder，该注解的主要作用是绑定一些自定义的参数。一般情况下我们使用的参数通过@RequestParam，@RequestBody或者@ModelAttribute等注解就可以进行绑定了，
     * 但对于一些特殊类型参数，比如Date，它们的绑定Spring是没有提供直接的支持的，我们只能为其声明一个转换器，
     * 将request中字符串类型的参数通过转换器转换为Date类型的参数，从而供给@RequestMapping标注的方法使用。
     *
     * 这里@InitBinder标注的方法注册的Formatter在每次request请求进行参数转换时都会调用，用于判断指定的参数是否为其可以转换的参数。
     * 可以看到当访问/users的时候，对request参数进行了转换，并且在接口方法中成功接收了该参数，并在控制台打印出日期格式的结果。
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }




    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * 关于@ModelAttribute的用法，除了用于方法参数时可以用于转换对象类型的属性之外，其还可以用来进行方法的声明。如果声明在方法上，
     * 并且结合@ControllerAdvice，该方法将会在@ControllerAdvice所指定的范围内的所有接口方法执行之前执行，
     * 并且@ModelAttribute标注的方法的返回值还可以供给后续会调用的接口方法使用。
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("words", "hello world");
    }

    /**
     * 这里@ModelAttribute注解的方法提供了一个String类型的返回值，而@ModelAttribute注解中指定了该属性的名称是message，
     * 这样在Controller层就可以通过@ModelAttribute注解接收名称为message的参数，从而获取到前面绑定的参数了。
     * @return
     */
    @ModelAttribute(value = "message")
    public String globalModelAttribute() {
        System.out.println("添加了message全局属性。");
        return "输出了message全局属性。";
    }




    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        return new ModelAndView("error");
    }

    /**
     * 全局异常捕捉处理
     * @ExceptionHandler拦截异常并统一处理
     *
     * @ExceptionHandler的作用主要在于声明一个或多个类型的异常，当符合条件的Controller抛出这些异常之后将会对这些异常进行捕获，然后按照其标注的方法的逻辑进行处理，从而改变返回的视图信息。
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }


}
