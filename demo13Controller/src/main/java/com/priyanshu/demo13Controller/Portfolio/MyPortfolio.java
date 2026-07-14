package com.priyanshu.demo13Controller.Portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyPortfolio {

    @GetMapping("/myself")
    public String Myself() {
        return """
                <div>
                <H1 style="color: orange;"> Myself </H1>
                <p style="color: gray;"> My Name is Priyanshu. I am Fourth Year Btech Student. </p>
                <ul>
                    <li>Github Link: <a href="https://www.github.com/mjpriyanshu" target="_blank">https://www.github.com/mjpriyanshu</a></li>
                    <li>LeetCode Link: <a href="https://www.leetcode.com/mjpriyanshu" target="_blank">https://www.leetcode.com/mjpriyanshu</a></li>
                </ul>
                </div>
                """;
    }



}   
