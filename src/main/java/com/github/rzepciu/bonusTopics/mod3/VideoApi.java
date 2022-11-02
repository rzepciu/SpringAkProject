package com.github.rzepciu.bonusTopics.mod3;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideoApi {

    private List<Video> videoList;

    public VideoApi() {
        this.videoList = new ArrayList<>();
        videoList.add(new Video(1L,"Zwierzenia Programisty Mieszkającego w Norwegii – Cała Prawda","https://youtu.be/j67Q5kGpfW8"));
        videoList.add(new Video(2L,"Docker Dla Programistów - Szybki Start - Praktyczny Przykład Od Podstaw","https://youtu.be/cqIu1h8FkMw"));
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Video>> getVideos(){
        return new ResponseEntity<>(videoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable long id){

        Optional<Video> videoById = videoList.stream().filter(video -> video.getId() == id).findFirst();

        if (videoById.isPresent()){
            return new ResponseEntity<>(videoById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity addVideo(@RequestBody Video video){
            boolean add  = videoList.add(video);
            if (add){
                return new ResponseEntity(HttpStatus.CREATED);
            } else {
                return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }
    @PutMapping
    public ResponseEntity modVideo(@RequestBody Video video){
            Optional<Video> videoById = videoList.stream().filter(vid -> vid.getId() == video.getId()).findFirst();
        if (videoById.isPresent()){
            videoList.remove(videoById.get());
            videoList.add(video);
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delVideo(@PathVariable long id){
        Optional<Video> videoById = videoList.stream().filter(video -> video.getId() == id).findFirst();

        if (videoById.isPresent()){
            videoList.remove(videoById.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
