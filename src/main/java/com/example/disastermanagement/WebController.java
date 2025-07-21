package com.example.disastermanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    private List<Disaster> disasterReports = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/report")
    public String report() {
        return "report";
    }

    @GetMapping("/hospitals")
    public String hospitals() {
        return "hospitals";
    }

    @PostMapping("/report")
    public String submitReport(Disaster disaster) {
        disasterReports.add(disaster);
        return "redirect:/reports";
    }

    @GetMapping("/reports")
    public String viewReports(Model model) {
        model.addAttribute("reports", disasterReports);
        return "reports";
    }
} 