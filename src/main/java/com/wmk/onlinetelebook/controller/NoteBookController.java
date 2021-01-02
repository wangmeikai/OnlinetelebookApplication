package com.wmk.onlinetelebook.controller;

import com.wmk.onlinetelebook.common.Result;
import com.wmk.onlinetelebook.pojo.Note;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class NoteBookController {

    @GetMapping({"/loadall"})
    public Result<List<Note>> loadall(){
        List<Note> list = new ArrayList<>();
        list.add(new Note(new Date(),"晴","窗前明月光"));
        list.add(new Note(new Date(),"晴","疑似地上霜"));
        list.add(new Note(new Date(),"晴","举头望明月"));
        list.add(new Note(new Date(),"晴","低头思故乡"));
        return new Result<List<Note>>(200,"ok",list);
    }

    @PostMapping({"/submitTest"})
    public Result<Note> submitTest(@RequestBody Map<String,String> map){
        System.out.println(map);
        return new Result<Note>(200,"ok",new Note(new Date(),"大雨",map.get("nowText")));
    }
}
