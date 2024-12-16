package hohich.omis2.controller.StrControllers;

import hohich.omis2.model.data.Consuming.StandartConsuming;
import hohich.omis2.model.data.EnergyResourse.StandartEnergyResourse;
import hohich.omis2.model.repositories.StrRepositories.ConsumingRepository;
import hohich.omis2.model.repositories.StrRepositories.ResourseRepository;
import hohich.omis2.utils.Pair;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import hohich.omis2.controller.IResourseManagerControlller;
import hohich.omis2.model.data.IConsuming;
import hohich.omis2.model.data.IEnergyResourse;
import hohich.omis2.model.repositories.IConsumingRepository;
import hohich.omis2.model.repositories.IResourseRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Controller
@AllArgsConstructor
@RequestMapping("/omis2/resources")
public class ResourseManagmentController implements IResourseManagerControlller {
    private IResourseRepository resourceRepository;
    private IConsumingRepository consumingRepository;

    @GetMapping
    public String showResourcesPage(Model model) {
        // Получение всех ресурсов
        List<IEnergyResourse> resources = getAllResources();
        model.addAttribute("resources", resources);

        // Добавить страницу с чекбоксами
        model.addAttribute("viewType", "resources");
        return "resources";
    }

    @GetMapping("/add")
    public String showResourcesForm(Model model) {
        return "addResource";
    }

    @PostMapping("/add")
    public String sendResourceForm(Model model, @RequestParam("type") String type,
                                   @RequestParam("costPerTimeUnit") double costPerTimeUnit){
        StandartEnergyResourse res = new StandartEnergyResourse();

        res.setType(type);
        res.setCostPerTimeUnit(costPerTimeUnit);
        createResourse(res);

        return "redirect:/omis2/resources";
    }

    @GetMapping("/edit/{id}")
    public String showEditResourcesForm(Model model, @PathVariable("id") int id) {
        IEnergyResourse res = getResourseById(id);
        model.addAttribute("resource", res);
        return "updResource";
    }

    @PostMapping("/edit/{id}")
    public String sendEditResourcesForm(@PathVariable("id") int id,
                                        @ModelAttribute("resource") StandartEnergyResourse resource) {
        resource.setId(id);
        System.out.println("update resource " + resource.getId());
        updateResourse(resource);
        return "redirect:/omis2/resources";
    }

    @GetMapping("/consuming")
    public String showConsumptionsPage(Model model) {
        List<IConsuming> consumptions = getAllConsumings();
        model.addAttribute("consumptions", consumptions);

        model.addAttribute("viewType", "consuming");
        return "resources";
    }

    @GetMapping("/consuming/add")
    public String showConsumingForm(){
        return "addConsuming";
    }

    @PostMapping("/consuming/add")
    public String addConsuming(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @ModelAttribute StandartConsuming consuming
    ) {
        // Установить период вручную
        consuming.setPeriod(new Pair<>(startDate, endDate));

        // Логика для добавления потребления
        createConsuming(consuming);
        return "redirect:/omis2/resources/consuming";
    }

    @GetMapping("/consuming/edit/{id}")
    public String showEditConsumingForm(Model model, @PathVariable("id") int id) {
        IConsuming consuming = getConsumingById(id);
        model.addAttribute("consuming", consuming);
        return "updConsuming";
    }

    @PostMapping("/consuming/edit/{id}")
    public String sendEditConsumingForm(@PathVariable("id") int id,
                                        @ModelAttribute("resource") StandartConsuming consuming) {
        consuming.setId(id);
        System.out.println("update resource " + consuming.getId());
        updateConsuming(consuming);
        return "redirect:/omis2/resources/consuming";
    }

    @Override
    public List<IEnergyResourse> getAllResources() {
        return resourceRepository.getAllResourses();
    }

    @Override
    public IEnergyResourse getResourseById(int id) {
        return resourceRepository.getResourse(id);
    }

    @Override
    public void createResourse(IEnergyResourse resourse) {
        resourceRepository.saveResourse(resourse);
    }

    @Override
    public void updateResourse(IEnergyResourse resourse) {
        resourceRepository.updateResourse(resourse);
    }

    @Override
    public void deleteResourse(int id) {

    }

    @Override
    public List<IConsuming> getAllConsumings() {
        return consumingRepository.getAllConsumings();
    }

    @Override
    public IConsuming getConsumingById(int id) {
        return consumingRepository.getConsuming(id);
    }

    @Override
    public void createConsuming(IConsuming consuming) {
        consumingRepository.saveConsuming(consuming);
    }

    @Override
    public void updateConsuming(IConsuming consuming) {
        consumingRepository.updateConsuming(consuming);
    }

    @Override
    public void deleteConsuming(int id) {

    }
}




