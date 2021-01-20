package com.eltacshixseyidov.profile.controller;

import com.eltacshixseyidov.profile.entity.Profile;
import com.eltacshixseyidov.profile.repository.ProfileRepository;
import com.eltacshixseyidov.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/")
    public String uploadFile(
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "description") String description,
            Model model){
        String fileName =  profileService.uploadFile(file, description);
        model.addAttribute("fileName", fileName);
        Iterable<Profile> profiles = profileRepository.findAll();
        model.addAttribute("profiles", profiles);
        return "index";
    }

    @GetMapping("/get/{keyName}")
    public void getObjectKey(@PathVariable String keyName, HttpServletResponse response) throws IOException {
        profileService.getFile(keyName,response);
    }
}

