package xyz.tom.www.config;


import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
// 配置只扫描Controller
//@ComponentScan(value = "xyz.tom.www", includeFilters = {
//    @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//})
@ComponentScan("xyz.tom.www")
// 引入子配置文件
@Import(JdbcConfig.class)
//载入配置文件
@PropertySource("classpath:jdbcConfig.properties")
@EnableWebMvc // 启动SpringMVC配置
public class SpringMVCConfig {

}
