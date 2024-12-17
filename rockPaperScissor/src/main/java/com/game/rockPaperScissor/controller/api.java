package com.game.rockPaperScissor.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/game")
public class api {

    private static String PlayerMove;
    public String[] rps = {"rock","paper","scissor"};

    @GetMapping
    public Map<String,String> getRPS(){
        String computerMove = rps[new Random().nextInt(rps.length)];
        Map<String ,String> res = new HashMap<>(){{
            put("Player", PlayerMove);
            put("Computer", computerMove);
            put("Result", gameRPS(PlayerMove,computerMove));
        }};
     return res;
    }

    @PostMapping
    public String postRPS(@RequestBody String pm){
        PlayerMove = pm;
        //return "PlayerMove retrieved";
        return PlayerMove;
    }

    public String gameRPS(String PlayerMove,String computerMove){
        String result=" ";
        if(computerMove.equals(PlayerMove)){
            result = "That's a Tie!!!";
        }
        else if(PlayerMove.equals("rock")){
            if(computerMove.equals("scissor")){result = "You Win!!!";}
            else if(computerMove.equals("paper")){result = "You Lose :(";}
        }
        else if(PlayerMove.equals("paper")){
            if(computerMove.equals("rock")){result = "You Win!!!";}
            else if(computerMove.equals("scissor")){result = "You Lose :(";}
        }
        else if(PlayerMove.equals("scissor")){
            if(computerMove.equals("paper")){result = "You Win!!!";}
            else if(computerMove.equals("rock")){result = "You Lose :(";}
        }
        else{
            result = "ERROR###";
        }

        return result;
    }

}


