package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.entities.Module;
import fr.doranco.study_smart.service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/module")
@CrossOrigin(origins = "*")
public class ModuleRESTController {

    @Autowired
    ModuleService moduleService;

    @GetMapping(path = "all")
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping(value = "/getbyid/{id}")
    public Module getModuleById(@PathVariable("id") Long id) {
        return moduleService.getModule(id);
    }

    @PostMapping(value = "/add")
    public Module createModule(@RequestBody Module module) {
        return moduleService.saveModule(module);
    }

    @PutMapping(value = "/update")
    public Module updateModule(@RequestBody Module module) {
        return moduleService.updateModule(module);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteModuleById(@PathVariable("id") Long id) {
        moduleService.deleteModuleById(id);
    }

    @GetMapping(value = "/getbycourse/{cat}")
    public List<Module> getModuleByCourseId(@PathVariable("id") Long id) {
        return moduleService.findByCourseId(id);
    }
}
