package com.GG.test.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.GG.test.model.Music;
import com.GG.test.repository.MusicPlayerRepository;


@Controller
public class MusicPlayerController {
	@Autowired
	private MusicPlayerRepository musicPlayerRepository;
	
	@RequestMapping(value="/")
	public String index(Model model){
		
		List<Music> music=musicPlayerRepository.getMusic();
		model.addAttribute("pu",music);
		return "index";
	}
	
	@PostMapping(value="/upload")
	public String dupload(@RequestParam("files") List<MultipartFile> files,HttpServletRequest req){
		String realpath = req.getSession().getServletContext().getRealPath("/");
		Path path = Paths.get(realpath);
		for (MultipartFile file : files) {
			Path filename = path.resolve(file.getOriginalFilename());//getOriginalFilename()这个方法是获取上传时的文件名
			try {
				Files.copy(file.getInputStream(), filename);
				Music music = new Music();
				
		
				music.setName(file.getOriginalFilename());
				music.setUrl("/upload/"+file.getOriginalFilename());
				musicPlayerRepository.save(music);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/";
	}
	
	
	
}
