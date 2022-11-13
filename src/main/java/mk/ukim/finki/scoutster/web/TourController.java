package mk.ukim.finki.scoutster.web;


import mk.ukim.finki.scoutster.model.Guide;
import mk.ukim.finki.scoutster.model.Terrain;
import mk.ukim.finki.scoutster.model.Tour;
import mk.ukim.finki.scoutster.service.GuideService;
import mk.ukim.finki.scoutster.service.TerrainService;
import mk.ukim.finki.scoutster.service.TourService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/tours")
public class TourController {
    private final TourService tourService;
    private final TerrainService terrainService;
    private final GuideService guideService;

    public TourController(TourService tourService, TerrainService terrainService, GuideService guideService) {   //?
        this.tourService = tourService;
        this.terrainService = terrainService;
        this.guideService = guideService;
    }


    @GetMapping
    public String getTourPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Tour> tours = this.tourService.findAll();
        model.addAttribute("tours", tours);
        model.addAttribute("bodyContent", "tours");
        return "master-template";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTour(@PathVariable Long id) {
        this.tourService.deleteById(id);
        return "redirect:/tours";
    }

    @GetMapping("/edit-form/{id}")
    public String editTourPage(@PathVariable Long id, Model model) {
        if (this.tourService.findById(id).isPresent()) {
            Tour tour = this.tourService.findById(id).get();
            List<Guide> guides = this.guideService.findAll();
            List<Terrain> terrains = this.terrainService.listCategories();
            model.addAttribute("guides", guides);
            model.addAttribute("terrains", terrains);
            model.addAttribute("tour", tour);
            model.addAttribute("bodyContent", "add-tour");
            return "master-template";
        }
        return "redirect:/tours?error=TourNotFound";
    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addTourPage(Model model) {
        List<Guide> guides = this.guideService.findAll();
        List<Terrain> terrains = this.terrainService.listCategories();
        model.addAttribute("guides", guides);
        model.addAttribute("terrains", terrains);
        model.addAttribute("bodyContent", "add-tour");
        return "master-template";
    }

    @PostMapping("/add")
    public String saveTour(
            @RequestParam(required = false) Long id,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Integer persons,
            @RequestParam Long terrain,
            @RequestParam Long guide,
            @RequestParam String condition)
        {
        if (id != null) {
            this.tourService.edit(id, name, price, persons, terrain, guide, condition);
        } else {
            this.tourService.save(name, price, persons, terrain, guide, condition);
        }
        return "redirect:/tours";
    }


}
