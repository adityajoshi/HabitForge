package xyz.adityajoshi.HabitForge.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/habits")
public class HabitController {
    @GetMapping("/")
    public String test() {
        return "It Works!!!";
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Map<String, String> data) {
        return "{}";
    }

    @PutMapping("/update/")
    public String update(@RequestParam(value = "id") String id) {
        return "{}";
    }


    @DeleteMapping("/delete/")
    public String delete(@RequestParam String id) {
        return "{}";
    }

    @GetMapping("/select/")
    public String select(@RequestParam String id) {
        return "{}";
    }

    /*
    POST = /insert
    PUT = /update/{id}
    GET = /select/{id}
    DELETE = /delete/{id}
     */
}
