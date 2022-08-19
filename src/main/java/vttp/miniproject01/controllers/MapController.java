package vttp.miniproject01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.miniproject01.models.CarparkAvail;
import vttp.miniproject01.models.CarparkDetails;
import vttp.miniproject01.services.MapService;

@Controller
@RequestMapping
public class MapController {

    @Autowired
    private MapService mSvc;
    
    @GetMapping(path = "/", produces = "application/json")
    public String getPP(Model model) {

        List<CarparkAvail> list = mSvc.getCarparkAvail();
        List<CarparkDetails> detailsList = mSvc.getCarparkDetails();
        // for (CarparkAvail c : list) {
        //     if () {

        //     }
        // }



        model.addAttribute("list", list);
        model.addAttribute("detailsList", detailsList);

        return "index";
    }
}
