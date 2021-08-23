package com.hivetech.tinypng;

import com.tinify.Source;
import com.tinify.Tinify;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
public class CompressingImage {
    private static final String UPLOAD_DIR = "compressing_";

    @GetMapping({"/", "/index"})
    public String index(Model model){
        model.addAttribute("message", "Let's do it!");
        return "index";
    }
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return "redirect:/index";
        }
        String fileName = file.getOriginalFilename();
        try {
            assert fileName != null;
            Path path = Paths.get(fileName);
            Source source = Tinify.fromFile(path.toAbsolutePath().toString());
            source.toFile(UPLOAD_DIR + path);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/index";
        }
        return "redirect:/index";
    }
}
