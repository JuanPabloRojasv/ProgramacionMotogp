package com.example.api_programacion.controller;

import com.example.api_programacion.model.Kid;
import com.example.api_programacion.model.Node;
import com.example.api_programacion.model.dto.FletAgeDTO;
import com.example.api_programacion.model.dto.KidByPositionDTO;
import com.example.api_programacion.model.dto.RangeByAgeDTO;
import com.example.api_programacion.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping(path = "listse")

public class ListSEController {
    @Autowired
    private ListSEService listSEService;

    @GetMapping
    public Node getlist() {return listSEService.getList().getHead(); }

    @PostMapping(path = "addfirst")
    public String addFirst(@RequestBody Kid kid) {
        return listSEService.addFirst(kid);
    }

    @PostMapping(path = "addfinal")
    public String addFinal(@RequestBody Kid kid) { return listSEService.addFinal(kid);}

    @PostMapping(path = "deleteposition")
    public String deletePosition(@RequestBody int position){ return listSEService.deletePosition(position);}

    @PostMapping(path = "deletedata")
    public String deleteData(@RequestBody String data){return listSEService.deleteData(data);}

    @GetMapping(path = "invert")
    public String invert(){return listSEService.invert();}

    @GetMapping(path = "girlsfirst")
    public String girlsFirst(){return listSEService.girlsFirst();}

    @PostMapping(path="/byposition")
    public String addByPosition(@RequestBody KidByPositionDTO kidByPositionDTO)
    {
        return listSEService.addByPosition(kidByPositionDTO);
    }
    @GetMapping(path = "changeextreme")
    public String changeExtreme(){return listSEService.changeExtreme();}

    @GetMapping(path = "/mixbygender")
    public String mixByGender()
    {
        return listSEService.mixByGender();
    }

    @GetMapping(path = "/evenAndOdd")
    public String evenAndOdd(){return listSEService.evenAndOdd();}

    @PostMapping(path = "/letterandage")
    public String deleteletterAndAge(@RequestBody FletAgeDTO fletAgeDTO){return listSEService.deleteletterAndAge(fletAgeDTO);}

    @GetMapping (path = "/rangebyage")
    public List<RangeByAgeDTO> ranges(){return listSEService.RangeByAge();}

}
